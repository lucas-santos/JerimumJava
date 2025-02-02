package org;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Arquivo {
    public static List<String> leia(String caminho) throws IOException {
        try {
            return Files.readAllLines(Paths.get(caminho));
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + caminho);
            e.printStackTrace();
            throw e; // Re-lança a exceção após imprimir a mensagem de erro
        }
    }
}