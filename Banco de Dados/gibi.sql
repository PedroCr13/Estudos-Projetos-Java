CREATE DATABASE gibis;
USE gibis;

CREATE TABLE universo (
  cod_universo INTEGER NOT NULL AUTO_INCREMENT,
  nome_universo VARCHAR(50),
  CONSTRAINT universo_pkey PRIMARY KEY (cod_universo)
);

CREATE TABLE heroi (
  cod_heroi INTEGER NOT NULL AUTO_INCREMENT,
  cod_universo INTEGER NOT NULL,
  nome_heroi VARCHAR(70),
  qtde_poder INTEGER,
  fortuna FLOAT,
  codinome VARCHAR(50),
  CONSTRAINT heroi_pkey PRIMARY KEY (cod_heroi),
  CONSTRAINT heroi_cod_universo_fkey FOREIGN KEY (cod_universo) REFERENCES universo (cod_universo)
);

INSERT INTO universo (cod_universo, nome_universo) VALUES
	(1, 'DC'),
	(2, 'Marvel');

INSERT INTO heroi (cod_heroi, cod_universo, nome_heroi, qtde_poder, fortuna, codinome) VALUES
	(1, 1, 'Bruce Wayne', 0, 50000, 'Batman'),
	(2, 1, 'Clark Kent', 10, 50000, 'Super Man'),
	(3, 2, 'Tony Stark', 0, 50000, 'Homem de Ferro'),
	(4, 2, 'Steve Rogers', 3, 50000, 'Capitão América'),
	(5, 1, 'John Stewart', 3, 15000, 'Lanterna Verde'),
	(6, 2, 'James Howlett', 5, 6000, 'Wolverine'),
	(7, 2, 'Natasha Romanoff', 0, 6000, 'Viúva Negra'),
	(8, 1, 'Diana Prince', 5, 6000, 'Mulher Maravilha'),
	(9, 1, 'Hal Jordan', 3, 5000, 'Lanterna Verde'),
	(10, 1, 'Guy Gardner', 3, 4500, 'Lanterna Verde'),
	(11, 1, 'Kyle Rayner', 3, 3500, 'Lanterna Verde'),
	(12, 2, 'Johnny Blaze', 3, 5000, 'Motoqueiro Fantasma'),
	(13, 2, 'Hank Pym', 2, 4000, 'Homem Formiga'),
	(14, 2, 'Scott Lang', 2, 3000, 'Homem-Formiga'),
	(15, 2, 'Peter Parker', 3, 1400, 'Homem Aranha'),
	(16, 2, 'Clint Barton', 0, 5900, 'Gavião Arqueiro'),
	(17, 2, 'Susan Storm', 2, 5900, 'Mulher Invisível'),
	(18, 2, 'Johnny Storm', 2, 5900, 'Tocha Humana'),
	(19, 2, 'Frank Castle', 0, 3500, 'Justiceiro'),
	(20, 2, 'Ben Grimm', 2, 3500, 'Coisa'),
	(21, 2, 'Reed Richards', 2, 3000, 'Senhor Fantástico'),
	(22, 2, 'Bruce Banner', 6, 3000, 'Hulk'),
	(23, 1, 'Billy Batson', 5, 2500, 'Shazam'),
	(24, 1, 'Oliver Queen', 0, 2500, 'Arqueiro Verde'),
	(25, 1, 'Jason Todd', 0, 2500, 'Capuz Vermelho'),
	(26, 1, 'Tim Drake', 0, 2500, 'Robin'),
	(27, 1, 'Damian Wayne', 0, 1500, 'Robin');
