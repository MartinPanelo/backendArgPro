package com.ArgentinaPrograma.FinalArgPro.servicio;

import com.ArgentinaPrograma.FinalArgPro.Entity.Proyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ArgentinaPrograma.FinalArgPro.repository.Rproyecto;

@Service
@Transactional
public class ServiceProyecto {

    @Autowired
    Rproyecto repoRproyectos;

    public List<Proyecto> verDatos() {

        return repoRproyectos.findAll();

    }

    public void savedato(Proyecto itemdato) {

        repoRproyectos.save(itemdato);

    }

    public void borrarDato(int id) {

        repoRproyectos.deleteById(id);

    }

    public Optional<Proyecto> getonedato(int id) {

        return repoRproyectos.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombre) {

        return repoRproyectos.findByNombre(nombre);
    }

    public boolean existsByIdP(int id) {

        return repoRproyectos.existsById(id);

    }

    public boolean existsByNombreP(String nombre) {

        return repoRproyectos.existsByNombre(nombre);

    }

}
