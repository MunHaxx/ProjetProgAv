package fr.efrei.projetTAN;

import java.util.List;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;
import fr.efrei.projetTAN.utils.GlobalConst.EnumNivCompt;

public class DataManager {
    // ---------------------------------------- TESTS ----------------------------------------

    // Méthode pour tester la récupération des informations d'un compétence -> A SUPPRIMER !!!
    public static void testerRecupUneCompetence(CompetenceSessionBean competenceSB, int id) {
        System.out.println("\n\n--- Début du test de récupération ---");
        System.out.println("Test récupération d'une compétence par ID :");
        int comptIdRecup = 1;
        CompetenceEntity competence = competenceSB.getCompetenceParId(comptIdRecup);
        System.out.println("Compétence récupérée - ID : " + competence.getIdCompetence());
        System.out.println("Nom : " + competence.getNom());
        System.out.println("Niveau : " + competence.getNiveau());
    }
    // Méthode pour tester la récupération des informations des compétences -> A SUPPRIMER !!!
    public static void testerRecupToutesCompetences(CompetenceSessionBean competenceSB){
        System.out.println("\n\n--- Début du test de récupération ---");
        System.out.println("Liste de toutes les compétences :");
        for (CompetenceEntity c : competenceSB.getToutesLesCompetences()) {
            System.out.println("ID : " + c.getIdCompetence());
            System.out.println("Nom : " + c.getNom());
            System.out.println("Niveau : " + c.getNiveau());
        }
    }
    // Méthode pour tester la modification d'une compétence -> A SUPPRIMER !!!
    public static void testerModificationCompetence(CompetenceSessionBean competenceSB, int id) {
        System.out.println("\n\n--- Début du test de modification ---");
        CompetenceEntity competenceAModifier = competenceSB.getCompetenceParId(id);
        if (competenceAModifier != null) {
            competenceAModifier.setNom("NouveauNom");
            competenceAModifier.setNiveau(EnumNivCompt.Intermediaire);

            competenceSB.modifierCompetence(competenceAModifier);
            System.out.println("Compétence modifiée avec succès : " + competenceAModifier.getIdCompetence());
        } else {
            System.out.println("La compétence avec l'ID spécifié n'a pas été trouvée.");
        }
    }


    public static void testerRecupExperiences(ExperienceSessionBean experienceSB) {
        List<ExperienceEntity> toutesLesExperiences = experienceSB.getToutesLesExperiences();
        System.out.println("\n--- Liste de toutes les expériences ---\n");
        for (ExperienceEntity experience : toutesLesExperiences) {
            System.out.println("ID : " + experience.getiDexperience());
            System.out.println("École : " + experience.getEcole());
            System.out.println("Évaluation École : " + experience.getEvalEcole());
            System.out.println("Durée : " + experience.getDuree());

            // Afficher les compétences associées à cette expérience
            List<CompetenceEntity> competences = experience.getListeCompetences();
            System.out.println("Compétences associées :");
            for (CompetenceEntity competence : competences) {
                System.out.println("ID : " + competence.getIdCompetence());
                System.out.println("Nom : " + competence.getNom());
                System.out.println("Niveau : " + competence.getNiveau());
            }

            System.out.println();
        }
    }

    public static void testerRecupExperienceParId(ExperienceSessionBean experienceSB, int experienceId) {
        ExperienceEntity experience = experienceSB.getExperienceParId(experienceId);
        System.out.println("\n--- Expérience récupérée par ID ---\n");
        System.out.println("ID : " + experience.getiDexperience());
        System.out.println("École : " + experience.getEcole());
        System.out.println("Évaluation École : " + experience.getEvalEcole());
        System.out.println("Durée : " + experience.getDuree());

        // Afficher les compétences associées à cette expérience
        List<CompetenceEntity> competences = experience.getListeCompetences();
        System.out.println("Compétences associées :");
        for (CompetenceEntity competence : competences) {
            System.out.println("ID : " + competence.getIdCompetence());
            System.out.println("Nom : " + competence.getNom());
            System.out.println("Niveau : " + competence.getNiveau());
        }
    }



    // ---------------------------------------- FIN DE TESTS  ----------------------------------------

}
