package ar.edu.unnoba.poo2013.model.model;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name="usuario")
public abstract class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private Long id;
    private String username;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String instituto;
    private String tipo;
    @JoinColumn(name = "idmaterialed", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaterialEducativo materialEducativo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MaterialEducativo getMaterialEducativo() {
        return materialEducativo;
    }

    public void setMaterialEducativo(MaterialEducativo materialEducativo) {
        this.materialEducativo = materialEducativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getTipo() {
        return tipo;
    }

    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public boolean isParticipante(){
        if(this.getTipo().equals("Participante")){
            return true;
        }
        return false;
    }
    public boolean isEvaluador(){
        if(this.getTipo().equals("Evaluador")){
            return true;
        }
        return false;
    }
    public boolean isAdministrador(){
        if(this.getTipo().equals("Administrador")){
            return true;
        }
        return false;
    }



}
