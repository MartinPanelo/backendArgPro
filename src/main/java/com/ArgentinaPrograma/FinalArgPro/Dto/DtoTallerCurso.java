package com.ArgentinaPrograma.FinalArgPro.Dto;

public class DtoTallerCurso {
    private String tipocapacitacion;
    private String nombre;
    private String cargahoraria;
    private String detalle1;
     private String detalle2;
    private String ubicacion;
    private String logo;

    public DtoTallerCurso() {
    }

    public DtoTallerCurso(String tipocapacitacion, String nombre, String cargahoraria, String detalle1, String detalle2, String ubicacion, String logo) {
        this.tipocapacitacion = tipocapacitacion;
        this.nombre = nombre;
        this.cargahoraria = cargahoraria;
        this.detalle1 = detalle1;
        this.detalle2 = detalle2;
        this.ubicacion = ubicacion;
        this.logo = logo;
    }

    public String getTipocapacitacion() {
        return tipocapacitacion;
    }

    public void setTipocapacitacion(String tipocapacitacion) {
        this.tipocapacitacion = tipocapacitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(String cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String getDetalle1() {
        return detalle1;
    }

    public void setDetalle1(String detalle1) {
        this.detalle1 = detalle1;
    }

    public String getDetalle2() {
        return detalle2;
    }

    public void setDetalle2(String detalle2) {
        this.detalle2 = detalle2;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }




    
}
