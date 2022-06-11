package com.gsnotes.services;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.InscriptionModule;

import java.util.List;

public interface IincriptionModuleService {
    List<InscriptionModule> getModulesByInscriptionAnnuelle(InscriptionAnnuelle inscriptionAnnuelle);
}
