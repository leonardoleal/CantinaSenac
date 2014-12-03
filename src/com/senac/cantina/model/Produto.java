package com.senac.cantina.model;

public class Produto {
    private int id;
    private int categoriaId;
    private CategoriaProduto categoria;
    private double valor;

    public Produto() {}

    public Produto(int id, int categoriaId, double valor) {
        this.id = id;
        this.categoriaId = categoriaId;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
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