package ar.edu.unnoba.poo2013.model.repository;

import ar.edu.unnoba.poo2013.model.model.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDao {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<MaterialEducativo> materialEducativo = new ArrayList<MaterialEducativo>();
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Usuario> getEvaluador() {
        List<Usuario> usuario=new ArrayList<Usuario>();
        for (Usuario User : this.getUsuarios()){
            if(User.getTipo().equals("Evaluador")){
                usuario.add(User);
            }
        }
        return usuario;
    }
    public List<Usuario> getAdministrador() {
        List<Usuario> usuario=new ArrayList<Usuario>();
        for (Usuario User : this.getUsuarios()){
            if(User.getTipo().equals("Administrador")){
                usuario.add(User);
            }
        }
        return usuario;    }

    public List<MaterialEducativo> getMaterialEducativo() {
        return materialEducativo;
    }

    public void setMaterialEducativo(List<MaterialEducativo> materialEducativo) {
        this.materialEducativo = materialEducativo;
    }

}
