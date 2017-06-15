-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.

create database projeto;
use projeto;

CREATE TABLE Evento (
descricao text,
dataI date,
dataF date,
COD_EVENTO int auto_increment PRIMARY KEY,
Nome_evento varchar(60),
COD_TIPOEVENTO int,
cod_admin int
);

select * from usuario;

CREATE TABLE Administrador (
cod_admin int auto_increment PRIMARY KEY,
ID INT
);

CREATE TABLE Patente (
COD_PATENTE int auto_increment PRIMARY KEY,
EXP_NECESSARIA int,
NOME_PATENTE varchar(20) unique
);

CREATE TABLE Usuario_Normal (
ativo char(1),
cod_usuario int auto_increment PRIMARY KEY,
ID INT,
COD_PATENTE int,
FOREIGN KEY(COD_PATENTE) REFERENCES Patente (COD_PATENTE)
);

CREATE TABLE USUARIO (
Nome varchar(50),
Login varchar(20) unique,
ID INT auto_increment PRIMARY KEY,
Senha varchar(20),
Experiencia int,
Sexo char(1),
Hierarquia varchar(50)
);

select * from usuario where Login='ariel' and Senha='123';

CREATE TABLE TIPO_EVENTO (
DESC_TIPOEVENTO text,
COD_TIPOEVENTO int auto_increment PRIMARY KEY,
EXPERIENCIA int,
NOME_TIPOEVENTO varchar(20)
);

CREATE TABLE Participacao (
data_participacao date,
cod_part int auto_increment PRIMARY KEY,
cod_usuario int,
COD_EVENTO int,
FOREIGN KEY(cod_usuario) REFERENCES Usuario_Normal (cod_usuario),
FOREIGN KEY(COD_EVENTO) REFERENCES Evento (COD_EVENTO)
);

ALTER TABLE Evento ADD FOREIGN KEY(COD_TIPOEVENTO) REFERENCES TIPO_EVENTO (COD_TIPOEVENTO);
ALTER TABLE Evento ADD FOREIGN KEY(cod_admin) REFERENCES Administrador (cod_admin);
ALTER TABLE Administrador ADD FOREIGN KEY(ID) REFERENCES USUARIO (ID);
ALTER TABLE Usuario_Normal ADD FOREIGN KEY(ID) REFERENCES USUARIO (ID);



-- Inserção Patente
insert into patente (nome_patente, exp_necessaria) values ('Soldado', 50);
insert into patente (nome_patente, exp_necessaria) values ('Cabo', 100);
insert into patente (nome_patente, exp_necessaria) values ('Tenente', 200);
insert into patente (nome_patente, exp_necessaria) values ('Capitao', 500);
insert into patente (nome_patente, exp_necessaria) values ('General', 1000);
-- Inserção Tipo Evento
insert into tipo_evento (nome_tipoevento, desc_tipoevento, experiencia) values ('Doação de Sangue', 'doação', 100);
insert into tipo_evento (nome_tipoevento, desc_tipoevento, experiencia) values ('Doação de Roupas', 'doação', 20);
insert into tipo_evento (nome_tipoevento, desc_tipoevento, experiencia) values ('Campeonatos', 'campeonato', 50);
insert into tipo_evento (nome_tipoevento, desc_tipoevento, experiencia) values ('Doação de Alimentos', 'doação', 30);
insert into tipo_evento (nome_tipoevento, desc_tipoevento, experiencia) values ('Doação de Briquedos', 'doação', 10);
-- Inserção Usuario
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Ariel', 50, 'ariel', null, 123, 'M');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Jose', 50, 'jose', null, 123, 'M');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Maria', 50, 'maria', null, 123, 'F');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Maria', 50, 'maria123', null, 123, 'F');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Jordi', 50, 'jordi', null, 123, 'M');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Flavio', 50, 'flavio', null, 123, 'M');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Ronney', 50, 'ronney', null, 123, 'M');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Jordana', 50, 'jordana', null, 123, 'F');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Pedro', 50, 'pedro', null, 123, 'M');
insert into usuario (nome, Experiencia, login, hierarquia, senha, sexo) values ('Joana', 50, 'joana', null, 123, 'F');
-- Inserção admin
insert into administrador (id) values (1);
insert into administrador (id) values (5);
insert into administrador (id) values (6);
insert into administrador (id) values (7);
insert into administrador (id) values (8);
-- Inserção usuario normal
insert into usuario_normal (ativo, id, cod_patente) values ('S', 2, 1);
insert into usuario_normal (ativo, id, cod_patente) values ('S', 3, 1);
insert into usuario_normal (ativo, id, cod_patente) values ('S', 4, 1);
insert into usuario_normal (ativo, id, cod_patente) values ('S', 9, 1);
insert into usuario_normal (ativo, id, cod_patente) values ('S', 10, 1);
-- inserção evento
insert into evento (nome_evento, descricao, dataI, dataF, cod_tipoevento, cod_admin) values ('Doação de Sangue Hemocentro', 'evento de doacao de sangue', '2017-05-30', '2017-06-20', 1, 1);
insert into evento (nome_evento, descricao, dataI, dataF, cod_tipoevento, cod_admin) values ('Doação de brinquedos Orfanato Santo Fé', 'evento', '2017-05-25', '2017-06-15', 5, 2);
insert into evento (nome_evento, descricao, dataI, dataF, cod_tipoevento, cod_admin) values ('Doação de Roupas Instituto Ajuda', 'evento de doacao de roupas', '2017-06-28', '2017-06-30', 1, 3);
insert into evento (nome_evento, descricao, dataI, dataF, cod_tipoevento, cod_admin) values ('Campeonato Benificente de CS', 'campeonato de cs', '2017-05-30', '2017-06-20', 1, 4);
insert into evento (nome_evento, descricao, dataI, dataF, cod_tipoevento, cod_admin) values ('Doação de leite para creche', 'evento de doacao de sangue', '2017-04-25', '2017-05-30', 4, 5);
-- inserção part
insert into participacao (cod_usuario, cod_evento, data_participacao) values (2, 1, '2017-05-29');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (1, 3, '2017-05-27');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (1, 2, '2017-05-28');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (3, 5, '2017-05-30');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (5, 5, '2017-05-31');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (4, 1, '2017-04-24');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (2, 3, '2017-02-17');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (3, 4, '2017-03-22');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (3, 4, '2017-05-20');
insert into participacao (cod_usuario, cod_evento, data_participacao) values (5, 2, '2017-01-29');

--

SELECT 
    *
FROM
    usuario
WHERE
    nome = 'ariel';
SELECT 
    *
FROM
    usuario
WHERE
    sexo = 'M';
SELECT 
    *
FROM
    usuario
WHERE
    sexo = 'F';
-- busca todo mundo que participou de eventos do sexo masculino
SELECT 
    p.*, u.nome
FROM
    participacao p,
    usuario u,
    usuario_normal n
WHERE
    n.cod_usuario = p.cod_usuario
        AND u.id = n.id
        AND p.cod_usuario IN (SELECT 
            c.cod_usuario
        FROM
            Usuario_Normal c,
            usuario u
        WHERE
            u.id = c.id AND sexo = 'm');
 -- busca todo mundo que participou de eventos do sexo feminino
SELECT 
    p.*, u.nome
FROM
    participacao p,
    usuario u,
    usuario_normal n
WHERE
    n.cod_usuario = p.cod_usuario
        AND u.id = n.id
        AND p.cod_usuario IN (SELECT 
            c.cod_usuario
        FROM
            Usuario_Normal c,
            usuario u
        WHERE
            u.id = c.id AND sexo = 'f');
            
            
            
            
            SELECT * FROM EVENTO;
            SELECT * FROM ADMINISTRADOR;
            SELECT * FROM USUARIO_NORMAL;
            SELECT * FROM TIPO_EVENTO;
            SELECT * FROM PARTICIPACAO;
            
            
            
            
            
select * from usuario where ID = (select ID from usuario where Login="Ariel" and Senha="123");



alter table usuario add index  ID (ID);


create index pass on USUARIO(Login) using HASH;

-- where Login=? and Senha=?;
            
            
            desc usuario;
            
            
            
            
            
            
            