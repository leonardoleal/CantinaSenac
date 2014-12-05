package com.senac.cantina.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.senac.cantina.controller.RelatorioController;

public class RelatorioView extends JFrame {
    private static final long serialVersionUID = 1L;

    private RelatorioController relatorioC;
    private JTable tabela;

    public RelatorioView(RelatorioController relatorioC) {
        this.relatorioC = relatorioC;
        init();
    }

    private void init() {
        setTitle("Relatório - Cantina Senac");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(400, 200, 800, 400);
        setLayout(new BorderLayout());

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Create and set up the content pane.
        tabela = new JTable();
        tabela.setMinimumSize(new Dimension(800, 400));
        tabela.setPreferredScrollableViewportSize(new Dimension(800, 400));
        tabela.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabela);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public void exibeRelatorio(AbstractTableModel atm) {
        tabela.setModel(atm);

        exibeJanela();
    }

    private void exibeJanela() {
//        pack();
        setResizable(false);
        this.setVisible(true);
    }

    public int solicitarMatriculaCliente() {
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do cliente:");
        return Integer.parseInt(matricula);
    }

    public int solicitarCodFuncinario() {
        String cod = JOptionPane.showInputDialog("Digite o código do funcionário:");
        return Integer.parseInt(cod);
    }

    public int[] solicitarMesAnoVenda() {
        String[] entrada = JOptionPane.showInputDialog("Digite a mes e ano (mm/aaaa):").split("[/]");

        int[] dados = new int[2];
        dados[0] = Integer.parseInt(entrada[0]);
        dados[1] = Integer.parseInt(entrada[1]);

        return dados;
    } 
}