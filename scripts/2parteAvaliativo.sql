-- 5 Consultas com junção de Tabelas, utilizar condições 
-- 1
SELECT 
    e.*
FROM
    categoria c left join evento e on c.cod_categoria=e.cod_categoria
where  c.experiencia >= 100 ;
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
    p.exp_necessaria,
    p.cod_patente
FROM
    voluntario v,
    patente p
WHERE
    v.cod_patente = p.cod_patente 
    and v.experiencia >= 50 ;
    
-- 4 

select * from voluntario;
select * from participacao;

SELECT 
    v.nome, p.data_participacao
FROM
    voluntario v,
    participacao p
WHERE
    v.admin <> 1 AND v.ID = p.ID_voluntario;
    
-- 5 
SELECT 
    v.nome, p.data_participacao, e.nome_evento, c.experiencia
FROM
    voluntario v,
    participacao p,
    evento e,
    categoria c
WHERE
    v.admin <> 1 AND v.ID = p.ID_voluntario
        AND e.cod_evento = p.cod_evento
        AND c.cod_categoria = e.cod_categoria
ORDER BY v.nome;


-- )5 Consultas com operador IN /  5 representação das mesmas consultas da letra b com operador Exists

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
select * from  participacao where id_voluntario in ( select id from voluntario);
select * from  participacao where exists ( select id from voluntario where id_voluntario=id);

-- 5
select * from patente where cod_patente in ( select cod_patente from voluntario);
select * from patente p where not exists ( select cod_patente from voluntario where p.cod_patente= cod_patente);



-- 10 consultas utilizando funções agregadas, cláusula group by e having.


-- 1
select max(experiencia) from voluntario;
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
    v.admin <> 1 AND v.ID = p.ID_voluntario
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
    v.admin <> 1 AND v.ID = p.ID_voluntario
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


-- 5 exemplos do comando UPDATE, 3 deles devem estar combiados com a cláusula select

-- 1
update voluntario set experiencia = experiencia * 2;


-- 2
select * from voluntario ;
update voluntario set experiencia = 500 where id=5;

-- 3
update voluntario set cod_patente=(select cod_patente from patente where experiencia=exp_necessaria) where id = 5;
-- 4
update voluntario set ativo=0 where id in ( select id_voluntario from participacao ) and sexo='F';

-- 5 
update categoria set experiencia = experiencia * 1.5 where  exists ( select * from evento e where e.cod_evento=cod_evento);

-- 5 exemplos do comando DELETE, 3 deles devem estar combinados com a cláusula select
--  3 exemplos de INSERT + SELECT, 2 exemplos de CREATE+SELECT
-- 5 exemplos de tabelas temporárias.



