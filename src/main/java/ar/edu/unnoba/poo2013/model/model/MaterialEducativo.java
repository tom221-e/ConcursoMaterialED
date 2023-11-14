package ar.edu.unnoba.poo2013.model.model;

import java.nio.file.Path;

public class MaterialEducativo{
    private String nombre;
    private String descripcion;
    private String grupo;
    private String creadores;

    private Path ubicacion;

    private Integer gusta=0;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCreadores() {
        return creadores;
    }

    public void setCreadores(String creadores) {
        this.creadores = creadores;
    }

    public Path getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Path ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getGusta() {
        return gusta;
    }

    public void setGusta(Integer gusta) {
        this.gusta = gusta;
    }

    public void meGusta(){
        this.gusta++;
    }
}
