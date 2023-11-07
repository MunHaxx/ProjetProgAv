package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import static fr.efrei.projetTAN.utils.GlobalConst.*;
import static fr.efrei.projetTAN.utils.User.LoginConst.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

public class ControleurLogin extends HttpServlet {
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

    public void placerUtilisateurDansContexte(HttpServletRequest request) {
        String identifiant = request.getParameter(CHAMP_LOGIN);
        String motDePasse = request.getParameter(CHAMP_PASSWORD);
        String role = null;

        if (identifiant != null && motDePasse != null) {
            // Vérifiez les identifiants et le mot de passe pour chaque utilisateur
            if (identifiant.equals("admin") && motDePasse.equals("prograv")) {
                role = "admin";
            } else if (identifiant.equals("recruteur") && motDePasse.equals("prograv")) {
                role = "recruteur";
            } else if (identifiant.equals("enseignant") && motDePasse.equals("prograv")) {
                role = "enseignant";
            }
        }

        if (role != null) {
            unUtilisateur = new Utilisateur();
            unUtilisateur.setIdentifiant(identifiant);
            unUtilisateur.setMotDePasse(motDePasse);
            unUtilisateur.setRole(role);
            unUtilisateur.setIdRole(1); // ID = 1 par défaut, à améliorer dans une version future
            request.getSession().setAttribute("utilisateur", unUtilisateur);
        }
        
    }

    // Page d'accueil différente selon le type d'utilisateur connecté
    public void dirigerVersPageAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur unUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
    
        if (unUtilisateur != null) {
            String role = unUtilisateur.getRole();
            request.getSession().setAttribute("messageInfo", "");
            request.getSession().setAttribute("messageErreur", "");

            if ("admin".equals(role)) {
                request.getSession().setAttribute("utilisateur", unUtilisateur);
                request.getSession().setAttribute("lAdmin", unUtilisateur);
                request.setAttribute("tousLesPostes", posteSB.getTousLesPostes());
                request.getRequestDispatcher(PAGE_LOGIN_ADMIN).forward(request, response);
            } else if ("recruteur".equals(role)) {
                List<RecruteurEntity> listeRecruteurs = recruteurSB.getTousRecruteurs();
                request.getSession().setAttribute("utilisateur", unUtilisateur);
                RecruteurEntity recruteurActuel = recruteurSB.getRecruteurParId(unUtilisateur.getIdRole()).get(0);
                request.setAttribute("leRecruteur", recruteurActuel);
                request.setAttribute("tousLesRecruteurs", listeRecruteurs);
                request.getRequestDispatcher(PAGE_LOGIN_RECRUTEUR).forward(request, response);
            } else if ("enseignant".equals(role)) {
                request.getSession().setAttribute("utilisateur", unUtilisateur);
                EnseignantEntity enseignantActuel = enseignantSB.getEnseignantParId(unUtilisateur.getIdRole()).get(0);
                request.getSession().setAttribute("lEnseignant", enseignantActuel);
                request.setAttribute("tousLesPostes", posteSB.getTousLesPostes());
                request.getRequestDispatcher(PAGE_LOGIN_ENSEIGNANT).forward(request, response);
            } else {
                request.getSession().setAttribute("messageErreur", "Rôle non valide");
                request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
            }
        } else {
            // Gérer le cas où l'utilisateur n'est pas authentifié
            request.getSession().setAttribute("messageErreur", MESSAGE_ERREUR_IDENTIFIANTS_INTROUVABLES);
            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
        }
    }

    public void chargerLaPageSuivante(String actionUtilisateur, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (actionUtilisateur == null || actionUtilisateur.isEmpty()) {
            request.getRequestDispatcher(PAGE_CONNEXION).forward(request, response);
        }
        else if (actionUtilisateur.equals(ACTION_LOGIN)){
            placerUtilisateurDansContexte(request);
            dirigerVersPageAccueil(request, response);
        }
    }
}

