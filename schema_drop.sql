DROP TABLE benutzerrolle CASCADE constraints;
DROP TABLE benutzer CASCADE constraints;
DROP TABLE sitzung CASCADE constraints;
DROP TABLE modul CASCADE constraints;
DROP TABLE mcfrage CASCADE constraints;
DROP TABLE mcantwort CASCADE constraints;
DROP TABLE mcloesung CASCADE constraints;
DROP TABLE badge CASCADE constraints;

DROP TRIGGER mcfrage_trigger;
DROP TRIGGER modul_trigger;
DROP TRIGGER mcantwort_trigger;

DROP SEQUENCE user_id_sequence;
DROP SEQUENCE mcfrage_id_sequence;
DROP SEQUENCE modul_id_sequence;
DROP SEQUENCE rolle_id_sequence;
DROP SEQUENCE badge_id_sequence;
