package fr.efrei.projetTAN;

import fr.efrei.projetTAN.utils.GlobalConst;
import jakarta.persistence.*;
import jakarta.servlet.http.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.User.UserRecruteurConst.*;
import static fr.efrei.projetTAN.utils.User.UserAdminConst.*;
import static fr.efrei.projetTAN.utils.User.UserEnseignantConst.*;

public class DataService {

    // Permet de vérifier la saisie utilisateur
    private static boolean saisieCaractereValide(String saisie) {
        return (!saisie.isEmpty()) && saisie.matches("^[a-zA-Z\\s]+$");
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
        else if (request.getParameter("data-id") == null || request.getParameter("data-id").isEmpty()) {
            RecruteurEntity nouveauRecruteur = new RecruteurEntity(nom, prenom);
            recruteurSB.ajouterRecruteur(nouveauRecruteur);
            msgInfo = "Création du recruteur effectuée";
        }

        // Modification de l'entité
        else {
            // Récupération de l'entité
            int idRecruteur = Integer.parseInt(request.getParameter("data-id"));
            RecruteurEntity recruteurModifie = recruteurSB.getRecruteurParId(idRecruteur).get(0);
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
        // Envoi des messages d'information
        request.setAttribute("messageErreur", msgErreur);
        request.setAttribute("messageInfo", msgInfo);
    }

    // Permet d'envoyer la liste des candidatures liées à un poste
    // Associé au bouton voir candidature sur la page liste des postes de l'utilisateur recruteur
    public static void serviceGetListeCandidatureDunPoste(PosteSessionBean posteSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        // Si on ne retrouve pas l'ID, on affiche une erreur
        if (request.getParameter("data-id") == null || request.getParameter("data-id").isEmpty())
            msgErreur = "Impossible d'afficher la liste des candidatures sur ce poste";
        else {
            int idPoste = Integer.parseInt(request.getParameter("data-id"));
            PosteEntity posteSelect = posteSB.getPosteParId(idPoste).get(0);
            request.getSession().setAttribute("PosteSelect", posteSelect);
            if (posteSelect == null)
                msgErreur = "Impossible d'afficher la liste des candidatures sur ce poste";
            else
                request.setAttribute("toutesLesCandidatures", posteSelect.getListeCandid());
        }
        // Envoi des messages d'information
        request.getSession().setAttribute("messageErreur", msgErreur);
    }

    // Permet de modifier le status d'une candidature en retenue (acceptée)
    // Associé au bouton accepter sur la page liste des candidatures de l'utilisateur recruteur
    public static void serviceModifStatusCandidatureRetenue(CandidatureSessionBean candidSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        String msgInfo = "";
        // Si on ne retrouve pas l'ID, on affiche une erreur
        if (request.getParameter("data-id") == null || request.getParameter("data-id").isEmpty())
            msgErreur = "Erreur : récupération de l'ID impossible, on ne peut pas modifier cette candidature";
        else {
            // Récupération de l'entité
            int idCandid = Integer.parseInt(request.getParameter("data-id"));
            CandidatureEntity candidSelect = candidSB.getCandidatureParId(idCandid).get(0);
            if (candidSelect == null)
                msgErreur = "Erreur : récupération de la candidature impossible";
            else if(Objects.equals(candidSelect.getDecision(), "Retenue"))
                msgInfo = "Cette candidature est déjà retenue";
            else {
                // Récupération de l'entité liée
                PosteEntity posteSelect = (PosteEntity) request.getSession().getAttribute("PosteSelect");
                ArrayList<CandidatureEntity> listeCandidPoste = posteSelect.getListeCandid();
                int index = posteSelect.getListeCandid().indexOf(candidSelect);
                // Modification de l'entité
                candidSelect.setDecision("Retenue");
                candidSB.modifierCandidature(candidSelect);
                // Modification de l'entité liée
                listeCandidPoste.set(index, candidSelect);
                posteSelect.setListeCandid(listeCandidPoste);

                msgInfo = "Candidature retenue";

            }
        }
        // Envoi des messages d'information
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
        if (request.getParameter("data-id") == null || request.getParameter("data-id").isEmpty())
            msgErreur = "Erreur : récupération de l'ID impossible, on ne peut pas modifier cette candidature";
        else {
            // Récupération de l'entité
            int idCandid = Integer.parseInt(request.getParameter("data-id"));
            CandidatureEntity candidSelect = candidSB.getCandidatureParId(idCandid).get(0);
            if (candidSelect == null)
                msgErreur = "Erreur : récupération de la candidature impossible";
            else if(Objects.equals(candidSelect.getDecision(), "Non retenue"))
                msgInfo = "Cette candidature est déjà non retenue";
            else {
                // Récupération de l'entité liée
                PosteEntity posteSelect = (PosteEntity) request.getSession().getAttribute("PosteSelect");
                ArrayList<CandidatureEntity> listeCandidPoste = posteSelect.getListeCandid();
                int index = posteSelect.getListeCandid().indexOf(candidSelect);
                // Modification de l'entité
                candidSelect.setDecision("Non Retenue");
                candidSB.modifierCandidature(candidSelect);
                // Modification de l'entité liée
                listeCandidPoste.set(index, candidSelect);
                posteSelect.setListeCandid(listeCandidPoste);
                msgInfo = "Candidature non retenue";

            }
        }
        // Envoi des messages d'information
        request.getSession().setAttribute("messageErreur", msgErreur);
        request.getSession().setAttribute("messageInfo", msgInfo);
    }

    // Permet de créer un poste, associé à la page de création de poste sur le profil recruteur
    // Associé au bouton sauvegarder de la page mentionnée
    public static void serviceCreerPoste(PosteSessionBean posteSB, EcoleSessionBean ecoleSB,
                                         CompetenceSessionBean competenceSB, ContrainteSessionBean contrainteSB,
                                         RemarqueSessionBean remarqueSB, NiveauEtudiantSessionBean nivEtudiantSB,
                                         RecruteurSessionBean recruteurSB, HttpServletRequest request) {
        // Déclaration de variable pour le message à afficher
        String msgErreur = "";
        String msgInfo = "";

        // Récupération des données du formulaire
        String nomPoste = request.getParameter(CHAMP_CREER_POSTE_TITRE);
        String strEcole = request.getParameter(CHAMP_CREER_POSTE_ECOLE);
        String strContrat = request.getParameter(CHAMP_CREER_POSTE_CONTRAT);
        String periode = request.getParameter(CHAMP_CREER_POSTE_PERIODE);
        String strNivEtudiant = request.getParameter(CHAMP_CREER_POSTE_NIVEAU);

        String strCompt1 = request.getParameter(CHAMP_CREER_POSTE_COMPETENCE_1);
        String strCompt2 = request.getParameter(CHAMP_CREER_POSTE_COMPETENCE_2);
        String strCompt3 = request.getParameter(CHAMP_CREER_POSTE_COMPETENCE_3);

        String contr1 = request.getParameter(CHAMP_CREER_POSTE_CONTRAINTES_1);
        String contr2 = request.getParameter(CHAMP_CREER_POSTE_CONTRAINTES_2);
        String contr3 = request.getParameter(CHAMP_CREER_POSTE_CONTRAINTES_3);

        String rem1 = request.getParameter(CHAMP_CREER_POSTE_REMARQUES_1);
        String rem2 = request.getParameter(CHAMP_CREER_POSTE_REMARQUES_2);
        String rem3 = request.getParameter(CHAMP_CREER_POSTE_REMARQUES_3);

        // Récupère le recruteur connecté
        RecruteurEntity recruteurConnecte = (RecruteurEntity) request.getAttribute("leRecruteur");
        if (recruteurConnecte == null)
            msgErreur = "Erreur : impossible de récupérer l'utilisateur recruteur connecté";
        // Vérifications des saisies utilisateur
        else if (nomPoste.isEmpty() || strEcole.isEmpty() || strContrat.isEmpty()
                || periode.isEmpty() || strNivEtudiant.isEmpty()) {
            msgErreur = "Erreur : compléter tous les champs obligatoires";
        }
        else if (!saisieCaractereValide(nomPoste) || !saisieCaractereValide(strEcole) || !saisieCaractereValide(strContrat)) // période et niveau étudiant peuvent contenir des chiffres et des caractères spéciaux
            msgErreur = "Saisie incorrecte, veuillez vérifier tous les champs";

        else {
            // Conversion de type des entrées utilisateurs
            GlobalConst.EnumTypeContrat contrat = serviceCreerTypeContrat(strContrat);
            NiveauEtudiantEntity nivEtudiant = serviceCreerNivEtudiant(nivEtudiantSB, strNivEtudiant);
            EcoleEntity ecole  = serviceRecupCreerEcole(ecoleSB, strEcole);

            PosteEntity nouveauPoste = new PosteEntity(nomPoste, ecole, contrat, periode, nivEtudiant, recruteurConnecte);
            posteSB.ajouterPoste(nouveauPoste);

            // Remplissage des listes du poste
            ArrayList<String> listeStr = new ArrayList<>();

            // Compétences
            listeStr.add(strCompt1);
            listeStr.add(strCompt2);
            listeStr.add(strCompt3);
            serviceCreerListeCompetences(competenceSB, nouveauPoste, posteSB, listeStr);
            listeStr.clear();

            // Contraintes et remarques
            // non implémenter car on aurait aimé résoudre les problèmes sur compétences avant de gérer ceux-là

            posteSB.modifierPoste(nouveauPoste);
            recruteurConnecte.getEstRespoListePostes().add(nouveauPoste);
            recruteurSB.modifierRecruteur(recruteurConnecte);
            msgInfo = "Création du poste effectuée";
        }
        // Envoi des messages d'information
        request.setAttribute("messageErreur", msgErreur);
        request.setAttribute("messageInfo", msgInfo);
    }

    // Crée un enum type de contrat à partir d'un string, utilisé lors de la création de poste
    public static GlobalConst.EnumTypeContrat serviceCreerTypeContrat(String strContrat){
        if (strContrat == null || !GlobalConst.estDansEnumTypeContrat(strContrat))
            return GlobalConst.EnumTypeContrat.CDD; // valeur par défaut
        else
            return GlobalConst.stringVersEnumTypeContrat(strContrat);
    }

    // Crée un niveau étudiant à partir d'un string, utilisé lors de la création de poste
    public static NiveauEtudiantEntity serviceCreerNivEtudiant(NiveauEtudiantSessionBean nivEtudSB, String strNivEtudiant){
        if (strNivEtudiant == null || !GlobalConst.estDansEnumTypeContrat(strNivEtudiant))
            strNivEtudiant = "L1"; // valeur par défaut
        NiveauEtudiantEntity nivEtud = new NiveauEtudiantEntity(GlobalConst.stringVersEnumNivEtudiant(strNivEtudiant));
        nivEtudSB.ajouterNiveauEtudiant(nivEtud);
        return nivEtud;
    }

    // Crée une école, utilisé lors de la création de poste
    public static EcoleEntity serviceRecupCreerEcole(EcoleSessionBean ecoleSB, String strEcole) {
        if (strEcole == null || !saisieCaractereValide(strEcole)){
            strEcole = "Ecole non mentionnée";
        }
        if(ecoleSB.getEcoleParRaisonSociale(strEcole).isEmpty()){
            // Créé l'entité si elle n'existe pas
            EcoleEntity nouvelleEcole = new EcoleEntity(strEcole);
            ecoleSB.ajouterEcole(nouvelleEcole);
            return nouvelleEcole;
        }
        else {
            // Récupère l'entité
            return ecoleSB.getEcoleParRaisonSociale(strEcole).get(0);
        }
    }

    // Crée une liste de compétences à partir d'une liste de string
    public static void serviceCreerListeCompetences(CompetenceSessionBean competenceSB, PosteEntity poste, PosteSessionBean posteSB, ArrayList<String> strListe) {
        ArrayList<CompetenceEntity> listeCompt = new ArrayList<>();
        for (String strCompt:strListe) {
            if (strCompt != null && !strCompt.isEmpty()){
                CompetenceEntity competence;

                // Vérifie si la compétence existe déjà pour ce poste
                boolean competenceExistePourPoste = false;
                for (CompetenceEntity comp : poste.getListeCompetences()) {
                    if (Objects.equals(comp.getNomCompetence(), strCompt)) {
                        competenceExistePourPoste = true;
                        break;
                    }
                }
                // Si la compétence n'existe pas pour ce poste, on l'ajoute
                if (!competenceExistePourPoste) {
                    // Si la compétence existe, on l'ajoute à la liste de compétences du poste
                    if (!competenceSB.getCompetenceParNom(strCompt).isEmpty()) {
                        competence = competenceSB.getCompetenceParNom(strCompt).get(0);
                    }
                    // Sinon on créé une compétence
                    else {
                        competence = new CompetenceEntity(strCompt, poste);
                    }
                    listeCompt.add(competence);
                    competenceSB.ajouterCompetence(competence);
                }
            }
        }
        poste.setListeCompetences(listeCompt);
        posteSB.modifierPoste(poste);
    }
}
