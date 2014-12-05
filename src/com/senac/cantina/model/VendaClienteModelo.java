package com.senac.cantina.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class VendaClienteModelo extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private String header[];
    private List<Venda> vendas;

    public VendaClienteModelo() {
        vendas = new ArrayList<Venda>();

    }

    public VendaClienteModelo(String[] header) {
        this.header = header;
    }

    public VendaClienteModelo(String[] header, List<Venda> vendas) {
        this.header = header;
        this.vendas = vendas;

    }

    @Override
    public int getRowCount() {
        return (vendas.size());
    }

    @Override
    public int getColumnCount() {
        return (header.length);
    }

    @Override
    public String getColumnName(int column) {
        return header[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (vendas.get(rowIndex).getData());
        } else {
            return (vendas.get(rowIndex).getTotal());
        }
    }

    public void addVenda(Venda c) {
        vendas.add(c);
    }

    public void removeVenda(int linha) {
        vendas.remove(linha);
    }

    public Venda getVenda(int linha) {
        return (vendas.get(linha));
    }
}
