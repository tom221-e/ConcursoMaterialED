package ar.edu.unnoba.poo2013.model.repository;

import ar.edu.unnoba.poo2013.model.model.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDao {
    private List<Participante> participante = new ArrayList<Participante>();
    private List<Evaluador> evaluador = new ArrayList<Evaluador>();
    private List<Administrador> administrador = new ArrayList<Administrador>();
    private List<MaterialAprovado> materialAprovado = new ArrayList<MaterialAprovado>();
    private List<MaterialASerRevisado> materialASerRevisado = new ArrayList<MaterialASerRevisado>();
    private List<MaterialFinalizadoElConcurso> materialFinalizadoElConcurso = new ArrayList<MaterialFinalizadoElConcurso>();

    public List<Participante> getParticipante() {
        return participante;
    }
    public void saveFilePath(String filePath){
        MaterialAprovado materialAprovado1=new MaterialAprovado();
        materialAprovado1.setUbicacion(filePath);
        getMaterialAprovado().add(materialAprovado1);
    }

    public void setParticipante(List<Participante> participante) {
        this.participante = participante;
    }

    public List<Evaluador> getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(List<Evaluador> evaluador) {
        this.evaluador = evaluador;
    }

    public List<Administrador> getAdministrador() {
        return administrador;
    }

    public void setAdministrador(List<Administrador> administrador) {
        this.administrador = administrador;
    }

    public List<MaterialAprovado> getMaterialAprovado() {
        return materialAprovado;
    }

    public void setMaterialAprovado(List<MaterialAprovado> materialAprovado) {
        this.materialAprovado = materialAprovado;
    }

    public List<MaterialASerRevisado> getMaterialASerRevisado() {
        return materialASerRevisado;
    }

    public void setMaterialASerRevisado(List<MaterialASerRevisado> materialASerRevisado) {
        this.materialASerRevisado = materialASerRevisado;
    }

    public List<MaterialFinalizadoElConcurso> getMaterialFinalizadoElConcurso() {
        return materialFinalizadoElConcurso;
    }

    public void setMaterialFinalizadoElConcurso(List<MaterialFinalizadoElConcurso> materialFinalizadoElConcurso) {
        this.materialFinalizadoElConcurso = materialFinalizadoElConcurso;
    }

    public MaterialAprovado buscar(MaterialAprovado material) {
        for (MaterialAprovado mat : this.getMaterialAprovado()) {
            if (material.getUbicacion().equals(material.getUbicacion())) {
                return material;
            }
        }
        return null;
    }
}
