package fr.efrei.projetTAN.utils.User;

public final class UserRecruteurConst {
    // Action
    public static final String ACTION_RECRUTEUR_VOIR_LISTE_POSTE = "VoirListePoste";
    public static final String ACTION_RECRUTEUR_VOIR_CREER_POSTE = "VoirCreerPoste";
    public static final String ACTION_RECRUTEUR_VOIR_MODIFIER_PROFIL = "VoirModifierProfil";
    public static final String ACTION_RECRUTEUR_VOIR_LISTE_CANDIDATURE = "VoirListeCandidature";
    public static final String ACTION_RECRUTEUR_SAUVE_CREATION_POSTE = "SauveCreationPosteRecruteur";
    public static final String ACTION_RECRUTEUR_SAUVE_MODIFICATION_PROFIL = "SauveModifProfil";
    public static final String ACTION_RECRUTEUR_ACCEPTER_CANDIDATURE = "AccepterCandidature";
    public static final String ACTION_RECRUTEUR_REJETER_CANDIDATURE = "RejeterCandidature";

    // Lien de page
    public static final String PAGE_RECRUTEUR_LISTE_POSTE = "/WEB-INF/Recruteur/listePosteRecruteur.jsp";
    public static final String PAGE_RECRUTEUR_CREER_POSTE = "/WEB-INF/Recruteur/creerPosteRecruteur.jsp";
    public static final String PAGE_RECRUTEUR_MODIFIER_PROFIL = "/WEB-INF/Recruteur/modifierProfilRecruteur.jsp";
    public static final String PAGE_RECRUTEUR_LISTE_CANDIDATURE = "/WEB-INF/Recruteur/listeCandidatureRecruteur.jsp";
    
    // Champ Modifier Profil
    public static final String CHAMP_RECRUTEUR_MODIFICATION_NOM = "champModifNomRecruteur";
    public static final String CHAMP_RECRUTEUR_MODIFICATION_PRENOM = "champModifPrenomRecruteur";
    
    // Champ Créer Poste
    public static final String CHAMP_CREER_POSTE_TITRE = "champTitre";
    
    public static final String CHAMP_CREER_POSTE_ECOLE = "champEcole";
    public static final String CHAMP_CREER_POSTE_CONTRAT = "champContrat";
    public static final String CHAMP_CREER_POSTE_PERIODE = "champPeriode";
    public static final String CHAMP_CREER_POSTE_NIVEAU = "champNiveau";

    public static final String CHAMP_CREER_POSTE_COMPETENCE_1 = "champCompetence1";
    public static final String CHAMP_CREER_POSTE_COMPETENCE_2 = "champCompetence2";
    public static final String CHAMP_CREER_POSTE_COMPETENCE_3 = "champCompetence3";

    public static final String CHAMP_CREER_POSTE_CONTRAINTES_1 = "champContrainte1";
    public static final String CHAMP_CREER_POSTE_CONTRAINTES_2 = "champContrainte2";
    public static final String CHAMP_CREER_POSTE_CONTRAINTES_3 = "champContrainte3";
    
    public static final String CHAMP_CREER_POSTE_REMARQUES_1 = "champRemarque1";
    public static final String CHAMP_CREER_POSTE_REMARQUES_2 = "champRemarque2";
    public static final String CHAMP_CREER_POSTE_REMARQUES_3 = "champRemarque3";

    // Autre
    public static final String ID_RECRUTEUR = "idRecruteur";
}
