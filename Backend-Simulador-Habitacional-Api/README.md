# Backend Simulador de Crédito Habitacional

API REST desenvolvida em **Java** utilizando **Spring Boot Framework**, com foco em **simulação de crédito habitacional**.  
O projeto permite empacotar em **Docker** para facilitar o deploy em qualquer ambiente.

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
Projeto desenvolvido por Pedro Lopes, como parte de estudos e prática em Spring Boot e APIs REST.
