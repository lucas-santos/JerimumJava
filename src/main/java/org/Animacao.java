// Classe: Animacao
// Função: Gerencia uma sequência de imagens que formam uma animação.
// Atributos:
//  velocidade: Controla a velocidade da animação.
//  imagens: Lista de imagens que compõem a animação.
//  inicio: Marca o tempo de início da animação.
//  tamanho: Número total de imagens na animação.
// Método:
//  imagem(): Retorna a imagem atual da animação com base no tempo decorrido e na velocidade.

package org;

import java.util.List;

public class Animacao {
    private final int velocidade;
    private final List<Imagem> imagens;
    private final long inicio;
    private final int tamanho;

    public Animacao(int velocidade, List<Imagem> imagens) {
        this.velocidade = velocidade;
        this.imagens = imagens;
        this.inicio = System.currentTimeMillis();
        this.tamanho = imagens.size();
    }

    public Imagem imagem() {
        int indice = (int) ((System.currentTimeMillis() - inicio) / velocidade % tamanho);
        return imagens.get(indice);
    }
}