package com.senac.cantina.dao.interfaces;

import java.util.List;

import com.senac.cantina.model.Produto;
import com.senac.cantina.model.ProdutoVenda;
import com.senac.cantina.model.Venda;

public interface ProdutoVendaDao {
	public ProdutoVenda cadastrarIdemVenda(Venda venda, Produto produto);
	public List<Integer> getIdProdutoDoCarrinho(Venda venda);
	public void deletarProdutosDaVenda(Venda venda);
}
