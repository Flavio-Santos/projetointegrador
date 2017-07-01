-- inser��o Patente
insert into patente (nome_patente, exp_necessaria) values ('Recruta', 0);
insert into patente (nome_patente, exp_necessaria) values ('Soldado', 500);
insert into patente (nome_patente, exp_necessaria) values ('Cabo', 1000);
insert into patente (nome_patente, exp_necessaria) values ('Tenente', 2000);
insert into patente (nome_patente, exp_necessaria) values ('Capitao', 10000);
insert into patente (nome_patente, exp_necessaria) values ('General', 20000);

-- inser��o Categoria
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Campeonato', 'Categoria de Campeonatos', 400);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Sangue', 'Categoria Doação de Sangue', 500);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Roupas', 'Categoria Doação de Roupas', 200);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Alimentos', 'Categoria de Doação de Alimentos', 300);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Briquedos', 'Categoria de Doação de Brinquedos', 100);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Materias escolares', 'Categoria de Doação de Materias escolares', 100);

-- inser��o Voluntario
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Ariel Vieira Silva', 1000, 'ariel', 'ariel@gmail.com',3 ,123, 'M');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Flavio Santos', 1359, 'flavio', 'flavio@gmail.com',3 ,123, 'M');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Jordana Vilela', 9999, 'jordana', 'jordana@gmail.com',4 ,123, 'F');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Jordi Ribeiro ', 731, 'jordi', 'jordi@gmail.com',2 ,123, 'M');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Ronney Petras', 477, 'ronney', 'ronney@gmail.com',1 ,123, 'M');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Jose De Alcantra Nunes', 19458, 'jose', 'josealcantra123nunes@outlook.com',5 ,123, 'M');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Maria Joaquina da Silva', 25679, 'maria', 'mariajoaquinadasilva@yahoo.com',6 ,123, 'F');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Maria das Graças de Jesus', 0, 'maria123', 'mariadasgracas.dejesus@hotmail.com.br',1 ,123, 'F');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Pedro Silva Carvalho', 1999, 'pedro', 'pedro.silva.carvalho@hotmail.com',3 ,123, 'M');
insert into Voluntario (nome, Experiencia, login, email, cod_patente,senha, sexo) values ('Joana Alvez da Silva', 2001, 'joana', 'joanaalvez@gmail.com',4 ,123, 'F');

-- inser��o Evento
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, cod_voluntario) values ('Doação de Sangue Hemocentro', 'Evento de doacao de sangue do hemocentro', '2017-05-30', '2017-06-20', 2, 4);
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, cod_voluntario) values ('Doação de brinquedos Orfanato Santo Fé', 'Evento para arrecadar brinquedos', '2017-05-25', '2017-06-15', 5, 2);
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, cod_voluntario) values ('Doação de Roupas Instituto Ajuda', 'Evento de doacao de roupas', '2017-06-28', '2017-06-30', 3, 3);
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, cod_voluntario) values ('Campeonato Benificente de Truco', 'Campeonato de Truco', '2017-05-30', '2017-06-20', 1, 1);
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, cod_voluntario) values ('Doação de leite para creche', 'Arrecadação de leite para creches', '2017-04-25', '2017-05-30', 4, 5);

-- inser��o participacao
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (2, 1, '2017-05-29');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (1, 3, '2017-05-27');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (1, 2, '2017-05-28');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (3, 5, '2017-05-30');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (5, 5, '2017-05-31');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (4, 1, '2017-04-24');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (2, 3, '2017-02-17');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (3, 4, '2017-03-22');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (3, 4, '2017-05-20');
insert into participacao (cod_voluntario, cod_evento, data_participacao) values (5, 2, '2017-01-29');