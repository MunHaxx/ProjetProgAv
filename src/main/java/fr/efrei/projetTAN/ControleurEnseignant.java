package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

import fr.efrei.projetTAN.utils.GlobalConst.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

// import static fr.efrei.projetTAN.utils.GlobalConst.*;
import static fr.efrei.projetTAN.utils.User.UserEnseignantConst.*;
import static fr.efrei.projetTAN.utils.User.LoginConst.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

public class ControleurEnseignant extends HttpServlet {
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
            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
        } 
        else {
            // Récupère et envoi les informations du recruteur connecté
            unUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
            if (unUtilisateur == null) {
                request.getSession().setAttribute("messageErreur", "Impossible de trouver l'utilisateur de cet enseignant");
                request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
            } else {
                EnseignantEntity enseignantActuel = enseignantSB.getEnseignantParId(unUtilisateur.getIdRole());
                if (!"enseignant".equals(unUtilisateur.getRole()) || enseignantActuel == null) {
                    request.getSession().setAttribute("messageErreur", "Cet utilisateur n'est pas un enseignant");
                    request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
                } else {
                    request.setAttribute("lEnseignant", enseignantActuel);
                    // Remise à zéro des messages
                    request.getSession().setAttribute("messageInfo", "");
                    request.getSession().setAttribute("messageErreur", "");
                    
                    switch (actionUtilisateur) {
                        case ACTION_ENSEIGNANT_VOIR_LISTE_POSTE:
                            request.setAttribute("tousLesPostes", posteSB.getTousLesPostes());
                            request.getRequestDispatcher(PAGE_ENSEIGNANT_LISTE_POSTE).forward(request, response);
                            break;
                        case ACTION_ENSEIGNANT_VOIR_LISTE_CANDIDATURE:
                            request.getRequestDispatcher(PAGE_ENSEIGNANT_LISTE_CANDIDATURE).forward(request, response);
                            break;
                        case ACTION_ENSEIGNANT_VOIR_MODIFIER_PROFIL:
                            
                            request.getRequestDispatcher(PAGE_ENSEIGNANT_MODIFIER_PROFIL).forward(request, response);
                            break;
                        case ACTION_ENSEIGNANT_POSTULER:
                            request.getRequestDispatcher(PAGE_ENSEIGNANT_LISTE_POSTE).forward(request, response);
                            break;
                        case ACTION_ENSEIGNANT_SAUVE_MODIFICATION_PROFIL:
                            request.getRequestDispatcher(PAGE_ENSEIGNANT_MODIFIER_PROFIL).forward(request, response);
                            break;
                        case ACTION_DECONNEXION:
                            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
                            break;
                    }
                }
            }
        }
    }
}