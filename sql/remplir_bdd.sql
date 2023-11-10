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