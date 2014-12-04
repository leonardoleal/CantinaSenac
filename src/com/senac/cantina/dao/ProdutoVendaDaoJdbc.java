package com.senac.cantina.dao;

import java.util.List;

import com.senac.cantina.dao.interfaces.ProdutoVendaDao;
import com.senac.cantina.model.Produto;
import com.senac.cantina.model.ProdutoVenda;
import com.senac.cantina.model.Venda;

public class ProdutoVendaDaoJdbc extends Dao implements ProdutoVendaDao {

    @Override
    public ProdutoVenda cadastrarIdemVenda(Venda venda, Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Integer> getIdProdutoDoCarrinho(Venda venda) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletarProdutosDaVenda(Venda venda) {
        // TODO Auto-generated method stub
        
    }

}