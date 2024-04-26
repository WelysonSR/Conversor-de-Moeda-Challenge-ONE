# Conversor de Moeda

Um simples conversor de moeda Java que utiliza a API ExchangeRate-API para obter as taxas de câmbio mais recentes e realizar a conversão entre diferentes moedas.

## Funcionalidades

- Conversão entre diferentes moedas, incluindo:
    - Dólar Americano (USD)
    - Peso Argentino (ARS)
    - Real Brasileiro (BRL)
    - Peso colombiano (COP)

## Pré-requisitos

Para utilizar este conversor de moeda, você precisa ter uma chave de API válida da ExchangeRate-API. Você pode se inscrever para uma chave gratuita no [ExchangeRate-API](https://www.exchangerate-api.com/).
Mas nesse caso não e necessário.

## Como Usar

1. Clone este repositório ou faça o download do código-fonte.
2. Abra o projeto em sua IDE preferida.
3. Certifique-se de adicionar sua chave de API no campo `apiKey` na classe `Main`.
4. Execute o programa.
5. Escolha a moeda de origem e destino para a conversão.
6. Digite o valor que deseja converter.
7. O programa retornará o valor convertido.

## Exemplo de Uso

Suponha que você queira converter 100 dólares americanos (USD) para real brasileiro (BRL). Aqui está como você pode fazer isso:

Escolha a moeda para conversão:
1. Dólar Americano =>> Peso Argentino
2. Peso Argentino =>> Dólar Americano
3. Real Brasileiro =>> Dólar Americano
4. Dólar Americano =>> Real Brasileiro
5. Dólar Americano =>> Peso colombiano
6. Peso colombiano =>> Dólar Americano
7. SAIR <br>
Escolha: 4 <br>
Digite o valor que deseja converter: 100 <br>
O valor 100,00 [USD] corresponde a 532,00 [BRL]


## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).


