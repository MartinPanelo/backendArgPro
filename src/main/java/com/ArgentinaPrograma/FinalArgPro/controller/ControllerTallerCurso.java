package com.ArgentinaPrograma.FinalArgPro.controller;

import com.ArgentinaPrograma.FinalArgPro.Dto.DtoTallerCurso;
import com.ArgentinaPrograma.FinalArgPro.Entity.TallerCurso;
import com.ArgentinaPrograma.FinalArgPro.Security.Controller.Mensaje;
import com.ArgentinaPrograma.FinalArgPro.servicio.ServiceTallerCurso;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tallercurso")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerTallerCurso {

    @Autowired
    ServiceTallerCurso StallerCurso;
 
    @GetMapping("/recibir")
    public ResponseEntity<List<TallerCurso>> resibirlistadatos() {

        List<TallerCurso> lista = StallerCurso.verDatos();

        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> agregardato(@RequestBody DtoTallerCurso item) {

        if (StringUtils.isBlank(item.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        if (StallerCurso.existsByNombreT(item.getNombre())) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }

        TallerCurso tallerCurso = new TallerCurso(item.getTipocapacitacion(), item.getNombre(), item.getCargahoraria(), item.getDetalle1(), item.getDetalle2(), item.getUbicacion(), item.getLogo());

        StallerCurso.savedato(tallerCurso);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editardato(@PathVariable("id") int id, @RequestBody DtoTallerCurso item) {

        if (!StallerCurso.existsByIdT(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.BAD_REQUEST);
        }
        if (StallerCurso.existsByNombreT(item.getNombre()) && StallerCurso.getByNombre(item.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(item.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        TallerCurso tallerCurso = StallerCurso.getonedato(id).get();

        tallerCurso.setTipocapacitacion(item.getTipocapacitacion());
        tallerCurso.setNombre(item.getNombre());
        tallerCurso.setCargahoraria(item.getCargahoraria());
        tallerCurso.setDetalle1(item.getDetalle1());
        tallerCurso.setDetalle2(item.getDetalle2());
        tallerCurso.setUbicacion(item.getUbicacion());
        tallerCurso.setLogo(item.getLogo());

        StallerCurso.savedato(tallerCurso);

        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrardato(@PathVariable("id") int id) {

        if (!StallerCurso.existsByIdT(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.NOT_FOUND);
        }

        StallerCurso.borrarDato(id);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TallerCurso> detailPorId(@PathVariable("id") int id) {
        if (!StallerCurso.existsByIdT(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        TallerCurso tallerCurso = StallerCurso.getonedato(id).get();
        return new ResponseEntity(tallerCurso, HttpStatus.OK);
    }
}
