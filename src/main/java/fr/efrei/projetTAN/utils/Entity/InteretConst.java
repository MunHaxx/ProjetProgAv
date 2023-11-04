package fr.efrei.projetTAN.utils.Entity;

public final class InteretConst {
    //Requêtes JPQL
    public static final String SELECT_TOUS_LES_INTERETS = "SELECT i FROM InteretEntity i";
    public static final String SELECT_UN_INTERET = "SELECT i FROM InteretEntity i WHERE i.idInteret = :id";
}
