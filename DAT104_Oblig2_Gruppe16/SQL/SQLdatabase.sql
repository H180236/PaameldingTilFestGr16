CREATE SCHEMA IF NOT EXISTS fest;


SET search_path TO fest;

DROP TABLE IF EXISTS deltaker;

CREATE DOMAIN  gender CHAR(1)
   CHECK (value IN ( 'F' , 'M' ) );
   
CREATE TABLE fest.deltaker (
  fornavn character varying(20) NOT NULL,
  etternavn character varying(20) NOT NULL,
  kjonn fest.gender NOT NULL,
  telefonnummer character(8) NOT NULL,
  betalingsstatus BOOLEAN,
  kasserer BOOLEAN,
  primary key (telefonnummer)
);

--