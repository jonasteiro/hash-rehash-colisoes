# Tabela Hash em Java

Uma tabela hash de 100 posições feita do zero em Java, sem usar nenhuma estrutura pronta da API. Só `if`, `else`, `for`, `while` e `Random`.

## O desafio

O exercício pedia o seguinte:

- Inserir 100 elementos em uma matriz de 100 posições.
- Bloquear novas inserções (re-hash) quando a tabela chegar a 90% de ocupação.
- Gerar os números com `Random`, usando `seed = 1090`.
- Mostrar, no final:
  - o total de colisões durante a inserção;
  - os 3 elementos que mais colidiram;
  - as posições que sobraram livres.
- Testar a busca com esses 3 elementos que mais colidiram.

## Como eu resolvi

| Ponto | Decisão |
|---|---|
| Função hash | `posição = número % 100` |
| Colisões | Sondagem linear: se a posição está ocupada, tenta a seguinte (de forma circular) até achar uma livre |
| Limite de ocupação | Depois de 90 elementos inseridos, as tentativas seguintes são bloqueadas |
| Posição vazia | Marcada com `-1` |
| Números gerados | `random.nextInt(1000)`, ou seja, de 0 a 999 |
| Busca | Começa na posição hash do elemento e vai andando até encontrá-lo, contando as colisões no caminho |

## Como rodar

```bash
javac TabelaHash.java
java TabelaHash
```

## O que aparece no console

1. Um aviso para cada tentativa barrada pelo limite de 90%.
2. O total de elementos inseridos e de colisões.
3. Os 3 elementos que mais colidiram.
4. As posições que ficaram livres.
5. O resultado da busca desses 3 elementos: posição hash inicial, posição onde foram encontrados e quantas colisões ocorreram na busca.

## Tecnologias

- Java
- `java.util.Random`

## Autor

**João Pedro**: [@jonasteiro](https://github.com/jonasteiro)
