package fr.efrei.projetTAN.utils;

public class CandidatureConst {
    //Requêtes JPQL
    public static final String SELECT_TOUTES_CANDIDATURES = "SELECT c FROM CandidatureEntity c";
    public static final String SELECT_CANDIDATURE_PAR_ID = "SELECT c FROM CandidatureEntity c WHERE c.idCandidature = :id";
    public static final String SELECT_CANDIDATURE_PAR_IDENSEIGNANT = "SELECT c FROM CandidatureEntity c WHERE c.idEnseignant = :id";
    public static final String SELECT_CANDIDATURE_PAR_IDPOSTE = "SELECT c FROM CandidatureEntity c WHERE c.idPoste = :id";

}
