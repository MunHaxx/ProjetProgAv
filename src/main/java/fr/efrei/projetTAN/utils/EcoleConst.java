package fr.efrei.projetTAN.utils;

public class EcoleConst {
    //Requêtes JPQL
    public static final String SELECT_TOUTES_ECOLES = "SELECT e FROM EcoleEntity e";
    public static final String SELECT_ECOLE_PAR_ID = "SELECT e FROM EcoleEntity e WHERE e.idEcole = :id";
}
