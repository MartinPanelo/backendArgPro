package com.ArgentinaPrograma.FinalArgPro.repository;

import com.ArgentinaPrograma.FinalArgPro.Entity.Acerca;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository    
public interface Racerca extends JpaRepository <Acerca, Integer>{
 
    public Optional<Acerca> findByNombre(String nombre);
     
    public boolean existsByNombre(String nombre);
}
