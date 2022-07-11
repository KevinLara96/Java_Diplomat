DROP TABLE IF EXISTS Friends;
DROP TABLE IF EXISTS BigBangTheory;
DROP TABLE IF EXISTS LocosAddams;

CREATE TABLE Friends (
	consecutivo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,   
	nombre VARCHAR(50) NOT NULL,
	profesion VARCHAR(50) NOT NULL,
	sexo CHAR(1) NOT NULL DEFAULT ('F'),
	tipoRol VARCHAR(50) NOT NULL DEFAULT 'Protagonista',
	actor VARCHAR(50) NOT NULL
);

CREATE TABLE BigBangTheory (
	id INT NOT NULL PRIMARY KEY,
	personaje VARCHAR(50) NOT NULL,
	profesion VARCHAR(50) NOT NULL,
	sexo CHAR(1) NOT NULL DEFAULT ('M'),
	temporadaAparicion SMALLINT NOT NULL DEFAULT 1,
	tipoRol VARCHAR(50) NOT NULL DEFAULT 'Protagonista'
);

INSERT INTO Friends (nombre,profesion,actor) VALUES ('Rachel Green','Moda','Jennifer Aniston'), 
	('Monica Geller','Chef','Courteney Cox'),('Phoebe Buffay','Cantante, Masajista', 'Lisa Kudrow');
INSERT INTO Friends (sexo,nombre,profesion,actor) VALUES ('M','Joey Tribbiani','Actor','Matt LeBlanc'),
	('M','Chandler Bing','Analista de datos','Matthew Perry'),('M','Ross Geller','Paleontólogo','David Schwimmer');
INSERT INTO Friends (tipoRol,sexo,nombre,profesion,actor) VALUES ('Secundario','F','Janice Goralnik','Desconocido','Maggie Wheeler'),
	('Secundario','M','Gunther ','Dueño de Café','James Michael Tyler'),('Secundario','F','Ursula Buffay','Actriz','Lisa Kudrow'),
	('Secundario','M','Richard Burke','Oftalmólogo','Tom Selleck'),('Invitado','M','Will Colbert','Desconocida','Brad Pitt');

INSERT INTO BigBangTheory (id,personaje,profesion,sexo,temporadaAparicion) 
	VALUES (2,'Leonard Hofstadter','Físico experimental','M',1), 	(1,'Sheldon Cooper','Físico teórico','M',1),
	(3,'Raj Koothrappali','Astrofísico','M',1), 	(4,'Howard Wolowitz','Astronauta','M',1),
	(11,'Penny','Actriz','F',1), (12,'Bernadette Rostenkowski','Microbióloga','F',3),
	(13,'Amy Farrah Fowler','Neurobióloga','F',3);
	
INSERT INTO BigBangTheory (id,personaje,profesion,sexo,temporadaAparicion, tipoRol) 
	VALUES (101, 'Stuart Bloom', 'Dueño de tienda de Comics', 'M', 2, 'Secundario'), 
		(102, 'Barry Kripke', 'Físico', 'M', 2, 'Secundario'),
		(103, 'Wil Wheaton', 'Actor', 'M', 3, 'Secundario'),(104, 'Stephen Hawking', 'Stephen Hawking', 'M', 3, 'Invitado');

	
CREATE TABLE LocosAddams (
	id INT NOT NULL PRIMARY KEY,
	personaje VARCHAR(50) NOT NULL,
	sexo CHAR(1) NOT NULL DEFAULT ('M'),
	tipoRol VARCHAR(50) NOT NULL DEFAULT 'Protagonista'
);
INSERT INTO LocosAddams VALUES (10, 'Homero Addams', 'M', 'Protagonista'),
	(20, 'Morticia Addams', 'F', 'Protagonista'), (30, 'Tío Lucas', 'M', 'Protagonista'),
	(110, 'Pericles', 'M', 'Secundario'), (120, 'Merlina', 'F', 'Secundario'),
	(130, 'Abuela Addams', 'F', 'Secundario'),(140, 'Largo', 'M', 'Secundario'),
	(150, 'Dedos', 'X', 'Secundario'), (160, 'Herman Munster', 'M', 'Protagonista');

drop table if exists localidades;
drop table if exists municipios;
drop table if exists estados;

CREATE TABLE estados (
  id int NOT NULL,
  clave varchar(2) NOT NULL,
  nombre varchar(45) NOT NULL,
  abrev varchar(16) NOT NULL,
  fabrica tinyint NOT NULL DEFAULT '1',
  clientes INT NOT NULL,
  CONSTRAINT pk_estados PRIMARY KEY (id)
) ;

INSERT INTO estados (id, clave, nombre, abrev, fabrica, clientes) VALUES
(1, '01', 'Aguascalientes', 'Ags.', 1,23051),
(2, '02', 'Baja California', 'BC', 0,44803),
(3, '03', 'Baja California Sur', 'BCS', 1,26357),
(4, '04', 'Campeche', 'Camp.', 1,8479),
(5, '05', 'Coahuila de Zaragoza', 'Coah.', 1,64655),
(6, '06', 'Colima', 'Col.', 1,10334),
(7, '07', 'Chiapas', 'Chis.', 1,9986),
(8, '08', 'Chihuahua', 'Chih.', 0,43189),
(9, '09', 'Ciudad de México', 'CDMX', 1,557085),
(10, '10', 'Durango', 'Dgo.', 1,30793),
(11, '11', 'Guanajuato', 'Gto.', 1,119084),
(12, '12', 'Guerrero', 'Gro.', 1,35240),
(13, '13', 'Hidalgo', 'Hgo.', 0,34496),
(14, '14', 'Jalisco', 'Jal.', 1,78064),
(15, '15', 'México', 'Mex.', 1,216881),
(16, '16', 'Michoacán de Ocampo', 'Mich.', 1,42959),
(17, '17', 'Morelos', 'Mor.', 0,26447),
(18, '18', 'Nayarit', 'Nay.', 1,10826),
(19, '19', 'Nuevo León', 'NL', 1,115101),
(20, '20', 'Oaxaca', 'Oax.', 1,40613),
(21, '21', 'Puebla', 'Pue.', 0,71036),
(22, '22', 'Querétaro', 'Qro.', 1,57024),
(23, '23', 'Quintana Roo', 'Q. Roo', 1,20095),
(24, '24', 'San Luis Potosí', 'SLP', 1,57121),
(25, '25', 'Sinaloa', 'Sin.', 1,33912),
(26, '26', 'Sonora', 'Son.', 1,67632),
(27, '27', 'Tabasco', 'Tab.', 1,57334),
(28, '28', 'Tamaulipas', 'Tamps.', 0,51572),
(29, '29', 'Tlaxcala', 'Tlax.', 1,17197),
(30, '30', 'Veracruz de Ignacio de la Llave', 'Ver.', 1,55013),
(31, '31', 'Yucatán', 'Yuc.', 1,32584),
(32, '32', 'Zacatecas', 'Zac.', 0,27424);


SELECT * FROM estados;
SELECT * FROM Friends;
SELECT * FROM BigBangTheory;
SELECT * FROM LocosAddams;

DESC friends;

INSERT INTO friends VALUES(12, 'Paul Stevens',  'Actor', 'M', 'Secundario', 'Bruce Willis');
UPDATE friends SET profesion='Camarera' WHERE nombre = 'Ursula Buffay';

UPDATE bigbangtheory SET profesion = 'Físico' WHERE profesion = 'Stephen Hawking';

DELETE FROM LocosAddams WHERE personaje = 'Herman Munster';



SELECT nombre FROM estados
WHERE fabrica = 1;

SELECT sexo, COUNT(sexo)
FROM friends 
GROUP BY sexo;

SELECT sexo, COUNT(sexo)
FROM LocosAddams 
GROUP BY sexo;

SELECT sexo, COUNT(sexo)
FROM BigBangTheory 
GROUP BY sexo;


SELECT nombre, clientes
FROM estados
ORDER BY clientes DESC;


show TABLES;

SELECT * FROM estados;