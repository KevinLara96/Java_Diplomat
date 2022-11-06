SET NAMES 'UTF8MB4';
DROP DATABASE IF EXISTS dgtic;
CREATE DATABASE IF NOT EXISTS dgtic DEFAULT CHARACTER SET UTF8MB4;
USE dgtic;

CREATE TABLE estudiantes(
cuenta_etd 					VARCHAR(3) NOT NULL ,
nombre					VARCHAR(40) NOT NULL,
edad					INTEGER NOT NULL,
PRIMARY KEY(cuenta_etd),
CONSTRAINT verificar_cuenta CHECK (REGEXP_LIKE(cuenta_etd,'[a-z]{1}[0-9]{2}'))
)DEFAULT CHARACTER SET UTF8MB4;

CREATE TABLE materias(
id_mtr					INTEGER NOT NULL AUTO_INCREMENT,
nombre					VARCHAR(40) NOT NULL,
creditos					INTEGER NOT NULL,
PRIMARY KEY(id_mtr)
)DEFAULT CHARACTER SET UTF8MB4;

CREATE TABLE estudiante_materia(
cuenta_etd					VARCHAR(3) NOT NULL ,
id_mtr					INTEGER NOT NULL,
PRIMARY KEY(cuenta_etd,id_mtr),
FOREIGN KEY(cuenta_etd) REFERENCES estudiantes(cuenta_etd) ON DELETE CASCADE,
FOREIGN KEY(id_mtr) REFERENCES materias(id_mtr) 
)DEFAULT CHARACTER SET UTF8MB4;

CREATE TABLE usuarios(
usuario_usa 				VARCHAR(10) NOT NULL ,
clave				VARCHAR(20) NOT NULL,
alta				INT(2)  NOT NULL,
PRIMARY KEY(usuario_usa)
)DEFAULT CHARACTER SET UTF8MB4;

CREATE TABLE autorizacion(
usuario_usa 				VARCHAR(10) NOT NULL ,
rol				VARCHAR(5) NOT NULL CHECK (rol IN ('admin','user')),
PRIMARY KEY(usuario_usa),
FOREIGN KEY(usuario_usa) REFERENCES usuarios(usuario_usa) ON DELETE CASCADE
)DEFAULT CHARACTER SET UTF8MB4;


