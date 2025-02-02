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
