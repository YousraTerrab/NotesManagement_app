package com.gsnotes.web.controllers;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.services.IInscriptionService;
import com.gsnotes.services.IincriptionModuleService;
import com.gsnotes.utils.export.FileManagerHelper;
import com.gsnotes.web.models.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class InscriptionAnnuelleController {

    @Autowired
    private IInscriptionService inscriptionService;

    @Autowired
    private IincriptionModuleService ModuleService;

    public InscriptionAnnuelleController(){

    }
    @ModelAttribute
    @RequestMapping(value ="exportNote" ,method = RequestMethod.POST)

    public void exportToExcelNote(HttpServletResponse response, HttpServletRequest rq, Model model) throws IOException {
     // List<InscriptionAnnuelle> inscription = (List<InscriptionAnnuelle>) model.getAttribute("InscriptionAnnuel");
        int idAnnee = Integer.parseInt(rq.getParameter("annee")) ;
        Long idNiveau = Long.valueOf(rq.getParameter("idNiveau"));
        System.out.println(idNiveau + "  " +idAnnee);
        List<InscriptionAnnuelle> inscription = inscriptionService.getInscriptionAnnuelleByAnneeAndByNiveau(idAnnee, idNiveau);



        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Délibération_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        System.out.println("l'appel d'exportNote");
      // List<InscriptionAnnuelle> inscription = inscriptionService.getAllInscription();
        for(InscriptionAnnuelle l:inscription){
            System.out.println(l.getEtudiant().getPrenom() +"  "+l.getEtudiant().getNom()+"  "+l.getAnnee());
        }
        System.out.println("apres avoir la liste des inscription");
        FileManagerHelper.ExcelExporter excelExporter = inscriptionService.prepareCompteExport(inscription,idAnnee, idNiveau);

        excelExporter.export(response);


    }
}
