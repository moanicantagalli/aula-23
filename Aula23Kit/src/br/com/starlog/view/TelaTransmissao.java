package br.com.starlog.view;

import br.com.starlog.controller.TransmissaoController;

import javax.swing.*;
import java.awt.FlowLayout;

public class TelaTransmissao extends JFrame {

    private final JTextField txtRemetente = new JTextField(20);
    private final JTextField txtMensagem = new JTextField(20);
    private final JTextField txtChaveCifra = new JTextField(5);
    private final JTextArea areaLog = new JTextArea(10, 35);

    public TelaTransmissao(TransmissaoController controller) {
        super("STARLOG-ZERO - Transmissão Cifrada");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnTransmitir = new JButton("Cifrar e Transmitir");
        areaLog.setEditable(false);

        add(new JLabel("Remetente da Frota:"));
        add(txtRemetente);
        add(new JLabel("Mensagem Secreta:"));
        add(txtMensagem);
        add(new JLabel("Chave de Deslocamento (César 1 a 25):"));
        add(txtChaveCifra);
        add(btnTransmitir);
        add(new JScrollPane(areaLog));

        btnTransmitir.addActionListener(e -> {
            try {
                areaLog.append(controller.processarTransmissao(
                        txtRemetente.getText(), txtMensagem.getText(), txtChaveCifra.getText()) + "\n");
                JOptionPane.showMessageDialog(this, "Transmissão efetuada com sucesso!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage(),
                        "Falha na transmissão", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
