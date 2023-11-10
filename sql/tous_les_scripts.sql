SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO';
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS fait_activite;
DROP TABLE IF EXISTS Activite;
DROP TABLE IF EXISTS est_interesse;
DROP TABLE IF EXISTS Interet;
DROP TABLE IF EXISTS Etude;
DROP TABLE IF EXISTS compt_lie_xp;
DROP TABLE IF EXISTS Experience;
DROP TABLE IF EXISTS requiert_compt;
DROP TABLE IF EXISTS Competence;
DROP TABLE IF EXISTS Candidature;
DROP TABLE IF EXISTS Enseignant;
DROP TABLE IF EXISTS contient_contrainte;
DROP TABLE IF EXISTS Contrainte;
DROP TABLE IF EXISTS contient_remarque;
DROP TABLE IF EXISTS Remarque;
DROP TABLE IF EXISTS Poste;
DROP TABLE IF EXISTS Niveau_etudiant;
DROP TABLE IF EXISTS Recruteur;
DROP TABLE IF EXISTS Ecole;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE Ecole(
   ID_Ecole INT NOT NULL AUTO_INCREMENT,
   Raison_sociale VARCHAR(50),
   PRIMARY KEY(ID_Ecole)
);

CREATE TABLE Competence(
   ID_Competence INT NOT NULL AUTO_INCREMENT,
   Nom VARCHAR(50),
   niveau VARCHAR(50),
   PRIMARY KEY(ID_Competence)
);

CREATE TABLE Contrainte(
   ID_Contrainte INT NOT NULL AUTO_INCREMENT,
   Contrainte VARCHAR(50),
   PRIMARY KEY(ID_Contrainte)
);

CREATE TABLE Niveau_etudiant(
   ID_NivEtudiant INT NOT NULL AUTO_INCREMENT,
   Niveau VARCHAR(50),
   PRIMARY KEY(ID_NivEtudiant)
);

CREATE TABLE Activite(
   ID_Activite INT NOT NULL AUTO_INCREMENT,
   Activite VARCHAR(50) NOT NULL,
   PRIMARY KEY(ID_Activite)
);

CREATE TABLE Interet(
   ID_Interet INT NOT NULL AUTO_INCREMENT,
   Interet VARCHAR(50) NOT NULL,
   PRIMARY KEY(ID_Interet)
);

CREATE TABLE Recruteur(
   ID_recruteur INT NOT NULL AUTO_INCREMENT,
   Nom VARCHAR(50),
   Prenom VARCHAR(50),
   PRIMARY KEY(ID_recruteur)
);

CREATE TABLE Remarque(
   ID_Remarque INT NOT NULL AUTO_INCREMENT,
   Remarque VARCHAR(50),
   PRIMARY KEY(ID_Remarque)
);

CREATE TABLE Enseignant(
   IDenseignant INT NOT NULL AUTO_INCREMENT,
   Nom VARCHAR(50) NOT NULL,
   Prenom VARCHAR(50) NOT NULL,
   Mail VARCHAR(50),
   Telephone VARCHAR(50),
   Site_web VARCHAR(50),
   ID_NivEtudiant INT,
   ID_recruteur INT,
   ID_Ecole INT,
   PRIMARY KEY(IDenseignant),
   FOREIGN KEY(ID_NivEtudiant) REFERENCES Niveau_etudiant(ID_NivEtudiant),
   FOREIGN KEY(ID_recruteur) REFERENCES Recruteur(ID_recruteur),
   FOREIGN KEY(ID_Ecole) REFERENCES Ecole(ID_Ecole)
);

CREATE TABLE Experience(
   IDexperience INT NOT NULL AUTO_INCREMENT,
   Ecole VARCHAR(50),
   Eval_ecole VARCHAR(50),
   Duree VARCHAR(50),
   IDenseignant INT NOT NULL,
   PRIMARY KEY(IDexperience),
   FOREIGN KEY(IDenseignant) REFERENCES Enseignant(IDenseignant)
);

CREATE TABLE Etude(
   ID_Etude INT NOT NULL AUTO_INCREMENT,
   Titre VARCHAR(50),
   Date_obtention DATE,
   IDenseignant INT NOT NULL,
   PRIMARY KEY(ID_Etude),
   FOREIGN KEY(IDenseignant) REFERENCES Enseignant(IDenseignant)
);

CREATE TABLE Poste(
   ID_Poste INT NOT NULL AUTO_INCREMENT,
   Nom VARCHAR(50),
   Type_contrat VARCHAR(50),
   Periode VARCHAR(50),
   ID_recruteur INT NOT NULL,
   ID_NivEtudiant INT NOT NULL,
   ID_Ecole INT NOT NULL,
   PRIMARY KEY(ID_Poste),
   FOREIGN KEY(ID_recruteur) REFERENCES Recruteur(ID_recruteur),
   FOREIGN KEY(ID_NivEtudiant) REFERENCES Niveau_etudiant(ID_NivEtudiant),
   FOREIGN KEY(ID_Ecole) REFERENCES Ecole(ID_Ecole)
);

CREATE TABLE Candidature(
   ID_Candidature INT NOT NULL AUTO_INCREMENT,
   Contacte_le DATE,
   Decision VARCHAR(50),
   IDenseignant INT NOT NULL,
   ID_Poste INT NOT NULL,
   PRIMARY KEY(ID_Candidature),
   FOREIGN KEY(IDenseignant) REFERENCES Enseignant(IDenseignant),
   FOREIGN KEY(ID_Poste) REFERENCES Poste(ID_Poste)
);

CREATE TABLE compt_lie_xp(
   IDexperience INT NOT NULL,
   ID_Competence INT NOT NULL,
   PRIMARY KEY(IDexperience, ID_Competence),
   FOREIGN KEY(IDexperience) REFERENCES Experience(IDexperience),
   FOREIGN KEY(ID_Competence) REFERENCES Competence(ID_Competence)
);

CREATE TABLE requiert_compt(
   ID_Poste INT NOT NULL,
   ID_Competence INT NOT NULL,
   PRIMARY KEY(ID_Poste, ID_Competence),
   FOREIGN KEY(ID_Poste) REFERENCES Poste(ID_Poste),
   FOREIGN KEY(ID_Competence) REFERENCES Competence(ID_Competence)
);

CREATE TABLE contient_contrainte(
   ID_Poste INT NOT NULL,
   ID_Contrainte INT NOT NULL,
   PRIMARY KEY(ID_Poste, ID_Contrainte),
   FOREIGN KEY(ID_Poste) REFERENCES Poste(ID_Poste),
   FOREIGN KEY(ID_Contrainte) REFERENCES Contrainte(ID_Contrainte)
);

CREATE TABLE fait_activite(
   IDenseignant INT NOT NULL,
   ID_Activite INT NOT NULL,
   PRIMARY KEY(IDenseignant, ID_Activite),
   FOREIGN KEY(IDenseignant) REFERENCES Enseignant(IDenseignant),
   FOREIGN KEY(ID_Activite) REFERENCES Activite(ID_Activite)
);

CREATE TABLE est_interesse(
   IDenseignant INT NOT NULL,
   ID_Interet INT NOT NULL,
   PRIMARY KEY(IDenseignant, ID_Interet),
   FOREIGN KEY(IDenseignant) REFERENCES Enseignant(IDenseignant),
   FOREIGN KEY(ID_Interet) REFERENCES Interet(ID_Interet)
);

CREATE TABLE Contient_remarque(
   ID_Poste INT NOT NULL,
   ID_Remarque INT NOT NULL,
   PRIMARY KEY(ID_Poste, ID_Remarque),
   FOREIGN KEY(ID_Poste) REFERENCES Poste(ID_Poste),
   FOREIGN KEY(ID_Remarque) REFERENCES Remarque(ID_Remarque)
);


INSERT INTO Ecole (ID_Ecole, Raison_sociale) VALUES
  (1, 'Ecole d''Ingénieurs A'),
  (2, 'Institut Technologique B'),
  (3, 'Université Technique C'),
  (4, 'Institut Polytechnique D'),
  (5, 'Ecole d''Ingénieurs E');

INSERT INTO Competence (ID_Competence, Nom, niveau) VALUES
  (1, 'Informatique', 'Confirme'),
  (2, 'Électronique', 'Intermediaire'),
  (3, 'Génie Civil', 'Expert'),
  (4, 'Biotechnologie', 'Debutant');
  
INSERT INTO Contrainte (ID_Contrainte, Contrainte) VALUES
  (1, 'Cours 100% en visio'),
  (2, 'Au moins 10 ans d''expérience'),
  (3, 'Intérim pour remplacer un professeur permanent'),
  (4, 'Période de vacances scolaires');

INSERT INTO Niveau_etudiant (ID_NivEtudiant, Niveau) VALUES
  (1, 'L3'),
  (2, 'M1'),
  (3, 'M2');

INSERT INTO Activite (ID_Activite, Activite) VALUES
  (1, 'Conférencier'),
  (2, 'Auteur d''articles scientifiques'),
  (3, 'Chef de projet étudiant'),
  (4, 'Membre de club d''informatique');

INSERT INTO Interet (ID_Interet, Interet) VALUES
  (1, 'Kayak'),
  (2, 'Magie'),
  (3, 'Taxidermie'),
  (4, 'Ping pong'),
  (5, 'Cinéma'),
  (6, 'Jardinage'),
  (7, 'Photographie'),
  (8, 'Échecs');

INSERT INTO Recruteur (ID_recruteur, Nom, Prenom) VALUES
  (1, 'Dampierre', 'Marie'),
  (2, 'Dupont', 'Anne'),
  (3, 'Boulanger', 'Sébastien');
  
INSERT INTO Remarque (ID_Remarque, Remarque) VALUES
(1, 'Cours du soir'),
(2, 'Remplacement'),
(3, 'Temps plein'),
(4, 'Mi-temps');

INSERT INTO Enseignant (IDenseignant, Nom, Prenom, Mail, Telephone, Site_web, ID_NivEtudiant, ID_recruteur, ID_Ecole) VALUES
  (1, 'Dupont', 'Jean-Pierre', 'jp.dupont@example.com', '+33777777777', '', 1, 1, NULL),
  (2, 'Martin', 'Marie', 'marie.martin@example.com', '+33666666666', 'www.mariemartin.com', 2, 2, NULL),
  (3, 'Leclerc', 'Pierre', 'pierre.leclerc@example.com', '+33555555555', 'www.pierreleclerc.com', 1, NULL, 1),
  (4, 'Dubois', 'Isabelle', 'isabelle.dubois@example.com', '+33444444444', 'www.isabelledubois.com', 3, NULL, 2);

INSERT INTO Experience (IDexperience, Ecole, Eval_ecole, Duree, IDenseignant) VALUES
  (1, 'Ecole d''Ingénieurs A', 'Bonne', '3 ans', 1),
  (2, 'Institut Technologique B', 'Moyenne', '2 ans', 2),
  (3, 'Université Technique C', 'Très bonne', '6 ans', 3),
  (4, 'Institut Polytechnique D', 'Excellente', '5 ans', 4);

INSERT INTO Etude (ID_Etude, Titre, Date_obtention, IDenseignant) VALUES
  (1, 'Licence en Informatique', '2010-05-15', 1),
  (2, 'Masters en Génie Électrique', '2012-12-20', 2),
  (3, 'Doctorat en Génie Civil', '2002-08-10', 3),
  (4, 'Baccalauréat en Biotechnologie', '2008-06-30', 4);

INSERT INTO Poste (ID_Poste, Nom, Type_contrat, Periode, ID_recruteur, ID_NivEtudiant, ID_Ecole) VALUES
  (1, 'Enseignant d''Informatique', 'CDI', '1 an', 1,  1, 1),
  (2, 'Professeur d''Électronique', 'CDD', '1 semestre', 1, 2, 2),
  (3, 'Chargé de cours en Génie Civil', 'CDI', '2 ans', 1, 3, 3),
  (4, 'Enseignant en Biotechnologie', 'CDD', '6 mois', 1, 1, 4);

INSERT INTO Candidature (ID_Candidature, Contacte_le, Decision, IDenseignant, ID_Poste) VALUES
  (1, '2023-09-01', 'Retenue', 1, 1),
  (2, '2023-09-02', 'En attente', 2, 2),
  (3, '2023-09-03', 'Non retenu', 3, 3),
  (4, '2023-09-04', 'En attente', 4, 4),
  (5, '2023-09-02', 'En attente', 2, 1),
  (6, '2023-09-03', 'En attente', 3, 1);

INSERT INTO compt_lie_xp (IDexperience, ID_Competence) VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4);
  
  INSERT INTO requiert_compt (ID_Poste, ID_Competence) VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4);

INSERT INTO contient_contrainte (ID_Poste, ID_Contrainte) VALUES
  (1, 1),
  (2, 2),
  (3, 3);

INSERT INTO fait_activite (IDenseignant, ID_Activite) VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4);

INSERT INTO est_interesse (IDenseignant, ID_Interet) VALUES
  (1, 1),
  (1, 8),
  (2, 3),
  (2, 7),
  (3, 7),
  (3, 6),
  (4, 5);

INSERT INTO contient_remarque (ID_Poste, ID_Remarque) VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4);