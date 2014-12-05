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
        int matricula = relatorioView.solicitarMatriculaCliente();

        VendaDaoJdbc vJdbc = new VendaDaoJdbc();
        AbstractTableModel atm = vJdbc.listarVendaPorCliente(matricula);

        relatorioView.exibeRelatorio(atm);
    }

    private void vendaPorFuncionario() {
        int cod = relatorioView.solicitarCodFuncinario();

        VendaDaoJdbc vJdbc = new VendaDaoJdbc();
        AbstractTableModel atm = vJdbc.listarVendaPorFuncionario(cod);

        relatorioView.exibeRelatorio(atm);
    }

    private void vendaPorMes() {
        int[] dados = relatorioView.solicitarMesAnoVenda();

        VendaDaoJdbc vJdbc = new VendaDaoJdbc();
        AbstractTableModel atm = vJdbc.listarVendaPorMes(dados[0], dados[1]);

        relatorioView.exibeRelatorio(atm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}