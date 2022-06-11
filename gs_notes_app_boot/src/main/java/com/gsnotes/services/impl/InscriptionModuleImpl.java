package com.gsnotes.services.impl;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.dao.IInscriptionModuleDao;
import com.gsnotes.services.IincriptionModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class InscriptionModuleImpl implements IincriptionModuleService {
    @Autowired
    IInscriptionModuleDao insciptionModuleDao;

    public List<InscriptionModule> getModulesByInscriptionAnnuelle(InscriptionAnnuelle inscriptionAnnuelle){

        return insciptionModuleDao.getInscriptionModuleByInscriptionAnnuelle(inscriptionAnnuelle);
    }
}
