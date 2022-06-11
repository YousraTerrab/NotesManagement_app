package com.gsnotes.services.impl;

import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.INiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NiveauImpl implements INiveauService {
    @Autowired
    private INiveauDao niveauDeo;



    public List<Niveau> getAllNiveau(){

        return niveauDeo.findAll();
    }
}
