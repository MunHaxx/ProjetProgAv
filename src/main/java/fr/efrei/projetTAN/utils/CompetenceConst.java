package fr.efrei.projetTAN.utils;

public final class CompetenceConst {

    //Requêtes JPQL
    public static final String SELECT_TOUTES_LES_COMPETENCES = "SELECT c FROM CompetenceEntity c";
    public static final String SELECT_UNE_COMPETENCE = "SELECT c FROM CompetenceEntity c WHERE c.idCompetence = :id";
}
