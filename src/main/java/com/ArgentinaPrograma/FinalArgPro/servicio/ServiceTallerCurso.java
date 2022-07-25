package com.ArgentinaPrograma.FinalArgPro.servicio;

import com.ArgentinaPrograma.FinalArgPro.Entity.TallerCurso;
import com.ArgentinaPrograma.FinalArgPro.repository.RtallerCurso;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceTallerCurso {

    @Autowired
    RtallerCurso repoTallerCurso;

    public List<TallerCurso> verDatos() {

        return repoTallerCurso.findAll();

    }

    public Optional<TallerCurso> getonedato(int id) {

        return repoTallerCurso.findById(id);
    }

    public Optional<TallerCurso> getByNombre(String nombre) {

        return repoTallerCurso.findByNombre(nombre);
    }

    public void savedato(TallerCurso itemdato) {

        repoTallerCurso.save(itemdato);

    }

    public void borrarDato(int id) {

        repoTallerCurso.deleteById(id);

    }

    public boolean existsByIdT(int id) {

        return repoTallerCurso.existsById(id);

    }

    public boolean existsByNombreT(String nombre) {

        return repoTallerCurso.existsByNombre(nombre);

    }

}
