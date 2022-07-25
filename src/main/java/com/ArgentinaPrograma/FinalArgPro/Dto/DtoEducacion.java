package com.ArgentinaPrograma.FinalArgPro.Dto;

public class DtoEducacion {
    
    private String grado;
    private String institucion;
    private String ubicacion;
    private String detalle1;
    private String detalle2;
    private String logo;

    public DtoEducacion() {
    }

    public DtoEducacion(String grado, String institucion, String ubicacion, String detalle1, String detalle2, String logo) {
        this.grado = grado;
        this.institucion = institucion;
        this.ubicacion = ubicacion;
        this.detalle1 = detalle1;
        this.detalle2 = detalle2;
        this.logo = logo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    
    
}
