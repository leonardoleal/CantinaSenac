package com.senac.cantina.dao;

import java.util.List;

import com.senac.cantina.dao.interfaces.ProdutoDao;
import com.senac.cantina.model.Produto;

public class ProdutoDaoJdbc extends Dao implements ProdutoDao {

    @Override
    public Produto inserir(Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deletar(Produto produto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean atualizar(Produto produto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Produto> listar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Produto buscarPorId(Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }

}