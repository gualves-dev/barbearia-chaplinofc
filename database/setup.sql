-- "IF NOT EXISTS" serve para o código não dar erro se você rodar ele duas vezes.]

CREATE DATABASE IF NOT EXISTS barbearia_chaplin;

USE barbearia_chaplin;

CREATE TABLE IF NOT EXISTS fila(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100) NOT NULL,
    servico VARCHAR(100) NOT NULL,
    profissional VARCHAR(100) NOT NULL,
    tempo_estimado INT NOT NULL,
    status VARCHAR(20) DEFAULT 'AGUARDANDO',
    numero VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS barbeariastatus (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Adicionei AUTO_INCREMENT
    aberto BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS profissionais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_funcionario VARCHAR(100) NOT NULL,
    usuario VARCHAR(100) NOT NULL UNIQUE, -- Adicionei o UNIQUE aqui
    senha VARCHAR(100) NOT NULL,
    page_html VARCHAR(50) NOT NULL,
    status VARCHAR(25) DEFAULT 'DISPONIVEL'
);
