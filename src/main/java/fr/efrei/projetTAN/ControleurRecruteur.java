package fr.efrei.projetTAN;

import java.io.*;

import fr.efrei.projetTAN.utils.GlobalConst.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import static fr.efrei.projetTAN.utils.User.UserRecruteurConst.*;
import static fr.efrei.projetTAN.utils.User.LoginConst.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;


public class ControleurRecruteur extends HttpServlet {
    private Utilisateur unUtilisateur;
    private String actionUtilisateur;
    @EJB
    private ActiviteSessionBean activiteSB;
    @EJB
    private CandidatureSessionBean candidatureSB;
    @EJB
    private CompetenceSessionBean competenceSB;
    @EJB
    private ContrainteSessionBean contrainteSB;
    @EJB
    private RemarqueSessionBean remarqueSB;
    @EJB
    private EcoleSessionBean ecoleSB;
    @EJB
    private EnseignantSessionBean enseignantSB;
    @EJB
    private EtudeSessionBean etudeSB;
    @EJB
    private ExperienceSessionBean experienceSB;
    @EJB
    private InteretSessionBean interetSB;
    @EJB
    private NiveauEtudiantSessionBean nivEtudSB;
    @EJB
    private PosteSessionBean posteSB;
    @EJB
    private RecruteurSessionBean recruteurSB;

    public void init() { }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        traiterRequete(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        traiterRequete(request, response);
    }

    public void traiterRequete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        actionUtilisateur = request.getParameter("action");
        chargerLaPageSuivante(actionUtilisateur, request, response);
    }

    public void chargerLaPageSuivante(String actionUtilisateur, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (actionUtilisateur == null || actionUtilisateur.isEmpty()) {
            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
        } else {
            // Récupère et envoi les informations du recruteur connecté
            unUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
            if (unUtilisateur == null) {
                request.getSession().setAttribute("messageErreur", "Impossible de trouver l'utilisateur de ce recruteur");
                request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
            } else {
                RecruteurEntity recruteurActuel = recruteurSB.getRecruteurParId(unUtilisateur.getIdRole()).get(0);
                if (!"recruteur".equals(unUtilisateur.getRole()) || recruteurActuel == null) {
                    request.getSession().setAttribute("messageErreur", "Cet utilisateur n'est pas un recruteur");
                    request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
                } else {
                    request.setAttribute("leRecruteur", recruteurActuel);
                    // Remise à zéro des messages
                    request.getSession().setAttribute("messageInfo", "");
                    request.getSession().setAttribute("messageErreur", "");
                    switch (actionUtilisateur) {
                        case ACTION_RECRUTEUR_VOIR_LISTE_POSTE:
                            request.getSession().setAttribute("PosteSelect", "");
                            request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_POSTE).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_VOIR_CREER_POSTE:
                            request.getRequestDispatcher(PAGE_RECRUTEUR_CREER_POSTE).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_VOIR_MODIFIER_PROFIL:
                            request.setAttribute("idRecruteur", recruteurActuel.getIdRecruteur());
                            request.getRequestDispatcher(PAGE_RECRUTEUR_MODIFIER_PROFIL).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_VOIR_LISTE_CANDIDATURE:
                            redirigerListeCandidatures(request, response);
                            break;
                        case ACTION_RECRUTEUR_SAUVE_CREATION_POSTE:
                            DataService.serviceCreerPoste(posteSB, ecoleSB, competenceSB, contrainteSB, remarqueSB, nivEtudSB, recruteurSB, request);
                            request.setAttribute("leRecruteur", recruteurActuel);
                            // Redirection vers la page correspondante
                            if (request.getSession().getAttribute("messageErreur") == "")
                                request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_POSTE).forward(request, response);
                            else
                                request.getRequestDispatcher(PAGE_RECRUTEUR_CREER_POSTE).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_SAUVE_MODIFICATION_PROFIL:
                            DataService.serviceModifierCreerRecruteur(recruteurSB, request);
                            request.getRequestDispatcher(PAGE_RECRUTEUR_MODIFIER_PROFIL).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_ACCEPTER_CANDIDATURE:
                            DataService.serviceModifStatusCandidatureRetenue(candidatureSB, request);
                            redirigerListeCandidatures(request, response);
                            break;
                        case ACTION_RECRUTEUR_REJETER_CANDIDATURE:
                            DataService.serviceModifStatusCandidatureNonRetenue(candidatureSB, request);
                            redirigerListeCandidatures(request, response);
                            break;
                        case ACTION_DECONNEXION:
                            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
                            break;
                    }
                }
            }
        }
    }

    public void redirigerListeCandidatures(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataService.serviceGetListeCandidatureDunPoste(posteSB, request);
        if (request.getSession().getAttribute("messageErreur") != "")
            // Redirection vers la page courante pour afficher l'erreur
            request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_POSTE).forward(request, response);
        else
            // Redirection vers la page correspondante
            request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_CANDIDATURE).forward(request, response);
    }
}