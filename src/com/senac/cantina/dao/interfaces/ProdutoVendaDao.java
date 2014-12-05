package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Produto;
import com.senac.cantina.model.ProdutoVenda;
import com.senac.cantina.model.Venda;

public interface ProdutoVendaDao {
	public ProdutoVenda cadastrarItemVenda(Venda venda, Produto produto, int quantidade);
	public List<Integer> getIdProdutoDoCarrinho(Venda venda);
	public void deletarProdutosDaVenda(Venda venda);
}
