use modulo11;
INSERT INTO
  agencia
VALUES
  (1, 'Agencia 1', 'Ciudad de México');
INSERT INTO
  empleado
VALUES
  (
    1,
    'SYS',
    'sys@sak.com',
    'sys1',
    '-',
    0.0,
    1,
    'Sys'
  );
INSERT INTO
  agencia
VALUES
  (2, 'Agencia 2', 'Guadalajara'),
  (3, 'Agencia 3', 'Monterrey');
INSERT INTO
  cliente
VALUES
  (
    1,
    'Cliente 1',
    'Calle1',
    'Colonia1',
    'Tel1',
    'rfc1',
    1
  ),
  (
    2,
    'Cliente 2',
    'Calle2',
    'Colonia2',
    'Tel2',
    'rfc2',
    1
  ),
  (
    3,
    'Cliente 3',
    'Calle3',
    'Colonia3',
    'Tel3',
    'rfc3',
    1
  ),
  (
    4,
    'Cliente 4',
    'Calle4',
    'Colonia4',
    'Tel4',
    'rfc4',
    1
  ),
  (
    5,
    'Cliente 5',
    'Calle5',
    'Colonia5',
    'Tel5',
    'rfc5',
    1
  ),
  (
    6,
    'Cliente 6',
    'Calle6',
    'Colonia6',
    'Tel6',
    'rfc6',
    1
  ),
  (
    7,
    'Cliente 7',
    'Calle7',
    'Colonia7',
    'Tel7',
    'rfc7',
    2
  ),
  (
    8,
    'Cliente 8',
    'Calle8',
    'Colonia8',
    'Tel8',
    'rfc8',
    2
  ),
  (
    9,
    'Cliente 9',
    'Calle9',
    'Colonia9',
    'Tel9',
    'rfc9',
    2
  ),
  (
    10,
    'Cliente 10',
    'Calle10',
    'Colonia10',
    'Tel10',
    'rfc10',
    2
  ),
  (
    11,
    'Cliente 11',
    'Calle11',
    'Colonia11',
    'Tel11',
    'rfc11',
    3
  ),
  (
    12,
    'Cliente 12',
    'Calle12',
    'Colonia12',
    'Tel12',
    'rfc12',
    3
  ),
  (
    13,
    'Cliente 13',
    'Calle13',
    'Colonia13',
    'Tel13',
    'rfc13',
    3
  ),
  (
    14,
    'Cliente 14',
    'Calle14',
    'Colonia14',
    'Tel14',
    'rfc14',
    3
  ),
  (
    15,
    'Cliente 15',
    'Calle15',
    'Colonia15',
    'Tel15',
    'rfc15',
    3
  );
INSERT INTO
  empleado
VALUES
  (
    2,
    'Empleado 2',
    'correo2',
    'contrasena2',
    'rfc2',
    20,
    1,
    'ADMINISTRADOR'
  ),
  (
    3,
    'Empleado 3',
    'correo3',
    'contrasena3',
    'rfc3',
    30,
    1,
    'PROGRAMADOR'
  ),
  (
    4,
    'Empleado 4',
    'correo4',
    'contrasena4',
    'rfc4',
    40,
    1,
    'CONDUCTOR'
  ),
  (
    5,
    'Empleado 5',
    'correo5',
    'contrasena5',
    'rfc5',
    50,
    2,
    'RECURSOS HUMANOS'
  ),
  (
    6,
    'Empleado 6',
    'correo6',
    'contrasena6',
    'rfc6',
    60,
    2,
    'ADMINISTRADOR'
  ),
  (
    7,
    'Empleado 7',
    'correo7',
    'contrasena7',
    'rfc7',
    70,
    2,
    'PROGRAMADOR'
  ),
  (
    8,
    'Empleado 8',
    'correo8',
    'contrasena8',
    'rfc8',
    80,
    3,
    'CONDUCTOR'
  ),
  (
    9,
    'Empleado 9',
    'correo9',
    'contrasena9',
    'rfc9',
    90,
    3,
    'RECURSOS HUMANOS'
  ),
  (
    10,
    'Empleado 10',
    'correo10',
    'contrasena10',
    'rfc10',
    100,
    3,
    'MARKETING'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1995-27-01',
    '3400.0',
    'Compra tres boletos de avión de Monterrey a Yucatán, pago en efectivo'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1990-30-04',
    '1500.0',
    'Compra un boleto de autobús de la Ciudad de México a Veracruz, pago con tarjeta'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1998-27-11',
    '5800.0',
    'Compra 3 boletos de avión de Guadalajara a Los Ángeles , pago con tarjeta'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1994-14-03',
    '1400.0',
    'Compra un boleto autobús de Monterrey a Chihuahua, pago en efetivo'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1989-20-12',
    '4500.0',
    'Compra dos boletos de avión de Ciudad de México a Quintana Roo, pago con tarjeta'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1991-10-11',
    '8500.0',
    'Compra dos boletos de avión de Monterrey a Bogotá, pago con tarjeta'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1995-28-07',
    '2400.0',
    'Compra dos boletos de autobús de Guadalajara a Oaxaca , pago en efectivo'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1988-03-06',
    '3500.0',
    'Compra tres boletos de autobús de Monterrey a Colima, pago con tarjeta'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1997-21-10',
    '1400.0',
    'Compra un boleto de autobús de Ciudad de México a Campeche, pago en efectivo'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1994-07-07',
    '2800.0',
    'Compra dos boletos de autobús de Monterrey a Veracruz, pago con tarjeta'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1997-02-05',
    '2500.0',
    'Compra dos boletos de autobús de Ciudad de México a Guerrero, pago con tarjeta'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1985-27-06',
    '1800.0',
    'Compra un boleto de avión de Ciudad de México a Chihuahua, pago en efectivo'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1999-15-09',
    '3500.0',
    'Compra tres boletos de avión de Guadalajara a Yucatán, pago con tarjeta'
  );
INSERT INTO
  orden (fecha, pago, descripcion)
VALUES
  (
    '1993-07-04',
    '2400.0',
    'Compra un boleto de avión de Ciudad de México a Bostón, pago con tarjeta'
  );
INSERT INTO
  cliente_orden
VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5),
  (6, 6),
  (7, 7),
  (8, 8),
  (9, 9),
  (10, 10),
  (11, 11),
  (12, 12),
  (12, 13),
  (13, 14);
INSERT INTO
  transporte (
    tipoTransporte,
    marca,
    modelo,
    capacidadUsuarios,
    capacidadCombustible,
    fechaAdquisicion,
    numeroTurbinas,
    puertoAsignado,
    idAgencia
  )
VALUES
  (
    'Avion',
    'Marca1',
    'Modelo1',
    10,
    50,
    '2005-03-05',
    2,
    'Puerto 1',
    1
  ),
  (
    'Avion',
    'Marca2',
    'Modelo2',
    20,
    60,
    '2008-08-25',
    2,
    'Puerto 2',
    2
  ),
  (
    'Avion',
    'Marca3',
    'Modelo3',
    30,
    90,
    '2015-10-16',
    4,
    'Puerto 3',
    3
  );
INSERT INTO
  transporte (
    tipoTransporte,
    marca,
    modelo,
    capacidadUsuarios,
    capacidadCombustible,
    fechaAdquisicion,
    numeroLlantas,
    estacionamientoAsignado,
    idAgencia
  )
VALUES
  (
    'Autobus',
    'Marca1',
    'Modelo1',
    10,
    40,
    '2020-01-06',
    4,
    'Lugar 1',
    1
  ),
  (
    'Autobus',
    'Marca2',
    'Modelo2',
    30,
    45,
    '2018-09-16',
    4,
    'Lugar 2',
    2
  ),
  (
    'Autobus',
    'Marca3',
    'Modelo3',
    35,
    60,
    '2022-08-03',
    6,
    'Lugar 3',
    3
  );