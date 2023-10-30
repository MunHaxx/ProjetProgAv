package fr.efrei.projetTAN.utils;

public class EtudeConst {
    //Requêtes JPQL
    public static final String SELECT_TOUTES_ETUDES = "SELECT e FROM EtudeEntity e";
    public static final String SELECT_ETUDE_PAR_ID = "SELECT e FROM EtudeEntity e WHERE e.idEtude = :id";

}
