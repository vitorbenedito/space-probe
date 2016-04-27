# Explorando Marte

Um conjunto de sondas foi enviado pela NASA à Marte e irá pousar num planalto.
Esse planalto, que curiosamente é retangular, deve ser explorado pelas sondas para que suas câmera embutidas consigam ter uma visão completa da área e enviar as imagens de volta para a Terra.

A posição e direção de uma sonda são representadas por uma combinação de coordenadas x-y e uma letra representando a direção cardinal para qual a sonda aponta, seguindo a rosa dos ventos em inglês.

![rosa dos ventos](http://i.imgur.com/li8Ae5L.png "Rosa dos Ventos")

O planalto é divido numa malha para simplificar a navegação. Um exemplo de posição seria (0, 0, N), que indica que a sonda está no canto inferior esquerdo e apontando para o Norte.

Para controlar as sondas, a NASA envia uma simples sequência de letras. As letras possíveis são "L", "R" e "M". Destas, "L" e "R" fazem a sonda virar 90 graus para a esquerda  ou direita, respectivamente, sem mover a sonda. "M" faz com que a sonda mova-se para a frente um ponto da malha, mantendo a mesma direção.

Nesta malha o ponto ao norte de (x,y) é sempre (x, y+1).

Você deve fazer um programa que processe uma série de instruções enviadas para as sondas que estão explorando este planalto.
O formato da entrada e saída deste programa segue abaixo.

A forma de entrada e saída dos dados fica à sua escolha.


## ENTRADA

A primeira linha da entrada de dados é a coordenada do ponto superior-direito da malha do planalto. Lembrando que a inferior esquerda sempre será (0,0).

O resto da entrada será informação das sondas que foram implantadas. Cada sonda é representada por duas linhas. A primeira indica sua posição inicial e a segunda uma série de instruções indicando para a sonda como ela deverá explorar o planalto.

A posição é representada por dois inteiros e uma letra separados por espaços, correpondendo à coordenada X-Y e à direção da sonda.
Cada sonda será controlada sequencialmente, o que quer dizer que a segunda sonda só irá se movimentar após que a primeira tenha terminado suas instruções.

## SAÍDA

A saída deverá contar uma linha para cada sonda, na mesma ordem de entrada, indicando sua coordenada final e direção.

### Exemplos de Entrada e Saída:

####Entrada de Teste:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

#### Saída esperada:
```
1 3 N
5 1 E
```

## SOLUÇÃO

Para socluionar o problema foi primeiramente implementado a lógica da Sonda. Que basicamente é definir onde ela está inicialmente, girar e movimentar a sonda no planalto.
Depois foi implementado a lógica que recebe as coordenadas (NASA), e envia para a sonda que executa os comandos.
A implementação dessa lógica foi coberta por testes unitários, e inclusão de logs que auxiliaram no desenvolvimento.

Com a lógica funcionando de forma correta, foi implentado os serviços REST que cria as sondas, carrega todas as sondas e carrega uma sonda específica. Também foi utilizado injeção de depêndencia, criando um objeto com o escopo singleton, mantendo as sondas já criadas armazenadas em tempo de execução.
Foi implementado também um test de API simples, que valida o funcionamento dos resources.

A stack utlizada foi Spring Boot, Spring MVC, JUnit e Log4j.

O deploy da aplicação foi realizado em um AWS Elastic Beanstalk, através de um war. Também foi necessário criar uma classe no projeto MyBootWebApp.class. Necessário para o ESB identificar o Application.class que faz o start da aplicação com spring-boot.

### Resources

```
POST http://space-probe.sa-east-1.elasticbeanstalk.com/spaceprobe

Body:

5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Response:
[
  {
    "id": "24abe96a-5141-4a68-8c1c-851d6d96d49d",
    "position": {
      "x": 1,
      "y": 3
    },
    "direction": "N"
  },
  {
    "id": "039dfb91-d668-410a-9237-94212ca9503f",
    "position": {
      "x": 5,
      "y": 1
    },
    "direction": "E"
  }
]
```

```
GET http://space-probe.sa-east-1.elasticbeanstalk.com/spaceprobe

Response:
[
  {
    "id": "24abe96a-5141-4a68-8c1c-851d6d96d49d",
    "position": {
      "x": 1,
      "y": 3
    },
    "direction": "N"
  },
  {
    "id": "039dfb91-d668-410a-9237-94212ca9503f",
    "position": {
      "x": 5,
      "y": 1
    },
    "direction": "E"
  }
]
```

```
GET http://space-probe.sa-east-1.elasticbeanstalk.com/spaceprobe/24abe96a-5141-4a68-8c1c-851d6d96d49d

Response:
[
  {
    "id": "24abe96a-5141-4a68-8c1c-851d6d96d49d",
    "position": {
      "x": 1,
      "y": 3
    },
    "direction": "N"
  }
]
```
