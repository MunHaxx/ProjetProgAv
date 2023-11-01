package fr.efrei.projetTAN.utils.Entity;

public final class ExperienceConst {

    //Requêtes JPQL
    public static final String SELECT_TOUTES_LES_EXPERIENCES = "SELECT e FROM ExperienceEntity e";
    public static final String SELECT_EXPERIENCE_PAR_ID = "SELECT e FROM ExperienceEntity e WHERE e.idExperience = :id";
}

