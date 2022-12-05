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
CREATE TABLE empleado(
  idEmpleado INT AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  correo VARCHAR(30) NOT NULL,
  contrasena VARCHAR(30) NOT NULL,
  rfc VARCHAR(20) NOT NULL,
  salario FLOAT NOT NULL,
  idAgencia INT NOT NULL,
  puesto VARCHAR(20) NOT NULL,
  CONSTRAINT empleado_pk PRIMARY KEY(idEmpleado),
  CONSTRAINT empleado_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia)
);