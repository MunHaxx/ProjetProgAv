package fr.efrei.projetTAN;

import java.io.*;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import static fr.efrei.projetTAN.utils.UtilisateurConst.*;
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

    public void init() {
        // Laisser cette fonction vide
        // Je l'ai utilisé pour mes tests avec des System.println
        /*testerRecupToutesCompetences();
        testerRecupUneCompetence(1);
        testerModificationCompetence(1);
        testerRecupUneCompetence(1);*/
        //testerRecupExperiences();
        testerRecupExperienceParId(1);
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

        return (unUtilisateur.getLoginSaisi().equals(motDePasseValide)
                && unUtilisateur.getMotDePasseSaisi().equals(loginValide));
    }

    public void placerUtilisateurDansContexte(HttpServletRequest request) {
        unUtilisateur = new Utilisateur();
        unUtilisateur.setLoginSaisi(request.getParameter(FRM_LOGIN));
        unUtilisateur.setMotDePasseSaisi(request.getParameter(FRM_MDP));
        request.getSession().setAttribute("utilisateur", unUtilisateur);
    }

    public void aiguillerVersLaProchainePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (verifierInfosConnexion(unUtilisateur)) {
            //request.getRequestDispatcher(PAGE_TOUS_LES_EMPLOYES).forward(request, response);
        } else {
            request.getSession().setAttribute("messageErreur", MESSAGE_ERREUR_CREDENTIALS_KO);
            request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
        }
    }

    public void chargerLaPageSuivante(String actionUtilisateur, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (actionUtilisateur == null || actionUtilisateur.isEmpty()) {
            request.getRequestDispatcher(PAGE_INDEX).forward(request, response);
        } else {
            switch (actionUtilisateur) {
                case ACTION_LOGIN:
                    placerUtilisateurDansContexte(request);
                    aiguillerVersLaProchainePage(request, response);
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


    // ---------------------------------------- TESTS ----------------------------------------

    // Méthode pour tester la récupération des informations d'un compétence -> A SUPPRIMER !!!
    public void testerRecupUneCompetence(int id) {
        System.out.println("\n\n--- Début du test de récupération ---");
        System.out.println("Test récupération d'une compétence par ID :");
        int comptIdRecup = 1;
        CompetenceEntity competence = competenceSB.getCompetenceParId(comptIdRecup);
        System.out.println("Compétence récupérée - ID : " + competence.getIdCompetence());
        System.out.println("Nom : " + competence.getNom());
        System.out.println("Niveau : " + competence.getNiveau());
    }
    // Méthode pour tester la récupération des informations des compétences -> A SUPPRIMER !!!
    public void testerRecupToutesCompetences(){
        System.out.println("\n\n--- Début du test de récupération ---");
        System.out.println("Liste de toutes les compétences :");
        for (CompetenceEntity c : competenceSB.getToutesLesCompetences()) {
            System.out.println("ID : " + c.getIdCompetence());
            System.out.println("Nom : " + c.getNom());
            System.out.println("Niveau : " + c.getNiveau());
        }
    }
    // Méthode pour tester la modification d'une compétence -> A SUPPRIMER !!!
    public void testerModificationCompetence(int id) {
        System.out.println("\n\n--- Début du test de modification ---");
        CompetenceEntity competenceAModifier = competenceSB.getCompetenceParId(id);
        if (competenceAModifier != null) {
            competenceAModifier.setNom("NouveauNom");
            competenceAModifier.setNiveau("NouveauNiveau");

            competenceSB.modifierCompetence(competenceAModifier);
            System.out.println("Compétence modifiée avec succès : " + competenceAModifier.getIdCompetence());
        } else {
            System.out.println("La compétence avec l'ID spécifié n'a pas été trouvée.");
        }
    }


    public void testerRecupExperiences() {
        List<ExperienceEntity> toutesLesExperiences = experienceSB.getToutesLesExperiences();
        System.out.println("\n--- Liste de toutes les expériences ---\n");
        for (ExperienceEntity experience : toutesLesExperiences) {
            System.out.println("ID : " + experience.getiDexperience());
            System.out.println("École : " + experience.getEcole());
            System.out.println("Évaluation École : " + experience.getEvalEcole());
            System.out.println("Durée : " + experience.getDuree());

            // Afficher les compétences associées à cette expérience
            List<CompetenceEntity> competences = experience.getListeCompetences();
            System.out.println("Compétences associées :");
            for (CompetenceEntity competence : competences) {
                System.out.println("ID : " + competence.getIdCompetence());
                System.out.println("Nom : " + competence.getNom());
                System.out.println("Niveau : " + competence.getNiveau());
            }

            System.out.println();
        }
    }

    public void testerRecupExperienceParId(int experienceId) {
        ExperienceEntity experience = experienceSB.getExperienceParId(experienceId);
        System.out.println("\n--- Expérience récupérée par ID ---\n");
        System.out.println("ID : " + experience.getiDexperience());
        System.out.println("École : " + experience.getEcole());
        System.out.println("Évaluation École : " + experience.getEvalEcole());
        System.out.println("Durée : " + experience.getDuree());

        // Afficher les compétences associées à cette expérience
        List<CompetenceEntity> competences = experience.getListeCompetences();
        System.out.println("Compétences associées :");
        for (CompetenceEntity competence : competences) {
            System.out.println("ID : " + competence.getIdCompetence());
            System.out.println("Nom : " + competence.getNom());
            System.out.println("Niveau : " + competence.getNiveau());
        }
    }



    // ---------------------------------------- FIN DE TESTS  ----------------------------------------
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }
}

