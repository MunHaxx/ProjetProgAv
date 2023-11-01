package fr.efrei.projetTAN.utils.Entity;

public final class CompetenceConst {

    //Requêtes JPQL
    public static final String SELECT_TOUTES_LES_COMPETENCES = "SELECT c FROM CompetenceEntity c";
    public static final String SELECT_UNE_COMPETENCE = "SELECT c FROM CompetenceEntity c WHERE c.idCompetence = :id";
    public static final String MODIF_UNE_COMPETENCE = "UPDATE CompetenceEntity c SET c.nom = :nom, c.niveau = :niveau WHERE c.idCompetence = :id";
}
