CREATE TABLE cursos_utf(
	cod_curso serial PRIMARY KEY,
	univ varchar(50) NOT NULL,
	curso varchar(30) DEFAULT 'Java',
	inicio date DEFAULT '2007-01-01',
	incritos integer DEFAULT 0
);

CREATE TABLE cursos(
	cod_curso integer,
	univ varchar(50) NOT NULL,
	curso varchar(30),
	inicio date DEFAULT '2009-01-01',
	incritos integer DEFAULT 0,
	CONSTRAINT cursos_pk PRIMARY KEY(cod_curso)
);

ALTER TABLE alunos
ADD CONSTRAINT alunos_cod_curso_fk FOREIGN KEY(cod_curso) REFERENCES cursos

CREATE TABLE mensalidades(
	cod integer,
	nome_aluno varchar(30),
	valor numeric(9, 2)
);

ALTER TABLE mensalidades
	ADD CONSTRAINT mensalidades_cod_pk PRIMARY KEY(cod);
	
INSERT INTO cursos_utf
VALUES (DEFAULT, DEFAULT, 'Pedagogia', '2007-08-01', DEFAULT);

INSERT INTO cursos_utf
VALUES (DEFAULT, DEFAULT, 'Pedagogia', '2007-08-01', DEFAULT);

INSERT INTO cursos_utf DEFAULT VALUES

INSERT INTO cursos_utf(curso, inicio, inscritos)
VALUES ('Redes', '2010-08-01', 5);	

INSERT INTO cursos 
	SELECT * FROM cursos_utf WHERE inicio < CURRENT_DATE;
	
INSERT INTO cursos VALUES (5, 'UEL', 'Web', '2009-03-05', 25);
INSERT INTO alunos VALUES (11596, 2, 'Reinaldo Costa', DEFAULT);
	
UPDATE cursos_utf SET inscritos = 0 WHERE inscritos < 10;
UPDATE cursos SET inicio = DEFAULT WHERE univ = 'UTFPR';

UPDATE cursos SET inicio = '2009-03-06', inscritos = DEFAULT WHERE univ = 'UTFPR' and curso = 'JAVA'.

INSERT INTO alunos VALUES ('11597', 2, 'João Da Silva', 'Inativo');
INSERT INTO alunos VALUES ('11598', 1, 'Paulo Lima', 'Regular');

DELETE FROM alunos WHERE situacao = 'Inativo';

DELETE FROM alunos USING cursos
WHERE alunos.cod_curso = cursos.cod_curso AND cursos.curso = 'Java';

DELETE FROM alunos WHERE cod_curso IN
	(SELECT cod_curso FROM cursos WHERE curso = 'Java');
	
	
	
INSERT INTO cursos VALUES (5, 'UTFPR', 'Automação', '2007-07-15', 22);

INSERT INTO cursos VALUES (6, 'UTFPR', 'Gestão', '2008-03-01', 18);

SELECT univ, curso, (inscritos * 375) as ARRECADACAO
FROM cursos

SELECT * FROM cursos 
WHERE univ <> 'UTFPR' and inscritos > 15

SELECT * FROM cursos
WHERE univ = 'UTFPR' and inscritos > 15
ORDER BY inscritos

SELECT DISTINCT univ from cursos ORDER BY univ

select univ, cursos from cursos
where inscritos = (select max(inscritos) from cursos)

select univ, sum(inscritos) from cursos
group by univ

select univ, sum(inscritos)
from cursos
group by univ
having sum(inscritos)>30

insert into alunos values ('11596', 2,'Reinaldo Costa', DEFAULT);
insert into alunos values ('11597', 2,'João da Silva', 'Inativo');
insert into alunos values ('11598', 1, 'Paulo Lima', 'Regular');

select * from alunos

INSERT INTO mensalidades VALUES(1,'Paulo Lima',300.00);
INSERT INTO mensalidades VALUES(2,'Paulo Lima',300.00);
INSERT INTO mensalidades VALUES(3,'João Silva',290.00);

select distinct(nome) from alunos
where nome not in (select nome_aluno from mensalidades)

select distinct(nome_aluno) from mensalidades
where valor in ('300', '250')

select * from cursos
where cod_curso in (select cod_curso from alunos)

select * from alunos
select * from mensalidades

select a.nome, a.num_matricula,
	   m.cod, m.valor
from alunos a inner join mensalidades m
on a.nome = m.nome_aluno
order by a.nome

select * from cursos
select * from alunos

select c.cod_curso, c.curso, 
       a.nome
from cursos c inner join alunos a
on c.cod_curso = a.cod_curso
order by c.cod_curso

select cursos.cod_curso, cursos.curso, alunos.nome
from cursos inner join alunos
using (cod_curso)

select cursos.cod_curso, cursos.curso, alunos.nome
from cursos natural inner join alunos
--on cursos.cod_curso = alunos.cod_curso

select alunos.num_matricula, alunos.nome, 
mensalidades.cod, mensalidades.valor
from alunos left join mensalidades
on alunos.nome = mensalidades.nome_aluno
order by alunos.nome

select cursos.univ, cursos.curso, count(alunos.cod_curso) as matriculados
from cursos inner join alunos
on cursos.cod_curso = alunos.cod_curso
group by cursos.cod_curso, cursos.univ, cursos.curso
having count(alunos.num_matricula) = 
(select max(matriculas.total)
from (select count(num_matricula) as total
from alunos group by cod_curso)as matriculas);

SELECT cursos.univ as universidade, cursos.curso,
count(alunos.num_matricula) as alunos_matriculados
FROM cursos,alunos
WHERE cursos.cod_curso = alunos.cod_curso -- Pode usar JOIN
GROUP BY cursos.cod_curso,cursos.univ,cursos.curso
HAVING count(alunos.num_matricula)=
(SELECT max(matriculas.total)
FROM(SELECT count(num_matricula) as total
FROM alunos
GROUP BY cod_curso) as matriculas);


select alunos.num_matricula, alunos.nome, 
mensalidades.cod, mensalidades.valor
from alunos left join mensalidades
on alunos.nome = mensalidades.nome_aluno
order by alunos.nome

select * from cursos

select * from alunos

select cursos.cod_curso, cursos.curso, alunos.nome
from cursos left join alunos

select cursos.cod_curso, cursos.curso, alunos.nome
from cursos left join alunos
on cursos.cod_curso = alunos.cod_curso 
and cursos.curso = 'Java'
order by cod_curso

insert into mensalidades values (4, 'Luciana', 310.00);

select * from mensalidades

select alunos.num_matricula, alunos.nome, 
	   mensalidades.cod, mensalidades.valor
from alunos right join mensalidades
on alunos.nome = mensalidades.nome_aluno
order by mensalidades.cod

select alunos.num_matricula, mensalidades.nome_aluno, 
mensalidades.valor
from alunos right join mensalidades
on alunos.nome = mensalidades.nome_aluno

select alunos.num_matricula, alunos.nome, 
mensalidades.nome_aluno, mensalidades.valor
from alunos FULL JOIN mensalidades
on alunos.nome = mensalidades.nome_aluno

select * from cursos_utf 
where inicio < current_date

select age('2015-09-15', cursos_utf.inicio) as duracao_total
from cursos_utf
where cursos_utf.cod_curso = '2'

select age(cursos_utf.inicio) as prazo_decorrido
from cursos_utf
where cursos_utf.cod_curso = '2'

select cursos_utf.univ, cursos_utf.curso, 
date_part('day', cursos_utf.inicio)||'/'||date_part('month', cursos_utf.inicio) as data_curso
from cursos_utf
where date_part('year', inicio) = '2007';

select cursos_utf.univ, cursos_utf.curso, to_char(cursos_utf.inicio, 'mm/yyyy')
from cursos_utf
where to_char(cursos_utf.inicio, 'yyyy') = '2007';

update cursos_utf 
set inicio = to_date('01/03/2009', 'dd/mm/yyyy')
where cod_curso = '1';

select * from cursos_utf

--Script (preparação):
DELETE FROM alunos; DELETE FROM cursos;
INSERT INTO cursos VALUES(1,'UEL','Web','2009-01-01',20);
INSERT INTO cursos VALUES(2,'UTFPR','Java','2009-03-01',25);
INSERT INTO cursos VALUES(3,'UTFPR','Java','2010-03-06',18);
INSERT INTO cursos VALUES(4,'UEL','Web','2007-02-01',22);
INSERT INTO cursos VALUES(5,'UFPR','Redes','2007-03-10',30);
INSERT INTO cursos VALUES(6,'UFPR','Redes','2009-07-01',25);
INSERT INTO alunos VALUES('156111',1,'João Lima','Inativo');
INSERT INTO alunos VALUES('156123',3,'Eduardo Marques','Regular');
INSERT INTO alunos VALUES('156124',3,'Lauro Rodrigues','Regular');
INSERT INTO alunos VALUES('156128',3,'Maria Soares','Regular');
INSERT INTO alunos VALUES('156131',4,'Heloisa Pires','Inativo');
INSERT INTO alunos VALUES('156133',4,'Ana Pereira','Regular');
INSERT INTO alunos VALUES('156134',5,'Mario Borges','Inativo');
INSERT INTO alunos VALUES('156137',6,'Beatriz Nunes','Regular');
INSERT INTO alunos VALUES('156138',5,'Luciana Vieira','Inativo');
INSERT INTO alunos VALUES('157123',5,'José Cardoso','Regular');
INSERT INTO alunos VALUES('157134',1,'Catarina Brito','Regular');
INSERT INTO alunos VALUES('157135',2,'Denise Braga','Regular');

select * from alunos
select * from cursos

select cursos.univ, cursos.curso, count(alunos.cod_curso) as total_inscritos
from cursos inner join alunos
on cursos.cod_curso = alunos.cod_curso
where alunos.situacao = 'Regular'
group by cursos.univ, cursos.curso

select * from alunos


select cursos.univ, cursos.curso, count(alunos.cod_curso) as matriculados
from cursos inner join alunos
on cursos.cod_curso = alunos.cod_curso
group by cursos.cod_curso, cursos.univ, cursos.curso
having count(alunos.num_matricula) = 
(select max(matriculas.total)
from (select count(num_matricula) as total
from alunos group by cod_curso)as matriculas);

SELECT cursos.univ as universidade, cursos.curso,
count(alunos.num_matricula) as alunos_matriculados
FROM cursos,alunos
WHERE cursos.cod_curso = alunos.cod_curso -- Pode usar JOIN
GROUP BY cursos.cod_curso,cursos.univ,cursos.curso
HAVING count(alunos.num_matricula)=
(SELECT max(matriculas.total)
FROM(SELECT count(num_matricula) as total
FROM alunos
GROUP BY cod_curso) as matriculas);
 


select max(matriculas.total) as total 
from (select count(num_matricula) as total from alunos group by cod_curso) as matriculas

select count(num_matricula) as total from alunos group by cod_curso

SELECT CURSOS.UNIV, CURSOS.CURSO, COUNT(ALUNOS.NUM_MATRICULA) as qtd_inativos
FROM CURSOS INNER JOIN ALUNOS
ON CURSOS.COD_CURSO = ALUNOS.COD_CURSO
WHERE ALUNOS.SITUACAO = 'Inativo'
GROUP BY CURSOS.COD_CURSO, CURSOS.UNIV, CURSOS.CURSO
HAVING COUNT(ALUNOS.NUM_MATRICULA) =  
(SELECT MAX(MATRICULAS.T_INATIVOS) FROM (SELECT COD_CURSO, COUNT(NUM_MATRICULA) AS T_INATIVOS FROM 
ALUNOS WHERE SITUACAO = 'Inativo' GROUP BY COD_CURSO) AS MATRICULAS)

SELECT COUNT(NUM_MATRICULA) AS T_INATIVOS FROM 
ALUNOS WHERE SITUACAO = 'Inativo' GROUP BY COD_CURSO

SELECT MAX(MATRICULAS.T_INATIVOS) FROM (SELECT COD_CURSO, COUNT(NUM_MATRICULA) AS T_INATIVOS FROM 
ALUNOS WHERE SITUACAO = 'Inativo' GROUP BY COD_CURSO) AS MATRICULAS


SELECT * FROM CURSOS
ORDER BY COD_CURSO

SELECT CURSOS.UNIV AS UNIVERSIDADE, CURSOS.CURSO, ALUNOS.NOME
FROM CURSOS INNER JOIN ALUNOS
USING (COD_CURSO)
WHERE DATE_PART('YEAR', CURSOS.INICIO) = '2007'


