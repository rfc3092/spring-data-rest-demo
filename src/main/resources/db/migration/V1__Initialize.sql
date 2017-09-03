CREATE TABLE author (
  id            NUMBER(11) PRIMARY KEY,
  first_name    VARCHAR2(100) NOT NULL,
  last_name     VARCHAR2(100) NOT NULL,
  date_of_birth DATE          NOT NULL,
  date_of_death DATE
);

CREATE TABLE book (
  id        NUMBER(11) PRIMARY KEY,
  author_id NUMBER(11)    NOT NULL,
  title     VARCHAR2(100) NOT NULL,
  CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author (id)
);