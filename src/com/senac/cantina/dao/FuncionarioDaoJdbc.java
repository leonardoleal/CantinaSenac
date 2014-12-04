package com.senac.cantina.dao;

import java.util.List;

import com.senac.cantina.dao.interfaces.FuncionarioDao;
import com.senac.cantina.model.Funcionario;

public class FuncionarioDaoJdbc extends Dao implements FuncionarioDao {

    @Override
    public Funcionario inserir(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deletar(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Funcionario> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Funcionario buscarPorId(Funcionario funcionario) {
        // TODO Auto-generated method stub
        return null;
    }

}