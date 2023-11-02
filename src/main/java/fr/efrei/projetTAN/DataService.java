package fr.efrei.projetTAN;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;
import fr.efrei.projetTAN.utils.GlobalConst.EnumNivCompt;



public class DataService {

    private static boolean saisieCaractereValide(String saisie) {
        return !saisie.isEmpty() && saisie.matches("^[a-zA-Z]+$");
    }

    // ----- Recruteur -----
    public static String serviceModifierRecruteur(RecruteurSessionBean recruteurSB, HttpServletRequest request) {

        // Récupération des données du formulaire
        int idRecruteur = Integer.parseInt(request.getParameter("idRecruteur"));
        String nom = request.getParameter("nom"); // !!!!!!!!!!!!!!!!!
        String prenom = request.getParameter("prenom"); // !!!!!!!!!!!!!!!!!

        // Vérifications des saisies utilisateur
        if (saisieCaractereValide(nom) || saisieCaractereValide(prenom)) {
            return "Saisie incorrecte, veuillez vérifier tous les champs";
        }

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
