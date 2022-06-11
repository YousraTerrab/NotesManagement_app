package com.gsnotes.services.impl;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.IInscriptionAnnuelleDao;
import com.gsnotes.dao.IInscriptionModuleDao;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.IInscriptionService;
import com.gsnotes.services.IincriptionModuleService;
import com.gsnotes.utils.export.FileManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.List;

@Service
@Transactional

 public  class InscriptionAnnuelleImpl implements IInscriptionService {


    @Autowired
    private IInscriptionAnnuelleDao inscriptionAnnuelleDao;

    @Autowired
    private INiveauDao niveauDao;

    @Autowired
    private IInscriptionModuleDao ModuleDao;


    public List<InscriptionAnnuelle> getAllInscription() {
        System.out.println("l'appel de la fonction getAll Inscription");
        return inscriptionAnnuelleDao.findAll();
    }


    public List<InscriptionAnnuelle> getInscriptionAnnuelleByAnneeAndByNiveau(int annee, Long idNiveau) {
        Niveau niveau = niveauDao.getNiveauByIdNiveau(idNiveau);
        return inscriptionAnnuelleDao.getInscriptionAnnuelleByAnneeAndNiveau(annee, niveau);

    }

    public FileManagerHelper.ExcelExporter prepareCompteExport(List<InscriptionAnnuelle> Inscription, int annee, Long idNiveau) {

        //pour connaitre les noms des module
        List<InscriptionModule> Module = ModuleDao.getInscriptionModuleByInscriptionAnnuelle(Inscription.get(0));

        for(InscriptionModule md: Module){
            System.out.println(md.getNoteFinale()+"  "+md.getValidation());
        }
        // pour avoir l'acces a tous le tableau niveau
        Niveau niveau = niveauDao.getNiveauByIdNiveau(idNiveau);
        String[] columnNames = new String[40];


        //le nom des colonne
                //{String.valueOf(annee), niveau.getTitre(),"IdEtudiant","CNE", "Nom","Prénom"};
        columnNames[0] =String.valueOf(annee);
        columnNames[1] =niveau.getAlias();
        columnNames[2] ="IdEtudiant";
        columnNames[3] ="CNE";
        columnNames[4] ="Nom";
        columnNames[5] ="Prénom";
        int j = 6;
        for(InscriptionModule md : Module){
            columnNames[j++] = md.getModule().getTitre();
            columnNames[j++]="Validation";
        }
        columnNames[j++]="Moyenne general";
        columnNames[j++]="Rang";

        String[][] data = new String[Inscription.size()][columnNames.length];

        int i = 0;
        int h=2;
        for (InscriptionAnnuelle u : Inscription) {
            data[i][h++] = String.valueOf(i+1);
            data[i][h++] = u.getEtudiant().getCne();
            data[i][h++] = u.getEtudiant().getNom();
            data[i][h++] = u.getEtudiant().getPrenom();
            for(int k=0;k<Module.size();k++){
                data[i][h++]=String.valueOf(ModuleDao.getInscriptionModuleByInscriptionAnnuelle(u).get(k).getNoteFinale());
                data[i][h++]= ModuleDao.getInscriptionModuleByInscriptionAnnuelle(u).get(k).getValidation();}

            int s=0;
            for(int k=0;k<Module.size();k++){
                s+=ModuleDao.getInscriptionModuleByInscriptionAnnuelle(u).get(k).getNoteFinale();
            }
            data[i][h++]=String.valueOf(s);
            data[i][h++]="0";
            i++;
            h=2;
            }





       System.out.println("l'appel de la fonction prepareCompteExport");
        return new FileManagerHelper.ExcelExporter(columnNames, data, "Inscription");
    }

}
