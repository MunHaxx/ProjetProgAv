package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

import fr.efrei.projetTAN.utils.GlobalConst.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import static fr.efrei.projetTAN.utils.GlobalConst.*;
import static fr.efrei.projetTAN.utils.User.LoginConst.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

public class Controleur extends HttpServlet {
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
        // Laisser cette fonction vide
        // Je l'ai utilisé pour mes tests avec des System.println
        // DataManager.testerRecupToutesCompetences(competenceSB);
        // DataManager.testerRecupUneCompetence(competenceSB, 1);
        // DataManager.testerModificationCompetence(competenceSB, 1);
        // DataManager.testerRecupUneCompetence(competenceSB, 1);
        // DataManager.testerRecupExperiences(experienceSB);
        // DataManager.testerRecupExperienceParId(experienceSB, 1);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        actionUtilisateur = request.getParameter("action");
//        tousLesEmployes = employesSessionBean.getTousLesEmployes();
//        request.getSession().setAttribute("tousLesEmployes", tousLesEmployes);
        chargerLaPageSuivante(actionUtilisateur, request, response);
    }

    // Une tâche <-> une méthode
    public boolean verifierInfosConnexion(Utilisateur unUtilisateur) {
        String motDePasseValide = getServletContext().getInitParameter("login");
        String loginValide = getServletContext().getInitParameter("motDePasse");
        return (unUtilisateur.getIdentifiant().equals(motDePasseValide)
                && unUtilisateur.getMotDePasse().equals(loginValide));
    }

    public void placerUtilisateurDansContexte(HttpServletRequest request) {

        String identifiant = request.getParameter(FRM_LOGIN);
        String motDePasse = request.getParameter(FRM_MDP);
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
            request.getSession().setAttribute("utilisateur", unUtilisateur);
        }
        
    }
    
    // seulement pour le login, vérif type user, rediriger
    // Page d'accuil différente selon le type d'utilisateur connecté
    public void dirigerVersPageAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur unUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
    
        if (unUtilisateur != null) {
            String role = unUtilisateur.getRole();
    
            if ("admin".equals(role)) {
                List<RecruteurEntity> listeRecruteurs = recruteurSB.getTousRecruteurs();
                request.setAttribute("tousLesRecruteurs", listeRecruteurs);
                request.getRequestDispatcher("/WEB-INF/Admin/listeRecruteur.jsp").forward(request, response);
            } else if ("recruteur".equals(role)) {
                List<RecruteurEntity> listeRecruteurs = recruteurSB.getTousRecruteurs();
                request.setAttribute("tousLesRecruteurs", listeRecruteurs);
                request.getRequestDispatcher(PAGE_RECRUTEUR).forward(request, response);
            } else if ("enseignant".equals(role)) {
                request.getRequestDispatcher(PAGE_ENSEIGNANT).forward(request, response);
            } else {
                request.getSession().setAttribute("messageErreur", "Rôle non valide");
                request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
            }
        } else {
            // Gérer le cas où l'utilisateur n'est pas authentifié
            request.getSession().setAttribute("messageErreur", MESSAGE_ERREUR_CREDENTIALS_KO);
            request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
        }
    }

    // un login, enseignant, recruteur, admin 
    public void chargerLaPageSuivante(String actionUtilisateur, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (actionUtilisateur == null || actionUtilisateur.isEmpty()) {
            request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
        } 
        // if recruteur, if enseignant, if admin, selon les consts définies dans chaque
        else {
            switch (actionUtilisateur) {
                case ACTION_LOGIN:
                    placerUtilisateurDansContexte(request);
                    dirigerVersPageAccueil(request, response);
                    break;
                /*case ACTION_DETAILS:
                    idEmployeSelect = Integer.parseInt(request.getParameter(FRM_ID_EMPL_SELECT));
                    employe = employesSessionBean.getEmployeParId(idEmployeSelect);
                    request.getSession().setAttribute("employe", employe);
                    request.getRequestDispatcher(PAGE_DETAILS_EMPLOYE).forward(request, response);
                    break;
                case ACTION_SUPPRIMER:
                    idEmployeSelect = Integer.parseInt(request.getParameter(FRM_ID_EMPL_SELECT));
                    employe = employesSessionBean.getEmployeParId(idEmployeSelect);
                    employesSessionBean.supprimerEmploye(employe);
                    request.getSession().setAttribute("tousLesEmployes", employesSessionBean.getTousLesEmployes());
                    request.getRequestDispatcher(PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;
                case ACTION_VOIR_LISTE:
                    request.getSession().setAttribute("tousLesEmployes", employesSessionBean.getTousLesEmployes());
                    request.getRequestDispatcher(PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;
                case ACTION_MODIFIER:
                    idEmployeSelect = Integer.parseInt(request.getParameter(FRM_ID_EMPL_SELECT));
                    employe = new EmployesEntity(idEmployeSelect,
                            request.getParameter(EmployesConstantes.CHAMP_NOM),
                            request.getParameter(EmployesConstantes.CHAMP_PRENOM),
                            request.getParameter(EmployesConstantes.CHAMP_TELDOMICILE),
                            request.getParameter(EmployesConstantes.CHAMP_TELPORTABLE),
                            request.getParameter(EmployesConstantes.CHAMP_TELPRO),
                            request.getParameter(EmployesConstantes.CHAMP_ADRESSE),
                            request.getParameter(EmployesConstantes.CHAMP_CODEPOSTAL),
                            request.getParameter(EmployesConstantes.CHAMP_VILLE),
                            request.getParameter(EmployesConstantes.CHAMP_EMAIL));
                    employesSessionBean.modifierEmploye(employe);
                    request.getSession().setAttribute("tousLesEmployes", employesSessionBean.getTousLesEmployes());
                    request.getRequestDispatcher(PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;*/
            }
        }
    }
}

