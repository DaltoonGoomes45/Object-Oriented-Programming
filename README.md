# 🚗 Sistema Automotivo – Gestão de Estoque de Veículos

## 📜 Descrição
Sistema completo para a **gestão de estoque de veículos**, permitindo o **cadastro**, **edição**, **exclusão** e **consulta** de veículos com filtros avançados por **marca**, **modelo**, **ano**, **preço** e **status** (Disponível, Vendido, Reservado).

O projeto adota uma arquitetura full-stack moderna, com foco em desempenho e facilidade de manutenção.

---

## 💻 Tecnologias Utilizadas

| Camada | Tecnologia | Versão/Detalhe |
| :--- | :--- | :--- |
| **Backend** | **Java** | 25 (OpenJDK) |
| | **Spring Boot** | Framework principal |
| **Banco de Dados** | **MySQL** | 8 |
| **Frontend** | **HTML, CSS, JavaScript** | Padrão Web |
| **Comunicação** | **API REST** | Formato JSON |
| **Gerenciador de Dependências** | **Apache Maven** | 3.9.11 |

---

## 🗃️ Estrutura do Banco de Dados

O projeto utiliza o banco de dados **MySQL** e gerencia o estoque através da tabela `veiculo`.

### Tabela `veiculo`

| Coluna | Tipo | Observações |
| :--- | :--- | :--- |
| `id` | `int` | **PK**, auto-increment |
| `marca` | `varchar(50)` | Nome da marca |
| `modelo` | `varchar(80)` | Modelo do veículo |
| `ano` | `int` | Ano de fabricação |
| `cor` | `varchar(50)` | Cor do veículo |
| `preco` | `decimal(10,2)` | Preço de venda |
| `quilometragem` | `int` | Quilometragem atual |
| `status` | `varchar(30)` | Disponível, Vendido, Reservado |

> ℹ️ O arquivo **`backup.sql`** contém esta tabela e dados de exemplo prontos para teste imediato.

---

## ✨ Funcionalidades

O sistema oferece as seguintes funcionalidades:

* **Cadastro Completo:** Registro de veículos com todos os campos (marca, modelo, ano, cor, preço, quilometragem, status).
* **Busca Avançada:** **Consulta** e **filtros** por marca, modelo, ano, preço e status.
* **Busca Rápida:** Implementada diretamente no frontend para agilidade.
* **Atualização de Dados:** Edição de informações como preço, quilometragem e status.
* **Gerenciamento de Status:** **Remoção** de veículos ou simples **marcação como vendido**.
* **Interface Amigável:** Uso de **Modais** para cadastro e edição de veículos.

---

## 🛠️ Como Rodar o Projeto

Siga os passos abaixo para configurar e executar o projeto em sua máquina local.

### **1️⃣ Pré-requisitos**

Certifique-se de ter os seguintes softwares instalados e configurados no **PATH do sistema**:

* **Java 25 (OpenJDK)**
* **Apache Maven 3.9.11**
* **MySQL 8**
* **Navegador moderno** (Chrome, Edge, Firefox, etc.)

---

### **2️⃣ Configurar o Banco de Dados**

#### **2.1. Criar o Banco de Dados**

Abra o terminal e acesse o cliente MySQL:

mysql -u root -p
SQL

# Digite sua senha:290820
Crie o bando de dados
CREATE DATABASE sistema_automotivo;
EXIT;
2.2. Importar o Backup
Importe o arquivo backup.sql para popular o banco com dados de exemplo:


mysql -u root -p sistema_automotivo < backup.sql
⚠️ Observação de Backup: O backup foi criado com as credenciais padrão root e senha 290820 para testes rápidos. Para gerar novos backups futuros, utilize o comando:


mysqldump -u root -p sistema_automotivo > backup.sql
3️⃣ Configurar o Backend (Spring Boot)
Edite o arquivo application.properties (ou o equivalente de configuração do Spring Boot) e ajuste as credenciais do banco de dados, se necessário.

spring.datasource.url=jdbc:mysql://localhost:3306/sistema_automotivo
spring.datasource.username=root
spring.datasource.password=290820
spring.jpa.hibernate.ddl-auto=update
4️⃣ Rodar o Backend
No terminal, navegue até a pasta raiz do projeto e execute o comando Maven para iniciar a aplicação Spring Boot:

mvn spring-boot:run
O serviço da API REST estará disponível em: http://localhost:8080/veiculos.

🔔 Atenção: Certifique-se de que a porta 8080 esteja livre em seu sistema.

5️⃣ Testar o Frontend
Após o backend estar rodando, abra o arquivo index.html diretamente em seu navegador para acessar a interface do sistema.

O frontend se comunica com a API REST utilizando a função fetch (JSON).
