package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Produto;

public interface ProdutoDao {
    public Produto inserir(Produto Produto);
    public boolean deletar(Produto Produto);
    public boolean atualizar(Produto Produto);
    public List<Produto> listar();
    public Produto buscarPorId(Produto Produto);
}