package fr.efrei.projetTAN.utils.User;

public final class UserAdminConst {
    // Action
    public static final String ACTION_ADMIN_VOIR_LISTE_POSTE = "VoirListePoste";
    public static final String ACTION_ADMIN_VOIR_LISTE_RECRUTEUR = "VoirListeRecruteur";
    public static final String ACTION_ADMIN_VOIR_CREER_RECRUTEUR = "VoirCreerRecruteur";
    public static final String ACTION_ADMIN_VOIR_LISTE_ENSEIGNANT = "VoirListeEnseignant";
    public static final String ACTION_ADMIN_VOIR_CREER_ENSEIGNANT = "VoirCreerEnseignant";
    public static final String ACTION_ADMIN_VOIR_LISTE_CANDIDATURE = "VoirListeCandidature";
    public static final String ACTION_ADMIN_SAUVE_RECRUTEUR = "SauveRecruteur";
    public static final String ACTION_ADMIN_SAUVE_ENSEIGNANT = "SauveEnseignant";
    public static final String ACTION_ADMIN_ACCEPTER_CANDIDATURE = "AccepterCandidature";
    public static final String ACTION_ADMIN_REJETER_CANDIDATURE = "RejeterCandidature";

    // Lien de page
    public static final String PAGE_ADMIN_LISTE_POSTE = "/WEB-INF/Admin/listePosteAdmin.jsp";
    public static final String PAGE_ADMIN_LISTE_RECRUTEUR = "/WEB-INF/Admin/listeRecruteur.jsp";
    public static final String PAGE_ADMIN_CREER_RECRUTEUR = "/WEB-INF/Admin/creerRecruteur.jsp";
    public static final String PAGE_ADMIN_LISTE_ENSEIGNANT = "/WEB-INF/Admin/listeEnseignant.jsp";
    public static final String PAGE_ADMIN_CREER_ENSEIGNANT = "/WEB-INF/Admin/creerEnseignant.jsp";
    public static final String PAGE_ADMIN_VOIR_CANDIDATURE = "/WEB-INF/Admin/listeCandidature.jsp";
    

     /**************************************************************************************
     ******************************** CHAMPS CREER RECRUTEUR *******************************
     **************************************************************************************/
    public static final String CHAMP_ADMIN_CREER_RECRUTEUR_NOM = "champModifNomRecruteur";
    public static final String CHAMP_ADMIN_CREER_RECRUTEUR_PRENOM = "champModifPrenomRecruteur";


    /**************************************************************************************
     ******************************** CHAMPS CREER ENSEIGNANT *****************************
     **************************************************************************************/
    // Information général
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NOM = "champNom";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_SITE = "champSite";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_PRENOM = "champchampPrenomSite";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_MAIL = "champMail";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_SOUTENU_PAR = "champSoutient";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_TELEPHONE = "champTelephone";
    
    // Interet
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_INTERET_1 = "champInteret1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_INTERET_2 = "champInteret2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_INTERET_3 = "champInteret3";

    // Activité
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ACTIVITE_1 = "champActivite1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ACTIVITE_2 = "champActivite2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ACTIVITE_3 = "champActivite3";
    
    // Etude
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ETUDE_1 = "champEtude1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_DATE_1 = "champDate1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ETUDE_2 = "champEtude2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_DATE_2 = "champDate2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ETUDE_3 = "champEtude3";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_DATE_3 = "champDate3";
    
    // Experience 1
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ECOLE_1 = "champEcole1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_DUREE_1 = "champDuree1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_EVALUATION_1 = "champEvaluation1";

    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_1_1 = "champCompetence1.1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_1_1 = "champNiveau1.1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_1_2 = "champCompetence1.2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_1_2 = "champNiveau1.2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_1_3 = "champCompetence1.3";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_1_3 = "champNiveau1.3";

    // Experience 2
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ECOLE_2 = "champEcole2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_DUREE_2 = "champDuree2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_EVALUATION_2 = "champEvaluation2";

    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_2_1 = "champCompetence2.1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_2_1 = "champNiveau2.1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_2_2 = "champCompetence2.2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_2_2 = "champNiveau2.2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_2_3 = "champCompetence2.3";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_2_3 = "champNiveau2.3";

    // Experience 3
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_ECOLE_3 = "champEcole3";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_DUREE_3 = "champDuree3";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_EVALUATION_3 = "champEvaluation3";

    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_3_1 = "champCompetence3.1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_3_1 = "champNiveau3.1";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_3_2 = "champCompetence3.2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_3_2 = "champNiveau3.2";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_COMPETENCE_3_3 = "champCompetence3.3";
    public static final String CHAMP_ADMIN_CREER_ENSEIGNANT_NIVEAU_3_3 = "champNiveau3.3";
}
