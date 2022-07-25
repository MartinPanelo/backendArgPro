package com.ArgentinaPrograma.FinalArgPro.Dto;

public class DtoProyecto {

    private String nombre;
    private String fecha;
    private String detalle;
    private String link;
    private String foto;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombre, String fecha, String detalle, String link, String foto) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.detalle = detalle;
        this.link = link;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    

}
