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

    // un login, enseignant, recruteur, admin 
    public void chargerLaPageSuivante(String actionUtilisateur, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (actionUtilisateur == null || actionUtilisateur.isEmpty()) {
            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
        } 
        // if recruteur, if enseignant, if admin, selon les consts définies dans chaque
        else {
            List<RecruteurEntity> listeRecruteurs = recruteurSB.getTousRecruteurs();

            switch (actionUtilisateur) {
                case ACTION_ADMIN_VOIR_LISTE_POSTE:
                    request.getSession().setAttribute("messageInfo", "");
                    request.getSession().setAttribute("messageErreur", "");
                    request.getRequestDispatcher(PAGE_ADMIN_LISTE_POSTE).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_LISTE_RECRUTEUR:
                    request.setAttribute("tousLesRecruteurs", listeRecruteurs);
                    request.getRequestDispatcher(PAGE_ADMIN_LISTE_RECRUTEUR).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_CREER_RECRUTEUR:
                    if(request.getParameter("data-id") != null) {
                        int dataId = Integer.parseInt(request.getParameter("data-id"));
                        System.out.println("\n\n\ndata-id du bouton cliqué : " + dataId + "\n\n\n");
                    }
                    request.getRequestDispatcher(PAGE_ADMIN_CREER_RECRUTEUR).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_LISTE_ENSEIGNANT:
                    request.getRequestDispatcher(PAGE_ADMIN_LISTE_ENSEIGNANT).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_CREER_ENSEIGNANT:
                    request.getRequestDispatcher(PAGE_ADMIN_CREER_ENSEIGNANT).forward(request, response);
                    break;
                case ACTION_ADMIN_VOIR_LISTE_CANDIDATURE:
                    request.getRequestDispatcher(PAGE_ADMIN_VOIR_CANDIDATURE).forward(request, response);
                    break;
                case ACTION_ADMIN_SAUVE_RECRUTEUR:
                    request.setAttribute("tousLesRecruteurs", listeRecruteurs);
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
}

