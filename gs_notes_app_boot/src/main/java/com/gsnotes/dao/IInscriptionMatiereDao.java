package com.gsnotes.dao;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IInscriptionMatiereDao extends JpaRepository<InscriptionMatiere, Long>{
    List<InscriptionMatiere> getInscriptionMatiereByInscriptionAnnuelle(InscriptionAnnuelle inscriptionAnnuelle);
}
