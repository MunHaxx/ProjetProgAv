package fr.efrei.projetTAN.utils.Entity;


public final class EntityConst {
    //Requêtes JPQL
    public static final String SELECT_TOUTES_LES_ACTIVITES = "SELECT a FROM ActiviteEntity a";
    public static final String SELECT_UNE_ACTIVITE = "SELECT a FROM ActiviteEntity a WHERE a.idActivite = :id";
    
    public static final String SELECT_TOUTES_LES_CANDIDATURES = "SELECT c FROM CandidatureEntity c";
    public static final String SELECT_CANDIDATURE_PAR_ID = "SELECT c FROM CandidatureEntity c WHERE c.idCandidature = :id";
    
    public static final String SELECT_TOUTES_LES_COMPETENCES = "SELECT c FROM CompetenceEntity c";
    public static final String SELECT_UNE_COMPETENCE = "SELECT c FROM CompetenceEntity c WHERE c.idCompetence = :id";
    
    public static final String SELECT_TOUTES_LES_CONTRAINTES = "SELECT c FROM ContrainteEntity c";
    public static final String SELECT_UNE_CONTRAINTE = "SELECT c FROM ContrainteEntity c WHERE c.idContrainte = :id";

    public static final String SELECT_TOUTES_LES_ECOLES = "SELECT e FROM EcoleEntity e";
    public static final String SELECT_ECOLE_PAR_ID = "SELECT e FROM EcoleEntity e WHERE e.idEcole = :id";
    public static final String SELECT_ECOLE_PAR_RAISON_SOCIALE = "SELECT e FROM EcoleEntity e WHERE e.raisonSociale = :nom";

    public static final String SELECT_TOUS_LES_ENSEIGNANTS = "SELECT e FROM EnseignantEntity e";
    public static final String SELECT_ENSEIGNANT_PAR_ID = "SELECT e FROM EnseignantEntity e WHERE e.idEnseignant = :id";
    
    public static final String SELECT_TOUTES_LES_ETUDES = "SELECT e FROM EtudeEntity e";
    public static final String SELECT_ETUDE_PAR_ID = "SELECT e FROM EtudeEntity e WHERE e.idEtude = :id";

    public static final String SELECT_TOUTES_LES_EXPERIENCES = "SELECT e FROM ExperienceEntity e";
    public static final String SELECT_EXPERIENCE_PAR_ID = "SELECT e FROM ExperienceEntity e WHERE e.idExperience = :id";

    public static final String SELECT_TOUS_LES_INTERETS = "SELECT i FROM InteretEntity i";
    public static final String SELECT_UN_INTERET = "SELECT i FROM InteretEntity i WHERE i.idInteret = :id";

    public static final String SELECT_TOUS_LES_NIVETUD = "SELECT n FROM NiveauEtudiantEntity n";
    public static final String SELECT_NIVETUD_PAR_ID = "SELECT n FROM NiveauEtudiantEntity n WHERE n.idNivEtud = :id";

    public static final String SELECT_TOUS_LES_POSTES = "SELECT p FROM PosteEntity p";
    public static final String SELECT_POSTE_PAR_ID = "SELECT p FROM PosteEntity p WHERE p.idPoste = :id";

    public static final String SELECT_TOUS_LES_RECRUTEURS = "SELECT r FROM RecruteurEntity r";
    public static final String SELECT_RECRUTEUR_PAR_ID = "SELECT r FROM RecruteurEntity r WHERE r.idRecruteur = :id";

    public static final String SELECT_TOUTES_LES_REMARQUES = "SELECT r FROM RemarqueEntity r";
    public static final String SELECT_REMARQUE_PAR_ID = "SELECT r FROM RemarqueEntity r WHERE r.idRemarque = :id";
}
