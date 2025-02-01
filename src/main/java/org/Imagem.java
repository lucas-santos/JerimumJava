// Classe: Imagem
// Função: Representa uma imagem e fornece métodos para manipulação.
// Atributos:
//  buffer: Armazena a imagem em um objeto BufferedImage.
//  caminho: Caminho do arquivo da imagem.
// Métodos:
//  carregar(caminho): Carrega uma imagem do sistema de arquivos.
//  fatie(x, y): Divide a imagem em subimagens.
//  desenhe(x, y, z, angulo, scalaX, scalaY): Desenha a imagem na tela com opções de rotação e escala.

package org;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import java.util.ArrayList;

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

    public void desenhe(double x, double y, int z, double angulo, double scalaX, double scalaY) {
        Desenho.incluir(z, g -> {
            g.rotate(Math.toRadians(angulo), x + buffer.getWidth() / 2, y + buffer.getHeight() / 2);
            g.drawImage(buffer, (int) x, (int) y, (int) (buffer.getWidth() * scalaX),
                    (int) (buffer.getHeight() * scalaY), null);
            g.rotate(-Math.toRadians(angulo), x + buffer.getWidth() / 2, y + buffer.getHeight() / 2);
        });
    }
}