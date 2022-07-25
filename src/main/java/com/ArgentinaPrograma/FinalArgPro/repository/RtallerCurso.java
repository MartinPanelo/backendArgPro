package com.ArgentinaPrograma.FinalArgPro.repository;

import com.ArgentinaPrograma.FinalArgPro.Entity.TallerCurso;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RtallerCurso extends JpaRepository<TallerCurso, Integer> {

    public Optional<TallerCurso> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);

}
