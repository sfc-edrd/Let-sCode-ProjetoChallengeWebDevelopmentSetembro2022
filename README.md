# Let's Code Challenge

> **Web Development**
> 
> *Setembro 2022*
> 
> **Autor:** Cleber Campomori
>
> **Objetivo:** Habilitar os participantes a criar APIs REST com persistência de dados utilizando componentes muito comuns do ecossistema Spring (Spring Boot, Spring Data)
>
> **Ferramentas e bibliotecas utilizadas:**
>- Spring Boot 2.7.0
>- Spring Data 2.7.0
>- SpringDoc 1.6.9
>- H2 Database 2.1.210
>- Jackson 2.13.0
>
> **Ambiente:**
> - IDE com suporte a Java (IntelliJ Community Edition, Eclipse etc.)
> - Java JDK 11+
>

### O desafio 🚀
Desta vez, iremos fazer uma dinâmica diferente para o challenge do mês.

Abaixo, vocês encontrarão uma lista de exercícios, pequenos desafios na verdade, que ao final, resultarão no desenvolvimento de uma API! Que é a proposta do desafio do mês. Dito isso, não deixe de percorrer cada etapa e estudar as ferramentas necessárias para cumprir o desafio final.


- **Questão 1**
  #### Desenvolvimento do primeiro endpoint utilizando Spring Boot:
  > A Ada precisa de uma API para armazenar os filmes preferidos por seus alunos.
  >
  > Neste momento, nós precisamos armazenar o nome e a descrição destes filmes. Também seria interessante que cada filme tivesse um identificador próprio e que fosse possível saber quando aquele filme foi registrado.
  >
  >Foi solicitado também que esta API fosse criada utilizando-se Java e Spring Boot, pois é uma das tecnologias de referência dentro da Ada.
  >
  > Vamos começar criando um endpoint de referência em nossa API. Este endpoint será utilizado somente para testarmos se conseguiremos ter uma API que consegue responder dentro de nosso ambiente.
  >
  >Para isso, crie um endpoint em uma API utilizando o Spring Boot na rota **“/test/hello”**. Este endpoint deve devolver somente uma string com o texto “Hello, World!”
  >
  >	Este primeiro exercício tem como objetivo habilitar os participantes a ter os primeiros contatos com o Spring Boot. Além disso, ele também tem como objetivo fazer com que os participantes entendam a maneira como controllers e rotas são gerenciadas quando utilizamos as estruturas do Spring Web.


- **Questão 2**

  #### Desenvolvimento de endpoint com parâmetros baseados em rotas:
  >Agora, também precisamos validar se nossa API é também capaz de receber parâmetros que são informados na rota de nossos endpoints.
  >
  >Crie um endpoint que, na rota **“/test/hello/{{name}}”**, seja capaz de responder uma string com o conteúdo “Hello World and {{name}}”.
  Por exemplo: caso a rota **“/test/hello/Ada”** seja chamada, a resposta deverá ser uma string com o texto “Hello World and Ada”.
  >
  >Este exercício tem como objetivo habilitar os participantes a serem capazes de criar rotas parametrizadas e dinâmicas utilizando o Spring Web.


- **Questão 3**
  #### Desenvolvimento de endpoint baseado em payloads:
  > Também precisamos validar se nossa API é também capaz de receber parâmetros que são informados no corpo da requisição.
  >
  > Por isso, crie um endpoint que, na rota **“/test/hello/body”** e ao receber um objeto com um atributo chamado “name”, seja capaz de responder um objeto contendo um atributo chamado “message” com o conteúdo “Hello, {{name}}!” e a data/hora quando a requisição foi processada.
  >
  > Por exemplo: se a rota **“/test/hello/body”** receber o objeto abaixo… { “name”: “Ada” } … devemos retornar o objeto abaixo:
  >
  >
  > ```json
  > { 
  >     “message”: “Hello, Ada!”, 
  >     “processedAt”: “2022-08-30T06:00:00” 
  > }
  > ```
  >
  > Neste desafio, os alunos precisarão começar a lidar com requisições utilizando o verbo HTTP POST, além de lidarem com a annotation @RequestBody.
  >
  > Provavelmente, também precisarão começar a explorar configurações de serialização ou das APIs de data e hora do Java


- **Questão 4**
  #### Gerenciamento de bancos de dados através de migrations:
  > Agora, estamos prontos para começarmos a criar nossos endpoints para escrita e leitura de filmes! Nossos filmes precisarão ser armazenados em uma base de dados.
  >
  > Neste momento, podemos utilizar um banco de dados leve e em memória chamado H2 para armazenarmos nossos dados. Porém, precisaremos criar nossa tabela de filmes… Além disso, seria muito interessante que a própria aplicação, ao se conectar ao banco de dados, criasse automaticamente as tabelas que são necessárias para que a aplicação funcione. 
  > 
  > Será que temos uma maneira de gerenciarmos o banco de dados a partir da própria aplicação e de maneira automatizada?
  >
  > Neste ponto, os alunos precisarão recorrer a ferramentas de versionamento de banco de dados. Uma das ferramentas mais comuns no mercado para esta finalidade é o Flyway.
  >
  > É esperado que os participantes o utilizem e passem a entender o conceito de “migrations” quando falamos sobre versionamento de banco de dados baseado em código.


- **Questão 5**
  #### Manipulação de bancos de dados através do Spring Data JDBC - escrita
  > Neste momento, sabemos criar endpoints e também já conseguimos gerenciar o nosso banco de dados de maneira automatizada através da própria aplicação. Chegou a hora de criarmos a funcionalidade de inserção de filmes em nossa base.
  >
  > Crie um endpoint que, recebendo um objeto que representa um filme com seu nome e descrição, seja capaz de armazenar estas informações em nossa base de dados H2. Como estamos utilizando Spring, será que já não existe alguma biblioteca que nos ajude a manipular bancos de dados através de comandos SQL dentro do ecossistema?
  >
  > Neste momento, é esperado que os alunos tenham os primeiros contatos com o Spring Data JDBC. Eles deverão ser capazes de utilizar classes como a NamedParameterJdbcTemplate para escrever a consulta SQL necessária para realizar o INSERT das informações do filme na base de dados. Aqui, também devem surgir discussões sobre o correto status HTTP que o endpoint de inserção de filmes deve retornar.


- **Questão 6**
  #### Manipulação de bancos de dados através do Spring Data JDBC - leitura:
  > Agora que nossa API já é capaz de registrar filmes, crie um endpoint que retorne a lista de filmes cadastrados. Crie também um endpoint que, dado um ID de filme informado na rota, devolva somente o filme com o ID informado.
  >
  > Ainda explorando o Spring Data JDBC, os participantes deverão conseguir utilizar a estrutura de RowMapper para conseguirem, a partir de um SELECT no banco de dados, transformar as informações em objetos que representam filmes e, em seguida, devolver estes objetos como resposta do endpoint.


- **Questão 7**
  #### Documentação de APIs REST com Swagger/OpenAPI :
  > Neste momento, temos uma API que é capaz de registrar e listar filmes. Porém, como poderíamos criar uma documentação automatizada de nossa API, permitindo a qualquer pessoa com acesso facilmente verificar informações sobre endpoints existentes e o formato dos possíveis responses?
  >
  > Neste momento, os alunos deverão lidar com documentação de APIs, um tópico muito recorrente no mercado. É esperado que eles comecem a explorar ferramentas como Swagger, OpenAPI e SpringDoc.


- **Questão 8**
  #### Gerenciamento de exceptions com advices:
  > Temos agora uma regra de negócio em nossa API: não podemos permitir que filmes com o mesmo título sejam cadastrados. Caso já exista um filme com o mesmo título no momento em que um cadastro de filme for solicitado, nossa aplicação deverá arremessar uma exceção.
  >
  > Esta exceção precisa ser serializada para uma mensagem de erro amigável para quem estiver consumindo nossa API.
  >
  > Este desafio tem como objetivo provocar aos participantes o conhecimento de estratégias de design de código (como service layer) e pensar em maneiras automatizadas de mapeamento de exceções para responses adequados. No Spring, isso é feito através de advices.

- **Questão 9**
  #### Evitando NullPointerException com optionals:
  > Ao realizar a verificação de existência do filme por título do desafio anterior, pode ser que você tenha criado métodos que, caso o filme não exista, o método retorne null ou até mesmo um booleano.
  >
  > Porém, estas abordagens podem não ser tão interessantes: um método que retorne booleano pode não ser necessariamente muito claro, ao passo que um método que retorne null pode causar um NullPointerException em quem o chama. Será que não existe uma maneira mais “elegante” de lidar com estas situações no Java?
  >
  > Neste momento, é esperado que os participantes passem a explorar a estrutura Optional no Java.

- **Questão 10**
  #### Melhorando a experiência de troubleshooting com logs:
  > Neste momento, temos uma API completamente funcional e que atende aos nossos requisitos de negócio, ao mesmo tempo que está devidamente documentada.
  >
  > Porém, mesmo assim, erros podem acontecer durante a execução do nosso código. Por exemplo: um filme pode não ser encontrado quando um ID inexistente for informado. Como podemos rastrear o fluxo de execução de nossa aplicação? Dessa maneira, seria mais fácil identificar situações de erro em nossa aplicação, mesmo posteriormente…
  >
  > Será que conseguiríamos criar um log de execução de nossa aplicação?
  >
  > Este desafio pressupõe que os alunos comecem a explorar conceitos de logging em aplicações Java, utilizando bibliotecas como SLF4j e Logback.

