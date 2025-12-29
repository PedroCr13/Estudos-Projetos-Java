create database exercicio2

use exercicio2

create table departamento(
    codigo int not null,
    nome varchar(100),
);

alter table departamento
add constraint departamento_pk primary key(codigo)

create table funcionario(
    codigo int not null,
    nome varchar(100),
    qtd_dependentes int,
    salario float,
    cargo varchar(50),
    departamento int,
);

alter table funcionario
add constraint funcionario_pk primary key(codigo)

alter table funcionario
add constraint funcionario_departamento_fk foreign key(departamento) references departamento(codigo)

insert into departamento values (1, 'Diretoria Comercial');
insert into departamento values (2, 'Marketing');
insert into departamento values (3, 'Desenvolvimento');

insert into funcionario values (1, 'Joao da Silva', 2, 1500.00, 'Vendedor', 1);
insert into funcionario values (2, 'Ruan Lopez', 1, 1800.50, 'Assist Compras',1);
insert into funcionario values (3, 'Maria Lucia', 3, 1500.00, 'Vendedor', 1);
insert into funcionario values (4, 'Marcos Roberto', 0, 700.00, 'estagiario', 1);
insert into funcionario values (5, 'Pedro Lopes', 2, 2500, 'Programador Jr', 3);
insert into funcionario values (6, 'Ana Claudia', 0, 2650, 'Programador Pl', 3);
insert into funcionario values (7, 'Mario Alves Ruiz', 1, 2500, 'Programador Jr',3);
insert into funcionario values (8, 'Rose Campos', 4, 6500.00, 'Gerente',3);
insert into funcionario values (9, 'Carlos Roberto', 3, 5600.00, 'Analista Jr',3);
insert into funcionario values (10, 'Joao da Silva', 2, 800.00, 'Estagio TI', 3);
insert into funcionario values (11, 'Mariana Braz', 3, 5800.00, 'Analista Pl', 3);
insert into funcionario values (12, 'Daniel Marcontes', 5, 3200, 'Programador Sr', 3);
insert into funcionario values (13, 'Debora Nascimento', 3, 3500, 'Analista Mkt Jr', 2);
insert into funcionario values (14, 'Carlos Miguel', 1, 1900, 'Assist Mkt Jr', 2);
insert into funcionario values (15, 'Marli Ana', 0, 1800, 'Aux. Cobranca', 1);
insert into funcionario values (16, 'Antonio Carlo', 0, 1200, 'Telefonista', 1);
insert into funcionario values (17, 'Carlo Antonio', 0, 6500, 'Gerente', 1);
insert into funcionario values (18, 'Maira Antonieta', 1, 6500, 'Gerente', 2);

/*Exercicio 1*/
select d.nome, count(f.departamento) as "qtd_funcionarios"
from funcionario f
inner join departamento d on (f.departamento = d.codigo)
group by f.departamento
having count(f.departamento) = (select max(tb1.qtd) from (select count(f.departamento) as "qtd"
from funcionario f

/*Exercicio 2*/
select d.nome, count(f.departamento) as "qtd_func_sem_dep"
from funcionario f
inner join departamento d on (f.departamento = d.codigo)
where f.qtd_dependentes = 0
group by f.departamento
having count(f.departamento) = (select min(tb_sem_dep.qtd_sem_dep) from (select count(f.departamento) as "qtd_sem_dep"
from funcionario f
where f.qtd_dependentes = 0
group by f.departamento) as tb_sem_dep)   

/*Exercicio 3*/
select d.nome, f.nome
from funcionario f
inner join departamento d on (f.departamento = d.codigo)
where d.nome like 'DIR%'
order by d.nome, f.nome

/*Exercicio 4*/
select f.nome, d.nome, f.salario as "salario"
from funcionario f
inner join departamento d on (f.departamento = d.codigo)
having f.salario = (select max(salario) from funcionario)
order by d.nome, f.nome

/*Exercicio 5*/
select d.nome, f.nome, f.cargo
from funcionario f
inner join departamento d on (f.departamento = d.codigo)
where f.cargo = 'Gerente'
order by d.nome, f.nome

/*Criação de Usuários*/
create user 'funcionario'@'localhost' identified by '123456';
grant SELECT on exercicio2.departamento to 'funcionario'@'localhost'; 
grant INSERT on exercicio2.departamento to 'funcionario'@'localhost';
grant SELECT on exercicio2.funcionario to 'funcionario'@'localhost';
grant INSERT on exercicio2.funcionario to 'funcionario'@'localhost';
flush privileges;

create user 'gerente'@'localhost' identified by '123456';
grant all privileges on exercicio2.* to 'gerente'@'localhost';
flush privileges;


