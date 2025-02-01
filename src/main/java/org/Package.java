//Classe: Package
//Função: Agrupa as instâncias principais da biblioteca para fácil acesso.

package org;

public class Package {
    public static final Jogo jogo = new Jogo();
    public static final Mouse mouse = new Mouse();
    public static final Teclado teclado = new Teclado();
    public static final Relogio relogio = new Relogio();
    public static final Cor cor = new Cor(null);
}