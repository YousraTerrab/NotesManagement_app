package com.gsnotes.dao;

import com.gsnotes.bo.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INiveauDao extends JpaRepository<Niveau, Long> {
    public Niveau getNiveauByIdNiveau(Long idNiveau);
}
