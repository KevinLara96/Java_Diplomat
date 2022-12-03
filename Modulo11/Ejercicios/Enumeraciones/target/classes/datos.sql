use modulo11;
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
INSERT INTO
  agencia
VALUES
  (2, 'Agencia 2', 'Guadalajara'),
  (3, 'Agencia 3', 'Monterrey');
insert into
  viajes
VALUES
  (
    1,
    'Ciudad de México',
    'Cuernavaca',
    500.0,
    '24/Dic/2022',
    1,
    1
  ),
  (
    2,
    'Ciudad de México',
    'Guadalajara',
    750.0,
    '25/Dic/2022',
    1,
    2
  ),
  (
    3,
    'Ciudad de México',
    'Monterrey',
    1500.0,
    '26/Dic/2022',
    1,
    3
  ),
  (
    4,
    'Monterrey',
    'Tijuana',
    600.0,
    '28/Dic/2022',
    3,
    2
  ),
  (
    5,
    'Guadalajara',
    'Sinaloa',
    500.0,
    '01/Ene/2023',
    2,
    2
  )