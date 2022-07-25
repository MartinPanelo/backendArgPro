package com.ArgentinaPrograma.FinalArgPro.controller;

import com.ArgentinaPrograma.FinalArgPro.Dto.DtoEducacion;
import com.ArgentinaPrograma.FinalArgPro.Entity.Educacion;
import com.ArgentinaPrograma.FinalArgPro.Security.Controller.Mensaje;
import com.ArgentinaPrograma.FinalArgPro.servicio.ServiceEducacion;
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
@RequestMapping("educacion")
@CrossOrigin(origins = "https://frontendargpro.web.app")
public class ControllerEducacion {

    @Autowired
    ServiceEducacion Seducacion;

    @GetMapping("/recibir")
    public ResponseEntity<List<Educacion>> resibirlistadatos() {

        List<Educacion> lista = Seducacion.verDatosE();

        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> agregardato(@RequestBody DtoEducacion item) {

        if (StringUtils.isBlank(item.getInstitucion())) {
            return new ResponseEntity(new Mensaje("la institucion es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        if (Seducacion.existsByDetalle1E(item.getDetalle1())) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(item.getGrado(), item.getInstitucion(), item.getUbicacion(), item.getDetalle1(), item.getDetalle2(), item.getLogo());

        Seducacion.savedatoE(educacion);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editardato(@PathVariable("id") int id, @RequestBody DtoEducacion item) {

        if (!Seducacion.existsByIdE(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.BAD_REQUEST);
        }
        if (Seducacion.existsByDetalle1E(item.getDetalle1()) && Seducacion.getByNombreE(item.getDetalle1()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(item.getInstitucion())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = Seducacion.getonedatoE(id).get();

        educacion.setGrado(item.getGrado());
        educacion.setInstitucion(item.getInstitucion());
        educacion.setUbicacion(item.getUbicacion());
        educacion.setDetalle1(item.getDetalle1());
        educacion.setDetalle2(item.getDetalle2());
        educacion.setLogo(item.getLogo());

        Seducacion.savedatoE(educacion);

        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrardato(@PathVariable("id") int id) {

        if (!Seducacion.existsByIdE(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.NOT_FOUND);
        }

        Seducacion.borrarDato(id);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> detailPorId(@PathVariable("id") int id) {
        if (!Seducacion.existsByIdE(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = Seducacion.getonedatoE(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

}
