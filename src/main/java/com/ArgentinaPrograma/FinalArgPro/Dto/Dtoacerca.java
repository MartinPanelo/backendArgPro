package com.ArgentinaPrograma.FinalArgPro.Dto;

import javax.validation.constraints.NotBlank;

public class Dtoacerca {
      
 //   @NotBlank
    private String nombre;
  //  @NotBlank
    private String apellido;
  //  @NotBlank
    private String ubicacion;
 //   @NotBlank
    private String banner;
    private String foto;
 //   @NotBlank
    private String acerca;
 //   @NotBlank
    private String titulo;

    public Dtoacerca() {
    }

    public Dtoacerca(String nombre, String apellido, String ubicacion, String banner, String foto, String acerca, String titulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ubicacion = ubicacion;
        this.banner = banner;
        this.foto = foto;
        this.acerca = acerca;
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
}
