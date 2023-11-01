package fr.efrei.projetTAN.utils.Entity;

public class RecruteurConst {

    //Requêtes JPQL
    public static final String SELECT_TOUS_RECRUTEUR = "SELECT r FROM RecruteurEntity r";
    public static final String SELECT_RECRUTEUR_PAR_ID = "SELECT r FROM RecruteurEntity r WHERE r.idRecruteur = :id";

}
