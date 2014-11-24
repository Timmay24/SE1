CREATE TABLE benutzerrolle
(
id int PRIMARY KEY,
name varchar(255)
);

CREATE TABLE benutzer
(
id int PRIMARY KEY,
benutzerkennung varchar(255) UNIQUE NOT NULL,
email varchar(255),
name varchar(255),
vorname varchar(255),
nutzerrolle int REFERENCES benutzerrolle(id)
);

CREATE TABLE sitzung
(
id int PRIMARY KEY
);

CREATE TABLE modul
(
id int PRIMARY KEY,
bezeichnung varchar(255) UNIQUE NOT NULL,
studiengang varchar(255)

);

CREATE TABLE mcfrage
(
id int PRIMARY KEY,
fragestellung varchar(255),
schwierigkeit int,
modul_id int REFERENCES modul(id)
);

CREATE TABLE mcantwort
(
id int PRIMARY KEY,
frage_id int REFERENCES mcfrage(id),
antwort varchar(255),
korrekt number(1) CHECK (korrekt in (0, 1)) /* boolean hack because oracle */
);

CREATE TABLE mcloesung
(
frage_id int REFERENCES mcfrage(id),
antwort_id int REFERENCES mcantwort(id),
sitzung_id int REFERENCES sitzung(id)
);


CREATE TABLE badge
(
id int PRIMARY KEY,
badge_name varchar(255)
/* badge_icon_path varchar(255) /* at first, you may enter junk for mocking purposes  */
);

CREATE SEQUENCE user_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 

CREATE SEQUENCE mcfrage_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 

CREATE OR REPLACE TRIGGER mcfrage_trigger
BEFORE INSERT ON mcfrage 
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT mcfrage_id_sequence.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/

CREATE SEQUENCE mcantwort_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue;

CREATE OR REPLACE TRIGGER mcantwort_trigger
BEFORE INSERT ON mcantwort 
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT mcantwort_id_sequence.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/

CREATE SEQUENCE modul_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 

CREATE OR REPLACE TRIGGER modul_trigger 
BEFORE INSERT ON modul
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT modul_id_sequence.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/

CREATE SEQUENCE rolle_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 

CREATE SEQUENCE badge_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue;