# 📘 Conversor de Moedas --- Projeto Java

Bem-vindo ao **Conversor de Moedas**, um projeto simples em Java que
realiza conversões entre diferentes moedas utilizando uma API externa de
taxas de câmbio.\
Este projeto foi desenvolvido para prática de **Java**, **HTTP Client**,
**Gson**, **orientação a objetos** e **integração com APIs**.

## ✨ Funcionalidades

-   🔄 Conversão de valores entre duas moedas
-   🌍 Suporte a múltiplas moedas (lista pré-definida e possibilidade de
    inserir novas)
-   🧠 Interface de menu interativa no console
-   🌐 Consulta de valores de conversão em tempo real através de API
-   🧱 Estrutura modular dividida em classes

## 📂 Estrutura do Projeto

    src/
     ├── Principal.java               # Classe principal e loop da aplicação
     ├── InterfaceMenu.java           # Interface de interação com o usuário
     ├── ConsultaConversao.java       # Integração com a API de conversão
     ├── BuscaValorConversao.java     # Record que representa a resposta da API
     └── Moeda.java                   # Classe/record representando o modelo de moeda

## 🚀 Como Executar o Projeto

### ✅ Pré-requisitos

-   Java **17** ou superior\
-   Biblioteca **Gson** adicionada ao classpath\
-   Acesso à internet (para realizar a consulta à API)

## 🔧 Tecnologias Utilizadas

-   **Java 17+**
-   **HttpClient**
-   **Gson**
-   **Records**

## 🌐 API Utilizada

O projeto consulta a API ExchangeRate-API de câmbio para obter o valor atualizado das
moedas.\
A URL é montada dinamicamente com base nas escolhas do usuário.

## 🏗️ Arquitetura e Organização

### 🧠 Principal.java

Gerencia o fluxo principal do programa.

### 🎛️ InterfaceMenu.java

Responsável pela interação com o usuário.

### 🌍 ConsultaConversao.java

Realiza a chamada HTTP.

### 🧾 BuscaValorConversao.java

Record que representa os dados retornados.

### 💰 Moeda.java

Modela uma moeda com código e nome.

## 📝 Exemplos de Uso

1.  O usuário escolhe a moeda de origem
2.  Escolhe a moeda de destino
3.  Digita o valor
4.  O sistema consulta a API
5.  Mostra o valor convertido ✳️

## 📜 Licença

Este projeto é aberto para estudos e modificações.
