DROP TABLE IF EXISTS EMP;
CREATE TABLE EMP (
  ID INTEGER NOT NULL,
  NAME VARCHAR(255),
  S_DATE DATE,
  D_RATE INTEGER,
  TERM INTEGER,
  VACATION INTEGER,
  H_RATE FLOAT,
  SALARY BIGINT,
  PENSION BIGINT,
  EMP_TYPE VARCHAR(32),
  PRIMARY KEY (ID)
);
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    1,
    'OSCAR',
    { d '2001-01-01' },
    500,
    12,
    NULL,
    NULL,
    NULL,
    NULL,
    'ContractEmployee'
  );
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    2,
    'PAULA',
    { d '2002-04-08' },
    600,
    24,
    NULL,
    NULL,
    NULL,
    NULL,
    'ContractEmployee'
  );
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    3,
    'NADIA',
    { d '2003-06-10' },
    700,
    18,
    NULL,
    NULL,
    NULL,
    NULL,
    'ContractEmployee'
  );
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    4,
    'MARCO',
    { d '2004-07-01' },
    NULL,
    NULL,
    15,
    NULL,
    55000,
    100000,
    'FTEmp'
  );
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    5,
    'JUAN',
    { d '2003-09-09' },
    NULL,
    NULL,
    15,
    NULL,
    59000,
    200000,
    'FTEmp'
  );
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    6,
    'SAMANTA',
    { d '2000-03-12' },
    NULL,
    NULL,
    20,
    NULL,
    60000,
    450000,
    'FTEmp'
  );
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    7,
    'MARTHA',
    { d '2004-11-01' },
    NULL,
    NULL,
    15,
    17.0,
    NULL,
    NULL,
    'PTEmp'
  );
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    8,
    'RAUL',
    { d '2005-12-05' },
    NULL,
    NULL,
    15,
    16.0,
    NULL,
    NULL,
    'PTEmp'
  );
INSERT INTO
  EMP (
    ID,
    NAME,
    S_DATE,
    D_RATE,
    TERM,
    VACATION,
    H_RATE,
    SALARY,
    PENSION,
    EMP_TYPE
  )
VALUES
  (
    9,
    'JAZMIN',
    { d '2006-01-03' },
    NULL,
    NULL,
    10,
    15.0,
    NULL,
    NULL,
    'PTEmp'
  );
select
  *
from
  EMP;