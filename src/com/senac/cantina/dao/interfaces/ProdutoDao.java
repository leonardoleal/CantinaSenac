package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Produto;

public interface ProdutoDao {
    public Produto inserir(Produto produto);
    public boolean deletar(Produto produto);
    public boolean atualizar(Produto produto);
    public List<Produto> listar();
    public Produto buscarPorId(Produto produto);
}