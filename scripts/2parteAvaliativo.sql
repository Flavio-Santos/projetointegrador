-- 5 Consultas com junÃ§Ã£o de Tabelas, utilizar condiÃ§Ãµes 
-- 1
SELECT 
    e.*
FROM
    categoria c left join evento e on c.cod_categoria=e.cod_categoria
where  c.experiencia >= 300 ;
-- 2 
SELECT 
    e.*
FROM
    categoria c
        LEFT JOIN
    evento e ON c.cod_categoria = e.cod_categoria
WHERE
    e.data_inicio BETWEEN '2017-05-01' AND '2017-05-30'
        AND e.data_fim BETWEEN '2017-06-01' AND '2017-06-30'	;
        
-- 3

SELECT 
    v.cod_patente,
    v.nome,
    v.experiencia,
    p.nome_patente,
    p.cod_patente
FROM
    voluntario v,
    patente p
WHERE
    v.cod_patente = p.cod_patente 
    and v.experiencia >= 1000 ;
    
-- 4 

select * from voluntario;
select * from participacao;

SELECT 
    v.nome, p.data_participacao
FROM
    voluntario v,
    participacao p
WHERE
    v.admin <> 1 AND v.cod_voluntario = p.cod_voluntario;
    
-- 5 
SELECT 
    v.nome, p.data_participacao, e.nome_evento, c.experiencia
FROM
    voluntario v,
    participacao p,
    evento e,
    categoria c
WHERE
    v.admin <> 1 AND v.cod_voluntario = p.cod_voluntario
        AND e.cod_evento = p.cod_evento
        AND c.cod_categoria = e.cod_categoria
ORDER BY v.nome;


-- )5 Consultas com operador IN /  5 representaÃ§Ã£o das mesmas consultas da letra b com operador Exists

-- 1
SELECT * FROM patente WHERE nome_patente IN ('Recruta' , 'Tenente');
SELECT * FROM patente WHERE exists ( select * from patente ) and nome_patente = 'Recruta' or  nome_patente ='Tenente';
    

    
-- 2
select * from evento where cod_categoria in ( select cod_categoria from categoria where cod_categoria =1 );
select * from evento e where exists ( select cod_categoria from categoria where e.cod_categoria=cod_categoria ) and cod_categoria =1;

-- 3
select * from categoria where cod_categoria in ( select cod_categoria from evento );
SELECT  * FROM categoria c WHERE EXISTS( SELECT * FROM evento WHERE c.cod_categoria = cod_categoria);

-- 4
select * from  participacao where cod_voluntario in ( select cod_voluntario from voluntario);
select * from  participacao where exists ( select cod_voluntario from voluntario where cod_voluntario=cod_voluntario);

-- 5
select * from patente where cod_patente in ( select cod_patente from voluntario);
select * from patente p where not exists ( select cod_patente from voluntario where p.cod_patente= cod_patente);



-- 10 consultas utilizando funções agregadas, clÃ¡usula group by e having.


-- 1
select max(experiencia), cod_patente from voluntario group by cod_patente;
select max(experiencia) from categoria;

-- 2
SELECT 
    count(*),v.nome
FROM
    voluntario v,
    participacao p,
    evento e,
    categoria c
WHERE
    v.admin <> 1 AND v.cod_voluntario = p.cod_voluntario
        AND e.cod_evento = p.cod_evento
        AND c.cod_categoria = e.cod_categoria
group by nome
ORDER BY v.nome;

-- 3 
SELECT 
    COUNT(*),
    v.nome,
    p.data_participacao,
    e.nome_evento,
    SUM(c.experiencia) AS total
FROM
    voluntario v,
    participacao p,
    evento e,
    categoria c
WHERE
    v.admin <> 1 AND v.cod_voluntario = p.cod_voluntario
        AND e.cod_evento = p.cod_evento
        AND c.cod_categoria = e.cod_categoria
GROUP BY nome
HAVING total > 100
ORDER BY v.nome;


-- 4 
select count(1),month(data_inicio) from evento where data_inicio > (select min(data_inicio) from evento)  group by month(data_inicio);

-- 5
select * from evento e,participacao p where p.cod_evento=e.cod_evento and e.data_inicio > ( select min(data_inicio) from evento);

-- 6 
select * from evento where cod_categoria in ( select  cod_categoria from categoria where experiencia = (select max(experiencia) from categoria)) ;

-- 7 
select * from participacao where data_participacao = (select min(data_participacao) from participacao);

-- 8 
SELECT 
    COUNT(*) qtd_patentes,
    p.exp_necessaria,
    p.nome_patente,
    avg(v.experiencia)  as media_exp_voluntarios,
    sum(v.experiencia) as total_exp_voluntarios
FROM
    voluntario v,
    patente p
WHERE
    v.cod_patente = p.cod_patente
GROUP BY p.nome_patente;

-- 9
select * from voluntario where experiencia = ( select max(experiencia) from voluntario);

-- 10
SELECT 
    sum(experiencia),
    sexo,
    (SELECT 
            COUNT(*)
        FROM
            voluntario
        GROUP BY admin
        HAVING admin > 1) AS qtd_admin,
    (SELECT 
            COUNT(*)
        FROM
            voluntario
        GROUP BY ativo
        HAVING ativo = 1) AS qtd_ativo
FROM
    voluntario
GROUP BY sexo;


-- 5 exemplos do comando UPDATE, 3 deles devem estar combiados com a clÃ¡usula select

-- 1
update voluntario set experiencia = experiencia * 2;

-- 2
select * from voluntario ;
update voluntario set experiencia = 500 where cod_voluntario=5;

-- 3
update voluntario set cod_patente=(select cod_patente from patente where experiencia=exp_necessaria) where cod_voluntario = 5;
-- 4
update voluntario set ativo=0 where cod_voluntario in ( select cod_voluntario from participacao ) and sexo='F';

-- 5 
update categoria set experiencia = experiencia * 1.5 where  exists ( select * from evento e where e.cod_evento=cod_evento);

-- 5 exemplos do comando DELETE, 3 deles devem estar combinados com a clÃ¡usula select
-- 1
delete from voluntario where cod_patente = (select cod_patente from patente where nome_patente = "General");
-- 2
delete from patente where nome_patente = "General";
-- 3
delete
	from evento 
    where cod_categoria = (
		select cod_categoria 
        from categoria 
        where nome_categoria = "Campeonato"
        );
-- 4
delete
	from evento
    where experiencia = (
		select max(experiencia)
        from categoria
    );
-- 5
delete from participacao where cod_voluntario not in(select cod_voluntario from voluntario);

--  3 exemplos de INSERT + SELECT, 2 exemplos de CREATE+SELECT

-- 1
create table mVoluntario(
	select * from voluntario where sexo="m"
);

-- 2
create table oldEvento(
	select * from evento where data_fim <= "2017-06-15"
);

-- 3
insert into mVoluntario(
	select * from voluntario where Experiencia <= 3000
);

-- 4
insert into oldEvento(
	select * from evento where month(data_inicio) = 5
);

-- 5
insert into oldEvento(
	select * from evento where cod_evento = 2
);

-- 5 exemplos de tabelas temporÃ¡rias.
/*
CREATE TABLE Evento (
    descricao TEXT,
    data_inicio DATE,
    data_fim DATE,
    cod_evento INT AUTO_INCREMENT PRIMARY KEY,
    nome_evento VARCHAR(100),
    cod_categoria INT,
    cod_voluntario INT
);*/

create temporary table Ranking (
	posicao int auto_increment not null primary key,
	nome varchar(50) not null,
    experiencia int
);

insert into ranking (nome, experiencia) (
	SELECT   v.nome,
		SUM(c.experiencia) AS total
	FROM
		voluntario v,
		participacao p,
		evento e,
		categoria c
	WHERE
		v.admin <> 1 AND v.cod_voluntario = p.cod_voluntario
			AND e.cod_evento = p.cod_evento
			AND c.cod_categoria = e.cod_categoria
	GROUP BY nome
	HAVING total > 100
	ORDER BY total desc
);

SELECT   v.nome,
    SUM(c.experiencia) AS total
FROM
    voluntario v,
    participacao p,
    evento e,
    categoria c
WHERE
    v.admin <> 1 AND v.cod_voluntario = p.cod_voluntario
        AND e.cod_evento = p.cod_evento
        AND c.cod_categoria = e.cod_categoria
GROUP BY nome
HAVING total > 100
ORDER BY total desc;


SELECT count(1), nome from voluntario group by nome;

select * from ranking
