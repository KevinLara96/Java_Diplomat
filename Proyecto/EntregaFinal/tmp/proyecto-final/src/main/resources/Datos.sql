use proyecto_final;
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
VALUES
  (
    3,
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
    'Compra de 2 boletos de avión de la Ciudad de México a ... por medio de pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1995-01-27',
    3400.0,
    'Compra tres boletos de avión de Monterrey a Yucatán, pago en efectivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1990-04-30',
    1500.0,
    'Compra un boleto de autobús de la Ciudad de México a Veracruz, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1998-11-27',
    5800.0,
    'Compra 3 boletos de avión de Guadalajara a Los Ángeles , pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1994-03-14',
    1400.0,
    'Compra un boleto autobús de Monterrey a Chihuahua, pago en efetivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1989-12-20',
    4500.0,
    'Compra dos boletos de avión de Ciudad de México a Quintana Roo, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1991-10-11',
    8500.0,
    'Compra dos boletos de avión de Monterrey a Bogotá, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1995-07-28',
    2400.0,
    'Compra dos boletos de autobús de Guadalajara a Oaxaca , pago en efectivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1988-03-06',
    3500.0,
    'Compra tres boletos de autobús de Monterrey a Colima, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1997-10-21',
    1400.0,
    'Compra un boleto de autobús de Ciudad de México a Campeche, pago en efectivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1994-07-07',
    2800.0,
    'Compra dos boletos de autobús de Monterrey a Veracruz, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1997-02-05',
    2500.0,
    'Compra dos boletos de autobús de Ciudad de México a Guerrero, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1985-06-27',
    1800.0,
    'Compra un boleto de avión de Ciudad de México a Chihuahua, pago en efectivo'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1999-09-15',
    3500.0,
    'Compra tres boletos de avión de Guadalajara a Yucatán, pago con tarjeta'
  );
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1993-07-04',
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