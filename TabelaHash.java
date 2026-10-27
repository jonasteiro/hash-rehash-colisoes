import java.util.Random;

public class TabelaHash {

    public static void main(String[] args) {

        int tamanho = 100;
        int[] matriz = new int[tamanho];

        int[] numerosInseridos = new int[tamanho];
        int[] colisoesPorNumero = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            matriz[i] = -1;
        }

        Random random = new Random(1090);

        int quantidadeInserida = 0;
        int colisoesTotais = 0;

        System.out.println("=== INICIANDO A INSERÇÃO DE 100 ELEMENTOS ===");

        for (int i = 0; i < 100; i++) {

            int numero = random.nextInt(1000);

            if (quantidadeInserida >= 90) {
                System.out.println("Tentativa " + (i + 1) + " (valor " + numero + "): Bloqueada pelo re-hash... O limite de 90% de ocupação foi atingido");
            } else {
                int posicao = numero % tamanho;
                int colisoesDoElemento = 0;

                while (matriz[posicao] != -1) {
                    colisoesTotais = colisoesTotais + 1;
                    colisoesDoElemento = colisoesDoElemento + 1;

                    posicao = (posicao + 1) % tamanho;
                }

                matriz[posicao] = numero;
                numerosInseridos[quantidadeInserida] = numero;
                colisoesPorNumero[quantidadeInserida] = colisoesDoElemento;
                quantidadeInserida = quantidadeInserida + 1;
            }
        }

        System.out.println("\n=== RESUMO DA INSERÇÃO ===");
        System.out.println("Total de elementos inseridos: " + quantidadeInserida);
        System.out.println("Número total de colisões na inserção: " + colisoesTotais);

        int maiorColisao1 = -1;
        int maiorColisao2 = -1;
        int maiorColisao3 = -1;

        int elemento1 = -1;
        int elemento2 = -1;
        int elemento3 = -1;

        for (int i = 0; i < quantidadeInserida; i++) {
            int colisoesAtuais = colisoesPorNumero[i];
            int numeroAtual = numerosInseridos[i];

            if (colisoesAtuais > maiorColisao1) {
                maiorColisao3 = maiorColisao2;
                elemento3 = elemento2;

                maiorColisao2 = maiorColisao1;
                elemento2 = elemento1;

                maiorColisao1 = colisoesAtuais;
                elemento1 = numeroAtual;
            } else if (colisoesAtuais > maiorColisao2) {
                maiorColisao3 = maiorColisao2;
                elemento3 = elemento2;

                maiorColisao2 = colisoesAtuais;
                elemento2 = numeroAtual;
            } else if (colisoesAtuais > maiorColisao3) {
                maiorColisao3 = colisoesAtuais;
                elemento3 = numeroAtual;
            }
        }

        System.out.println("\n=== OS 3 ELEMENTOS QUE MAIS COLIDIRAM ===");
        System.out.println("1º lugar: Elemento " + elemento1 + " com " + maiorColisao1 + " colisões");
        System.out.println("2º lugar: Elemento " + elemento2 + " com " + maiorColisao2 + " colisões");
        System.out.println("3º lugar: Elemento " + elemento3 + " com " + maiorColisao3 + " colisões");

        System.out.println("\n=== POSIÇÕES LIVRES NA MATRIZ ===");
        int totalLivres = 0;
        System.out.print("Posições livres: ");
        for (int i = 0; i < tamanho; i++) {
            if (matriz[i] == -1) {
                System.out.print("[" + i + "] ");
                totalLivres = totalLivres + 1;
            }
        }
        System.out.println("\nTotal de posições livres: " + totalLivres);

        System.out.println("\n=== TESTE DE BUSCA DOS 3 ELEMENTOS ===");

        int[] elementosParaBuscar = new int[3];
        elementosParaBuscar[0] = elemento1;
        elementosParaBuscar[1] = elemento2;
        elementosParaBuscar[2] = elemento3;

        for (int i = 0; i < 3; i++) {
            int alvo = elementosParaBuscar[i];
            int posInicial = alvo % tamanho;
            int posAtual = posInicial;
            int tentativas = 0;

            while (matriz[posAtual] != -1 && matriz[posAtual] != alvo && tentativas < tamanho) {
                posAtual = (posAtual + 1) % tamanho;
                tentativas = tentativas + 1;
            }

            if (matriz[posAtual] == alvo) {
                System.out.println(
                    "Busca pelo elemento " + alvo
                    + " | Hash inicial: " + posInicial
                    + " | Encontrado na posição: " + posAtual
                    + " (após " + tentativas + " colisões na busca)"
                );
            } else {
                System.out.println("Elemento " + alvo + " não encontrado na tabela");
            }
        }
    }
}