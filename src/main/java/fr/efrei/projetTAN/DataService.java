package fr.efrei.projetTAN;

import jakarta.servlet.http.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

import java.util.Objects;

import static fr.efrei.projetTAN.utils.User.UserRecruteurConst.*;
import static fr.efrei.projetTAN.utils.User.UserAdminConst.*;
import static fr.efrei.projetTAN.utils.User.UserEnseignantConst.*;

public class DataService {

    private static boolean saisieCaractereValide(String saisie) {
        return (!saisie.isEmpty()) && saisie.matches("^[a-zA-Z]+$");
    }

    // Permet de modifier ou de créer un recruteur
    // Associé aux boutons :
    // - modifier profil de l'utilisateur recruteur
    // - modifier recruteur sur la page liste des recruteurs de l'utilisateur admin
    public static void serviceModifierCreerRecruteur(RecruteurSessionBean recruteurSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        String msgInfo = "";

        // Récupération des données du formulaire
        String nom = request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_NOM);
        String prenom = request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_PRENOM);

        // Vérifications des saisies utilisateur
        if(nom == null || prenom == null)
            msgErreur = "Erreur : récupération des données saisies impossible";
        else if (!saisieCaractereValide(nom) || !saisieCaractereValide(prenom))
            msgErreur = "Saisie incorrecte, veuillez vérifier tous les champs";

        // Création de l'entité s'il n'y a pas d'ID dans la requête
        else if (request.getParameter("data-id") == null) {
            RecruteurEntity nouveauRecruteur = new RecruteurEntity(nom, prenom);
            recruteurSB.ajouterRecruteur(nouveauRecruteur);
            msgInfo = "Création du recruteur effectuée";
        }

        // Modification de l'entité
        else {
            // Récupération de l'entité
            int idRecruteur = Integer.parseInt(request.getParameter("data-id"));
            RecruteurEntity recruteurModifie = recruteurSB.getRecruteurParId(idRecruteur);
            if(idRecruteur <= 0 || recruteurModifie == null)
                msgErreur = "Erreur : impossible de récupérer l'ID du recruteur à modifier";
            else{
                // Modification des données
                recruteurModifie.setNom(nom);
                recruteurModifie.setPrenom(prenom);
                recruteurSB.modifierRecruteur(recruteurModifie);
                msgInfo = "Modification du recruteur effectuée";
            }
        }
        // Envoi des informations
        request.setAttribute("messageErreur", msgErreur);
        request.setAttribute("messageInfo", msgInfo);
    }

    // Permet d'envoyer la liste des candidatures liées à un poste
    // Associé au bouton voir candidature sur la page liste des postes de l'utilisateur recruteur
    public static void serviceGetListeCandidatureDunPoste(PosteSessionBean posteSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        // Si on ne retrouve pas l'ID, on affiche une erreur
        if (request.getParameter("data-id") == null)
            msgErreur = "Impossible d'afficher la liste des candidatures sur ce poste";
        else {
            int idPoste = Integer.parseInt(request.getParameter("data-id"));
            PosteEntity posteSelect = posteSB.getPosteParId(idPoste);
            if (posteSelect == null)
                msgErreur = "Impossible d'afficher la liste des candidatures sur ce poste";
            else
                request.setAttribute("toutesLesCandidatures", posteSelect.getListeCandid());
        }
        request.getSession().setAttribute("messageErreur", msgErreur);
    }

    // Permet de modifier le status d'une candidature en retenue (acceptée)
    // Associé au bouton accepter sur la page liste des candidatures de l'utilisateur recruteur
    public static void serviceModifStatusCandidatureRetenue(CandidatureSessionBean candidSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        String msgInfo = "";
        // Si on ne retrouve pas l'ID, on affiche une erreur
        if (request.getParameter("data-id") == null)
            msgErreur = "Erreur : récupération de l'ID impossible, on ne peut pas modifier cette candidature";
        else {
            // Récupération de l'entité
            int idCandid = Integer.parseInt(request.getParameter("data-id"));
            CandidatureEntity candidSelect = candidSB.getCandidatureParId(idCandid);
            if (candidSelect == null)
                msgErreur = "Erreur : récupération de la candidature impossible";
            else if(Objects.equals(candidSelect.getDecision(), "Retenue"))
                msgInfo = "Cette candidature est déjà retenue";
            else {
                // Modification de l'entité
                candidSelect.setDecision("Retenue");
                candidSB.modifierCandidature(candidSelect);
                msgInfo = "Candidature retenue";
            }
        }
        request.getSession().setAttribute("messageErreur", msgErreur);
        request.getSession().setAttribute("messageInfo", msgInfo);
    }

    // Permet de modifier le status d'une candidature en non retenue (refusée)
    // Associé au bouton refuser sur la page liste des candidatures de l'utilisateur recruteur
    public static void serviceModifStatusCandidatureNonRetenue(CandidatureSessionBean candidSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        String msgInfo = "";
        // Si on ne retrouve pas l'ID, on affiche une erreur
        if (request.getParameter("data-id") == null)
            msgErreur = "Erreur : récupération de l'ID impossible, on ne peut pas modifier cette candidature";
        else {
            // Récupération de l'entité
            int idCandid = Integer.parseInt(request.getParameter("data-id"));
            CandidatureEntity candidSelect = candidSB.getCandidatureParId(idCandid);
            if (candidSelect == null)
                msgErreur = "Erreur : récupération de la candidature impossible";
            else if(Objects.equals(candidSelect.getDecision(), "Non retenue"))
                msgInfo = "Cette candidature est déjà non retenue";
            else {
                // Modification de l'entité
                candidSelect.setDecision("Non retenue");
                candidSB.modifierCandidature(candidSelect);
                msgInfo = "Candidature non retenue";
            }
        }
        request.getSession().setAttribute("messageErreur", msgErreur);
        request.getSession().setAttribute("messageInfo", msgInfo);
    }

    // Permet de créer une école
    // Utilisé lors de la création de poste
    public static void serviceCreerEcole(EcoleSessionBean ecoleSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        String msgInfo = "";

        // Récupération des données du formulaire
        String raisonSociale = request.getParameter(CHAMP_CREER_POSTE_ECOLE);

        // Vérifications des saisies utilisateur
        if(raisonSociale == null)
            msgErreur = "Erreur : récupération des données saisies impossible";
        else if (!saisieCaractereValide(raisonSociale))
            msgErreur = "Saisie incorrecte, veuillez vérifier tous les champs";

        // Création de l'entité
        EcoleEntity nouvelleEcole = new EcoleEntity(raisonSociale);
        ecoleSB.ajouterEcole(nouvelleEcole);
        msgInfo = "Création du recruteur effectuée";

        // Envoi des informations
        request.setAttribute("messageErreur", msgErreur);
        request.setAttribute("messageInfo", msgInfo);
    }

    public static void serviceModifierCreerPoste(PosteSessionBean posteSB, HttpServletRequest request) {

    }

    // Permet de modifier ou de créer une candidature
    // Associé aux boutons :
    // - postuler sur la page liste des postes de l'utilisateur enseignant
    // - accepter/refuser sur la page listes des candidatures de l'utilisateur recruteur
    /*public static void serviceModifierCreerCandidature(CandidatureSessionBean candidatureSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        String msgInfo = "";

        // Récupération des données du formulaire
        // gérer après pour création/modif String idPoste = request.getParameter("data-id");
        //EnseignantEntity enseignantActuel = request.getParameter("lEnseignant"); //enseignantSB.getEnseignantParId(unUtilisateur.getIdRole());
        request.getSession().setAttribute("lEnseignant", enseignantActuel);
        // Enseignant co
        // date = now
        // Decision = en attente
        String nom = request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_NOM);
        String prenom = request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_PRENOM);

        // Vérifications des saisies utilisateur
        if(nom == null || prenom == null)
            msgErreur = "Erreur : récupération des données saisies impossible";
        else if (!saisieCaractereValide(nom) || !saisieCaractereValide(prenom))
            msgErreur = "Saisie incorrecte, veuillez vérifier tous les champs";

            // Création de l'entité s'il n'y a pas d'ID dans la requête
        else if (request.getParameter("data-id") == null) {
            RecruteurEntity nouveauRecruteur = new RecruteurEntity(nom, prenom);
            recruteurSB.ajouterRecruteur(nouveauRecruteur);
            msgInfo = "Création du recruteur effectuée";
        }

        // Modification de l'entité
        else {
            int idRecruteur = Integer.parseInt(request.getParameter("data-id"));
            if(idRecruteur <= 0)
                msgErreur = "Erreur : impossible de récupérer l'ID du recruteur à modifier";
            else{
                // Récupération de l'entité
                RecruteurEntity recruteurModifie = recruteurSB.getRecruteurParId(idRecruteur);
                // Modification des données
                recruteurModifie.setNom(nom);
                recruteurModifie.setPrenom(prenom);
                recruteurSB.modifierRecruteur(recruteurModifie);
                msgInfo = "Modification du recruteur effectuée";
            }
        }
        // Envoi des informations
        request.setAttribute("messageErreur", msgErreur);
        request.setAttribute("messageInfo", msgInfo);
    }*/
}
