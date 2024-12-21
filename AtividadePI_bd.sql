USE AtividadePI;

CREATE TABLE usuario(
    id INT NOT NULL AUTO_INCREMENT NOT NULL,
    nome VARCHAR(70) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tarefa(
    id INT NOT NULL AUTO_INCREMENT NOT NULL,
    titulo VARCHAR(70) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    dataLimite DATE NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)	
);

SELECT * FROM usuario;

SELECT * FROM tarefa;