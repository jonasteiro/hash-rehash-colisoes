# Tabela Hash em Java

Implementação de uma tabela hash com 100 posições, desenvolvida sem o uso de estruturas prontas da API do Java (apenas `if`, `else`, `for`, `while` e `Random`).

## Enunciado

- Inserir 100 elementos em uma matriz de 100 posições.
- Ao atingir 90% de ocupação, o re-hash deve impedir a inserção de novos elementos.
- Gerar os números aleatórios com `Random`, usando `seed = 1090`.
- Ao final, informar:
  - o número total de colisões na inserção;
  - os 3 elementos que mais colidiram;
  - as posições que ficaram livres na matriz.
- Fazer o teste de busca com os 3 elementos que mais colidiram.

## Como funciona

- **Função hash:** `posição = número % 100`
- **Tratamento de colisões:** sondagem linear. Se a posição está ocupada, tenta a próxima (circular) até achar uma livre.
- **Limite de ocupação:** após 90 elementos inseridos, as demais tentativas são bloqueadas.
- **Posição vazia:** representada por `-1`.
- **Números gerados:** `random.nextInt(1000)`, ou seja, valores de 0 a 999.
- **Busca:** parte da posição hash do elemento e avança linearmente até encontrá-lo, contando as colisões durante a busca.

## Como executar

```bash
javac TabelaHash.java
java TabelaHash
```

## Saída do programa

1. Log de cada tentativa bloqueada pelo limite de 90%
2. Total de elementos inseridos e total de colisões
3. Os 3 elementos que mais colidiram
4. Posições livres na matriz
5. Resultado da busca dos 3 elementos (posição hash inicial, posição encontrada e colisões na busca)

## Tecnologias

- Java
- `java.util.Random`

## Autor

João Pedro — [jonasteiro](https://github.com/jonasteiro)
