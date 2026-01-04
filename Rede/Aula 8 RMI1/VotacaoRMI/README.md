# 🗳️ Apuração de Votos – Sistema Cliente/Servidor (RMI)

![Java](https://img.shields.io/badge/Java-ED8B00?logo=java&logoColor=white)
![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-green)

Projeto desenvolvido como atividade na disciplina de **Redes de Computadores**, consistindo em um sistema **cliente/servidor** para apuração de votos, simulando o fechamento de uma seção eleitoral.

O projeto único é composto por:

- Classes referentes ao **cliente com interface gráfica**
- Classes referentes ao **servidor** responsável pela apuração e consolidação dos votos

- Poderá ser desmembrado em dois projetos, possui a interface MetodosRemotosUrna que são implementadas tanto pelo cliente quanto pelo servidor
---

## 🧩 Descrição Técnica

- O cliente permite cadastrar candidatos, número da chapa e quantidade de votos.
- A comunicação é feita utilizando **Java RMI (UnicastRemoteObject)**.
- O servidor realiza a apuração dos votos recebidos.
- A cada **5 segundos**, o servidor exibe logs com os resultados parciais da apuração.
- O projeto inclui **tratamento de exceções** tanto no cliente quanto no servidor.

---

## ⚙️ Funcionalidades

- Cadastro de candidatos e chapas
- Envio de votos via aplicação cliente
- Apuração automática no servidor
- Atualização periódica dos resultados
- Exibição de resultados parciais e finais
- Tratamento de erros e exceções

---

## 🛠️ Tecnologias Utilizadas

- Java
- Java RMI (UnicastRemoteObject)
- NetBeans IDE
- Conceitos de Redes e Comunicação Cliente/Servidor

---

## ▶️ Como Executar

1. Clone o repositório:
    ```bash
    git clone https://github.com/PedroCr13/Estudos-Projetos-Java.git

2. Navegue até a pasta do projeto:
    ```bash
    cd "Estudos-Projetos-Java/Rede/Aula 8 RMI1/VotacaoRMI/"

3. Abra o projeto no NetBeans e poderá clicar com botão direito sobre a classe Servidor e selecinar Run File ou Shift + F6,

4. Clicar com o botão direito sobre a classe frmCliente e selecinar Run File ou Shift + F6, cadastrar candidatos, votos e enviar

5. Acompanhar a apuração dos votos pelo console na aba Servidor.

👤 Autor

Pedro Cristovão Lopes Fogaça