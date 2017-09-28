CREATE TABLE fest.bruker
(
  brukernavn character varying(50) NOT NULL,
  etternavn character varying(50) NOT NULL,
  kjonn character varying(50) NOT NULL,
  telefonnummer character varying(8) NOT NULL,
  betalingsstatus BOOLEAN,
  primary key (telefonnummer)
)
