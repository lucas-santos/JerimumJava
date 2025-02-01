// Classe: Jogo
// Função: Controla o ciclo principal do jogo.
// Atributos:
//  titulo, largura, altura, fps: Configurações do jogo.
//  running: Indica se o jogo está em execução.
//  thread: Thread que executa o jogo.
// Métodos:
//  iniciar(...): Inicia o jogo com as configurações especificadas.
//  run(): Loop principal do jogo que atualiza e desenha a tela.
// Métodos para calcular distâncias e projeções.

package org;

import java.awt.Graphics2D;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class Jogo implements Runnable {
    private String titulo = "Sem Nome";
    private int largura = 640;
    private int altura = 480;
    private int fps = 60;
    private Tela display;
    private Teclado Teclado;
    private Mouse Mouse;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private Thread thread;
    private Runnable desenhe = () -> {
    };
    private Runnable atualize = () -> {
    };

    private void init() {
        display = new Tela(titulo, largura, altura);
        display.frame.addKeyListener(Teclado);
        display.frame.addMouseListener(Mouse);
        display.frame.addMouseMotionListener(Mouse);
        display.canvas.addMouseListener(Mouse);
        display.canvas.addMouseMotionListener(Mouse);
    }

    private void draw() {
        if (display.canvas.getBufferStrategy() == null) {
            display.canvas.createBufferStrategy(3);
        } else {
            Graphics2D g = (Graphics2D) display.canvas.getBufferStrategy().getDrawGraphics();
            g.clearRect(0, 0, largura, altura);
            Desenho.desenhe(g);
            display.canvas.getBufferStrategy().show();
            g.dispose();
        }
    }

    @Override
    public void run() {
        init();
        double frequencia = 1000000000.0 / fps;
        double delta = 0.0;
        long ultimo = System.nanoTime();
        long tempo = 0L;
        int ciclos = 0;

        while (running.get()) {
            long agora = System.nanoTime();
            delta += (agora - ultimo) / frequencia;
            tempo += agora - ultimo;
            ultimo = agora;

            if (delta >= 1) {
                atualize.run();
                draw();
                desenhe.run();
                ciclos++;
                delta--;
            }

            if (tempo >= 1000000000) {
                ciclos = 0;
                tempo = 0;
            }
        }
        parar();
    }

    public synchronized void iniciar(String titulo, int largura, int altura, Runnable atualize,
            Runnable desenhe) {
        this.titulo = titulo;
        this.largura = largura;
        this.altura = altura;
        this.atualize = atualize;
        this.desenhe = desenhe;

        if (!running.get()) {
            running.set(true);
            thread = new Thread(this);
            thread.start();
        }
    }

    private synchronized void parar() {
        if (running.get()) {
            running.set(false);
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static double distancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double projeçãoX(double angulo, double valor) {
        return Math.sin(Math.toRadians(angulo)) * valor;
    }

    public static double projeçãoY(double angulo, double valor) {
        return -Math.cos(Math.toRadians(angulo)) * valor;
    }

    public static int getLargura() {
        return 640;
    }

    public static int getAltura() {
        return 480;
    }
}