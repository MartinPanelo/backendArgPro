package com.ArgentinaPrograma.FinalArgPro.repository;

import com.ArgentinaPrograma.FinalArgPro.datosportfolio.datos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository    
public interface personarepository extends JpaRepository <datos, Long>{
 
    
     
    
}
