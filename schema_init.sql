CREATE TABLE benutzer
(
user_id int PRIMARY KEY,
benutzerkennung varchar(255) UNIQUE NOT NULL,
email varchar(255),
benutzer_name varchar(255),
benutzer_vorname varchar(255),
nutzerrolle int REFERENCES benutzerrolle(rolle_id)
);

CREATE TABLE benutzerrolle
(
rolle_id int PRIMARY KEY,
rolle_name varchar(255)
);

CREATE TABLE modul
(
modul_id int PRIMARY KEY,
modul_bezeichnung varchar(255) UNIQUE NOT NULL,
modul_studiengang varchar(255)

);

CREATE TABLE mcfrage
(
frage_id int PRIMARY KEY,
fragestellung varchar(255),
schwierigkeit int,
modul_id int REFERENCES modul(modul_id)
);

CREATE TABLE mcantwort
(
antwort_id int PRIMARY KEY,
frage_id int REFERENCES mcfrage(frage_id),
antwort varchar(255),
korrekt number(1) CHECK (korrekt in (0, 1)) /* boolean hack because oracle */
);

CREATE TABLE mcloesung
(
frage_id int REFERENCES mcfrage(frage_id),
antwort_id int REFERENCES mcantwort(antwort_id),
sitzung_id int REFERENCES sitzung(sitzung_id)
);

CREATE TABLE sitzung
(
sitzung_id int PRIMARY KEY
);

CREATE TABLE badge
(
badge_id int PRIMARY KEY,
badge_name varchar(255)
/* badge_icon_path varchar(255) /* at first, you may enter junk for mocking purposes  */
);

CREATE SEQUENCE user_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 

CREATE SEQUENCE frage_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 

CREATE SEQUENCE modul_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 

CREATE SEQUENCE rolle_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 

CREATE SEQUENCE badge_id_sequence
START WITH 1
INCREMENT BY 1 
nomaxvalue; 