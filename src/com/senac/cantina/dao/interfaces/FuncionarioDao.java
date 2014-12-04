package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Funcionario;

public interface FuncionarioDao {
    public Funcionario inserir(Funcionario funcionario);
    public boolean deletar(Funcionario funcionario);
    public boolean atualizar(Funcionario funcionario);
    public List<Funcionario> listar();
    public Funcionario buscarPorId(Funcionario funcionario);
}