package org;

import java.util.List;

public class Animacao {
    private final int velocidade;
    private final List<Imagem> imagens;
    private long inicio;
    private final int tamanho;

    public Animacao(int velocidade, List<Imagem> imagens) {
        this.velocidade = velocidade;
        this.imagens = imagens;
        this.inicio = System.currentTimeMillis();
        this.tamanho = imagens.size();
    }

    public Imagem imagem() {
        if (velocidade == 0) {
            return imagens.get(0); // Ou outra imagem padrão
        }
        int indice = (int) ((System.currentTimeMillis() - inicio) / velocidade % tamanho);
        return imagens.get(indice);
    }

    public void reiniciar() {
        // Reinicia a animação, definindo o tempo de início para o tempo atual
        // Isso faz com que a animação volte ao início
        inicio = System.currentTimeMillis();
    }
}
