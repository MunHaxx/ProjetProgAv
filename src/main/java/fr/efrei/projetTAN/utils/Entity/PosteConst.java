package fr.efrei.projetTAN.utils.Entity;

public final class PosteConst {
    //Requêtes JPQL
    public static final String SELECT_TOUS_LES_POSTES = "SELECT p FROM PosteEntity p";
    public static final String SELECT_POSTE_PAR_ID = "SELECT p FROM PosteEntity p WHERE p.idPoste = :id";
}
