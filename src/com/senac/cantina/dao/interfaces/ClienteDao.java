package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Cliente;

public interface ClienteDao {
    public Cliente inserir(Cliente cliente);
    public boolean deletar(Cliente cliente);
    public boolean atualizar(Cliente cliente);
    public List<Cliente> listar();
    public Cliente buscarPorId(Cliente cliente);
    public Cliente buscarPorMatricula(Cliente cliente);
}