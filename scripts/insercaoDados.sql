-- Inserção Patente
insert into patente (nome_patente, exp_necessaria) values ('Recruta', 0);
insert into patente (nome_patente, exp_necessaria) values ('Soldado', 500);
insert into patente (nome_patente, exp_necessaria) values ('Cabo', 1000);
insert into patente (nome_patente, exp_necessaria) values ('Tenente', 2000);
insert into patente (nome_patente, exp_necessaria) values ('Capitao', 10000);
insert into patente (nome_patente, exp_necessaria) values ('General', 20000);
-- Inserção Categoria
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Sangue', 'doação', 100);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Roupas', 'doação', 20);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Campeonatos', 'campeonato', 50);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Alimentos', 'doação', 30);
insert into Categoria (nome_categoria, desc_categoria, experiencia) values ('Doação de Briquedos', 'doação', 10);
-- Inserção Voluntario
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Jose', 50, 'jose',       'email@email.com',1 ,123, 'M');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Ariel', 50, 'ariel',     'email1@email.com',1 ,123, 'M');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Maria', 50, 'maria',     'email2@email.com',1 ,123, 'F');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Maria', 50, 'maria123',  'email3@email.com',1 ,123, 'F');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Jordi', 50, 'jordi',     'email4@email.com',1 ,123, 'M');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Flavio', 50, 'flavio',   'email5@email.com',1 ,123, 'M');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Ronney', 50, 'ronney',   'email6@email.com',1 ,123, 'M');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Jordana', 50, 'jordana', 'email7@email.com',1 ,123, 'F');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Pedro', 50, 'pedro',     'email8@email.com',1 ,123, 'M');
insert into Voluntario (nome, Experiencia, login,  email, cod_patente,senha, sexo) values ('Joana', 50, 'joana',     'email9@email.com',1 ,123, 'F');
-- inserção Evento
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, ID) values ('Doação de Sangue Hemocentro', 'evento de doacao de sangue', '2017-05-30', '2017-06-20', 1, 1);
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, ID) values ('Doação de brinquedos Orfanato Santo Fé', 'evento', '2017-05-25', '2017-06-15', 5, 2);
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, ID) values ('Doação de Roupas Instituto Ajuda', 'evento de doacao de roupas', '2017-06-28', '2017-06-30', 1, 3);
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, ID) values ('Campeonato Benificente de CS', 'campeonato de cs', '2017-05-30', '2017-06-20', 1, 4);
insert into evento (nome_evento, descricao, data_inicio, data_fim, cod_categoria, ID) values ('Doação de leite para creche', 'evento de doacao de sangue', '2017-04-25', '2017-05-30', 4, 5);

select nome_evento, descricao, cod_categoria, data_inicio, data_fim, cod_evento, ID from evento;

-- inserção part
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (2, 1, '2017-05-29');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (1, 3, '2017-05-27');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (1, 2, '2017-05-28');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (3, 5, '2017-05-30');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (5, 5, '2017-05-31');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (4, 1, '2017-04-24');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (2, 3, '2017-02-17');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (3, 4, '2017-03-22');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (3, 4, '2017-05-20');
insert into participacao (ID_voluntario, cod_evento, data_participacao) values (5, 2, '2017-01-29');