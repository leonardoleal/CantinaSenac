package com.senac.cantina.model;

import java.util.Date;

public class Venda {
    private int id;
    private int idFuncionario;
    private Funcionario funcionario;
    private int idCliente;
    private Cliente cliente;
    private double total;
    private Date data;

    public Venda() {}

    public Venda(int id, int idFuncionario, int idCliente, double total, Date data) {
        this.id = id;
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.total = total;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}