package com.ArgentinaPrograma.FinalArgPro.controller;

import com.ArgentinaPrograma.FinalArgPro.Dto.Dtoacerca;
import com.ArgentinaPrograma.FinalArgPro.Entity.Acerca;
import com.ArgentinaPrograma.FinalArgPro.Security.Controller.Mensaje;
import com.ArgentinaPrograma.FinalArgPro.servicio.ServiceAcerca;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("acerca")
@CrossOrigin(origins = "https://frontendargpro.web.app")
public class ControllerAcerca {

    @Autowired
    ServiceAcerca Sacerca;

    @GetMapping("/recibir")
    public ResponseEntity<List<Acerca>> resibirlistadatos() {

        List<Acerca> lista = Sacerca.verDatos();

        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> agregardato(@RequestBody Dtoacerca item) {

        if (StringUtils.isBlank(item.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        if (Sacerca.existsByNombreA(item.getNombre())) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }

        Acerca acerca = new Acerca(item.getNombre(), item.getApellido(), item.getUbicacion(), item.getBanner(),item.getFoto(), item.getAcerca(), item.getTitulo());

        Sacerca.savedato(acerca);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    // url +/nombre & apellido etc
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editardato(@PathVariable("id") int id, @RequestBody Dtoacerca item) {

        if (!Sacerca.existsByIdA(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.BAD_REQUEST);
        }
        if (Sacerca.existsByNombreA(item.getNombre()) && Sacerca.getByNombre(item.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(item.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        Acerca acerca = Sacerca.getonedato(id).get();

        acerca.setNombre(item.getNombre());
        acerca.setApellido(item.getApellido());
        acerca.setUbicacion(item.getUbicacion());
        acerca.setBanner(item.getBanner());
        acerca.setFoto(item.getFoto());
        acerca.setAcerca(item.getAcerca());
        acerca.setTitulo(item.getTitulo());

        Sacerca.savedato(acerca);

        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrardato(@PathVariable("id") int id) {

        if (!Sacerca.existsByIdA(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.NOT_FOUND);
        }

        Sacerca.borrarDato(id);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Acerca> detailPorId(@PathVariable("id") int id) {
        if (!Sacerca.existsByIdA(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Acerca acerca = Sacerca.getonedato(id).get();
        return new ResponseEntity(acerca, HttpStatus.OK);
    }

}
