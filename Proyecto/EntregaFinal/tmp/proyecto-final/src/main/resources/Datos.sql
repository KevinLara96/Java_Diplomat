use proyecto_final;
INSERT INTO
  agencia
VALUES
  (1, 'Agencia 1', 'CDMX');
INSERT INTO
  agencia
VALUES
  (2, 'Agencia 2', 'Guadalajara');
INSERT INTO
  agencia
VALUES
  (3, 'Agencia 3', 'Monterrey');
-- CLIENTES--
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
    '55(5)659-18-850',
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
    '55(5)659-18-850',
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
    'Lomas de Santa Fe, Contadero, Cuajimalpa de Morelos',
    '01219',
    '55(5)413-79-848',
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
    'Col del Mar, Tláhuac',
    '13270',
    ' 55(5)099-36-427',
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
    '55(5)668-49-298',
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
    '55(5)162-71-100',
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
    '55(5)971-73-852',
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
    ' 55(5)124-57-339 ',
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
    '55(5)492-85-864',
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
    '55(5)668-94-346',
    'PAPP960625736',
    'creihellemmuhou-4970@yopmail.com',
    'xC%6h83o7061',
    2
  );
-- Órdenes.. --
INSERT INTO
  orden (fechaEmision, monto, descripcion)
VALUES
  (
    '1996-03-08',
    2400.0,
    'Compra de 2 boletos de avión de la Ciudad de México a ... por medio de pago con tarjeta'
  );