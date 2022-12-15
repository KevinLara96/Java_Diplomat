use proyectofinal;
-----------------------------------------------Puestos-----------------------------------------------------
INSERT INTO
  puesto
VALUES
  (2, 'PROGRAMADOR'),
  (3, 'ADMINISTRADOR'),
  (4, 'CONDUCTOR'),
  (5, 'RECURSOS HUMANOS'),
  (6, 'MARKETING');
---------------------------------------------Empleado-------------------------------------------------------
INSERT INTO
  empleado
VALUES
  (
    2,
    'Kevin Arturo',
    'Lara Sala',
    'kevin@avk.com',
    'Wf394$$&aYGw',
    'LASK960308B77',
    35000.0,
    1,
    2
  );
INSERT INTO
  empleado
VALUES(
    3,
    'Ana Laura',
    'Gómez López',
    'laura@avk.com',
    'bE151Puge7@%',
    'GOLA940712FD0',
    2400.0,
    2,
    6
  );
INSERT INTO
  empleado
VALUES(
    4,
    'Jóse Luis',
    'Duarte Sosa',
    'duarte@avk.com',
    '39X4cs86I*^m',
    ' DUSL9104244H10',
    4500.0,
    1,
    4
  );
INSERT INTO
  empleado
VALUES(
    5,
    'Antonio',
    'Navarro Ruíz',
    'antonio@avk.com',
    'I7^Xzyx2%d2U',
    'NARA950615FZ7',
    3000.0,
    3,
    5
  );
INSERT INTO
  empleado
VALUES(
    6,
    'María Lucía',
    'Torres Pesa',
    'lucia@avk.com',
    'jpnnU77Hi5H*',
    'TOPL960815JN5',
    3500.0,
    1,
    2
  );
INSERT INTO
  empleado
VALUES(
    7,
    'Vicente',
    'Gutiérrez Nieto',
    'vicente@avk.com',
    'n5Bz7036j#A3',
    'GUNV900405P67',
    4500.0,
    3,
    4
  );
INSERT INTO
  empleado
VALUES(
    8,
    'Jóse Antonio',
    'Arellano Asenjo',
    'arellano@avk.com',
    'Us6zGxl62#i#',
    'AEAA951029UI3',
    2400.0,
    2,
    5
  );
INSERT INTO
  empleado
VALUES(
    9,
    'Rodrigo',
    'Cruz Domínguez',
    'rodrigo@avk.com',
    'jzd7U0oZ!d06',
    'CUDR9505149H4',
    3800.0,
    1,
    3
  );
INSERT INTO
  empleado
VALUES(
    10,
    'Lixy Fernanda',
    'Pérez Mora',
    'lixy@avk.com',
    '0FnZ#f*n11P5',
    'PEML920925Q52',
    3800.0,
    2,
    3
  );
INSERT INTO
  empleado
VALUES(
    11,
    'Adrián',
    'Toledo Sierra',
    'adrian@avk.com',
    'M9Ii4$^U00i0',
    'TOSA9304078H7',
    2400.0,
    3,
    6
  );
INSERT INTO
  empleado
VALUES(
    12,
    'Luisa Ximena',
    'Garrido Pinol',
    'ximena@avk.com',
    '5K!IsI1B3#W6',
    'GAPL950829RLA',
    3000.0,
    1,
    5
  );
INSERT INTO
  empleado
VALUES(
    13,
    'Juan Carlos',
    'Escamilla Campos',
    'carlos@avk.com',
    '0p4ti6FaR^n1',
    'EACJ961211L46',
    3800.0,
    3,
    4
  );
INSERT INTO
  empleado
VALUES(
    14,
    'Josefa',
    'Bustamante Vara',
    'josefa@avk.com',
    'p!u5EG920ScJ',
    'BUVJ911110MB2',
    3900.0,
    2,
    4
  );
INSERT INTO
  empleado
VALUES(
    15,
    'María Jóse',
    'Baraja Hernández',
    'baraja@avk.com',
    '608WI0HfTWe&',
    'BAH931212P45',
    3000.0,
    1,
    3
  );
INSERT INTO
  empleado
VALUES
  (
    16,
    'Carlos Crispín',
    'Aliñado Asturias',
    'vopusseuttehi-2697@avk.com',
    'De235@k&ZA*S',
    'AIAC9605265S5',
    12000.0,
    2,
    3
  );
--------------------------------------------------Clientes-------------------------------------------------
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Hicham',
    'Rivas',
    'Calle Dr Olvera 192-158',
    'Doctores, Cuauhtémoc',
    '06720',
    '55-5659-1885',
    'RIPH650308DY9',
    'wippiquousicri-5492@yopmail.com',
    'lB33Q@vH6k^!',
    1
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Marta',
    'Amador-Aranda',
    'Hortelanos 28-12',
    'Venustiano Carranza',
    '15270',
    '55-5659-1754',
    'AAAM980908DY4',
    'prijiruyemmo-1298@yopmail.com',
    '@9hMO34Ff@IN',
    1
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Heraclio',
    'Fajardo-Lasa',
    'Av. Santa Fe 482',
    'Lomas de Santa Fe',
    '01219',
    '55-5413-7988',
    'FALH900801K63',
    'quennufeuppaneu-7276@yopmail.com',
    '0*kNtr0b02HK',
    1
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Plácido',
    'Valverde Font',
    'Av Aleta 35-47',
    'Col del Mar',
    '13270',
    '55-5099-3627',
    'VAFP850128DTA',
    'pevatanneissu-4200@yopmail.com',
    '5bQ12FUOOz$I',
    1
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Nerea',
    'Serna Melero',
    '16 de Septiembre 401B',
    'Casco Urbano',
    '66230',
    '55-5668-4928',
    'SEMN920430U24',
    'moileuffuzaucou-8755@yopmail.com',
    '@Qmh63Y1KDe&',
    3
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Clarisa',
    'Soto Chaves',
    'Av. Camino Real SN',
    'Camino Real',
    '67170',
    '55-5162-7110',
    'SOCC83100538A',
    'gruxitroveira-6869@yopmail.com',
    'V9p4&V68VZTE',
    3
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Celestina',
    'Palacio Blanco',
    'C. Clavelina 237-179',
    'Prados del Nogalar',
    '66480',
    '55-5971-7852',
    'PABC9008031W4',
    'grajitreuyeirei-6073@yopmail.com',
    'Sv06h*^^6GwE',
    3
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Jose Carlos',
    'Roma Saez',
    'C. Joaquín Angulo 2480',
    'Ladrón de Guevara',
    '44600',
    '55-5124-5339',
    'ROSC7512287M10',
    'mojeijizauppo-9314@yopmail.com',
    '4mhR$nP72Ji7',
    2
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Dominga',
    'Martorell Cases',
    'Turmalina 2887',
    'Victoria',
    '45060',
    '55-5492-5864',
    'MACD4011301U6',
    'kauffafabaucro-7704@yopmail.com',
    'W11l90Gg%@pM',
    2
  );
INSERT INTO
  cliente (
    nombres,
    apellidos,
    calle,
    colonia,
    codigoPostal,
    telefono,
    rfc,
    correo,
    contrasena,
    idAgencia
  )
VALUES
  (
    'Pastor',
    'Plana Perelló',
    'San Martin 74',
    'Plan de Oriente',
    '45620',
    '55-5668-9346',
    'PAPP960625736',
    'creihellemmuhou-4970@yopmail.com',
    'xC%6h83o7061',
    2
  );
----------------------------------------- Órdenes. --------------------------------------------------
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1996-03-08',
    2400.0,
    'Compra de 2 boletos de avión de la Ciudad de México a Berlín, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2010-01-27',
    3400.0,
    'Compra tres boletos de avión de Monterrey a Yucatán, pago en efectivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2011-04-30',
    1500.0,
    'Compra un boleto de autobús de la Ciudad de México a Veracruz, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2012-11-27',
    5800.0,
    'Compra 3 boletos de avión de Guadalajara a Los Ángeles , pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2013-03-14',
    1400.0,
    'Compra un boleto autobús de Monterrey a Chihuahua, pago en efetivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2015-12-20',
    4500.0,
    'Compra dos boletos de avión de Ciudad de México a Quintana Roo, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2014-11-10',
    8500.0,
    'Compra dos boletos de avión de Monterrey a Bogotá, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2014-07-28',
    2400.0,
    'Compra dos boletos de autobús de Guadalajara a Oaxaca , pago en efectivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2016-06-03',
    3500.0,
    'Compra tres boletos de autobús de Monterrey a Colima, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2017-10-21',
    1400.0,
    'Compra un boleto de autobús de Ciudad de México a Campeche, pago en efectivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2018-07-07',
    2800.0,
    'Compra dos boletos de autobús de Monterrey a Veracruz, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2018-05-02',
    2500.0,
    'Compra dos boletos de autobús de Ciudad de México a Guerrero, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2019-06-27',
    1800.0,
    'Compra un boleto de avión de Ciudad de México a Chihuahua, pago en efectivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2020-09-15',
    3500.0,
    'Compra tres boletos de avión de Guadalajara a Yucatán, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '2020-10-07',
    2400.0,
    'Compra un boleto de avión de Ciudad de México a Bostón, pago con tarjeta'
  );
-----------------------------------------Cliente Orden------------------------------------------------------
INSERT INTO
  cliente_orden
VALUES
  (1, 1);
INSERT INTO
  cliente_orden
VALUES
  (5, 2);
INSERT INTO
  cliente_orden
VALUES
  (2, 3);
INSERT INTO
  cliente_orden
VALUES
  (8, 4);
INSERT INTO
  cliente_orden
VALUES
  (6, 5);
INSERT INTO
  cliente_orden
VALUES
  (3, 6);
INSERT INTO
  cliente_orden
VALUES
  (7, 7);
INSERT INTO
  cliente_orden
VALUES
  (9, 8);
INSERT INTO
  cliente_orden
VALUES
  (5, 9);
INSERT INTO
  cliente_orden
VALUES
  (4, 10);
INSERT INTO
  cliente_orden
VALUES
  (6, 11);
INSERT INTO
  cliente_orden
VALUES
  (1, 12);
INSERT INTO
  cliente_orden
VALUES
  (2, 13);
INSERT INTO
  cliente_orden
VALUES
  (10, 14);
INSERT INTO
  cliente_orden
VALUES
  (3, 15);
---------------------------------------------Tipos de viaje-------------------------------------------------
INSERT INTO
  tipoViajeAutobus
VALUES
  (1, 'VIAJE CORTO'),
  (2, 'VIAJE MEDIO'),
  (3, 'VIAJE LARGO'),
  (4, 'N.A');
INSERT INTO
  tipoViajeAvion
VALUES
  (1, 'VUELO NACIONAL'),
  (2, 'VUELO INTERNACIONAL'),
  (3, 'VUELVO INTERCONTINENTAL'),
  (4, 'N.A');
----------------------------------------------Viaje--------------------------------------------------------
INSERT INTO
  viaje
VALUES
  (
    1,
    'Ciudad de México',
    'Berlín',
    22000.0,
    '1996-03-08',
    1,
    4,
    3
  );
INSERT INTO
  viaje
VALUES
  (
    2,
    'Monterrey',
    'Yucatán',
    900.0,
    '2010-01-27',
    3,
    3,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    3,
    'Ciudad de México',
    'Veracruz',
    400.0,
    '2011-04-30',
    1,
    2,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    4,
    'Guadalajara',
    'Los Ángeles',
    15000.0,
    '2012-11-27',
    2,
    4,
    2
  );
INSERT INTO
  viaje
VALUES
  (
    5,
    'Monterrey',
    'Chihuahua',
    600.0,
    '2013-03-14',
    3,
    2,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    6,
    'Ciudad de México',
    'Quintana Roo',
    2900.0,
    '2015-12-20',
    1,
    4,
    1
  );
INSERT INTO
  viaje
VALUES
  (
    7,
    'Monterrey',
    'Bogotá',
    6700.0,
    '2014-11-10',
    3,
    4,
    2
  );
INSERT INTO
  viaje
VALUES
  (
    8,
    'Guadalajara',
    'Oaxaca',
    900.0,
    '2014-07-28',
    2,
    2,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    9,
    'Monterrey',
    'Colima',
    800.0,
    '2016-06-03',
    3,
    2,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    10,
    'Ciudad de México',
    'Campeche',
    1500.0,
    '2017-10-21',
    1,
    3,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    11,
    'Monterrey',
    'Veracruz',
    1200.0,
    '2018-07-07',
    3,
    3,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    12,
    'Ciudad de México',
    'Guerrero',
    1000.0,
    '2018-05-02',
    1,
    2,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    13,
    'Ciudad de México',
    'Chihuahua',
    2200.0,
    '2019-06-27',
    1,
    4,
    1
  );
INSERT INTO
  viaje
VALUES
  (
    14,
    'Guadalaja',
    'Yucatán',
    2500.0,
    '2020-09-15',
    2,
    4,
    1
  );
INSERT INTO
  viaje
VALUES
  (
    15,
    'Ciudad de México',
    'Boston',
    22000.0,
    '2020-10-07',
    1,
    4,
    2
  );
INSERT INTO
  viaje
VALUES
  (
    16,
    'Ciudad de México',
    'Bora Bora',
    45000.0,
    '2022-12-23',
    1,
    4,
    3
  );
INSERT INTO
  viaje
VALUES
  (
    17,
    'Guadalajara',
    'Miami',
    15000.0,
    '2022-12-28',
    2,
    4,
    2
  );
INSERT INTO
  viaje
VALUES
  (
    18,
    'Monterrey',
    'Vancouver',
    18000.0,
    '2023-01-05',
    3,
    4,
    2
  );
INSERT INTO
  viaje
VALUES
  (
    19,
    'Ciudad de México',
    'Cuernavaca',
    700.0,
    '2023-01-20',
    1,
    1,
    4
  );
INSERT INTO
  viaje
VALUES
  (
    20,
    'Guadalajara',
    'Puerto Vallarta',
    500.0,
    '2023-02-12',
    2,
    1,
    4
  );
----------------------------------------------Transportes------------------------------------------------
INSERT INTO
  transporte (
    tipoTransporte,
    marca,
    modelo,
    capacidadUsuarios,
    capacidadCombustible,
    fechaAdquisicion,
    numeroLlantas,
    estacionamientoAsignado
  )
VALUES
  (
    'Autobús',
    'Mercedes Benz',
    'Zafiro',
    40,
    65,
    '2014-05-19',
    6,
    'Estacionamiento 2'
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
    estacionamientoAsignado
  )
VALUES
  (
    'Autobús',
    'Volvo',
    '9800',
    55,
    80,
    '2019-10-09',
    10,
    'Estacionamiento 3'
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
    estacionamientoAsignado
  )
VALUES
  (
    'Autobús',
    'Volvo',
    'Access',
    50,
    70,
    '2018-11-10',
    4,
    'Estacionamiento 4'
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
    estacionamientoAsignado
  )
VALUES
  (
    'Autobús',
    'Volvo',
    '9700 US/CAN',
    70,
    150,
    '2022-08-03',
    10,
    'Estacionamiento 5'
  );
INSERT INTO
  transporte (
    tipoTransporte,
    marca,
    modelo,
    capacidadUsuarios,
    capacidadCombustible,
    fechaAdquisicion,
    numeroTurbinas,
    puertoAsignado
  )
VALUES
  (
    'Avión',
    'Boeing',
    '747',
    190,
    120,
    '2015-12-24',
    4,
    'Puerto 1'
  );
INSERT INTO
  transporte (
    tipoTransporte,
    marca,
    modelo,
    capacidadUsuarios,
    capacidadCombustible,
    fechaAdquisicion,
    numeroTurbinas,
    puertoAsignado
  )
VALUES
  (
    'Avión',
    'Boeing',
    '777',
    300,
    180,
    '2017-08-03',
    2,
    'Puerto 2'
  );
INSERT INTO
  transporte (
    tipoTransporte,
    marca,
    modelo,
    capacidadUsuarios,
    capacidadCombustible,
    fechaAdquisicion,
    numeroTurbinas,
    puertoAsignado
  )
VALUES
  (
    'Avión',
    'Boeing',
    '737',
    180,
    150,
    '2009-05-24',
    2,
    'Puerto 3'
  );
INSERT INTO
  transporte (
    tipoTransporte,
    marca,
    modelo,
    capacidadUsuarios,
    capacidadCombustible,
    fechaAdquisicion,
    numeroTurbinas,
    puertoAsignado
  )
VALUES
  (
    'Avión',
    'Boeing',
    '787 Dreamliner',
    120,
    90,
    '2010-03-12',
    2,
    'Puerto 4'
  );
INSERT INTO
  transporte (
    tipoTransporte,
    marca,
    modelo,
    capacidadUsuarios,
    capacidadCombustible,
    fechaAdquisicion,
    numeroTurbinas,
    puertoAsignado
  )
VALUES
  (
    'Avión',
    'Airbus',
    'A320',
    100,
    140,
    '2012-01-01',
    2,
    'Puerto 5'
  );