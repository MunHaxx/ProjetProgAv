package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
                request.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
            } else {
                RecruteurEntity recruteurActuel = recruteurSB.getRecruteurParId(unUtilisateur.getIdRole());
                if (!"recruteur".equals(unUtilisateur.getRole()) || recruteurActuel == null) {
                    request.getSession().setAttribute("messageErreur", "Cet utilisateur n'est pas un recruteur");
                    request.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
                } else {
                    request.setAttribute("leRecruteur", recruteurActuel);

                    switch (actionUtilisateur) {
                        case ACTION_RECRUTEUR_VOIR_LISTE_POSTE:
                            // Récupère et envoi la liste des recruteurs
                            List<RecruteurEntity> listeRecruteurs = recruteurSB.getTousRecruteurs();
                            request.setAttribute("tousLesRecruteurs", listeRecruteurs);
                            // Redirection vers la page correspondante
                            request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_POSTE).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_VOIR_CREER_POSTE:
                            // Redirection vers la page correspondante
                            request.getRequestDispatcher(PAGE_RECRUTEUR_CREER_POSTE).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_VOIR_MODIFIER_PROFIL:
                            request.setAttribute("idRecruteur", recruteurActuel.getIdRecruteur());
                            // Redirection vers la page correspondante
                            request.getRequestDispatcher(PAGE_RECRUTEUR_MODIFIER_PROFIL).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_VOIR_LISTE_CANDIDATURE:
                            // Redirection vers la page correspondante
                            request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_CANDIDATURE).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_SAUVE_CREATION_POSTE:
                            
                            request.getRequestDispatcher(PAGE_RECRUTEUR_CREER_POSTE).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_SAUVE_MODIFICATION_PROFIL:
                            // int idRecruteurSelect = Integer.parseInt(request.getParameter(ID_RECRUTEUR));
                            // RecruteurEntity recruteur = new RecruteurEntity(idRecruteurSelect,
                            //         request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_NOM),
                            //         request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_PRENOM));
                            // recruteurSessionBean.modifierRecruteur(recruteur);


//                            request.getSession().setAttribute("idRecruteur", recruteurActuel.getIdRecruteur());
                            System.out.println("\n\n" + request.getParameter("idRecruteur")/*.getIdRecruteur()*/ + "\n\n");
                            String msgInfo = DataService.serviceModifierRecruteur(recruteurSB, request);
                            System.out.println("\n\n" + msgInfo + "\n\n");
                            request.setAttribute("messageErreur", msgInfo);
                            // Redirection vers la page correspondante
                            request.getRequestDispatcher(PAGE_RECRUTEUR_MODIFIER_PROFIL).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_ACCEPTER_CANDIDATURE:
                            request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_CANDIDATURE).forward(request, response);
                            break;
                        case ACTION_RECRUTEUR_REJETER_CANDIDATURE:
                            request.getRequestDispatcher(PAGE_RECRUTEUR_LISTE_CANDIDATURE).forward(request, response);
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