package com.ArgentinaPrograma.FinalArgPro.servicio;

import com.ArgentinaPrograma.FinalArgPro.Entity.Acerca;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ArgentinaPrograma.FinalArgPro.repository.Racerca;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class ServiceAcerca {

    @Autowired
    Racerca repoRacerca;

    
    public List<Acerca> verDatos() {

        return repoRacerca.findAll();

    }
    public Optional<Acerca> getonedato (int id){           
        
        return repoRacerca.findById(id);
    }
    public Optional<Acerca> getByNombre(String nombre){
        
        return repoRacerca.findByNombre(nombre);
    }

    
    public void savedato(Acerca itemdato) {

        repoRacerca.save(itemdato);

    }
     public void borrarDato(int id) {

        repoRacerca.deleteById(id);

    }

     public boolean existsByIdA(int id) {

        return repoRacerca.existsById(id);

    }
     public boolean existsByNombreA(String nombre) {

        return repoRacerca.existsByNombre(nombre);

    }

   
   

}
