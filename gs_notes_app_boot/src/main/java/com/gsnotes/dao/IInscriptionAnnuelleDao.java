package com.gsnotes.dao;


import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInscriptionAnnuelleDao extends JpaRepository<InscriptionAnnuelle, Long> {


    public List<InscriptionAnnuelle> getInscriptionAnnuelleByAnneeAndNiveau(int annee, Niveau niveau);


}
