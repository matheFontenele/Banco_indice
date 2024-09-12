package banco.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GerarIndice {

    public static Map<String, List<Integer>> gerarIndiceRemissivo(String pathName, List<String> palavras) {

        Map<String, List<Integer>> indice = new HashMap<>();

        //Inicializar o mapa com as palvras-chave e listas vazias
        for (String palavra : palavras) {
            indice.put(palavra, new ArrayList<>());
        }

        //Ler o arquivo linha por linha
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathName));
            String linha;
            int linhaCont = 1;

            while ((linha = reader.readLine()) != null){
                //Quebra a linha em palavras
                String [] palavrasPorLinha = linha.split("\\W+"); //Metodo Regex para quebrar linhas

                for (String palavra : palavrasPorLinha){
                    palavra = palavra.toLowerCase(); //Ignora a diferença entre maiusculas e minusculas

                    //Se a palavra for uma palavra-chave, adicionar a linha ao indice
                    if (indice.containsKey(palavra)){
                        indice.get(palavra).add(linhaCont);
                    }
                }
                linhaCont ++;

            }

            reader.close();

        } catch (IOException e){
            System.out.println("Erro ao bsucar arquivo: "+e.getMessage());
        }

        return indice;
    }

}
