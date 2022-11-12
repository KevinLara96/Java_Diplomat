DROP DATABASE IF EXISTS modulo06;
CREATE DATABASE modulo06 DEFAULT CHARACTER SET = 'utf8mb4';
USE modulo06;
create table agencia(
  idAgencia INT NOT NULL,
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
  idEmpleado INT,
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
  idClaseBus INT NOT NULL,
  claseBus VARCHAR(30) NOT NULL,
  CONSTRAINT claseBus_pk PRIMARY KEY (idClaseBus)
);
CREATE TABLE claseTuribus (
  idClaseTuribus INT NOT NULL,
  claseTuribus VARCHAR(30) NOT NULL,
  CONSTRAINT claseTuribus_pk PRIMARY KEY(idClaseTuribus)
);
CREATE TABLE autobus (
  idAutobus INT NOT NULL,
  modelo VARCHAR(30) NOT NULL,
  marca VARCHAR(30) NOT NULL,
  capacidad INT NOT NULL,
  idClaseBus INT NOT NULL,
  idClaseTuribus INT NOT NULL,
  idAgencia INT NOT NULL,
  CONSTRAINT autobus_pk PRIMARY KEY (idAutobus),
  CONSTRAINT autobus_clasebus_fk FOREIGN KEY (idClaseBus) REFERENCES claseBus (idClaseBus),
  CONSTRAINT autobus_claseturibus_fk FOREIGN KEY (idClaseTuribus) REFERENCES claseTuribus (idClaseTuribus),
  CONSTRAINT autobus_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia)
);
CREATE TABLE tours (
  idTour INT NOT NULL,
  ciudad VARCHAR(50) NOT NULL,
  precio FLOAT NOT NULL,
  fecha VARCHAR(50) NOT NULL,
  idAgencia INT NOT NULL,
  CONSTRAINT tour_pk PRIMARY KEY(idTour),
  CONSTRAINT tour_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia)
);
CREATE TABLE tipoTour (
  idTipoTour INT NOT NULL,
  tipoTour VARCHAR(20) NOT NULL,
  CONSTRAINT tipotour_pk PRIMARY KEY (idTipoTour)
);
CREATE TABLE tours_tipoTour(
  idTour INT NOT NULL,
  idTipoTour INT NOT NULL,
  CONSTRAINT tours_tipoTour_PK PRIMARY KEY (idTour, idTipoTour),
  CONSTRAINT tour_fk FOREIGN KEY (idTour) REFERENCES tours (idTour),
  CONSTRAINT tipoTour_fk FOREIGN KEY (idTipoTour) REFERENCES tipoTour (idTipoTour)
);
CREATE TABLE viajes (
  idViaje INT NOT NULL,
  origen VARCHAR(50) NOT NULL,
  destino VARCHAR(50) NOT NULL,
  precio FLOAT NOT NULL,
  fecha VARCHAR(50) NOT NULL,
  idAgencia INT NOT NULL,
  CONSTRAINT viaje_pk PRIMARY KEY(idViaje),
  CONSTRAINT viaje_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia)
);
CREATE TABLE tipoViaje (
  idTipoViaje INT NOT NULL,
  tipoViaje VARCHAR(20) NOT NULL,
  CONSTRAINT tipoviaje_pk PRIMARY KEY (idTipoViaje)
);
CREATE TABLE viajes_tipoViaje(
  idViaje INT NOT NULL,
  idTipoViaje INT NOT NULL,
  CONSTRAINT viajes_tipoViaje_PK PRIMARY KEY (idViaje, idTipoViaje),
  CONSTRAINT viaje_fk FOREIGN KEY (idViaje) REFERENCES viajes (idViaje),
  CONSTRAINT tipoViaje_fk FOREIGN KEY (idTipoViaje) REFERENCES tipoViaje (idTipoViaje)
);
CREATE TABLE conductor_viaje(
  idAsignacionViaje INT NOT NULL,
  idAgencia INT NOT NULL,
  idConductor INT NOT NULL,
  idViaje INT NOT NULL,
  CONSTRAINT cond_viaje_pk PRIMARY KEY(idAsignacionViaje),
  CONSTRAINT cond_viaje_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia (idAgencia)
);
CREATE TABLE conductor_autobus (
  idAsignacionAutobus INT NOT NULL,
  idAgencia INT NOT NULL,
  idConductor INT NOT NULL,
  idAutobus INT NOT NULL,
  CONSTRAINT cond_autobus_pk PRIMARY KEY(idAsignacionAutobus),
  CONSTRAINT cond_autobus_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia (idAgencia)
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
INSERT INTO
  agencia
VALUES
  (1, 'Agencia 1', 'Ciudad de México');
INSERT INTO
  empleado
VALUES
  (1, 'SYS', 'sys@sak.com', 'sys1', '-', 0.0, 1, 1);
commit;