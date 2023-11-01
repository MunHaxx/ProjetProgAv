package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

import fr.efrei.projetTAN.utils.GlobalConst.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import static fr.efrei.projetTAN.utils.GlobalConst.*;
import static fr.efrei.projetTAN.utils.User.UserRecruteurConst.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

public class ControleurRecruteur extends HttpServlet {
    private Utilisateur unUtilisateur;
    private String actionUtilisateur;
    @EJB
    private CompetenceSessionBean competenceSB;
    @EJB
    private ExperienceSessionBean experienceSB;
    @EJB
    private RecruteurSessionBean recruteurSB;
    @EJB
    private EtudeSessionBean etudeSB;
    @EJB
    private CandidatureSessionBean candidatureSB;
    @EJB
    private EcoleSessionBean ecoleSB;
    @EJB
    private PosteSessionBean posteSB;
    @EJB
    private EnseignantSessionBean enseignantSB;

    public void init() {
        
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        actionUtilisateur = request.getParameter("action");
        chargerLaPageSuivante(actionUtilisateur, request, response);
    }

    public void chargerLaPageSuivante(String actionUtilisateur, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (actionUtilisateur == null || actionUtilisateur.isEmpty()) {
            request.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
        } 
        
        else {
            List<RecruteurEntity> listeRecruteurs = recruteurSB.getTousRecruteurs();
            switch (actionUtilisateur) {
                case ACTION_RECRUTEUR_VOIR_LISTE_POSTE:
                    request.setAttribute("tousLesRecruteurs", listeRecruteurs);
                    request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_POSTE).forward(request, response);
                    break;
                case ACTION_RECRUTEUR_VOIR_CREER_POSTE:
                    request.getRequestDispatcher(PAGE_RECRUTEUR_CREER_POSTE).forward(request, response);
                    break;
                case ACTION_RECRUTEUR_VOIR_MODIFIER_PROFIL:
                    request.getRequestDispatcher(PAGE_RECRUTEUR_MODIFIER_PROFIL).forward(request, response);
                    break;
                case ACTION_RECRUTEUR_VOIR_LISTE_CANDIDATURE:
                    request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_CANDIDATURE).forward(request, response);
                    break;
                case ACTION_DECONNEXION:
                    request.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
                    break;
            }
        }
    }
}