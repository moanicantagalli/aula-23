package br.com.starlog.model;

public class CriptoMensagem {
    private final String remetente;
    private final String mensagem;
    private final int chaveDeslocamento;

    public CriptoMensagem(String remetente, String mensagem, int chaveDeslocamento) {
        if (remetente == null || remetente.isBlank()) {
            throw new IllegalArgumentException("Remetente não pode ser nulo ou vazio.");
        }
        if (mensagem == null || mensagem.isBlank()) {
            throw new IllegalArgumentException("Mensagem não pode ser nula ou vazia.");
        }
        if (chaveDeslocamento < 1 || chaveDeslocamento > 25) {
            throw new IllegalArgumentException("Chave deve estar entre 1 e 25.");
        }
        this.remetente = remetente.trim().toUpperCase();
        this.mensagem = mensagem.trim().toUpperCase();
        this.chaveDeslocamento = chaveDeslocamento;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getChaveDeslocamento() {
        return chaveDeslocamento;
    }

    public String cifrar() {
        StringBuilder cifrado = new StringBuilder();
        for (char c : mensagem.toCharArray()) {
            boolean letra = c >= 'A' && c <= 'Z';
            cifrado.append(letra ? (char) ('A' + (c - 'A' + chaveDeslocamento) % 26) : c);
        }
        return cifrado.toString();
    }

    public int calcularChecksum() {
        return mensagem.chars().sum();
    }
}
