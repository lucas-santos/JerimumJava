
// Classe: Relogio
// Função: Fornece informações sobre o tempo.
// Métodos:
//  agora(): Retorna o tempo atual.
//  milisegundos(): Retorna o tempo em milissegundos desde o início.

package org;

import java.util.Date;

public class Relogio {
    private static final long inicio = new Date().getTime();

    public static double agora() {
        return new Date().getTime();
    }

    public static int milisegundos() {
        return (int) (System.currentTimeMillis() - inicio);
    }
}