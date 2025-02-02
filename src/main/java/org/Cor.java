package org;

import java.awt.Color;

public class Cor {
    private final int vermelho;
    private final int verde;
    private final int azul;

    public Cor(int vermelho, int verde, int azul) {
        this.vermelho = vermelho;
        this.verde = verde;
        this.azul = azul;
    }

    public Color color() {
        return new Color(vermelho, verde, azul);
    }

    public Cor(Color color) {
        this(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static final Cor AMARELO = new Cor(Color.YELLOW);
    public static final Cor AZUL = new Cor(Color.BLUE);
    public static final Cor BRANCO = new Cor(Color.WHITE);
    public static final Cor CIANO = new Cor(Color.CYAN);
    public static final Cor CINZA = new Cor(Color.GRAY);
    public static final Cor CINZA_CLARO = new Cor(Color.LIGHT_GRAY);
    public static final Cor CINZA_ESCURO = new Cor(Color.DARK_GRAY);
    public static final Cor LARANJA = new Cor(Color.ORANGE);
    public static final Cor MAGENTA = new Cor(Color.MAGENTA);
    public static final Cor PRETO = new Cor(Color.BLACK);
    public static final Cor ROSA = new Cor(Color.PINK);
    public static final Cor VERDE = new Cor(Color.GREEN);
    public static final Cor VERMELHO = new Cor(Color.RED);
}