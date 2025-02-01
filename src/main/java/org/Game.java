package org;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private static final Imagem fundo = Imagem.carregar("src/main/resources/assets/Space.png");
  private static final Imagem naveImagem = Imagem.carregar("src/main/resources/assets/Nave.png");
  private static final Imagem estrelaImagem = Imagem.carregar("src/main/resources/assets/Estrela.png");

  private static double naveX = 320; // Posição inicial da nave no eixo X
  private static double naveY = 400; // Posição inicial da nave no eixo Y
  private static final double naveVelocidade = 5.0; // Velocidade de movimento da nave
  private static final List<double[]> estrelas = new ArrayList<>(); // Lista de estrelas (x, y)

  public static void main(String[] args) {
    Jogo jogo = new Jogo();
    jogo.iniciar("Game Test", 640, 480, atualize(), desenhe());
  }

  public static Runnable atualize() {
    return () -> {
      // Lógica de atualização do jogo
      atualizarMovimentoNave();
      atualizarEstrelas();
    };
  }

  public static Runnable desenhe() {
    return () -> {
      // Lógica de desenho do jogo
      fundo.desenhe(0, 0, 0, 0, 1, 1);
      desenharEstrelas();
      naveImagem.desenhe(naveX, naveY, 1, 0, 1, 1);
    };
  }

  private static void atualizarMovimentoNave() {
    if (Teclado.teclaPressionada(Teclado.TECLA_PARA_DIREITA)) {
      naveX += naveVelocidade;
    }
    if (Teclado.teclaPressionada(Teclado.TECLA_PARA_ESQUERDA)) {
      naveX -= naveVelocidade;
    }
    if (Teclado.teclaPressionada(Teclado.TECLA_PARA_CIMA)) {
      naveY -= naveVelocidade;
    }
    if (Teclado.teclaPressionada(Teclado.TECLA_W)) {
      naveY -= naveVelocidade;
    }
    if (Teclado.teclaPressionada(Teclado.TECLA_A)) {
      naveX -= naveVelocidade;
    }
    if (Teclado.teclaPressionada(Teclado.TECLA_D)) {
      naveX += naveVelocidade;
    }

    // Limitar a nave para não sair da tela
    naveX = Math.max(0, Math.min(naveX, Jogo.getLargura() - naveImagem.buffer.getWidth()));
    naveY = Math.max(0, Math.min(naveY, Jogo.getAltura() - naveImagem.buffer.getHeight()));
  }

  private static void atualizarEstrelas() {
    // Adicionar novas estrelas periodicamente
    if (Math.random() < 0.02) {
      estrelas.add(new double[] { Math.random() * Jogo.getLargura(), 0 });
    }

    // Atualizar a posição das estrelas
    for (int i = 0; i < estrelas.size(); i++) {
      double[] estrela = estrelas.get(i);
      estrela[1] += 2; // Movimento das estrelas para baixo

      // Remover estrela se sair da tela
      if (estrela[1] > Jogo.getAltura()) {
        estrelas.remove(i);
        i--;
      }
    }
  }

  private static void desenharEstrelas() {
    for (double[] estrela : estrelas) {
      estrelaImagem.desenhe(estrela[0], estrela[1], 0, 0, 0.5, 0.5); // Desenhar estrela menor
    }
  }
}
