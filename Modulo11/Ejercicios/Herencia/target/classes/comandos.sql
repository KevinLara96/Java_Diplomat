DROP DATABASE IF EXISTS modulo11;
CREATE DATABASE modulo11 DEFAULT CHARACTER SET = 'utf8mb4';
USE modulo11;
CREATE SEQUENCE secuencia_tipoViaje MINVALUE 1 START WITH 10 INCREMENT BY 10;
create table agencia(
  idAgencia INT NOT NULL AUTO_INCREMENT,
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
CREATE TABLE tipoViaje (
  idTipoViaje INT NOT NULL,
  tipoViaje VARCHAR(20) NOT NULL,
  CONSTRAINT tipoviaje_pk PRIMARY KEY (idTipoViaje)
);
CREATE TABLE viajes (
  idViaje INT NOT NULL AUTO_INCREMENT,
  origen VARCHAR(50) NOT NULL,
  destino VARCHAR(50) NOT NULL,
  precio FLOAT NOT NULL,
  fecha VARCHAR(50) NOT NULL,
  idAgencia INT NOT NULL,
  idTipoViaje INT NOT NULL,
  CONSTRAINT viaje_pk PRIMARY KEY(idViaje),
  CONSTRAINT viaje_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia),
  CONSTRAINT viaje_tipoViaje_fk FOREIGN KEY (idTipoViaje) REFERENCES tipoViaje(idTipoViaje)
);
CREATE TABLE cliente (
  idCliente INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  calle VARCHAR(30) NOT NULL,
  colonia VARCHAR(30) NOT NULL,
  telefono VARCHAR(15) NOT NULL,
  rfc VARCHAR(20) NOT NULL,
  idAgencia INT NOT NULL,
  CONSTRAINT cliente_pk PRIMARY KEY (idCliente),
  CONSTRAINT cliente_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia (idAgencia)
);
CREATE TABLE orden(
  idOrden INT NOT NULL,
  fecha VARCHAR(20) NOT NULL,
  pago FLOAT NOT NULL,
  descripcion TEXT NULL,
  CONSTRAINT orden_pk PRIMARY KEY (idOrden)
);
CREATE TABLE cliente_orden (
  idCliente INT NOT NULL,
  idOrden INT NOT NULL,
  CONSTRAINT cliente_orden_pk PRIMARY KEY (idCliente, idOrden),
  CONSTRAINT cliente_orden_pk1 FOREIGN KEY (idCliente) REFERENCES cliente (idCliente),
  CONSTRAINT cliente_orden_pk2 FOREIGN KEY (idOrden) REFERENCES orden (idOrden)
);
commit;