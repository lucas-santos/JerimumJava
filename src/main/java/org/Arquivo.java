// Classe: Arquivo
// Função: Lê arquivos de texto do sistema de arquivos.
// Método:
//  leia(caminho): Lê o conteúdo de um arquivo e retorna uma lista de linhas.

package org;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Arquivo {
    public static List<String> leia(String caminho) throws IOException {
        return Files.readAllLines(Paths.get(caminho));
    }
}