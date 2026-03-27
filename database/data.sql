-- Garante que o status inicial exista
INSERT IGNORE INTO barbeariastatus (id, aberto) VALUES (1, false);

-- Inserindo os barbeiros
INSERT IGNORE INTO profissionais (id, nome_funcionario, usuario, senha, page_html, status) 
VALUES 
(1, 'Gabriel', 'gabriel', '1234', 'gabriel.html', 'DISPONIVEL'),
(2, 'Pedro', 'pedro', '1234', 'pedro.html', 'DISPONIVEL'),
(3, 'Ramon', 'ramon', '1234', 'ramon.html', 'DISPONIVEL'),
(4, 'Guilherme', 'guilherme', '1234', 'guilherme.html', 'DISPONIVEL'),
(5, 'Nenhum', 'nenhum', 'nenhum', 'nenhum.html', 'INDISPONIVEL');