package org;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class Mouse implements MouseListener, MouseMotionListener {
    private static int mouseX = 0;
    private static int mouseY = 0;
    private static boolean mouseClicado = false;

    // Construtor privado para evitar instanciação direta
    private Mouse() {}

    // Método para inicializar o Mouse
    static void inicializar(JFrame frame, Canvas panel) {
        Mouse mouse = new Mouse();
        frame.addMouseListener(mouse);
        frame.addMouseMotionListener(mouse);
        panel.addMouseListener(mouse);
        panel.addMouseMotionListener(mouse);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClicado = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseClicado = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    // Métodos para acessar o estado do mouse
    public static int getMouseX() {
        return mouseX;
    }

    public static int getMouseY() {
        return mouseY;
    }

    public static boolean isMouseClicado() {
        return mouseClicado;
    }
}
