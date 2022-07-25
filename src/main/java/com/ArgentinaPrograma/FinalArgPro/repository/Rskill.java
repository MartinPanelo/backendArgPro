package com.ArgentinaPrograma.FinalArgPro.repository;

import com.ArgentinaPrograma.FinalArgPro.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rskill extends JpaRepository<Skill, Integer> {

    public Optional<Skill> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
