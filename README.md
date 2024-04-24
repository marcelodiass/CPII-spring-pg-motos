# Concessionárias Benezinho 🏍️🤓👍🏾

CP II - **Java Advanced** aplicado em 23/04/2024.

| ![](documentacao/fiap.jpg)               | **Java Advanced** |
|------------------------------------------|-------------------|
| **ALUNO:**                               | **TURMA:** 2TDSPG |
| **PROFESSOR:** Benefrancis do Nascimento | 23/04/2024        |
| **CP II**                                | ****              |

# Sumário

[Estudo de caso ](#_Estudo_de_caso)

[O que deverá ser feito? ](#_O_que_devera_ser_feito)

[Diagrama de Classes ](#_Diagrama_de_Classes)

[Como Entregar ](#_Entrega)

[Correção da Prova ](#_Correcao)

<a id="_Estudo_de_caso"></a>

# Estudo de caso

![index.png](documentacao/index.png)

A Holding Benezinho está interessada em investir na abertura de concessionárias de motos premium no Brasil em 2024. Este
investimento pode oferecer diversas vantagens para um empresário, especialmente considerando o contexto econômico e
social do país. Entre as principais vantagens destacam-se:

1. Margens de lucro mais elevadas: Motos premium geralmente têm preços mais altos e, portanto, podem oferecer margens de
   lucro mais generosas em comparação com modelos mais básicos. Isso pode resultar em maiores retornos financeiros para
   a concessionária.

2. Público-alvo específico: Clientes interessados em motos premium geralmente têm maior poder aquisitivo e estão
   dispostos a pagar mais por qualidade, desempenho e exclusividade. Isso pode resultar em um público-alvo mais fiel e
   menos sensível a flutuações econômicas.

3. Prestígio da marca: Representar marcas premium pode conferir prestígio à concessionária e aumentar sua reputação no
   mercado. Isso pode atrair clientes em busca de uma experiência de compra diferenciada e associar a concessionária a
   valores de qualidade e sofisticação.

4. Menos concorrência direta: O mercado de motos premium pode ser menos saturado do que o mercado de motos de massa, o
   que significa que a concorrência direta pode ser menor. Isso pode permitir que a concessionária estabeleça uma
   posição mais forte no mercado e capture uma fatia maior do público-alvo.

5. Oportunidades de serviços adicionais: Clientes de motos premium muitas vezes procuram um atendimento ao cliente
   excepcional e serviços personalizados. Isso pode abrir oportunidades para a concessionária oferecer serviços
   adicionais, como personalização de motos, eventos exclusivos para proprietários e programas de fidelidade.

Com o objetivo de fazer este negócio dar certo, idealizamos o desenvolvimento de um Sistema de Gestão de veículos a
serem comercializados pelas lojas da rede.

Criaremos, nesta aula, um Produto Mínimo Viável (PMV) de uma API Rest para um sistema para Sistema de Gestão de veículos
a serem comercializados.

Nossa equipe de analistas desenvolveu o Diagrama de Classes abaixo, e a sua missão aqui é realizar o Mapeamento Objeto
Relacional das classes de Entidade. Usaremos a JPA e o Hibernate como ferramentas de Mapeamento Objeto Relacional.

Na sprint atual, você foi incumbido de fazer:

1. O Mapeamento Objeto Relacional das primeiras classes envolvidas neste projeto de software;

2. A criação automatizada das tabelas no banco de dados Oracle;

3. A persistência de todos os dados, e;

4. A criação dos Seguintes Resources que devem implementar a ResourceDTO (foi fornecida):

    1. **VeiculoResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/veiculos" - **GET by Example**, **POST**
        2. "logalhost/veiculos/{id}" - **GET**
        3. "logalhost/veiculos/{id}/acessorios" - **GET**, **POST**

    2. **AcessorioResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/acessorios" - **GET by Example**, **POST**
        2. "logalhost/acessorios/{id}" - **GET**

    3. **LojaResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/lojas" - **GET by Example**, **POST**
        2. "logalhost/lojas/{id}" - **GET**
        3. "logalhost/lojas/{id}/veiculos" - **GET**, **POST**

    4. **TipoVeiculoResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/tipos" - **GET by Example**, **POST**
        2. "logalhost/tipos/{id}" - **GET**

    5. **CaracteristicaResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/caracteristicas" - **GET by Example**, **POST**
        2. "logalhost/caracteristicas/{id}" - **GET**

    5. **FabricanteResource** com as seguintes ROTAS e VERBOS:
        1. "localhost/fabricantes" - **GET by Example**, **POST**
        2. "logalhost/fabricantes/{id}" - **GET**


5. A criação dos Seguintes Services que devem implementar a ServiceDTO (foi fornecida):

    1. **AcessorioService**
    2. **CaracteristicaService**
    3. **FabricanteService**
    4. **LojaService**
    5. **TipoVeiculoService**
    6. **VeiculoService**

6. A criação dos Seguintes DTOs (Objetos de Transferência de Dados) de Request e de Response:

    1. **AcessorioRequest** e **AcessorioResponse**
    2. **CaracteristicaRequest** e **CaracteristicaResponse**
    3. **FabricanteRequest** e **FabricanteResponse**
    4. **TipoVeiculoRequest** e **TipoVeiculoResponse**
    5. **VeiculoRequest** e **VeiculoResponse**
    5. **AbstractRequest**

<a id="_O_que_devera_ser_feito"></a>

# O que deverá ser feito?

**Você deverá:**

**Fazer o fork do projeto do github.**:

[https://github.com/Benefrancis/CPII-spring-pg-motos](https://github.com/Benefrancis/CPII-spring-pg-motos)

Caso o github esteja indisponível, você deverá pegar o projeto no diretório compartilhado.

Alterar o arquivo contido em  **documentacao/equipe.txt** para incluir os RMs e nomes e turma do trio que fará esta
atividade.

**OBS:** Será com base nos nomes contidos neste aquivo que eu irei atribuir a nota.

## No pacote entity, criar as seguintes classes

1.**(0,5 Pontos)** Na **Veiculo** e adicionar corretamente as anotações JPA.

Lembre-se que:

    1. Existe relacionamento **Muitos para Um** entre **Veiculo** e **TipoVeiculo** no atributo tipo.
    2. Existe relacionamento **Muitos para Muitos** entre **Veiculo** e **Acessorio** no atributo acessorios.

2. **(0,25 Ponto)** Na **Loja** e adicionar corretamente as anotações JPA.

Lembre-se que:

    1. Existe relacionamento **Muitos para Muitos** entre **Loja** e **Veiculo** a no atributo veiculosComercializados.

3. **(0,25 Ponto)** Na **Acessorio** e adicionar corretamente as anotações JPA.


4. **(0,25 Ponto)** Na classe **TipoVeiculo** e adicionar corretamente as anotações JPA.
   Lembrando-se que é necessário fazer a UK para garantir que não se tenha mais de um Tipo de veículo com o mesmo nome.

5. **(0,5 Ponto)** Na **Caracteristica** e adicionar corretamente as anotações JPA.
   Lembrando-se que é necessário fazer a UK para garantir que não se tenha mais de uma caracteristica com o mesmo nome
   para um memso veículo.

6. **(0,25 Ponto)** Na **Fabricante** e adicionar corretamente as anotações JPA.

## No pacote resources criar as seguintes classes

7. **(1,5 Ponto)**  A criação dos Seguintes Services que devem implementar a ServiceDTO (foi fornecida):

    1. **(0,25 Ponto)** - **AcessorioService**
    2. **(0,25 Ponto)** - **CaracteristicaService**
    3. **(0,25 Ponto)** -  **FabricanteService**
    4. **(0,25 Ponto)** - **LojaService**
    5. **(0,25 Ponto)** - **TipoVeiculoService**
    6. **(0,25 Ponto)** - **VeiculoService**


8. **(4,5 Ponto)**  A perfeita criação dos Seguintes Resources no pacote resources:

    1. **(1,25 Pontos)** VeiculoResource com as seguintes ROTAS e VERBOS:
        1. "localhost/veiculos" - **GET by Example**;
        2. "localhost/veiculos" - **POST**
        3. "logalhost/veiculos/{id}" - **GET**
        4. "logalhost/veiculos/{id}/acessorios" - **GET**;
        5. "logalhost/veiculos/{id}/acessorios" - **POST**

    2. **(0,5 Ponto)** AcessorioResource com as seguintes ROTAS e VERBOS:
        1. "localhost/acessorio" - **GET by Example**;
        2. "localhost/acessorio" - **POST**
        3. "logalhost/acessorio/{id}" - **GET**

    3. **(1,25 Pontos)** LojaResource com as seguintes ROTAS e VERBOS:
        1. "localhost/loja" - **GET by Example**;
        2. "localhost/loja" - **POST**
        3. "logalhost/loja/{id}" - **GET**
        4. "logalhost/loja/{id}/veiculos" - **GET**;
        5. "logalhost/loja/{id}/veiculos" - **POST**

    4. **(0,5 Ponto)** TipoVeiculoResource com as seguintes ROTAS e VERBOS:
        1. "localhost/tipo-de-veiculo" - **GET by Example**;
        2. "localhost/tipo-de-veiculo" - **POST**;
        3. "logalhost/tipo-de-veiculo/{id}" - **GET**

    5. **(0,5 Ponto)** FabricanteResource com as seguintes ROTAS e VERBOS:
        1. "localhost/fabricantes" - **GET by Example**;
        2. "localhost/fabricantes" - **POST**
        3. "logalhost/fabricantes/{id}" - **GET**

    6. **(0,5 Ponto)** CaracteristicaResource com as seguintes ROTAS e VERBOS:
        1. "localhost/caracteristicas" - **GET by Example**,
        2. "localhost/caracteristicas" - **POST**
        2. "logalhost/caracteristicas/{id}" - **GET**


9. **(2 PONTOS)** - Execução dos Testes com o **POSTMAN**:
   A dupla deverá criar e executar os testes no POSTMAN para todos os endpoints da aplicação, exportar os testes e
   colocar na pasta documentação/requisições.

<a id="_Diagrama_de_Classes"></a>

# Diagrama de Classes de Entidade

![classes-entidade.png](documentacao/diagramas/classes-entidade.png)

# Diagrama de Classes de Request

![classes-request.png](documentacao/diagramas/classes-request.png)

# Diagrama de Classes de Response

![classes-responsee.png](documentacao/diagramas/classes-response.png)

<a id="_Entrega"></a>

# Como Entregar

**A entrega deverá ser feita pelo Teams**, você deverá postar o arquivo compactado do projeto. Porém não se esqueça
de fazer o **commit** e **push** do projeto no github.

**ATENÇÃO**
**Não será aceito para correção o link para o projeto no github**. O aluno que entregar apenas o link receberá nota *
*ZERO**

<a id="_Correcao"></a>

# Correção da Prova

Nos próximos dias, a correção da prova será disponibilizada no github do professor (branch correcao):

Para acessar digite no prompt:

```shell
git clone https://github.com/Benefrancis/CPII-spring-pg-motos && cd CPII-spring-pg-motos && git checkout correcao
```

A avaliação é em trio ( devido a grande quantidade de coisas para fazer Desenvolvimento, ORM, Testes e Documentação).

**Não copie, não forneça e nem aceite o código de outro aluno.**
O professor acessará o log do github e outras fontes para ver se a avaliação foi fraudada.
Caso o arquivo compactado não tenha o log igual ao do github, a dupla receberá nota **ZERO**
Em caso de fraude **de qualquer tipo** à atividade avaliativa, todos os envolvidos receberão nota **ZERO**

Boa avaliação.
