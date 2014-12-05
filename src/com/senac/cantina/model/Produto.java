package com.senac.cantina.model;

public class Produto {
    private int id;
    private int idCategoria;
    private CategoriaProduto categoria;
    private String nome;
    private double valor;

    public Produto() {}

    public Produto(int id, int idCategoria, String nome, double valor) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }
}