package org;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Imagem {
    final BufferedImage buffer;
    private final String caminho;

    public Imagem(BufferedImage buffer, String caminho) {
        this.buffer = buffer;
        this.caminho = caminho;
    }

    public static Imagem carregar(String caminho) {
        try {
            BufferedImage img = ImageIO.read(new File(caminho));
            return new Imagem(img, caminho);
        } catch (IOException e) {
            System.err.println("Erro ao carregar imagem: " + caminho);
            e.printStackTrace();
            return new Imagem(new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB), caminho);
        }
    }

    public List<Imagem> fatie(int x, int y) {
        List<Imagem> lista = new ArrayList<>();
        for (int j = 0; j < buffer.getHeight(); j += y) {
            for (int i = 0; i < buffer.getWidth(); i += x) {
                if (i + x <= buffer.getWidth() && j + y <= buffer.getHeight()) {
                    BufferedImage subImage = buffer.getSubimage(i, j, x, y);
                    lista.add(new Imagem(subImage, caminho));
                }
            }
        }
        return lista;
    }

    public void desenhe(double x, double y, int z, double angulo, double escalaX, double escalaY) {
        Desenho.incluir(z, g -> {
            Graphics2D g2d = (Graphics2D) g.create(); // Cria um novo contexto gráfico para não afetar outros desenhos
            g2d.rotate(Math.toRadians(angulo), x + buffer.getWidth() / 2, y + buffer.getHeight() / 2);
            g2d.scale(escalaX, escalaY); // Aplica a escala antes de desenhar a imagem
            g2d.drawImage(buffer, (int) x, (int) y, null);
            g2d.dispose(); // Libera os recursos do contexto gráfico criado
        });
    }
}