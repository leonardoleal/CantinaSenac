package com.senac.cantina.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class VendaModelo extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private String header[];
    private List<ArrayList> vendas;

    public VendaModelo() {
        vendas = new ArrayList<ArrayList>();

    }

    public VendaModelo(String[] header) {
        this.header = header;
    }

    public VendaModelo(String[] header, List<ArrayList> vendas) {
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
        return (vendas.get(rowIndex).get(columnIndex));
    }

    public void addVenda(List<ArrayList> c) {
        vendas.add((ArrayList) c);
    }

    public void removeVenda(int linha) {
        vendas.remove(linha);
    }

    public List<ArrayList> getVenda(int linha) {
        return (vendas.get(linha));
    }
}
