package org;

import java.awt.Font;

public class Fonte {
    private final Font font;

    public Fonte(int tamanho) {
        this.font = new Font("Dialog", Font.BOLD, tamanho);
    }

    public void desenheCentralizado(String msg, double x, double y, int z, Cor cor) {
        Desenho.incluir(z, g -> {
            g.setColor(cor.color());
            g.setFont(font);
            int largura = g.getFontMetrics().stringWidth(msg);
            int altura = g.getFontMetrics().getHeight();
            g.drawString(msg, (int) x - largura / 2, (int) y - altura / 2);
        });
    }

    public void desenhe(String msg, double x, double y, int z, Cor cor) {
        Desenho.incluir(z, g -> {
            g.setColor(cor.color());
            g.setFont(font);
            g.drawString(msg, (int) x, (int) y);
        });
    }
}