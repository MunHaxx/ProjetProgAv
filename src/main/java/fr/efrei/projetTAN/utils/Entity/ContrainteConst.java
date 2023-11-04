package fr.efrei.projetTAN.utils.Entity;

public final class ContrainteConst {
    //Requêtes JPQL
    public static final String SELECT_TOUTES_LES_CONTRAINTES = "SELECT c FROM ContrainteEntity c";
    public static final String SELECT_UNE_CONTRAINTE = "SELECT c FROM ContrainteEntity c WHERE c.idContrainte = :id";
}
