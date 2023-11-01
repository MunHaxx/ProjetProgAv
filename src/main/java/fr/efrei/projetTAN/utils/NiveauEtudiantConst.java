package fr.efrei.projetTAN.utils;

public class NiveauEtudiantConst{
        //Requêtes JPQL
        public static final String SELECT_TOUTES_NIVETUD = "SELECT n FROM NiveauEtudiantEntity n";
        public static final String SELECT_NIVETUD_PAR_ID = "SELECT n FROM NiveauEtudiantEntity n WHERE n.idNivEtud = :id";
}
