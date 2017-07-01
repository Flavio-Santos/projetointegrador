-- 	Retorna os participantes de um evento passando o codigo de um evento
SELECT 
	v.*
FROM
    voluntario v,
    participacao p,
    evento e
WHERE
  v.cod_voluntario = p.cod_voluntario
        AND e.cod_evento = p.cod_evento
        and e.cod_evento='1'-- codigo do evento
-- GROUP BY nome
ORDER BY v.nome;


-- Ranking 
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

select * from ranking  limit  3;


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
    limit 5;
    
    
    
		
    SELECT 
    'DESATIVADO',e.*
FROM
    evento e
WHERE
    DATE_FORMAT(e.data_fim, '%y-%m-%d') >= DATE_FORMAT('17-06-30', '%y-%m-%d')
    
  UNION  
    
     SELECT 
    'ATIVADO',x.*
FROM
    evento x
WHERE
    DATE_FORMAT(x.data_fim, '%y-%m-%d') <= DATE_FORMAT('17-06-30', '%y-%m-%d');
    
    
    
    
    
    
    SELECT date_format(SYSDATE(),'%y-%m-%d') FROM DUAL;
