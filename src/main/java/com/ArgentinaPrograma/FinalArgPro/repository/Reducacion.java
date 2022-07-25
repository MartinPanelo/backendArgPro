package com.ArgentinaPrograma.FinalArgPro.repository;

import com.ArgentinaPrograma.FinalArgPro.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reducacion extends JpaRepository<Educacion, Integer>{
    
    public Optional<Educacion> findByDetalle1(String nombre);
    
        public boolean existsByDetalle1(String nombre);

}
