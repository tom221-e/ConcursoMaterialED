package ar.edu.unnoba.poo2013.model.model;

import java.nio.file.Path;

public abstract class MaterialEstate {
    private Path ubicacion;
    private Participante creador;
    private Evaluador evaluador;
    private Integer gusta=0;

    public Path getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Path ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Participante getCreador() {
        return creador;
    }

    public void setCreador(Participante creador) {
        this.creador = creador;
    }

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }

    public Integer getGusta() {
        return gusta;
    }

    public void setGusta(Integer gusta) {
        this.gusta = gusta;
    }

}
