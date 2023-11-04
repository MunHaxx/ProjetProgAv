package fr.efrei.projetTAN.utils.Entity;

public final class RemarqueConst {

    //Requêtes JPQL
    public static final String SELECT_TOUTES_LES_REMARQUES = "SELECT r FROM RemarqueEntity r";
    public static final String SELECT_REMARQUE_PAR_ID = "SELECT r FROM RemarqueEntity r WHERE r.idRemarque = :id";

}
