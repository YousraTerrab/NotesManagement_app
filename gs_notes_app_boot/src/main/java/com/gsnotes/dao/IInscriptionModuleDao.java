package com.gsnotes.dao;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInscriptionModuleDao extends JpaRepository<InscriptionModule, Long>{

    List<InscriptionModule> getInscriptionModuleByInscriptionAnnuelle(InscriptionAnnuelle inscriptionAnnuelle);
}
