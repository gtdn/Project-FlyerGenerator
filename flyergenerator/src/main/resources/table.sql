CREATE TABLE UTILISATEUR
(
  ID_UTILISATEUR INTEGER PRIMARY KEY,
  PSEUDO VARCHAR(255) NOT NULL,
  MOT_DE_PASSE VARCHAR(255) NOT NULL
);

DROP TABLE EVENT;
CREATE TABLE EVENT
(
  ID_EVENT INTEGER,
  ID_UTILISATEUR INTEGER REFERENCES UTILISATEUR (ID_UTILISATEUR),
  NOM VARCHAR(255) NOT NULL,
  PATH_IMG_BACK VARCHAR(255),
  LIEU VARCHAR(255) NOT NULL,
  PRIX INTEGER,
  HEUREDEB TIME NOT NULL, 
  HEUREDEF TIME,
  DATEDEB DATE NOT NULL,
  DATEDEF DATE,
  PRIMARY KEY (ID_EVENT)
);
/*
CREATE TABLE EVENT
(
  ID_EVENT INTEGER,
  ID_UTILISATEUR INTEGER REFERENCES UTILISATEUR (ID_UTILISATEUR),
  NOM VARCHAR(255) NOT NULL,
  PATH_IMG_BACK VARCHAR(255),
  LIEU VARCHAR(255) NOT NULL,
  PRIX INTEGER,
  HEUREDEB INT NOT NULL, 
  HEUREDEF INT,
  DATEDEB INT NOT NULL,
  DATEDEF INT,
  PRIMARY KEY (ID_EVENT)

CREATE TABLE SPECTACLE
(
  ID_SPECT INTEGER,
  ID_EVENT INTEGER,
  NOM_ASSO VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID_SPECT, ID_EVENT),  
  FOREIGN KEY (ID_EVENT) REFERENCES EVENT (ID_EVENT)
);

CREATE TABLE COMPETITION
(
  ID_COMPET INTEGER,
  ID_EVENT INTEGER,
  HASHTAG VARCHAR(255) NOT NULL,
  NOM_ORGA VARCHAR(255) NOT NULL,
  RESUME VARCHAR(255) NOT NULL,
  CASH_PRICE VARCHAR(255),
  PRIMARY KEY (ID_COMPET, ID_EVENT),  
  FOREIGN KEY (ID_EVENT) REFERENCES EVENT (ID_EVENT)
);

CREATE TABLE CONFERENCE
(
  ID_CONF INTEGER,
  ID_EVENT INTEGER,
  RESUME VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID_CONF, ID_EVENT),
  FOREIGN KEY (ID_EVENT) REFERENCES EVENT (ID_EVENT)
);

CREATE TABLE EXPOSITION
(
  ID_EXPO INTEGER,
  ID_EVENT INTEGER,
  THEME VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID_EXPO, ID_EVENT),  
  FOREIGN KEY (ID_EVENT) REFERENCES EVENT (ID_EVENT)
);

CREATE TABLE PERSONNE
(
  ID_PERSONNE INTEGER,
  ID_EVENT INTEGER,
  NOM VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID_PERSONNE, ID_EVENT, NOM),
  FOREIGN KEY (ID_EVENT) REFERENCES EVENT(ID_EVENT)
);
);
*/
CREATE TABLE INTERVENANT
(
  NOM VARCHAR(255) NOT NULL,
  ID_EVENT INTEGER NOT NULL,
  PRIMARY KEY (NOM),
  FOREIGN KEY (ID_EVENT) REFERENCES EVENT(ID_EVENT)
);

CREATE TABLE CONTACT
(
  ID_CONTACT INTEGER,
  NOM VARCHAR(255),
  NUMERO INTEGER,
  MAIL VARCHAR(255),
  PRIMARY KEY (ID_CONTACT)
);

DROP TABLE SPECTACLE;
CREATE TABLE SPECTACLE
(
  ID_EVENT INTEGER,
  ID_UTILISATEUR INTEGER REFERENCES UTILISATEUR (ID_UTILISATEUR),
  NOM VARCHAR(255) NOT NULL,
  PATH_IMG_BACK VARCHAR(255),
  LIEU VARCHAR(255) NOT NULL,
  PRIX INTEGER,
  HEUREDEB TIME NOT NULL, 
  HEUREDEF TIME,
  DATEDEB DATE NOT NULL,
  DATEDEF DATE,
  NOM_ASSO VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID_EVENT)
);

DROP TABLE COMPETITION;
CREATE TABLE COMPETITION
(
  ID_EVENT INTEGER,
  ID_UTILISATEUR INTEGER REFERENCES UTILISATEUR (ID_UTILISATEUR),
  NOM VARCHAR(255) NOT NULL,
  PATH_IMG_BACK VARCHAR(255),
  LIEU VARCHAR(255) NOT NULL,
  PRIX INTEGER,
  HEUREDEB TIME NOT NULL, 
  HEUREDEF TIME,
  DATEDEB DATE NOT NULL,
  DATEDEF DATE,
  HASHTAG VARCHAR(255) NOT NULL,
  NOM_ORGA VARCHAR(255) NOT NULL,
  RESUME VARCHAR(255) NOT NULL,
  CASH_PRICE VARCHAR(255),
  PRIMARY KEY (ID_EVENT)
);
DROP TABLE CONFERENCE;
CREATE TABLE CONFERENCE
(
  ID_EVENT INTEGER,
  RESUMEE VARCHAR(255) NOT NULL,
  ID_UTILISATEUR INTEGER REFERENCES UTILISATEUR (ID_UTILISATEUR),
  NOM VARCHAR(255) NOT NULL,
  PATH_IMG_BACK VARCHAR(255),
  LIEU VARCHAR(255) NOT NULL,
  PRIX INTEGER,
  HEUREDEB TIME NOT NULL, 
  HEUREDEF TIME,
  DATEDEB DATE NOT NULL,
  DATEDEF DATE,
  PRIMARY KEY (ID_EVENT)
);

DROP TABLE EXPOSITION;
CREATE TABLE EXPOSITION
(
  ID_EVENT INTEGER,
  ID_UTILISATEUR INTEGER REFERENCES UTILISATEUR (ID_UTILISATEUR),
  NOM VARCHAR(255) NOT NULL,
  PATH_IMG_BACK VARCHAR(255),
  LIEU VARCHAR(255) NOT NULL,
  PRIX INTEGER,
  HEUREDEB TIME NOT NULL, 
  HEUREDEF TIME,
  DATEDEB DATE NOT NULL,
  DATEDEF DATE,
  THEME VARCHAR(255) NOT NULL,
  PRIMARY KEY ( ID_EVENT)
);
