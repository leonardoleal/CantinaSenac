package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Funcionario;

public interface FuncionarioDao {
    public Funcionario inserir(Funcionario Funcionario);
    public boolean deletar(Funcionario Funcionario);
    public boolean atualizar(Funcionario Funcionario);
    public List<Funcionario> listar();
    public Funcionario buscarPorId(Funcionario Funcionario);
}