package fr.efrei.projetTAN.utils.Entity;

public final class ActiviteConst {
    //Requêtes JPQL
    public static final String SELECT_TOUTES_LES_ACTIVITES = "SELECT a FROM ActiviteEntity a";
    public static final String SELECT_UNE_ACTIVITE = "SELECT a FROM ActiviteEntity a WHERE a.idActivite = :id";
}
