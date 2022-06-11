package com.gsnotes.services;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.utils.export.FileManagerHelper;

import java.util.List;

public interface IInscriptionService {
    public List<InscriptionAnnuelle> getAllInscription();
    public List<InscriptionAnnuelle> getInscriptionAnnuelleByAnneeAndByNiveau(int annee, Long niveau);


    public FileManagerHelper.ExcelExporter prepareCompteExport(List<InscriptionAnnuelle> Inscription, int annee, Long niveau );
}
