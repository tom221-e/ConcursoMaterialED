package ar.edu.unnoba.poo2013.model.model;

import jakarta.persistence.*;

@Entity
@Table(name="materialeducativo")
public class MaterialEducativo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmaterialed")
    private Long Id;
    private String nombre;
    private String descripcion;
    private String grupo;
    private String creadores;
    private String estado;
    private String ubicacion;
    private Integer gusta=0;


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
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

    public void setEnRevision(){
        this.setEstado("Revision");
    }
    public void setAprobado(){
        this.setEstado("Aprobado");
    }
}