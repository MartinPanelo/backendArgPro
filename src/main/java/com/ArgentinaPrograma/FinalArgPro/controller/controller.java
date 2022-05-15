
package com.ArgentinaPrograma.FinalArgPro.controller;


import com.ArgentinaPrograma.FinalArgPro.datosportfolio.datos;
import com.ArgentinaPrograma.FinalArgPro.servicio.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    
    @Autowired
    private IPersonaService persoservi;
    
    
    @PostMapping ("/crear")
     public void agregardato (@RequestBody datos item){
         
         persoservi.crearDato(item);
         
     }
     
     @GetMapping("/recibir")
     @ResponseBody
     public List<datos> resibirdato(){
         
         
        return persoservi.verDatos();
         
         
     }
     
     @DeleteMapping ("/borrar/{id}")
     public void barrardato(@PathVariable Long id){
         
         persoservi.borrarDato(id);
         
     }
    
    
}
