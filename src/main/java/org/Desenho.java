// Classe: Desenho
// Função: Gerencia a renderização de gráficos.
// Atributos:
//  camadas: Mapa que armazena funções de desenho organizadas por camadas.
// Métodos:
//  desenhe(g): Desenha todos os elementos gráficos na tela.
//  incluir(z, funcao): Adiciona uma função de desenho a uma camada específica.

package org;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Desenho {
    private static final Map<Integer, List<Graphics2DConsumer>> camadas = new HashMap<>();
    private static final RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

    public static void desenhe(Graphics2D g) {
        g.setRenderingHints(rh);
        camadas.values().forEach(funcaoList -> funcaoList.forEach(funcao -> funcao.accept(g)));
        camadas.clear();
    }

    public static void incluir(int z, Graphics2DConsumer funcao) {
        camadas.computeIfAbsent(z, k -> new ArrayList<>()).add(funcao);
    }

    @FunctionalInterface
    public interface Graphics2DConsumer {
        void accept(Graphics2D g);
    }
}