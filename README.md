# Projeto Loja

Este é um projeto Spring Boot para uma aplicação de loja, incialmente apenas com cadastro de funcionários, utilizando PostgreSQL como banco de dados e com tratamento de exceções implementado. O front-end é construído utilizando jQuery, HTML e CSS.

## Configuração do Ambiente

- **Java**: JDK 17
- **Banco de Dados**: PostgreSQL
- **Build Tool**: Maven

## Dependências do Projeto

Este projeto utiliza as seguintes dependências Maven:

- `spring-boot-starter-data-jdbc`: Para acessar o banco de dados utilizando JDBC.
- `spring-boot-starter-data-jpa`: Suporte ao Spring Data JPA para persistência de dados.
- `spring-boot-starter-web`: Para construção de aplicativos da web, incluindo RESTful APIs.
- `spring-boot-starter-web-services`: Suporte ao desenvolvimento de serviços web SOAP.
- `spring-boot-devtools`: Ferramentas de desenvolvimento para reinicialização automática e outros utilitários de desenvolvimento.
- `postgresql`: Driver JDBC para PostgreSQL.
- `lombok`: Biblioteca para geração automática de código Java boilerplate.
- `spring-boot-starter-test`: Dependências para testes unitários e de integração.
- `hibernate-validator`: Implementação da especificação de validação Bean Validation (JSR 380).
- `validation-api`: API de validação para Java Bean Validation.

## Executando o Projeto

Para executar o projeto localmente, você pode usar a classe principal `LojaApplication.java`
A aplicação estará acessível em `http://localhost:8080`.

## Configurações do Banco de Dados

As configurações do banco de dados estão localizadas no arquivo `application.properties`. 
Configure as propriedades relacionadas ao PostgreSQL, como URL, nome de usuário e senha. 
Sugiro que configure essas propriedades relacionadas ao banco de dados utilizando variáveis de ambiente.
DATABASE_URL: A URL de conexão com o banco de dados PostgreSQL não esqueça de colocar o nome do banco em sua váriavel.
DATABASE_USERNAME= O nome de usuário do banco de dados PostgreSQL.
DATABASE_PASSWORD=A senha do banco de dados PostgreSQL.

## Front-End

O front-end básico utilizando jQuery, HTML e CSS. Os arquivos do front-end estão localizados na pasta `src/main/resources/static`.


