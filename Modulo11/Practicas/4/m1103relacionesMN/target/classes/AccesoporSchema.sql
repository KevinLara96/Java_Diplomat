-- Acceso por Schema
CREATE DATABASE modulo11RH;
CREATE TABLE modulo11RH.RH_Employee (
  id INTEGER NOT NULL,
  name VARCHAR(255),
  salary BIGINT,
  PRIMARY KEY (id)
);
INSERT INTO
  modulo11RH.RH_Employee
VALUES
  ('1', 'Oscar', '1000');
INSERT INTO
  modulo11RH.RH_Employee
VALUES
  ('2', 'Paula', '2000');
INSERT INTO
  modulo11RH.RH_Employee
VALUES
  ('3', 'Nadia', '3000');
DROP TABLE if exists Employee;
CREATE TABLE Employee (
    ID INTEGER NOT NULL,
    PHONE VARCHAR(255),
    NAME VARCHAR(255),
    SALARY BIGINT,
    PRIMARY KEY (ID)
  );
INSERT INTO
  Employee
VALUES
  ('100', '667788', 'Oscar', '1000');
INSERT INTO
  Employee
VALUES
  ('200', '778899', 'Paula', '2000');
INSERT INTO
  Employee
VALUES
  ('300', '998877', 'Nadia', '3000');