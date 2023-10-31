package fr.efrei.projetTAN.utils;

public class CandidatureConst {
    //Requêtes JPQL
    public static final String SELECT_TOUTES_CANDIDATURES = "SELECT c FROM CandidatureEntity c";
    public static final String SELECT_CANDIDATURE_PAR_ID = "SELECT c FROM CandidatureEntity c WHERE c.idCandidature = :id";

}
