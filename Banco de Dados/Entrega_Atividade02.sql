Pedro Cristovão Atividade 02 entrega moodle

# Atividade 2

# Item 2

CREATE SCHEMA empresa;

USE empresa;

CREATE TABLE departamento(
	codigo INTEGER NOT NULL primary key, 
	nome VARCHAR(50)
);

CREATE TABLE funcionario(
	codigo INTEGER NOT NULL PRIMARY KEY,
	nome VARCHAR(100),
	qtd_dependentes INTEGER,
	salario DECIMAL(10,2),
	cargo VARCHAR(50),
	cod_departamento INTEGER,
	CONSTRAINT funcionario_departamento_fk FOREIGN KEY (cod_departamento) REFERENCES departamento (codigo)
);

# Item 3

INSERT INTO departamento
(codigo, nome)
VALUES
(1, 'Diretoria Comercial'),
(2, 'TI'),
(3, 'RH'),
(4, 'Suporte'),
(5, 'Diretoria Cobranca'),
(6, 'Marketing'),
(7, 'Administracao'),
(8, 'Assistencia Tecnica');

INSERT INTO funcionario
(codigo, nome, qtd_dependentes, salario, cargo, cod_departamento)
VALUES
(1, 'Joao Luiz', 3, 10000.00, 'Gerente', 1),
(2, 'Maria Silva', 1, 10000.00, 'Gerente', 5),
(3, 'Marcos Oliveira', 2, 3900.00, 'Analista JR', 2),
(4, 'Julia Prado', 0, 6500.00, 'Analista PL', 2),
(5, 'Roberto Lopes', 2, 10000.00, 'Analista SR', 2),
(6, 'Roberta Clara', 0, 6500.00, 'Analista PL', 2),
(7, 'Anderson Silva', 4, 1800.00, 'Tecnico Suporte JR', 4),
(8, 'Paulo Jose', 1, 2200.00, 'Tecnico Suporte PL', 4),
(9, 'Rui Silveira', 3, 4500.00, 'Tecnico Suporte SR', 4),
(10, 'Tais Alves', 2, 1800.00, 'Agente Cobranca JR', 5),
(11, 'Carlos Santos', 4, 1800.00, 'Agente Cobranca JR', 5),
(12, 'Mariana da Silva', 2, 2200.00, 'Agente Cobranca PL', 5),
(13, 'Augusta Maria', 3, 2200.00, 'Vendedor PL', 1),
(14, 'Alicia Pedroso', 0, 10000, 'Gerente', 1),
(15, 'Paulo Silveira', 0, 2200.00, 'Vendedor PL', 1),
(16, 'Consoelo do Prado', 2, 6000.00, 'Vendedor SR', 1),
(17, 'Airton Franca', 2, 1800.00, 'Tecnico Adm JR', 7),
(18, 'Lucia Colina', 0, 2200.00, 'Tecnico Adm PL', 7),
(19, 'Alfredo Luiz', 2, 2200.00, 'Tecnico Adm PL', 7),
(20, 'Pamela Bravo', 5, 1800.00, 'Tecnico Marketing JR', 6),
(21, 'Thiago Ruiz', 2, 10000, 'Gerente', 6),
(22, 'Caio Roberto', 0, 1800.00, 'Tec Eletronica JR', 8),
(23, 'Ana Maria', 0, 2500.00, 'Tec Eletronica PL', 8),
(24, 'Carlos Eduardo', 3, 2000.00, 'Tecnico RH JR', 8);


# Item 4 a 

CREATE view vw_maiorQtdFuncDepartamento AS
SELECT qtd_func_dpto.nome,
		 MAX(qtd_func_dpto.qtd_funcionarios)	
from (SELECT d.nome,
		 COUNT(*) AS qtd_funcionarios
FROM funcionario f
INNER JOIN departamento d ON (d.codigo = f.cod_departamento)
GROUP BY f.cod_departamento) AS qtd_func_dpto;

# Item 4 b 

CREATE VIEW vw_DepartamentoMenorQtdFuncSemDependentes as
SELECT d.nome AS nome_depto,
		 COUNT(*) AS qtd_func_sem_dep
FROM funcionario f
INNER JOIN departamento d ON (d.codigo = f.cod_departamento)
WHERE f.qtd_dependentes = 0
GROUP BY d.nome
HAVING qtd_func_sem_dep = 
(
	SELECT MIN(dpto_func_sem_dep.qtd_func) 
	FROM 
		(
			SELECT f.cod_departamento, COUNT(*) AS qtd_func
			FROM funcionario f
			WHERE f.qtd_dependentes = 0
			GROUP BY cod_departamento
		)AS dpto_func_sem_dep
);

# Item 4 c

CREATE VIEW vw_ListaFuncDeptoIniciaComDir as
SELECT 
	d.nome AS "departamento",
	f.nome AS "nome_funcionario"
FROM funcionario f
INNER JOIN departamento d ON (d.codigo = f.cod_departamento)
WHERE d.nome LIKE "Dir%"
ORDER BY d.nome, f.nome;

# Item 4 d 

CREATE VIEW vw_DptoComFuncMaiorSalario as
SELECT 
	d.nome AS "departamento",
	f.nome AS "funcionario",
	f.salario
FROM 
funcionario f
INNER JOIN departamento d ON (d.codigo = f.cod_departamento)
WHERE f.salario = 
(
	SELECT MAX(f.salario) FROM funcionario f
)
ORDER BY d.nome, f.nome;

# Item 4 e 

CREATE VIEW vw_GerentesPorDepartamento as
SELECT f.nome AS "nome_funcionario",
       d.nome AS "departamento"
FROM funcionario f
INNER JOIN departamento d ON (d.codigo = f.cod_departamento)
WHERE f.cargo LIKE "GERENTE%"
ORDER BY F.NOME;

# Item 5

#Gerente

SELECT * FROM mysql.`user`;

CREATE USER 'gerente'@'localhost' IDENTIFIED BY 'gerente';

GRANT ALL privileges ON empresa.* TO 'gerente'@'localhost';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'gerente'@'localhost';

#Funcionario

create USER 'funcionario'@'localhost' IDENTIFIED BY 'funcionario';

GRANT SELECT, INSERT ON empresa.* TO 'funcionario'@'localhost';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'funcionario'@'localhost';



