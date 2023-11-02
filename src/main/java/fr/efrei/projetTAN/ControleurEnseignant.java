package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

import fr.efrei.projetTAN.utils.GlobalConst.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

// import static fr.efrei.projetTAN.utils.GlobalConst.*;
import static fr.efrei.projetTAN.utils.User.UserEnseignantConst.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

public class ControleurEnseignant extends HttpServlet {
    
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
                case ACTION_ENSEIGNANT_VOIR_LISTE_POSTE:
                    request.setAttribute("tousLesRecruteurs", listeRecruteurs);
                    request.getRequestDispatcher(PAGE_ENSEIGNANT_LISTE_POSTE).forward(request, response);
                    break;
                case ACTION_ENSEIGNANT_VOIR_LISTE_CANDIDATURE:
                    request.getRequestDispatcher(PAGE_ENSEIGNANT_LISTE_CANDIDATURE).forward(request, response);
                    break;
                case ACTION_ENSEIGNANT_VOIR_MODIFIER_PROFIL:
                    request.getRequestDispatcher(PAGE_ENSEIGNANT_MODIFIER_PROFIL).forward(request, response);
                    break;
                case ACTION_DECONNEXION:
                    request.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
                    break;
            }
        }
    }
}