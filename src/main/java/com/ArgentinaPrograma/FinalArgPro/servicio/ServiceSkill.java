package com.ArgentinaPrograma.FinalArgPro.servicio;

import com.ArgentinaPrograma.FinalArgPro.Entity.Skill;
import com.ArgentinaPrograma.FinalArgPro.repository.Rskill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceSkill {

    @Autowired
    Rskill repoRskill;

    public List<Skill> verDatos() {

        return repoRskill.findAll();

    }

    public Optional<Skill> getonedato(int id) {

        return repoRskill.findById(id);
    }

    public Optional<Skill> getByNombre(String nombre) {

        return repoRskill.findByNombre(nombre);
    }

    
     public void savedato(Skill itemdato) {

        repoRskill.save(itemdato);

    }
     public void borrarDato(int id) {

        repoRskill.deleteById(id);

    }
    
         public boolean existsByIdS(int id) {

        return repoRskill.existsById(id);

    }
     public boolean existsByNombreS(String nombre) {

        return repoRskill.existsByNombre(nombre);

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
