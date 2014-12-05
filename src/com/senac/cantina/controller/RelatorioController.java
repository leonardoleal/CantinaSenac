package com.senac.cantina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.senac.cantina.dao.VendaDaoJdbc;
import com.senac.cantina.view.RelatorioView;

public class RelatorioController implements ActionListener {
    public enum tipoRelatorio {VENDAPORCLIENTE, VENDAPORFUNCIONARIO, VENDAPORMES};
    private tipoRelatorio tipo;
    private RelatorioView relatorioView;

    public RelatorioController(tipoRelatorio tipoRelatorio) {
        tipo = tipoRelatorio;
        relatorioView = new RelatorioView(this);

        switch (tipo) {
            case VENDAPORCLIENTE:
                vendaPorCliente();
                break;

            case VENDAPORFUNCIONARIO:
                vendaPorFuncionario();
                break;

            case VENDAPORMES:
                vendaPorMes();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Tipo de relatório inválido.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private void vendaPorCliente() {
        VendaDaoJdbc vJdbc = new VendaDaoJdbc();
        AbstractTableModel atm = vJdbc.listarVendaPorCliente(27);
        relatorioView.exibeRelatorio(atm);
    }

    private void vendaPorFuncionario() {
        VendaDaoJdbc vJdbc = new VendaDaoJdbc();
        AbstractTableModel atm = vJdbc.listarVendaPorCliente(2);
        relatorioView.exibeRelatorio(atm);
    }

    private void vendaPorMes() {
        VendaDaoJdbc vJdbc = new VendaDaoJdbc();
        AbstractTableModel atm = vJdbc.listarVendaPorMes(12, 2014);
        relatorioView.exibeRelatorio(atm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}