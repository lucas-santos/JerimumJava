
// Teclado.java
        package org;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Teclado implements KeyListener {
    private static final boolean[] teclas = new boolean[256];

    // Construtor privado para evitar instanciação direta
    private Teclado() {}

    // Método para inicializar o Teclado
    static void inicializar(JFrame frame) {
        Teclado teclado = new Teclado();
        frame.addKeyListener(teclado);
        frame.setFocusable(true); // Garante que o JFrame possa receber foco
        frame.requestFocusInWindow(); // Solicita o foco para o JFrame
    }

    private void update(int keyCode, boolean valor) {
        if (keyCode >= 0 && keyCode < teclas.length) {
            teclas[keyCode] = valor;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        update(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        update(e.getKeyCode(), false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não utilizado, mas necessário para a interface KeyListener
    }

    // Método para verificar se uma tecla está pressionada
    public static boolean teclaPressionada(int tecla) {
        return teclas[tecla];
    }

    // Constantes para as teclas
    public static final int TECLA_I = KeyEvent.VK_I;
    public static final int TECLA_PARA_DIREITA = KeyEvent.VK_RIGHT;
    public static final int TECLA_PARA_ESQUERDA = KeyEvent.VK_LEFT;
    public static final int TECLA_PARA_CIMA = KeyEvent.VK_UP;
    public static final int TECLA_BAIXO = KeyEvent.VK_DOWN;
    public static final int TECLA_W = KeyEvent.VK_W;
    public static final int TECLA_A = KeyEvent.VK_A;
    public static final int TECLA_D = KeyEvent.VK_D;
    public static final int TECLA_R = KeyEvent.VK_R;
    public static final int TECLA_S = KeyEvent.VK_S;

}