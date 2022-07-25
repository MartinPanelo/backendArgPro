package com.ArgentinaPrograma.FinalArgPro.controller;

import com.ArgentinaPrograma.FinalArgPro.Dto.DtoSkill;
import com.ArgentinaPrograma.FinalArgPro.Entity.Skill;
import com.ArgentinaPrograma.FinalArgPro.Security.Controller.Mensaje;
import com.ArgentinaPrograma.FinalArgPro.servicio.ServiceSkill;
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
@RequestMapping("skill")
@CrossOrigin(origins = "https://frontendargpro.web.app")
public class ControllerSkill {

    @Autowired
    ServiceSkill Sskill;

    @GetMapping("/recibir")
    public ResponseEntity<List<Skill>> resibirlistadatos() {

        List<Skill> lista = Sskill.verDatos();

        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> agregardato(@RequestBody DtoSkill item) {

        if (StringUtils.isBlank(item.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        if (Sskill.existsByNombreS(item.getNombre())) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill(item.getNombre(), item.getValor(), item.getTipo());

        Sskill.savedato(skill);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editardato(@PathVariable("id") int id, @RequestBody DtoSkill item) {

        if (!Sskill.existsByIdS(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.BAD_REQUEST);
        }
        if (Sskill.existsByNombreS(item.getNombre()) && Sskill.getByNombre(item.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esta escribiendo lo mismo"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(item.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatoriio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = Sskill.getonedato(id).get();

        skill.setNombre(item.getNombre());
        skill.setValor(item.getValor());
        skill.setTipo(item.getTipo());

        Sskill.savedato(skill);

        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrardato(@PathVariable("id") int id) {

        if (!Sskill.existsByIdS(id)) {
            return new ResponseEntity(new Mensaje("error no se encontro el item"), HttpStatus.NOT_FOUND);
        }

        Sskill.borrarDato(id);
        return new ResponseEntity(new Mensaje("operacion realizada con exito"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> detailPorId(@PathVariable("id") int id) {
        if (!Sskill.existsByIdS(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = Sskill.getonedato(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
}
