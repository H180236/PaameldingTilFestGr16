CREATE SCHEMA IF NOT EXISTS fest;

CREATE DOMAIN gender CHAR(1)
    CHECK (value IN ( 'F' , 'M' ) );

CREATE TABLE fest.bruker (
  brukernavn character varying(50) NOT NULL,
  etternavn character varying(50) NOT NULL,
  kjonn fest.gender NOT NULL,
  telefonnummer character varying(8) NOT NULL,
  betalingsstatus BOOLEAN,
  primary key (telefonnummer)
);

