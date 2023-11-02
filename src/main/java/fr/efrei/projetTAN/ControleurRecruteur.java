package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

import fr.efrei.projetTAN.utils.GlobalConst.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

// import static fr.efrei.projetTAN.utils.GlobalConst.*;
import static fr.efrei.projetTAN.utils.User.UserRecruteurConst.*;

import fr.efrei.projetTAN.entities.*;
import fr.efrei.projetTAN.session.*;

public class ControleurRecruteur extends HttpServlet {
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
                case ACTION_RECRUTEUR_SAUVE_CREATION_POSTE:
                    // RecruteurEntity recruteur = new RecruteurEntity(idRecruteurSelect,
                    //         request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_NOM),
                    //         request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_PRENOM));
                    // recruteurSessionBean.modifierRecruteur(recruteur);

                    // // Info normal
                    // request.getParameter(CHAMP_CREER_POSTE_ECOLE));
                    // request.getParameter(CHAMP_CREER_POSTE_CONTRAT));
                    // request.getParameter(CHAMP_CREER_POSTE_PERIODE));
                    // request.getParameter(CHAMP_CREER_POSTE_NIVEAU));
                    
                    // // Compétences
                    // request.getParameter(CHAMP_CREER_POSTE_COMPETENCE_1));
                    // request.getParameter(CHAMP_CREER_POSTE_COMPETENCE_2));
                    // request.getParameter(CHAMP_CREER_POSTE_COMPETENCE_3));

                    // // Contraintes
                    // request.getParameter(CHAMP_CREER_POSTE_CONTRAINTES_1));
                    // request.getParameter(CHAMP_CREER_POSTE_CONTRAINTES_2));
                    // request.getParameter(CHAMP_CREER_POSTE_CONTRAINTES_3));

                    // // Remarques
                    // request.getParameter(CHAMP_CREER_POSTE_REMARQUES_1));
                    // request.getParameter(CHAMP_CREER_POSTE_REMARQUES_2));
                    // request.getParameter(CHAMP_CREER_POSTE_REMARQUES_3));

                    request.getRequestDispatcher(PAGE_RECRUTEUR_CREER_POSTE).forward(request, response);
                    break;
                case ACTION_RECRUTEUR_SAUVE_MODIFICATION_PROFIL:
                    // int idRecruteurSelect = Integer.parseInt(request.getParameter(ID_RECRUTEUR));
                    // RecruteurEntity recruteur = new RecruteurEntity(idRecruteurSelect,
                    //         request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_NOM),
                    //         request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_PRENOM));
                    // recruteurSessionBean.modifierRecruteur(recruteur);
                    System.out.println("\n\n\n " + request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_NOM) + " " + request.getParameter(CHAMP_RECRUTEUR_MODIFICATION_PRENOM) + "\n\n\n");
                    request.getRequestDispatcher(PAGE_RECRUTEUR_MODIFIER_PROFIL).forward(request, response);
                    break;
                case ACTION_RECRUTEUR_ACCEPTER_CANDIDATURE:
                
                    break;
                case ACTION_RECRUTEUR_REJETER_CANDIDATURE:
                
                    break;
            }
        }
    }
}