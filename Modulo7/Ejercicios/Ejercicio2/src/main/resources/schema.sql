USE modulo07;
DROP TABLE IF EXISTS Automoviles;
CREATE Table Automoviles (
  id_automovil INT NOT NULL,
  marca VARCHAR(30) NOT NULL,
  modelo VARCHAR(20) NOT NULL,
  color VARCHAR(15) NOT NULL,
  torque INT NOT NULL,
  potencia INT NOT NULL,
  CONSTRAINT Automoviles_PK PRIMARY KEY (id_automovil)
);