![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.x-6DB33F?logo=spring&logoColor=white)
![SQL Server](https://img.shields.io/badge/SQL%20Server-Azure-blue?logo=microsoftsqlserver&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-Database-lightgrey?logo=h2&logoColor=blue)
![Azure EventHub](https://img.shields.io/badge/Azure-EventHub-0078D4?logo=azureeventhub&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Engine-2496ED?logo=docker&logoColor=white)
![Eclipse IDE](https://img.shields.io/badge/Eclipse-2025--03%20(4.35.0)-2C2255?logo=eclipseide&logoColor=white)

# backend-simulador-api

API REST desenvolvida em **Java** com **Spring Boot Framework**, com foco em **simulação de crédito habitacional**
utilizando os sistemas de amortização SAC e PRICE, como atividade em desafio de hackathon
O projeto permite empacotar em **Docker** para facilitar o deploy em qualquer ambiente.
Por questões de segurança as credenciais e URLs de banco de dados e serviços foram removidos.

---

##  Descrição

A API recebe dados via JSON, consulta parâmetros em um banco **SQL Server** na nuvem (taxa de juros, prazo, valor mínimo e máximo), realiza cálculos de simulação nos sistemas **Price** e **SAC**, grava os resultados em um banco local **H2** e envia os dados para um **Azure EventHub**.

---

## Tecnologias utilizadas
- **Java 17+**
- **Spring Boot / Spring Data JPA**
- **SQL Server (Azure)**
- **H2 Database** (local)
- **Azure EventHub**
- **Docker**
- IDE: **Eclipse 2025-03 (4.35.0)**

---

## Segurança

Por questões de segurança, todas as credenciais sensíveis, como usuários, senhas, URLs de banco de dados e chaves de serviços externos (ex.: Azure EventHub), foram removidas deste repositório.


## Funcionalidades

- Simulação de financiamento pelo método Price.
- Simulação de financiamento pelo método SAC.
- Retorno de parcelas, juros e amortização.
- Consulta de simulações realizadas por data
- Consulta de produtos (linhas de crédito) cadastradas no SQL Server
- Relatório de dados de monitoramento da API

# Organização do Projeto

src/main/java/com/pedrocr13/simuladorhabitacional/

config/                  # Configurações de banco (SQL Server, H2)
controller/              # Endpoints REST da API
entity/                  # Entidades JPA que representam os modelos de dados
repository/              # Interfaces de acesso ao banco (Spring Data JPA)
h2/                      # Repositórios específicos para H2
sqlserver/               # Repositórios específicos para SQL Server
service/                 # Regras de negócio e lógica de simulação (Price e SAC)
dto/                     # Objetos de transferência de dados
enums/                   # Enumerações utilizadas no sistema
exceptions/              # Tratamento de exceções customizadas
mapper/                  # Conversão entre entidades e DTOs
monitoring/              # Monitoramento e métricas da aplicação
integration/azure/       # Integração com Azure EventHub 
BackendSimuladorApiApplication.java  # Classe principal da aplicação

## Endpoints disponíveis

- POST /api/simular
Recebe um JSON contendo valorSolicitado e prazo.
Retorna um JSON com os cálculos de simulação nos sistemas Price e SAC.
- GET /api/listar_todas_simulacoes
Retorna todas as simulações salvas no banco H2 local.
- GET /api/simulacoes_data
Retorna simulações agrupadas por data de referência.
- GET /api/listar_produtos
Retorna os produtos cadastrados no SQL Server.
- GET /relatorio
Retorna dados de monitoramento da API.

# Autor
Projeto desenvolvido por Pedro Cristovão, como parte de estudos e prática em Spring Boot e APIs REST.
