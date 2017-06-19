
select * from evento;
select * from voluntario;
select * from Patente where cod_patente=1;
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
            
            
            
            
            
select * from voluntario where ID = (select ID from voluntario where Login="Ariel" and Senha="123");



alter table voluntario add index  ID (ID);



create index senha on voluntario(senha) using HASH;

-- where Login=? and Senha=?;
            
            
desc usuario;