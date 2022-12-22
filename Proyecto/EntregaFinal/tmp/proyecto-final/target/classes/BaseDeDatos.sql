DROP DATABASE IF EXISTS proyectofinal;
CREATE DATABASE proyectofinal DEFAULT CHARACTER SET = 'utf8mb4';
USE proyectofinal;
CREATE SEQUENCE id_seq MINVALUE 1 START WITH 50 INCREMENT BY 5;
CREATE TABLE agencia(
  idAgencia INT NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  ubicacion VARCHAR(30) NOT NULL,
  CONSTRAINT agencia_pk PRIMARY KEY (idAgencia)
);
CREATE TABLE puesto(
  idPuesto INT NOT NULL,
  puesto VARCHAR(20),
  CONSTRAINT puesto_pk PRIMARY KEY(idPuesto)
);
CREATE TABLE empleado(
  idEmpleado INT NOT NULL,
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
  idTipoViajeAutobus INT NOT NULL,
  tipoViajeAutobus VARCHAR(30) NOT NULL,
  CONSTRAINT tipoViajeAutobus_pk PRIMARY KEY (idTipoViajeAutobus)
);
CREATE TABLE tipoViajeAvion (
  idTipoViajeAvion INT NOT NULL,
  tipoViajeAvion VARCHAR(30) NOT NULL,
  CONSTRAINT tipoViajeAvion_pk PRIMARY KEY (idTipoViajeAvion)
);
CREATE TABLE viaje(
  idViaje INT NOT NULL,
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
  idTransporte INT NOT NULL,
  tipoTransporte VARCHAR(10) NOT NULL,
  marca VARCHAR(30),
  modelo VARCHAR(30),
  capacidadCombustible INT,
  fechaAdquisicion DATE,
  asientosBasicos INT NOT NULL,
  asientosPrimeraClase INT NOT NULL,
  puertoAsignado VARCHAR(10),
  estacionamientoAsignado VARCHAR(20),
  idAgencia INT NOT NULL,
  CONSTRAINT transporte_pk PRIMARY KEY (idTransporte),
  CONSTRAINT transporte_agencia_fk FOREIGN KEY(idAgencia) REFERENCES agencia(idAgencia)
);
CREATE TABLE cliente (
  idCliente INT NOT NULL,
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
  idOrden INT NOT NULL,
  idCliente INT NOT NULL,
  fechaEmision DATE NOT NULL,
  monto FLOAT NOT NULL,
  descripcion TEXT NOT NULL,
  CONSTRAINT orden_pk PRIMARY KEY (idOrden),
  CONSTRAINT oden_cliente_fk FOREIGN KEY (idCliente) REFERENCES cliente(idCliente)
);
CREATE TABLE producto(
  idProducto INT NOT NULL,
  nombreProducto VARCHAR(50) NOT NULL,
  multiplicador FLOAT NOT NULL,
  estatus VARCHAR(10) NOT NULL,
  CONSTRAINT producto_pk PRIMARY KEY (idProducto)
);
CREATE TABLE orden_producto (
  idOrden INT NOT NULL,
  idProducto INT NOT NULL,
  CONSTRAINT orden_producto_pk PRIMARY KEY (idOrden, idProducto),
  CONSTRAINT op_orden_fk FOREIGN KEY (idOrden) REFERENCES orden(idOrden),
  CONSTRAINT op_producto_fk FOREIGN KEY (idProducto) REFERENCES producto (idProducto)
);
CREATE TABLE asignacionAvionViaje(
  idAvion INT NOT NULL,
  idViaje INT NOT NULL,
  idAgencia INT NOT NULL,
  CONSTRAINT asignacionAvion_pk PRIMARY KEY (idAvion, idViaje),
  CONSTRAINT aisgnacionAvion_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia)
);
CREATE TABLE asignacionAutobusViaje(
  idAutobus INT NOT NULL,
  idViaje INT NOT NULL,
  idAgencia INT NOT NULL,
  CONSTRAINT asignacionAutobus_pk PRIMARY KEY (idAutobus, idViaje),
  CONSTRAINT aisgnacionAutobus_agencia_fk FOREIGN KEY (idAgencia) REFERENCES agencia(idAgencia)
);