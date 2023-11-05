package fr.efrei.projetTAN;

import fr.efrei.projetTAN.utils.GlobalConst;
import jakarta.persistence.*;
import jakarta.servlet.http.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

import java.util.ArrayList;
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
        else if (request.getParameter("data-id").isEmpty()) {
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
        if (request.getParameter("data-id").isEmpty())
            msgErreur = "Impossible d'afficher la liste des candidatures sur ce poste";
        else {
            int idPoste = Integer.parseInt(request.getParameter("data-id"));
            PosteEntity posteSelect = posteSB.getPosteParId(idPoste);
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
        if (request.getParameter("data-id").isEmpty())
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
        if (request.getParameter("data-id").isEmpty())
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
        // Envoi des messages d'information
        request.getSession().setAttribute("messageErreur", msgErreur);
        request.getSession().setAttribute("messageInfo", msgInfo);
    }

    public static void serviceCreerPoste(PosteSessionBean posteSB, EcoleSessionBean ecoleSB,
                                         CompetenceSessionBean competenceSB, ContrainteSessionBean contrainteSB,
                                         RemarqueSessionBean remarqueSB, NiveauEtudiantSessionBean nivEtudiantSB,
                                         HttpServletRequest request) {
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

            // Remplissage des listes du poste
            ArrayList<String> listeStr = new ArrayList<>();

            // Compétences
            listeStr.add(strCompt1);
            listeStr.add(strCompt2);
            listeStr.add(strCompt3);
            ArrayList<CompetenceEntity> listeCompetences = serviceCreerListeCompetences(competenceSB, nouveauPoste, listeStr);
            if (listeCompetences != null)
                nouveauPoste.setListeCompetences(listeCompetences);
            listeStr.clear();

            // Contraintes
            /*listeStr.add(contr1); listeStr.add(contr2); listeStr.add(contr3);
            ArrayList<ContrainteEntity> listeContraintes = serviceCreerListeContraintes(contrainteSB, nouveauPoste, listeStr);
            if (listeContraintes != null)
                nouveauPoste.setListeContraintes(listeContraintes);
            listeStr.clear();*/

            // Ajout des compétences, contraintes et remarques
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            posteSB.ajouterPoste(nouveauPoste);
            msgInfo = "Création du poste effectuée";
        }
        // Envoi des messages d'information
        request.setAttribute("messageErreur", msgErreur);
        request.setAttribute("messageInfo", msgInfo);
    }

    // Créé un enum type de contrat à partir d'un string, utilisé lors de la création de poste
    public static GlobalConst.EnumTypeContrat serviceCreerTypeContrat(String strContrat){
        if (strContrat == null || !GlobalConst.estDansEnumTypeContrat(strContrat))
            return GlobalConst.EnumTypeContrat.CDD; // valeur par défaut
        else
            return GlobalConst.stringVersEnumTypeContrat(strContrat);
    }

    // Créé un niveau étudiant à partir d'un string, utilisé lors de la création de poste
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
    public static ArrayList<CompetenceEntity> serviceCreerListeCompetences(CompetenceSessionBean competenceSB, PosteEntity poste, ArrayList<String> strListe) {
        if (strListe == null)
            return null;
        ArrayList<CompetenceEntity> listeCompt = new ArrayList<>();
        for (String compt:strListe) {
            if (compt != null && !compt.isEmpty()){
                CompetenceEntity nouvelleCompetence = new CompetenceEntity(compt, poste);
                competenceSB.ajouterCompetence(nouvelleCompetence);
                listeCompt.add(nouvelleCompetence);
            }
        }
        return listeCompt;
    }

    // Crée une liste de contraintes à partir d'une liste de string
    /*public static ArrayList<CompetenceEntity> serviceCreerListeContraintes(ContrainteSessionBean contrainteSB, PosteEntity poste, ArrayList<String> strListe) {
        if (strListe == null)
            return null;
        ArrayList<CompetenceEntity> listeCompt = new ArrayList<>();
        for (String compt:strListe) {
            if (compt != null && !compt.isEmpty()){
                CompetenceEntity nouvelleCompetence = new CompetenceEntity(compt, poste);
                competenceSB.ajouterCompetence(nouvelleCompetence);
                listeCompt.add(nouvelleCompetence);
            }
        }
        return listeCompt;
    }*/

}
