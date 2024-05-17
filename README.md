# Producer Kafka Example 🛠️

Este é um exemplo de aplicação Spring Boot com Java 17 que atua como um produtor Kafka utilizando o Kafka Template.

## Funcionalidades 🚀

- Envia mensagens para um tópico Kafka
- Configurações simplificadas com Spring Boot
- Exemplo prático

## Requisitos 📋

- Java 17
- Docker Desktop [Baixar Docker Desktop](https://www.docker.com/products/docker-desktop/)

## Como rodar o projeto 🏃‍♂️

1. Clone este repositório:
    ```sh
    git clone https://github.com/betobrandaojr/Producer-Kafka-Exemple.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd Producer-Kafka-Exemple
    ```

3. Na raiz do projeto, há uma pasta chamada `docker`. Dentro desta pasta, há um arquivo `docker-compose.yml`. Este arquivo contém todas as configurações necessárias para rodar o Kafka. Certifique-se de ter o Docker Desktop instalado e em execução.

4. Para iniciar o Kafka, execute o seguinte comando na pasta `docker`:
    ```sh
    docker-compose up
    ```

5. Após iniciar o Kafka, você pode rodar a aplicação Spring Boot:
    ```sh
    Inicialização varia de IDE para IDE.
    ```

6. É possível testar o envio de mensagens de forma rápida e fácil pela documentação do Swagger no endereço [http://localhost:8081/producer/swagger-ui/index.html#/](http://localhost:8081/producer/swagger-ui/index.html#/):
![image](https://github.com/betobrandaojr/Producer-Kafka-Exemple/assets/59041231/311dd841-6ed1-4294-b391-8305033d8eae)

7. No endereço [http://localhost:19000/](http://localhost:19000/) é possível visualizar a interface do Kafka e acompanhar os tópicos criados:
![image](https://github.com/betobrandaojr/Producer-Kafka-Exemple/assets/59041231/9044d4d0-f1af-4957-b20f-af63c734dbd9)

## Estrutura do Projeto 📁

- **src/**: Contém o código fonte da aplicação
- **docker/**: Contém o arquivo `docker-compose.yml` para subir o Kafka
- **pom.xml**: Arquivo de configuração do Maven

## Contato ✉️

Se você tiver alguma dúvida, sinta-se à vontade para abrir uma [issue](https://github.com/betobrandaojr/Producer-Kafka-Exemple/issues) ou entrar em contato.
---
# Producer Kafka Example 🛠️

This is an example of a Spring Boot application with Java 17 that acts as a Kafka producer using the Kafka Template.

## Features 🚀

- Sends messages to a Kafka topic
- Simplified configurations with Spring Boot
- Practical example

## Requirements 📋

- Java 17
- Docker Desktop [Download Docker Desktop](https://www.docker.com/products/docker-desktop/)

## How to run the project 🏃‍♂️

1. Clone this repository:
    ```sh
    git clone https://github.com/betobrandaojr/Producer-Kafka-Exemple.git
    ```

2. Navigate to the project directory:
    ```sh
    cd Producer-Kafka-Exemple
    ```

3. At the root of the project, there is a folder named `docker`. Inside this folder, there is a `docker-compose.yml` file. This file contains all the necessary configurations to run Kafka. Make sure you have Docker Desktop installed and running.

4. To start Kafka, run the following command in the `docker` folder:
    ```sh
    docker-compose up
    ```

5. After starting Kafka, you can run the Spring Boot application:
    ```sh
    Initialization varies from IDE to IDE.
    ```

6. You can quickly and easily test message sending using the Swagger documentation at [http://localhost:8081/producer/swagger-ui/index.html#/](http://localhost:8081/producer/swagger-ui/index.html#/):
![image](https://github.com/betobrandaojr/Producer-Kafka-Exemple/assets/59041231/311dd841-6ed1-4294-b391-8305033d8eae)

7. You can view the Kafka interface and monitor the created topics at [http://localhost:19000/](http://localhost:19000/):
![image](https://github.com/betobrandaojr/Producer-Kafka-Exemple/assets/59041231/9044d4d0-f1af-4957-b20f-af63c734dbd9)

## Project Structure 📁

- **src/**: Contains the application source code
- **docker/**: Contains the `docker-compose.yml` file to start Kafka
- **pom.xml**: Maven configuration file

## Contact ✉️

If you have any questions, feel free to open an [issue](https://github.com/betobrandaojr/Producer-Kafka-Exemple/issues) or get in touch.
