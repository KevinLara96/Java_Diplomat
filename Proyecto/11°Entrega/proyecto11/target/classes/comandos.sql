DROP DATABASE IF EXISTS modulo11;
CREATE DATABASE modulo11 DEFAULT CHARACTER SET = 'utf8mb4';
USE modulo11;
CREATE SEQUENCE secuencia_tipoViaje MINVALUE 1 START WITH 10 INCREMENT BY 10;
----------------------------- Uno a muchos -------------------------------------
create table agencia(
  idAgencia INT NOT NULL AUTO_INCREMENT,
  nombreAgencia VARCHAR(50) NOT NULL,
  ubicacion VARCHAR(100) NOT NULL,
  CONSTRAINT Agencia_PK PRIMARY KEY (idAgencia)
);
------------------------------- Embebido. --------------------------------------
CREATE TABLE empleado(
  idEmpleado INT AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  correo VARCHAR(30) NOT NULL,
  contrasena VARCHAR(30) NOT NULL,
  rfc VARCHAR(20) NOT NULL,
  salario FLOAT NOT NULL,
  idAgencia INT NOT NULL,
  puesto VARCHAR(30) NOT NULL,
  CONSTRAINT empleado_pk PRIMARY KEY(idEmpleado),
  CONSTRAINT empleado_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia)
);
------------------------------ Muchos a muchos ---------------------------------
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
  idOrden INT NOT NULL AUTO_INCREMENT,
  fecha VARCHAR(20) NOT NULL,
  pago FLOAT NOT NULL,
  descripcion TEXT NULL,
  CONSTRAINT orden_pk PRIMARY KEY (idOrden)
);
CREATE TABLE cliente_orden (
  idCliente INT NOT NULL,
  idOrden INT NOT NULL,
  CONSTRAINT cliente_orden_pk PRIMARY KEY (idCliente, idOrden),
  CONSTRAINT cliente_orden_fk1 FOREIGN KEY (idCliente) REFERENCES cliente (idCliente),
  CONSTRAINT cliente_orden_fk2 FOREIGN KEY (idOrden) REFERENCES orden (idOrden)
);
CREATE TABLE transporte (
  idTransporte INT NOT NULL AUTO_INCREMENT,
  tipoTransporte VARCHAR(10) NOT NULL,
  marca VARCHAR(30),
  modelo VARCHAR(30),
  capacidadUsuarios INT,
  capacidadCombustible INT,
  fechaAdquisicion DATE,
  numeroTurbinas INT,
  numeroLlantas INT,
  puertoAsignado VARCHAR(10),
  estacionamientoAsignado VARCHAR(10),
  idAgencia INT NOT NULL,
  CONSTRAINT transporte_pk PRIMARY KEY (idTransporte),
  CONSTRAINT transporte_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia (idAgencia)
);
commit;