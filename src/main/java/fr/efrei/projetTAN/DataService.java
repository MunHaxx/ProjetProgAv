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
        return (!saisie.isEmpty()) && saisie.matches("^[a-zA-Z]+$");
    }

    // ----- Recruteur -----
    public static void serviceModifierRecruteur(RecruteurSessionBean recruteurSB, HttpServletRequest request) {
        String msgErreur = "";
        String msgInfo = "";
        if (request.getParameter("data-id") == null)
            msgErreur = "Erreur : le recruteur à modifier n'existe pas";
        else {
            // Récupération des données du formulaire
            int idRecruteur = Integer.parseInt(request.getParameter("data-id"));
            String nom = request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_NOM);
            String prenom = request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_PRENOM);

            if(idRecruteur <= 0 || nom == null || prenom == null)
                msgErreur = "Erreur : récupération des données saisies impossible";
            else if (!saisieCaractereValide(nom) || !saisieCaractereValide(prenom)){
                // Vérifications des saisies utilisateur
                msgErreur = "Saisie incorrecte, veuillez vérifier tous les champs";
            }
            else{
                // Récupération de l'entité
                try {
                    RecruteurEntity recruteurModifie = recruteurSB.getRecruteurParId(idRecruteur);
                    // Modification des données
                    recruteurModifie.setNom(nom);
                    recruteurModifie.setPrenom(prenom);
                    recruteurSB.modifierRecruteur(recruteurModifie);
                    msgInfo = "Modification du recruteur effectuée";
                }
                catch (NoResultException e){
                    // Création de l'entité s'il n'existe pas
                    RecruteurEntity nouveauRecruteur = new RecruteurEntity(nom, prenom);
                    recruteurSB.ajouterRecruteur(nouveauRecruteur);
                    msgInfo = "Création du recruteur effectuée";
                }
            }
            
        }
        request.setAttribute("messageErreur", msgErreur);
        request.setAttribute("messageInfo", msgInfo);
    }
}
