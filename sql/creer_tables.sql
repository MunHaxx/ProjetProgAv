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
