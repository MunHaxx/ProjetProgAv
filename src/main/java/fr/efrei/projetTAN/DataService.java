package fr.efrei.projetTAN;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;
import fr.efrei.projetTAN.utils.GlobalConst.EnumNivCompt;

import static fr.efrei.projetTAN.utils.User.UserRecruteurConst.*;


public class DataService {

    private static boolean saisieCaractereValide(String saisie) {
        return !saisie.isEmpty() && saisie.matches("^[a-zA-Z]+$");
    }

    // ----- Recruteur -----
    public static String serviceModifierRecruteur(RecruteurSessionBean recruteurSB, HttpServletRequest request) {
        if (request.getParameter("data-id") == null)
            return "Erreur : le recruteur à modifier n'existe pas";

        // Récupération des données du formulaire
        int idRecruteur = Integer.parseInt(request.getParameter("idRecruteur"));
        String nom = request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_NOM);
        String prenom = request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_PRENOM);

        if(idRecruteur <= 0 || nom == null || prenom == null)
            return "Erreur : récupération des données saisies impossible";

        // Vérifications des saisies utilisateur
        if (saisieCaractereValide(nom) || saisieCaractereValide(prenom))
            return "Saisie incorrecte, veuillez vérifier tous les champs";

        // Récupération de l'entité
        try {
            RecruteurEntity recruteurModifie = recruteurSB.getRecruteurParId(idRecruteur);
            // Modification des données
            recruteurSB.modifierRecruteur(recruteurModifie);
            return "Modification du recruteur effectuée";
        }
        catch (NoResultException e){
            // Création de l'entité s'il n'existe pas
            RecruteurEntity nouveauRecruteur = new RecruteurEntity(nom, prenom);
            recruteurSB.ajouterRecruteur(nouveauRecruteur);
            return "Création du recruteur effectuée";
        }
    }
}
