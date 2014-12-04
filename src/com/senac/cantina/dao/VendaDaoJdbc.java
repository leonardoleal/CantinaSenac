package com.senac.cantina.dao;

import java.util.List;

import com.senac.cantina.dao.interfaces.VendaDao;
import com.senac.cantina.model.Cliente;
import com.senac.cantina.model.Funcionario;
import com.senac.cantina.model.Venda;

public class VendaDaoJdbc extends Dao implements VendaDao {

    @Override
    public Venda inserir(Cliente cliente, Funcionario funcionario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deletar(Venda codigoVenda) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Integer> listar(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Integer> listar(Cliente cliente) {
        // TODO Auto-generated method stub
        return null;
    }

}