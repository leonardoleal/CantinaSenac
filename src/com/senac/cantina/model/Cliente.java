package com.senac.cantina.model;

public class Cliente extends Usuario {
    private int id;
    private int idUsuario;
    private int matricula;
    private String email;
    private double saldo;
    private Usuario usuario;

    public Cliente() {};

    public Cliente(int id, int idUsuario, int matricula, String email,
            double saldo) {
        super();
        this.id = id;
        this.idUsuario = idUsuario;
        this.matricula = matricula;
        this.email = email;
        this.saldo = saldo;
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuarioObject() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario != null) {
            this.usuario = usuario;
            this.idUsuario = usuario.getId();
        }
    }
}