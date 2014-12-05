package com.senac.cantina.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
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
        setBounds(400, 200, 500, 400);
        setLayout(new BorderLayout());

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Create and set up the content pane.
        tabela = new JTable();
        tabela.setMinimumSize(new Dimension(500, 400));
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 400));
        tabela.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabela);

        //Add the scroll pane to this panel.
        add(scrollPane);
        add(tabela, BorderLayout.CENTER);
    }

    public void exibeRelatorio(AbstractTableModel atm) {
        tabela.setModel(atm);
        tabela.updateUI();

        exibeJanela();
    }

    private void exibeJanela() {
//        pack();
        setResizable(false);
        this.setVisible(true);
    } 
}