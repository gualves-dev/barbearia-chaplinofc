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


-- Primeiro limpamos o ID 1 para não dar erro de "já existe"
DELETE FROM barbeariastatus WHERE id = 1;

-- Inserimos que o sistema começa ABERTO (TRUE)
INSERT INTO barbeariastatus (id, sistema_aberto) VALUES (1, TRUE);

SELECT * FROM fila;

SELECT * FROM barbeariastatus;


SELECT * FROM profissionais;


DROP Table fila;

-- Garante que a barbearia comece com o registro de status ID 1
INSERT IGNORE INTO barbeariastatus (id, aberto) VALUES (1, true);

-- Inserindo os barbeiros (Corrigido: um único VALUES e todas as colunas preenchidas)
INSERT IGNORE INTO profissionais (id, nome_funcionario, usuario, senha, page_html, status) 
VALUES 
(1, 'Gabriel', 'gabriel', '1234', 'gabriel.html', 'DISPONIVEL'),
(2, 'Pedro', 'pedro', '1234', 'pedro.html', 'DISPONIVEL'),
(3, 'Ramon', 'ramon', '1234', 'ramon.html', 'DISPONIVEL'),
(4, 'Guilherme', 'guilherme', '1234', 'guilherme.html', 'DISPONIVEL'),
(5, 'Nenhum', 'nenhum', 'nenhum', 'nenhum.html', 'INDISPONIVEL');

