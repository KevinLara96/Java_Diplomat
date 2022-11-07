use dgtic;
truncate table estudiante_materia;
delete from
  usuarios;
delete from
  autorizacion;
delete from
  materias;
delete from
  estudiantes;
insert into
  estudiantes(cuenta_etd, nombre, edad)
values('A00', 'Rosa', 19);
insert into
  estudiantes(cuenta_etd, nombre, edad)
values('A01', 'Pedro', 22);
insert into
  estudiantes(cuenta_etd, nombre, edad)
values('A02', 'Samuel', 19);
insert into
  estudiantes(cuenta_etd, nombre, edad)
values('A03', 'Sara', 21);
:x
insert into
  estudiantes(cuenta_etd, nombre, edad)
values('A04', 'Alfredo', 24);
alter table
  materias auto_increment = 1;
insert into
  materias(nombre, creditos)
values('L�gica', 9);
insert into
  materias(nombre, creditos)
values('Programaci�n', 10);
insert into
  materias(nombre, creditos)
values('Circuitos l�gicos', 9);
insert into
  materias(nombre, creditos)
values('Estructura de Datos', 9);
insert into
  materias(nombre, creditos)
values('Spring', 10);
insert into
  materias(nombre, creditos)
values('Dise�o y An�lisis de Algoritmos', 9);
insert into
  estudiante_materia value('A00', 2);
insert into
  estudiante_materia value('A01', 1);
insert into
  estudiante_materia value('A01', 2);
insert into
  estudiante_materia value('A01', 5);
insert into
  estudiante_materia value('A02', 1);
insert into
  estudiante_materia value('A02', 2);
insert into
  estudiante_materia value('A03', 3);
insert into
  estudiante_materia value('A03', 4);
insert into
  estudiante_materia value('A04', 5);
insert into
  usuarios(usuario_usa, clave, alta)
values(
    'dgtic',
    '$2a$10$5OPg9MiA6NsHLqqso2KsOeJonhpkAc4iNTzwNCi1BbyvqkoycXO6',
    1
  );
insert into
  usuarios(usuario_usa, clave, alta)
values(
    'usuario',
    '$2a$10$FqCXhbXkUuYsBF.Y9zcNNuYtyxjuVtft3AqVnZxhYmDn8opw0G3Pu',
    1
  );
insert into
  autorizacion(usuario_usa, rol)
values('dgtic', 'admin');
insert into
  autorizacion(usuario_usa, rol)
values('usuario', 'user');