USE modulo03;

DROP TABLE IF EXISTS Entidad;
CREATE TABLE Entidad (
	clave INT NOT NULL,
	entidad VARCHAR(30) NOT NULL,
	poblacion BIGINT NOT NULL,
	PRIMARY KEY (clave)
);