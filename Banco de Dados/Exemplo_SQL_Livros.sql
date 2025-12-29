create table autor (
   cod_autor  integer(3)  not null,
   nome       varchar(70) not null,
   nascimento date        not null,
 primary key(cod_autor),
 unique(nome, nascimento));
 
 create table editora(
	cod_editora integer(3) not null,
    razao       varchar(70),
    endereco    char(70),
    cidade      char(70),
primary key(cod_editora));

create table livro(
	titulo       char(70)    not null,
    cod_autor    integer(3)  not null,
    cod_editora  integer(3)  not null,
    valor        float(7,2),
    comentario   blob,
    publicacao   date,
    volume       integer(2),
 primary key (titulo, cod_autor)

);

alter table livro
add constraint livro_autor_fk foreign key(cod_autor) references autor(cod_autor);

alter table livro
add constraint livro_editora_fk foreign key(cod_editora) references editora(cod_editora)

/*adicionar email na tabela autor depois da coliuna nome*/

alter table autor
add
   email varchar(30) after nome;
   
alter table autor 
modify 
	nome varchar(75) not null;
    

create index indNome on
	autor (nome desc);
    
create index indCidadeRazao on
	editora (cidade, razao)

/*Comando DML*/

insert into autor
	(cod_autor, nome, nascimento)
values
	(1, 'Ramakrisham, R.', '1960-01-01'); 
    
select * from autor

insert into editora
	(cod_editora, razao, endereco, cidade)
values
	(1, 'McGraw', 'Av. Trab. São-Manuelense, 400', 'São  Manuel');
    
select * from editora

create table autor2(
	cod_autor  integer(3)  not null,
    nome       varchar(70) not null, 
    nascimento date        not null,
primary key(cod_autor),
unique (nome, nascimento)
);

alter table autor2
add column email varchar(70)
after nome


insert into autor2
select * from autor 
where nascimento < '1970-01-01';

select * from autor2
select * from autor

update editora
set	
	endereco = 'Av. São Carlos, 400',
    cidade   = 'São Carlos'
where 
	cod_editora = 1;
    
select * from editora

select * from livro

update livro
set valor = valor * 1.1
where titulo = 'Teste' and cod_autor = 1

insert into livro 
	(titulo, cod_autor, cod_editora, valor)
values
	('Teste', 1, 1, 100);
    

select nome, titulo
from autor, livro
where 
autor.cod_autor = livro.cod_autor;
    
/*Group by pág 11*/




