-- Pedro Cristovão BD Atividade 01 Moodle

# Questão 01

SELECT c.nome_cantor, 
       count(g.cod_gravacao) AS num_gravacoes 
FROM gravacao g
INNER JOIN cantor c ON (c.cod_cantor = g.cod_cantor)
GROUP BY c.nome_cantor
having count(g.cod_gravacao) = 
(
	SELECT MIN(tg.total_grav) FROM (SELECT count(g.cod_cantor) AS total_grav 
FROM gravacao g GROUP BY g.cod_cantor) AS tg
);

# Questão 02

SELECT c.nome_cantor, 
       COUNT(DISTINCT G.COD_GRAVADORA) AS NUM_GRAVADORAS
FROM gravacao G
INNER JOIN cantor c ON (c.cod_cantor = g.cod_cantor) 
GROUP BY g.COD_CANTOR
HAVING NUM_GRAVADORAS = (
		SELECT MAX(total_grav.num_gravadoras) FROM 
			(SELECT c.nome_cantor, 
	       COUNT(DISTINCT G.COD_GRAVADORA) AS NUM_GRAVADORAS
			FROM gravacao G
			INNER JOIN cantor c ON (c.cod_cantor = g.cod_cantor) 
			GROUP BY g.COD_CANTOR
		) AS total_grav
)
ORDER BY c.nome_cantor;

# Questão 03

SELECT c.nome_cantor, 
       avg(m.duracao) AS media_duracao 
FROM gravacao g
INNER JOIN cantor C ON (C.cod_cantor = g.cod_cantor)
INNER JOIN musica m ON (m.cod_musica = g.cod_musica)
GROUP BY c.nome_cantor
HAVING media_duracao = (
	SELECT MAX(medias.media_cantor) FROM (SELECT avg(m.duracao) AS media_cantor
	FROM gravacao g
	INNER JOIN musica m ON (m.cod_musica = g.cod_musica)
	GROUP BY g.cod_cantor) AS medias
);

# Questão 04

SELECT C.NOME_CANTOR
FROM cantor C
WHERE C.COD_CANTOR not in
(
	SELECT G.COD_CANTOR
	FROM GRAVACAO G
	INNER JOIN gravadora gva ON (gva.cod_gravadora = g.cod_gravadora)
	AND gva.nome_gravadora LIKE "Sony%"
	GROUP BY G.cod_cantor
)

# Questão 05

SELECT c.nome_cantor AS "cantor", 
       m.titulo AS "musica",
       g.data_gravacao 
FROM gravacao G
INNER JOIN musica M ON (m.cod_musica = g.cod_musica)
INNER JOIN cantor c ON (c.cod_cantor = g.cod_cantor)
WHERE  extract(year from data_gravacao) = 2004;

# Questão 06


SELECT c.nome_cantor,
       max(g.data_gravacao) 
FROM gravacao G
INNER JOIN musica M ON (m.cod_musica = g.cod_musica)
right JOIN cantor c ON (c.cod_cantor = g.cod_cantor)
GROUP BY c.nome_cantor
order by g.data_gravacao DESC

# Questão 07

SELECT p.nome_pessoa, 
      res.numero AS "fone_residencial",
      com.numero AS "fone_comercial",
      cel.numero AS "fone_celular"
FROM pessoa p
inner JOIN (SELECT 
        f.cod_pessoa,
		  f.numero
FROM fone f
WHERE f.tipo = 'L') AS cel ON (cel.cod_pessoa = p.cod_pessoa)
INNER JOIN (SELECT 
        f.cod_pessoa,
		  f.numero
FROM fone f
WHERE f.tipo = 'R') AS res ON (res.cod_pessoa = p.cod_pessoa)
INNER JOIN (SELECT 
        f.cod_pessoa,
		  f.numero
FROM fone f
WHERE f.tipo = 'C') AS com ON (com.cod_pessoa = p.cod_pessoa)

