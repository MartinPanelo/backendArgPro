package com.ArgentinaPrograma.FinalArgPro.servicio;

import com.ArgentinaPrograma.FinalArgPro.datosportfolio.datos;
import com.ArgentinaPrograma.FinalArgPro.repository.personarepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    
    public personarepository persorepo;
    
    @Override
    public List<datos> verDatos() {

       return persorepo.findAll();

    }

    @Override
    public void crearDato(datos itemdato) {

        persorepo.save(itemdato);
        
    }

    @Override
    public void borrarDato(Long id) {

        persorepo.deleteById(id);

    }

    @Override
    public datos buscaritemdato(Long id) {

       return persorepo.findById(id).orElse(null);

    }


}
