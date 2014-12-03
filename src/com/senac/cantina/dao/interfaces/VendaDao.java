package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Cliente;
import com.senac.cantina.model.Funcionario;
import com.senac.cantina.model.Venda;

public interface VendaDao {
    public Venda inserir(Cliente cliente, Funcionario funcionario);
    public boolean deletar(Venda codigoVenda);
    public List<Integer> listar(Funcionario funcionario);
    public List<Integer> listar(Cliente cliente);
}