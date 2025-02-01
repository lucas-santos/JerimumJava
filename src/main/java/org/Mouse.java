package org;
// Classe: Mouse

// Função: Gerencia eventos do mouse.
// Atributos:
//  botoes: Array que armazena o estado dos botões do mouse.
//  _x, _y: Posições atuais do mouse.
// Métodos:
//  mousePressed, mouseReleased, mouseMoved: Manipuladores de eventos do mouse.

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
    private static final boolean[] botoes = new boolean[4];
    private static int _x, _y;

    public static boolean BOTAO_ESQUERDO() {
        return botoes[1];
    }

    public static boolean BOTAO_DIREITO() {
        return botoes[3];
    }

    private void update(MouseEvent e, boolean valor) {
        int botao = e.getButton();
        if (botao == MouseEvent.BUTTON1) {
            botoes[1] = valor;
        }
        if (botao == MouseEvent.BUTTON3) {
            botoes[3] = valor;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        update(e, true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        update(e, false);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        _x = e.getX();
        _y = e.getY();
    }

    public static int x() {
        return _x;
    }

    public static int y() {
        return _y;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
