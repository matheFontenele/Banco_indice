package banco.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GerarArrayDePalavrasChaves {
    public static List<String> listaDePalvrasPorLinha(String pathEntrada) {

        List<String> lista = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(Paths.get(pathEntrada));
            for (String linha : linhas){
                lista.add(linha);
            }

        }catch (IOException e){
            System.out.println("Erro ao buscar arquivo: "+e.getMessage());
        }
        return lista;
    }
}
