DROP DATABASE IF EXISTS modulo04;
CREATE DATABASE modulo04 DEFAULT CHARACTER SET = 'utf8mb4';
USE modulo04;
create table agencia(
  idAgencia INT AUTO_INCREMENT,
  nombreAgencia VARCHAR(50) NOT NULL,
  ubicacion VARCHAR(100) NOT NULL,
  CONSTRAINT Agencia_PK PRIMARY KEY (idAgencia)
);
CREATE TABLE puesto(
  idPuesto INT NOT NULL,
  puesto VARCHAR(30) NOT NULL,
  CONSTRAINT puesto_pk PRIMARY KEY(idPuesto)
);
CREATE TABLE empleado(
  idEmpleado INT AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  correo VARCHAR(30) NOT NULL,
  contrasena VARCHAR(30) NOT NULL,
  rfc VARCHAR(20) NOT NULL,
  salario FLOAT NOT NULL,
  idAgencia INT NOT NULL,
  idPuesto INT NOT NULL,
  CONSTRAINT empleado_pk PRIMARY KEY(idEmpleado),
  CONSTRAINT empleado_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia),
  CONSTRAINT empleado_puesto_fk FOREIGN KEY (idPuesto) REFERENCES puesto(idPuesto)
);
CREATE TABLE claseBus (
  idClaseBus INT NOT NULL AUTO_INCREMENT,
  claseBus VARCHAR(30) NOT NULL,
  CONSTRAINT claseBus_pk PRIMARY KEY (idClaseBus)
);
CREATE TABLE claseTuribus (
  idClaseTuribus INT NOT NULL AUTO_INCREMENT,
  claseTuribus VARCHAR(30) NOT NULL,
  CONSTRAINT claseTuribus_pk PRIMARY KEY(idClaseTuribus)
);
CREATE TABLE autobus (
  idAutobus INT NOT NULL AUTO_INCREMENT,
  modelo VARCHAR(30) NOT NULL,
  marca VARCHAR(30) NOT NULL,
  capacidad INT NOT NULL,
  idClaseBus INT NOT NULL,
  idClaseTuribus INT NOT NULL,
  CONSTRAINT autobus_pk PRIMARY KEY (idAutobus),
  CONSTRAINT autobus_clasebus_fk FOREIGN KEY (idClaseBus) REFERENCES claseBus (idClaseBus),
  CONSTRAINT autobus_claseturibus_fk FOREIGN KEY (idClaseTuribus) REFERENCES claseTuribus (idClaseTuribus)
);
CREATE TABLE tipoViaje (
  idTipoViaje INT NOT NULL AUTO_INCREMENT,
  tipoViaje VARCHAR(20) NOT NULL,
  CONSTRAINT tipoviaje_pk PRIMARY KEY (idTipoViaje)
);
CREATE TABLE tipoTour (
  idTipoTour INT NOT NULL AUTO_INCREMENT,
  tipoTour VARCHAR(20) NOT NULL,
  CONSTRAINT tipotour_pk PRIMARY KEY (idTipoTour)
);
CREATE TABLE viaje (
  idViaje INT NOT NULL AUTO_INCREMENT,
  origen VARCHAR(50) NOT NULL,
  destino VARCHAR(50) NOT NULL,
  precio FLOAT NOT NULL,
  distancia INT NOT NULL,
  fecha VARCHAR(50) NOT NULL,
  idTipoViaje INT NOT NULL,
  idTipoTour INT NOT NULL,
  CONSTRAINT viaje_pk PRIMARY KEY(idViaje),
  CONSTRAINT viaje_tipoviaje_fk FOREIGN KEY (idTipoViaje) REFERENCES tipoViaje(idTipoViaje),
  CONSTRAINT viaje_tipotour_fk FOREIGN KEY (idTipoTour) REFERENCES tipoTour(idTipoTour)
);
CREATE TABLE conductor_viaje(
  idAsignacionViaje INT NOT NULL AUTO_INCREMENT,
  idConductor INT NOT NULL,
  idViaje INT NOT NULL,
  CONSTRAINT conductor_viaje_pk PRIMARY KEY (idAsignacionViaje)
);
CREATE TABLE conductor_autobus (
  idAsignacionAutobus INT NOT NULL AUTO_INCREMENT,
  idConductor INT NOT NULL,
  idAutobus INT NOT NULL,
  CONSTRAINT conductor_autobus_pk PRIMARY KEY(idAsignacionAutobus)
);
INSERT INTO
  claseBus
VALUES
  (1, 'Turista'),
  (2, 'Ejecutivo'),
  (3, 'Primera Clase'),
  (4, 'N.A.');
INSERT INTO
  claseTuribus
VALUES
  (1, 'Un Piso'),
  (2, 'Dos Pisos'),
  (3, 'Articulado'),
  (4, 'Bi-Articulado'),
  (5, 'N.A.');
INSERT INTO
  tipoViaje
VALUES
  (1, 'Viaje Corto'),
  (2, 'Viaje Medio'),
  (3, 'Viaje Largo'),
  (4, 'N.A.');
INSERT INTO
  tipoTour
VALUES
  (1, 'Un día'),
  (2, 'Dos días'),
  (3, 'Tres días'),
  (4, 'N.A.');
INSERT INTO
  puesto
VALUES
  (1, 'Sys'),
  (2, 'Administrador'),
  (3, 'Conductor'),
  (4, 'Programador'),
  (5, 'Recursos Humanos');