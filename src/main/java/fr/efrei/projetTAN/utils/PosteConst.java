package fr.efrei.projetTAN.utils;

public class PosteConst {
    //Requêtes JPQL
    public static final String SELECT_TOUS_POSTES = "SELECT p FROM PosteEntity p";
    public static final String SELECT_POSTE_PAR_ID = "SELECT p FROM PosteEntity p WHERE p.idPoste = :id";
}
