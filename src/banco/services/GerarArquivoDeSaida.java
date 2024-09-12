package banco.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GerarArquivoDeSaida {

    public static void gerarArquivo(Map<String, List<Integer>> indice, String pathSaida) {


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathSaida));

            for (Map.Entry<String, List<Integer>> entrada : indice.entrySet()){
                String palavra = entrada.getKey();
                List<Integer> linhas = entrada.getValue();

                writer.write(palavra+" - "+linhas.toString());
                writer.newLine();
            }
            System.out.println("Arquivo gerado com sucesso na localização: "+ pathSaida );
            System.out.println("Verifique na pasta de repositorios");
            writer.close();
        }catch (IOException e){
            System.out.println("Erro ao salvar arquivo: "+e.getMessage());
        }

    }

}
