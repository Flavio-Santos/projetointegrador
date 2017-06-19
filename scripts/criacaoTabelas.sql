-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.
create database projeto;
use projeto;
-- drop database projeto;


CREATE TABLE Evento (
    descricao TEXT,
    data_inicio DATE,
    data_fim DATE,
    cod_evento INT AUTO_INCREMENT PRIMARY KEY,
    nome_evento VARCHAR(50),
    cod_categoria INT,
    ID INT
);



CREATE TABLE Patente (
    cod_patente INT AUTO_INCREMENT PRIMARY KEY,
    exp_necessaria INT,
    nome_patente VARCHAR(20)
);

CREATE TABLE Categoria (
    desc_categoria TEXT,
    cod_categoria INT AUTO_INCREMENT PRIMARY KEY,
    experiencia INT,
    nome_categoria VARCHAR(20)
);

CREATE TABLE Voluntario (
    Senha VARCHAR(20),
    Nome VARCHAR(50),
    Login VARCHAR(20) UNIQUE,
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Admin BOOLEAN DEFAULT FALSE,
    Ativo BOOLEAN DEFAULT TRUE,
    Email VARCHAR(50) UNIQUE,
    Experiencia INT,
    Sexo CHAR(1),
    cod_patente INT,
    FOREIGN KEY (cod_patente)
        REFERENCES Patente (cod_patente)
);

CREATE TABLE Participacao (
    data_participacao DATE,
    cod_participacao INT AUTO_INCREMENT PRIMARY KEY,
    participou BOOLEAN DEFAULT FALSE,
    ID_voluntario INT,
    cod_evento INT,
    FOREIGN KEY (ID_voluntario)
        REFERENCES Voluntario (ID),
    FOREIGN KEY (cod_evento)
        REFERENCES Evento (cod_evento)
);

ALTER TABLE Evento ADD FOREIGN KEY(cod_categoria) REFERENCES Categoria (cod_categoria);
ALTER TABLE Evento ADD FOREIGN KEY(ID) REFERENCES Voluntario (ID);





            
            
            
            
            
            
            