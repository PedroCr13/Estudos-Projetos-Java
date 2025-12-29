--Exercicio 1  Aula Banco de Dados:
--Pedro Cristovao 

1)
select cantor.nome_cantor, count(gravacao.cod_gravacao)
from gravacao inner join cantor
using (cod_cantor)
group by cantor.cod_cantor, cantor.nome_cantor
having count(gravacao.cod_cantor) = 
(select min(total_grav.total) from
(select count(g.cod_cantor) as total 
 from gravacao g group by g.cod_cantor) as total_grav)

2)
select c.nome_cantor, count(tab1.cod_gravadora) as qtd_distinta 
from (select g1.cod_cantor, g1.cod_gravadora from gravacao g1 
	 group by g1.cod_cantor, g1.cod_gravadora) as tab1 
inner join cantor c
using(cod_cantor)
group by c.nome_cantor
having count(tab1.cod_gravadora) = (select max(qtd_grav_cantor.total_por_cantor) from
   (select count(qtd_distintas.cod_cantor) as total_por_cantor from 
	   (select g.cod_gravadora, g.cod_cantor from gravacao g
        group by g.cod_cantor, g.cod_gravadora) as qtd_distintas
group by qtd_distintas.cod_cantor) as qtd_grav_cantor)

3)
select g.cod_cantor, c.nome_cantor, avg(m.duracao)
	 from gravacao g inner join musica m
     using(cod_musica)
     inner join cantor c
     using(cod_cantor)
     group by g.cod_cantor, c.nome_cantor
having avg(m.duracao) = (select max(medias.media) from (select avg(m.duracao) as media
	 from gravacao g inner join musica m
     using(cod_musica)
     group by g.cod_cantor) as medias)

4)
select c.nome_cantor
from gravacao gv 
inner join cantor c
using (cod_cantor)
inner join gravadora g
using(cod_gravadora)
group by gv.cod_cantor, c.nome_cantor
having cod_cantor not in 
(select distinct(cod_cantor) as cantor from gravacao
 inner join gravadora using (cod_gravadora)
where nome_gravadora = 'Sony')
order by c.nome_cantor

5)
select c.nome_cantor, m.titulo, g.data_gravacao 
from gravacao g
inner join cantor c
using(cod_cantor)
inner join musica m
using (cod_musica)
where date_part('year', g.data_gravacao) = 2004

6)
select max(g.data_gravacao) as data_ultima_gravacao, c.nome_cantor 
from gravacao g right join cantor c
using (cod_cantor)
group by c.nome_cantor
order by data_ultima_gravacao desc

7)
select p.nome_pessoa, r.fone_residencial, c.fone_comercial, l.celular from pessoa p
inner join (select numero as fone_residencial, cod_pessoa from fone where tipo = 'R') as r
on p.cod_pessoa = r.cod_pessoa
inner join (select numero as fone_comercial, cod_pessoa from fone where tipo = 'C') as c
on p.cod_pessoa = c.cod_pessoa
inner join (select numero as celular, cod_pessoa from fone where tipo = 'L') as l
on p.cod_pessoa = l.cod_pessoa


