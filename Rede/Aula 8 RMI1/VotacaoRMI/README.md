![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-lightgrey?style=for-the-badge)

# Projeto de Redes - Servidor de Apuração de Votos  

Repositório da disciplina de **Redes de Computadores**, contendo a implementação de um servidor que apura votos recebidos de uma aplicação cliente GUI, simulando o fechamento de uma seção eleitoral.  

---

## Descrição  

- O usuário acessa a aplicação cliente onde cadastra **candidatos**, **número da chapa** e **quantidade de votos**.  
- O servidor implementa **UnicastObject** para comunicação com os clientes.  
- A cada **5 segundos**, o servidor exibe um **log com os resultados parciais** da apuração.  
- Projeto desenvolvido em **Java** utilizando a **IDE NetBeans**.  

---

## Funcionalidades  

- Cadastro de candidatos e chapas.  
- Tratamento de exceções no cliente e servidor.
- Registro de votos enviados pelo cliente.  
- Apuração automática com atualização periódica (logs a cada 5 segundos).  
- Exibição dos resultados parciais e finais.  

---

## Tecnologias utilizadas  

- **Java**  
- **NetBeans IDE**  
- **Sockets / RMI (UnicastObject)**  

---

## Como executar  

1. Clone este repositório:  
   ```bash
   git clone https://github.com/seuusuario/projeto-redes-votacao.git

## Autor
- Pedro Cristovão 