package com.ArgentinaPrograma.FinalArgPro.servicio;

import com.ArgentinaPrograma.FinalArgPro.Entity.Educacion;
import com.ArgentinaPrograma.FinalArgPro.repository.Reducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ServiceEducacion {
    
     @Autowired
     Reducacion repoReducacion;
     
         public List<Educacion> verDatosE() {

        return repoReducacion.findAll();

    }
       public void savedatoE(Educacion itemdato) {

        repoReducacion.save(itemdato);

    }
     public void borrarDato(int id) {

        repoReducacion.deleteById(id);

    }
         public Optional<Educacion> getonedatoE (int id){           
        
        return repoReducacion.findById(id);
    }
    public Optional<Educacion> getByNombreE(String nombre){
        
        return repoReducacion.findByDetalle1(nombre);
    }
     
          public boolean existsByIdE(int id) {

        return repoReducacion.existsById(id);

    }
     public boolean existsByDetalle1E(String nombre) {

        return repoReducacion.existsByDetalle1(nombre);

    }
     
    
    
}
