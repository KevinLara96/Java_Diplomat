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
insert into
  viaje
VALUES
  (
    1,
    'Ciudad de México',
    'Cuernavaca',
    500.0,
    '24/Dic/2022',
    1,
    'Viaje Corto'
  ),
  (
    2,
    'Ciudad de México',
    'Guadalajara',
    750.0,
    '25/Dic/2022',
    1,
    'Viaje Medio'
  ),
  (
    3,
    'Ciudad de México',
    'Monterrey',
    1500.0,
    '26/Dic/2022',
    1,
    'Viaje Largo'
  ),
  (
    4,
    'Monterrey',
    'Tijuana',
    600.0,
    '28/Dic/2022',
    3,
    'Viaje Medio'
  ),
  (
    5,
    'Guadalajara',
    'Sinaloa',
    500.0,
    '01/Ene/2023',
    2,
    'Viaje Largo'
  )