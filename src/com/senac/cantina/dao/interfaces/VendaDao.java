package com.senac.cantina.dao.interfaces;

import javax.swing.table.AbstractTableModel;

import com.senac.cantina.model.Cliente;
import com.senac.cantina.model.Funcionario;
import com.senac.cantina.model.Venda;

public interface VendaDao {
    public Venda registrar(Cliente cliente, Funcionario funcionario, Double total);
    public boolean deletar(Venda codigoVenda);
    public AbstractTableModel listarVendaPorFuncionario(int id);
    public AbstractTableModel listarVendaPorCliente(int id);
    public AbstractTableModel listarVendaPorMes(int mes, int ano);
}