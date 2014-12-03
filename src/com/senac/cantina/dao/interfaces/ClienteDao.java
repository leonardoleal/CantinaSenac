package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Cliente;

public interface ClienteDao {
    public Cliente inserir(Cliente Cliente);
    public boolean deletar(Cliente Cliente);
    public boolean atualizar(Cliente Cliente);
    public List<Cliente> listar();
    public Cliente buscarPorId(Cliente cliente);
    public Cliente buscarPorMatricula(Cliente cliente);
}