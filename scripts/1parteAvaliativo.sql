-- 1 PARTE CRICIA
use projeto;

select * from categoria;
select * from evento;
select * from participacao;
select * from patente;
select * from voluntario;


-- 1
SELECT 
    *
FROM
    evento e,
    categoria c
WHERE
    e.cod_categoria = c.cod_categoria
        AND c.experiencia > 50;
        
SELECT 
    *
FROM
    evento e,
    categoria c
WHERE
    e.cod_categoria = c.cod_categoria
        AND c.experiencia < 50;
-- 2
SELECT 
    *
FROM
    evento e,
    categoria c
WHERE
    e.cod_categoria = c.cod_categoria
        AND c.experiencia <= 100;
        
        
SELECT 
    *
FROM
    evento e,
    categoria c
WHERE
    e.cod_categoria = c.cod_categoria
        AND c.experiencia >= 100;
-- 3
SELECT 
    *
FROM
    evento e,
    categoria c
WHERE
    e.cod_categoria = c.cod_categoria
        AND e.data_inicio between '2017-05-01' and '2017-05-30';
-- 4
SELECT 
    *
FROM
    voluntario
WHERE
    email LIKE '%.com';

-- 5

SELECT 
    *
FROM
    patente
WHERE
    nome_patente IN ('Recruta' , 'Tenente', 'Cabo');

-- 6

SELECT 
    *
FROM
    categoria c
WHERE
    EXISTS( SELECT 
            *
        FROM
            evento
        WHERE
            c.cod_categoria = cod_categoria);
            
SELECT 
    *
FROM
    categoria c
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            evento
        WHERE
            c.cod_categoria = cod_categoria);


-- 7 
SELECT 
    e.*
FROM
    evento e,
    categoria c
WHERE
    c.cod_categoria = e.cod_categoria
        AND c.experiencia <> 100;
        