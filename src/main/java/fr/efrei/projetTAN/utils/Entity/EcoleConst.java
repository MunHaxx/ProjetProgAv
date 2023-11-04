package fr.efrei.projetTAN.utils.Entity;

public final class EcoleConst {
    //Requêtes JPQL
    public static final String SELECT_TOUTES_LES_ECOLES = "SELECT e FROM EcoleEntity e";
    public static final String SELECT_ECOLE_PAR_ID = "SELECT e FROM EcoleEntity e WHERE e.idEcole = :id";
}
