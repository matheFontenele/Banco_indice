import banco.services.GerarArquivoDeSaida;
import banco.services.GerarArrayDePalavrasChaves;
import banco.services.GerarIndice;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String pathEntradaTexto = "src\\banco\\repository\\texto.txt";
        String pathEntradaChaves = "src\\banco\\repository\\palavras_chave.txt";
        String pathSaida = "src\\banco\\repository\\indice_texto.txt";

        List<String> palavrasChaves = GerarArrayDePalavrasChaves.listaDePalvrasPorLinha(pathEntradaChaves);

        Map<String, List<Integer>> indices =  GerarIndice.gerarIndiceRemissivo(pathEntradaTexto, palavrasChaves);

        GerarArquivoDeSaida.gerarArquivo(indices, pathSaida);

    }
}