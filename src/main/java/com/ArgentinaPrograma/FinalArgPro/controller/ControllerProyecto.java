package com.ArgentinaPrograma.FinalArgPro.controller;

import com.ArgentinaPrograma.FinalArgPro.Dto.DtoProyecto;
import com.ArgentinaPrograma.FinalArgPro.Entity.Proyecto;
import com.ArgentinaPrograma.FinalArgPro.Security.Controller.Mensaje;
import com.ArgentinaPrograma.FinalArgPro.servicio.ServiceProyecto;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "https://frontendargpro.web.app")
public class ControllerProyecto {

    @Autowired
    ServiceProyecto Sproyecto;

    @GetMapping("/recibir")
    public ResponseEntity<List<Proyecto>> resibirlistadatos() {

        List<Proyecto> lista = Sproyecto.verDatos();

        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> agregardato(@RequestBody DtoProyecto item) {

        if (StringUtils.isBlank(item.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        if (Sproyecto.existsByNombreP(item.getNombre())) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(item.getNombre(), item.getFecha(), item.getDetalle(), item.getLink(), item.getFoto());

        Sproyecto.savedato(proyecto);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editardato(@PathVariable("id") int id, @RequestBody DtoProyecto item) {

        if (!Sproyecto.existsByIdP(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.BAD_REQUEST);
        }
        if (Sproyecto.existsByNombreP(item.getNombre()) && Sproyecto.getByNombre(item.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(item.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = Sproyecto.getonedato(id).get();

        proyecto.setNombre(item.getNombre());
        proyecto.setFecha(item.getFecha());
        proyecto.setDetalle(item.getDetalle());
        proyecto.setLink(item.getLink());
        proyecto.setFoto(item.getFoto());

        Sproyecto.savedato(proyecto);

        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrardato(@PathVariable("id") int id) {

        if (!Sproyecto.existsByIdP(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.NOT_FOUND);
        }

        Sproyecto.borrarDato(id);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> detailPorId(@PathVariable("id") int id) {
        if (!Sproyecto.existsByIdP(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = Sproyecto.getonedato(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

}
