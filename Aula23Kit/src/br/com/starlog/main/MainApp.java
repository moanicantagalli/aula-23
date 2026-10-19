package br.com.starlog.main;

import br.com.starlog.controller.TransmissaoController;
import br.com.starlog.view.TelaTransmissao;

import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new TelaTransmissao(new TransmissaoController()).setVisible(true));
    }
}
