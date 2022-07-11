DROP DATABASE if EXISTS modulo03;
CREATE DATABASE modulo03;
USE modulo03;
DROP TABLE if EXISTS Empleado;
DROP TABLE if EXISTS Puesto;
DROP TABLE if EXISTS Administrador;
DROP TABLE if EXISTS Conductor_Autobus;
DROP TABLE if EXISTS Conductor;
DROP TABLE if EXISTS Viaje;
DROP TABLE if EXISTS Autobus;
DROP TABLE if EXISTS Tipo_Uso;
DROP TABLE if EXISTS Turibus;
DROP TABLE if EXISTS Clase_Bus;
CREATE TABLE Puesto(
  idPuesto INT NOT NULL,
  puesto VARCHAR(30) NOT NULL,
  CONSTRAINT ck_puesto CHECK(
    puesto IN ('SYS', 'ADMINISTRADOR', 'CONDUCTOR')
  ),
  PRIMARY KEY (idPuesto)
);
CREATE TABLE Empleado(
  claveEmpleado VARCHAR(5) NOT NULL UNIQUE,
  idPuesto INT NOT NULL,
  CONSTRAINT fk_Puesto FOREIGN KEY (idPuesto) REFERENCES Puesto(idPuesto),
  nombre VARCHAR(50) NOT NULL,
  correo VARCHAR(40) NOT NULL,
  CONSTRAINT ck_correo CHECK(correo LIKE '%@%.com'),
  contrasena VARCHAR(30) NOT NULL,
  rfc VARCHAR(14) NOT NULL,
  salario FLOAT NOT NULL,
  CONSTRAINT ck_calario CHECK(salario > 0),
  PRIMARY KEY(claveEmpleado)
);
CREATE TABLE Administrador(
  claveEmpleado VARCHAR(5) NOT NULL,
  CONSTRAINT FK_Empleado_Admin FOREIGN KEY (claveEmpleado) REFERENCES Empleado(claveEmpleado),
  claveAdministrador INT NOT NULL,
  PRIMARY KEY(claveEmpleado)
);
CREATE TABLE tipoViaje(
  idTipoViaje INT NOT NULL,
  tipoViaje VARCHAR(20) NOT NULL,
  CONSTRAINT ck_tipoViaje CHECK (tipoViaje in ('CORTO', 'MEDIO', 'LARGO')),
  PRIMARY KEY (idTipoViaje)
);
CREATE TABLE Viaje(
  idViaje INT NOT NULL,
  idTipoViaje INT NOT NULL,
  CONSTRAINT fk_tipoViaje FOREIGN KEY (idTipoViaje) REFERENCES tipoViaje(idTipoViaje),
  origen VARCHAR(30) NOT NULL,
  destino VARCHAR(30) NOT NULL,
  precio FLOAT NOT NULL,
  CONSTRAINT ck_precio CHECK(precio > 0.0),
  distancia INT NOT NULL,
  CONSTRAINT ck_distancia CHECK(distancia > 0),
  fecha DATE NOT NULL,
  PRIMARY KEY (idViaje)
);
CREATE TABLE Conductor(
  claveEmpleado VARCHAR(5) NOT NULL UNIQUE,
  claveConductor INT NOT NULL,
  CONSTRAINT ck_claveCond CHECK(claveConductor > 0),
  PRIMARY KEY(claveEmpleado)
);
CREATE TABLE Conductor_Viaje(
  claveEmpleado VARCHAR(5) NOT NULL,
  CONSTRAINT FK1_Cond_Viaje FOREIGN KEY(claveEmpleado) REFERENCES Empleado(claveEmpleado),
  idViaje INT NOT NULL,
  CONSTRAINT FK2_Cond_Viaje FOREIGN KEY(idViaje) REFERENCES Viaje(idViaje),
  PRIMARY KEY(claveEmpleado, idViaje)
);
CREATE TABLE Clase_Bus(
  idClase INT NOT NULL,
  clase VARCHAR(30) NOT NULL,
  CONSTRAINT ck_clase_Bus CHECK(
    clase IN ('TURISTA', 'EJECUTIVO', 'PRIMERA_CLASE', 'NA')
  ),
  PRIMARY KEY (idClase)
);
CREATE TABLE Turibus(
  idTuribus INT NOT NULL,
  tipoTuribus VARCHAR(30) NOT NULL,
  CONSTRAINT ck_tipo_turibus CHECK(
    tipoTuribus IN (
      'UN_PISO',
      'DOS_PISOS',
      'ARTICULADO',
      'BIARTICULADO',
      'NA'
    )
  ),
  PRIMARY KEY(idTuribus)
);
CREATE TABLE Tipo_Uso(
  idUso INT NOT NULL,
  tipoUso VARCHAR(30) NOT NULL,
  CONSTRAINT ck_tipo_Uso CHECK(tipoUso IN ('VIAJE', 'TOUR')),
  PRIMARY KEY (idUso)
);
CREATE TABLE Autobus(
  claveAutobus INT NOT NULL UNIQUE,
  modelo VARCHAR(30) NOT NULL,
  marca VARCHAR(30) NOT NULL,
  capacidad int not NULL,
  CONSTRAINT ck_capacidad CHECK (capacidad > 0),
  tipoUso INT NOT NULL,
  CONSTRAINT fk_tipoUso FOREIGN KEY (tipoUso) REFERENCES Tipo_Uso (idUso),
  claseBus INT NOT NULL,
  CONSTRAINT fk_claseBus FOREIGN KEY (claseBus) REFERENCES Clase_Bus (idClase),
  tipoTuribus INT NOT NULL,
  CONSTRAINT fk_tipoTuribus FOREIGN KEY (tipoTuribus) REFERENCES Turibus (idTuribus)
);
CREATE TABLE Conductor_Autobus(
  claveEmpleado VARCHAR(5) NOT NULL,
  claveAutobus INT NOT NULL,
  CONSTRAINT FK1_Cond_Bus FOREIGN KEY(claveEmpleado) REFERENCES Conductor(claveEmpleado),
  CONSTRAINT FK2_Cond_Bus FOREIGN KEY(claveAutobus) REFERENCES Autobus(claveAutobus),
  PRIMARY KEY(claveEmpleado, claveAutobus)
);
INSERT INTO
  Puesto
VALUES
  (1, 'SYS'),
  (2, 'ADMINISTRADOR'),
  (3, 'CONDUCTOR');
INSERT INTO
  Clase_Bus
VALUES
  (1, 'TURISTA'),
  (2, 'EJECUTIVO'),
  (3, 'PRIMERA_CLASE'),
  (0, 'NA');
INSERT INTO
  Turibus
VALUES
  (1, 'UN_PISO'),
  (2, 'DOS_PISOS'),
  (3, 'ARTICULADO'),
  (4, 'BIARTICULADO'),
  (0, 'NA');
INSERT INTO
  Tipo_Uso
VALUES
  (1, 'VIAJE'),
  (2, 'TOUR');
INSERT into
  tipoViaje
VALUES
  (1, 'CORTO'),
  (2, 'MEDIO'),
  (3, 'LARGO');
SHOW TABLES;
COMMIT;