DROP DATABASE IF EXISTS proyectofinal;
CREATE DATABASE proyectofinal DEFAULT CHARACTER SET = 'utf8mb4';
USE proyectofinal;
CREATE TABLE agencia(
  idAgencia INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  ubicacion VARCHAR(30) NOT NULL,
  CONSTRAINT agencia_pk PRIMARY KEY (idAgencia)
);
CREATE TABLE puesto(
  idPuesto INT NOT NULL AUTO_INCREMENT,
  puesto VARCHAR(20),
  CONSTRAINT puesto_pk PRIMARY KEY(idPuesto)
);
CREATE TABLE empleado(
  idEmpleado INT NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(40) NOT NULL,
  apellidos VARCHAR(40) NOT NULL,
  correo VARCHAR(40) NOT NULL,
  contrasena VARCHAR(40) NOT NULL,
  rfc VARCHAR(20) NOT NULL,
  salario FLOAT NOT NULL,
  idAgencia INT NOT NULL,
  idPuesto INT NOT NULL,
  CONSTRAINT empleado_pk PRIMARY KEY(idEmpleado),
  CONSTRAINT empleado_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia),
  CONSTRAINT empleado_puesto_fk FOREIGN KEY (idPuesto) REFERENCES puesto(idPuesto),
  CONSTRAINT empleado_correo_ck CHECK (correo LIKE "%@avk.com")
);
CREATE TABLE tipoViajeAutobus (
  idTipoViajeAutobus INT NOT NULL AUTO_INCREMENT,
  tipoViajeAutobus VARCHAR(30) NOT NULL,
  CONSTRAINT tipoViajeAutobus_pk PRIMARY KEY (idTipoViajeAutobus)
);
CREATE TABLE tipoViajeAvion (
  idTipoViajeAvion INT NOT NULL AUTO_INCREMENT,
  tipoViajeAvion VARCHAR(30) NOT NULL,
  CONSTRAINT tipoViajeAvion_pk PRIMARY KEY (idTipoViajeAvion)
);
CREATE TABLE viaje(
  idViaje INT NOT NULL AUTO_INCREMENT,
  origen VARCHAR(50) NOT NULL,
  destino VARCHAR(50) NOT NULL,
  precio FLOAT NOT NULL,
  fecha DATE NOT NULL,
  idAgencia INT NOT NULL,
  idTipoViajeAutobus INT NOT NULL,
  idTipoViajeAvion INT NOT NULL,
  CONSTRAINT viaje_pk PRIMARY KEY(idViaje),
  CONSTRAINT viaje_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia),
  CONSTRAINT viaje_tipoViajeAutobus_fk FOREIGN KEY (idTipoViajeAutobus) REFERENCES tipoViajeAutobus(idTipoViajeAutobus),
  CONSTRAINT viaje_tipoViajeAvion_fk FOREIGN KEY (idTipoViajeAvion) REFERENCES tipoViajeAvion (idTipoViajeAvion)
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
  estacionamientoAsignado VARCHAR(20),
  CONSTRAINT transporte_pk PRIMARY KEY (idTransporte)
);
CREATE TABLE cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(50) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  calle VARCHAR(30) NOT NULL,
  colonia VARCHAR(50) NOT NULL,
  codigoPostal VARCHAR(30) NOT NULL,
  telefono VARCHAR(15) NOT NULL,
  rfc VARCHAR(20) NOT NULL,
  correo VARCHAR(50) NOT NULL,
  contrasena VARCHAR(50) NOT NULL,
  idAgencia INT NOT NULL,
  CONSTRAINT cliente_pk PRIMARY KEY (idCliente),
  CONSTRAINT cliente_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia (idAgencia)
);
CREATE TABLE orden(
  idOrden INT NOT NULL AUTO_INCREMENT,
  fechaEmision DATE NOT NULL,
  monto FLOAT NOT NULL,
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