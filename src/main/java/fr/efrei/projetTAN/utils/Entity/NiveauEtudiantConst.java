package fr.efrei.projetTAN.utils.Entity;

public class NiveauEtudiantConst{
        //Requêtes JPQL
        public static final String SELECT_TOUS_LES_NIVETUD = "SELECT n FROM NiveauEtudiantEntity n";
        public static final String SELECT_NIVETUD_PAR_ID = "SELECT n FROM NiveauEtudiantEntity n WHERE n.idNivEtud = :id";
}
