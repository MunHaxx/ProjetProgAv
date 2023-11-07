package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

import fr.efrei.projetTAN.utils.GlobalConst.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

// import static fr.efrei.projetTAN.utils.GlobalConst.*;
import static fr.efrei.projetTAN.utils.User.UserAdminConst.*;
import static fr.efrei.projetTAN.utils.User.LoginConst.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

public class ControleurAdmin extends HttpServlet {
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
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        traiterRequete(request, response);
    }

    public void traiterRequete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        actionUtilisateur = request.getParameter("action");
        chargerLaPageSuivante(actionUtilisateur, request, response);
    }

    public void chargerLaPageSuivante(String actionUtilisateur, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (actionUtilisateur == null || actionUtilisateur.isEmpty()) {
            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
        }
        else {
            List<RecruteurEntity> listeRecruteurs = recruteurSB.getTousRecruteurs(); // Besoin de la liste dans différents case
            List<EnseignantEntity> listeEnseignants = enseignantSB.getTousEnseignants(); // Besoin de la liste dans différents case
            
           
            switch (actionUtilisateur) {
                case ACTION_ADMIN_VOIR_LISTE_POSTE:
                    request.setAttribute("tousLesPostes", posteSB.getTousLesPostes());
                    request.getRequestDispatcher(PAGE_ADMIN_LISTE_POSTE).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_LISTE_RECRUTEUR:
                    request.setAttribute("tousLesRecruteurs", listeRecruteurs);
                    request.getRequestDispatcher(PAGE_ADMIN_LISTE_RECRUTEUR).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_CREER_RECRUTEUR:
                    if(request.getParameter("data-id").isEmpty()) {
                        int dataId = Integer.parseInt(request.getParameter("data-id"));
                        request.setAttribute("leRecruteur", recruteurSB.getRecruteurParId(dataId).get(0));
                    } else {
                        request.setAttribute("leRecruteur", null);
                    }
                    request.getRequestDispatcher(PAGE_ADMIN_CREER_RECRUTEUR).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_LISTE_ENSEIGNANT:
                    request.setAttribute("tousLesEnseignants", listeEnseignants);
                    request.getRequestDispatcher(PAGE_ADMIN_LISTE_ENSEIGNANT).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_CREER_ENSEIGNANT:
                    if(!request.getParameter("data-id").isEmpty()) {
                        int dataId = Integer.parseInt(request.getParameter("data-id"));
                        request.setAttribute("lEnseignant", enseignantSB.getEnseignantParId(dataId).get(0));
                    } else {
                        request.setAttribute("lEnseignant", null);
                    }
                    request.getRequestDispatcher(PAGE_ADMIN_CREER_ENSEIGNANT).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_LISTE_CANDIDATURE:
                    // int dataId = Integer.parseInt(request.getParameter("data-id"));
                    // request.setAttribute("toutesLesCandidatures", posteSB.getPosteParId(dataId).getListeCandid());
                    redirigerListeCandidatures(request, response);
                    request.getRequestDispatcher(PAGE_ADMIN_VOIR_CANDIDATURE).forward(request, response);
                    break;
                case ACTION_ADMIN_SAUVE_RECRUTEUR:
                    DataService.serviceModifierCreerRecruteur(recruteurSB, request);
                    request.setAttribute("tousLesRecruteurs", recruteurSB.getTousRecruteurs());
                    request.getRequestDispatcher(PAGE_ADMIN_LISTE_RECRUTEUR).forward(request, response);
                    break;
                case ACTION_ADMIN_SAUVE_ENSEIGNANT:
                    request.getRequestDispatcher(PAGE_ADMIN_LISTE_ENSEIGNANT).forward(request, response);
                    break;

                
                case ACTION_DECONNEXION:
                    request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
                    break;
            }
        }
    }
    public void redirigerListeCandidatures(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataService.serviceGetListeCandidatureDunPoste(posteSB, request);
        if (request.getSession().getAttribute("messageErreur") != "")
            // Redirection vers la page courante pour afficher l'erreur
            request.getRequestDispatcher(PAGE_ADMIN_LISTE_POSTE).forward(request, response);
        else
            // Redirection vers la page correspondante
            request.getRequestDispatcher(PAGE_ADMIN_VOIR_CANDIDATURE).forward(request, response);
    }
}

