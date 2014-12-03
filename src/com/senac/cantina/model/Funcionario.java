package com.senac.cantina.model;

public class Funcionario extends Usuario {
    private int id;
    private int idUsuario;

    public Funcionario(int id, int idUsuario) {
        super();
        this.id = id;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}