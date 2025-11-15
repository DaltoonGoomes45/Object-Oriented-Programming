Sistema Automotivo – Gestão de Estoque de Veículos
Descrição

Sistema para gestão de estoque de veículos, permitindo cadastro, edição, exclusão e consulta de veículos com filtros por marca, modelo, ano, preço e status.

O projeto é desenvolvido em Java com Spring Boot no backend, MySQL como banco de dados, e frontend em HTML, CSS e JavaScript.

Tecnologias Utilizadas

Backend: Java 25 + Spring Boot

Banco de Dados: MySQL 8

Frontend: HTML, CSS, JavaScript

Gerenciador de Dependências: Apache Maven 3.9.11

Comunicação: API REST (JSON)

Estrutura do Banco de Dados
Tabela veiculo
Coluna	Tipo	Observações
id	int	PK, auto-increment
marca	varchar(50)	Nome da marca
modelo	varchar(80)	Modelo do veículo
ano	int	Ano de fabricação
cor	varchar(50)	Cor do veículo
preco	decimal(10,2)	Preço do veículo
quilometragem	int	Quilometragem atual
status	varchar(30)	Disponível, Vendido, Reservado

O arquivo backup.sql contém esta tabela com dados de exemplo prontos para testes.

Funcionalidades

Cadastro de veículos (marca, modelo, ano, cor, preço, quilometragem, status)

Consulta e filtros por marca, modelo, ano, preço e status

Atualização de informações (preço, quilometragem e status)

Remoção de veículos ou marcação como vendido

Busca rápida diretamente no frontend

Modais de cadastro e edição de veículos

Como Rodar o Projeto
1️⃣ Pré-requisitos

Java 25 (OpenJDK)

Apache Maven 3.9.11

MySQL 8

Navegador moderno (Chrome, Edge, Firefox)

Certifique-se de que Java, Maven e MySQL estejam no PATH do sistema.

2️⃣ Configurar o Banco de Dados

Criar o banco de dados:
mysql -u root -p

Digite a senha: 290820

Dentro do MySQL:
CREATE DATABASE sistema_automotivo;
EXIT;

Importar o backup:
mysql -u root -p sistema_automotivo < backup.sql

3️⃣ Configurar o Backend (Spring Boot)

No arquivo application.properties configure:

spring.datasource.url=jdbc:mysql://localhost:3306/sistema_automotivo
spring.datasource.username=root
spring.datasource.password=290820
spring.jpa.hibernate.ddl-auto=update

4️⃣ Rodar o Projeto

No terminal, na pasta do projeto, execute:
mvn spring-boot:run

A API estará disponível em: http://localhost:8080/veiculos

Certifique-se de que a porta 8080 esteja livre.

5️⃣ Testar o Frontend

Abra index.html no navegador

Certifique-se que o backend está rodando

Teste cadastro, edição, filtros e exclusão

6️⃣ Observações

Qualquer usuário pode importar o backup usando o usuário root e a senha 290820.

O arquivo backup.sql contém apenas a tabela veiculo com dados de exemplo.

Para gerar novos backups futuros:
mysqldump -u root -p sistema_automotivo > backup.sql

O frontend se comunica com a API via fetch (JSON).
