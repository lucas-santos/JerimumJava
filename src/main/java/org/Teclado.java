package org;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
    private static final boolean[] teclas = new boolean[256];

    private void update(KeyEvent e, boolean valor) {
        int cod = e.getKeyCode();
        if (cod >= 0 && cod < teclas.length) {
            teclas[cod] = valor;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        update(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        update(e, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não utilizado, mas necessário para a interface KeyListener
    }

    public static boolean teclaPressionada(int tecla) {
        return teclas[tecla];
    }

    public static final int TECLA_I = KeyEvent.VK_I;
    public static final int TECLA_PARA_DIREITA = KeyEvent.VK_RIGHT;
    public static final int TECLA_PARA_ESQUERDA = KeyEvent.VK_LEFT;
    public static final int TECLA_PARA_CIMA = KeyEvent.VK_UP;
    public static final int TECLA_W = KeyEvent.VK_W;
    public static final int TECLA_A = KeyEvent.VK_A;
    public static final int TECLA_D = KeyEvent.VK_D;
    public static final int TECLA_R = KeyEvent.VK_R;
}