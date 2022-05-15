package com.ArgentinaPrograma.FinalArgPro.datosportfolio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Setter;
import lombok.Getter;
    
@Getter @Setter
@Entity
public class datos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    private String nombre;
    private String apellido;
    
    public datos(){
    
    }

    public datos(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    
    
}


