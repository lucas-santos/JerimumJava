package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Rectangle;

public class Game {
  private static final Imagem fundo = Imagem.carregar("src/main/resources/assets/Space.png");
  private static final Imagem naveImagem = Imagem.carregar("src/main/resources/assets/Nave.png");
  private static final Imagem estrelaImagem = Imagem.carregar("src/main/resources/assets/Estrela.png");

  private static double naveX = 320;
  private static double naveY = 400;
  private static final double naveVelocidade = 5.0;
  private static final List<double[]> estrelas = new ArrayList<>();
  private static final Random random = new Random();
  private static int pontuacao = 0;
  private static final Fonte fontePontuacao = new Fonte(20);

  public static void main(String[] args) {
    Jogo jogo = new Jogo();
    jogo.iniciar("Game Test", 640, 480, atualize(), desenhe());
  }

  public static Runnable atualize() {
    return () -> {
      atualizarMovimentoNave();
      atualizarEstrelas();
    };
  }

  public static Runnable desenhe() {
    return () -> {
      fontePontuacao.desenheCentralizado("Pontuação: " + pontuacao, Jogo.getLargura() / 2.0, 30, 2, Cor.BRANCO);
      fundo.desenhe(0, 0, 0, 0, 1, 1);
      desenharEstrelas();
      naveImagem.desenhe(naveX, naveY, 1, 0, 1, 1);
    };
  }

  private static void atualizarMovimentoNave() {
    if (Teclado.teclaPressionada(Teclado.TECLA_PARA_DIREITA) || Teclado.teclaPressionada(Teclado.TECLA_D)) {
      naveX += naveVelocidade;
    }
    if (Teclado.teclaPressionada(Teclado.TECLA_PARA_ESQUERDA) || Teclado.teclaPressionada(Teclado.TECLA_A)) {
      naveX -= naveVelocidade;
    }
    if (Teclado.teclaPressionada(Teclado.TECLA_PARA_CIMA) || Teclado.teclaPressionada(Teclado.TECLA_W)) {
      naveY -= naveVelocidade;
    }
    if (Teclado.teclaPressionada(Teclado.TECLA_BAIXO) || Teclado.teclaPressionada(Teclado.TECLA_S)) {
      naveY += naveVelocidade;
    }

    // Limitar a nave para não sair da tela
    naveX = Math.max(0, Math.min(naveX, Jogo.getLargura() - naveImagem.buffer.getWidth()));
    naveY = Math.max(0, Math.min(naveY, Jogo.getAltura() - naveImagem.buffer.getHeight()));
  }

  private static void atualizarEstrelas() {
    if (random.nextDouble() < 0.02) {
      estrelas.add(new double[] { random.nextDouble() * Jogo.getLargura(), 0 });
    }
    for (int i = 0; i < estrelas.size(); i++) {
      double[] estrela = estrelas.get(i);
      estrela[1] += 2;

      // Verifica colisão
      if (colidiuComNave(estrela)) {
        pontuacao += 10;
        estrelas.remove(i);
        i--;
      } else if (estrela[1] > Jogo.getAltura() + estrelaImagem.buffer.getHeight()) {
        estrelas.remove(i);
        i--;
      }
    }
  }

  private static boolean colidiuComNave(double[] estrela) {
    double naveLargura = naveImagem.buffer.getWidth();
    double naveAltura = naveImagem.buffer.getHeight();
    double estrelaLargura = estrelaImagem.buffer.getWidth();
    double estrelaAltura = estrelaImagem.buffer.getHeight();

    double centroEstrelaX = estrela[0] + estrelaLargura / 2;
    double centroEstrelaY = estrela[1] + estrelaAltura / 2;

    return centroEstrelaX >= naveX && centroEstrelaX <= naveX + naveLargura &&
            centroEstrelaY >= naveY && centroEstrelaY <= naveY + naveAltura;
  }

  private static void desenharEstrelas() {
    for (double[] estrela : estrelas) {
      estrelaImagem.desenhe(estrela[0], estrela[1], 0, 0, 0.5, 0.5);
    }
  }
}