package fr.efrei.projetTAN.utils.Entity;

public final class EnseignantConst {
    //Requêtes JPQL
    public static final String SELECT_TOUS_LES_ENSEIGNANTS = "SELECT e FROM EnseignantEntity e";
    public static final String SELECT_ENSEIGNANT_PAR_ID = "SELECT e FROM EnseignantEntity e WHERE e.idEnseignant = :id";

}
