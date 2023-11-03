package fr.efrei.projetTAN.utils.User;

public final class LoginConst {
    // Action
    public static final String ACTION_LOGIN = "Login";
    public static final String ACTION_DECONNEXION = "Deconnexion";

    // Lien de page
    public static final String PAGE_CONNEXION = "/WEB-INF/index.jsp";
    public static final String PAGE_LOGIN_RECRUTEUR = "/WEB-INF/Recruteur/listePosteRecruteur.jsp";
    public static final String PAGE_LOGIN_ENSEIGNANT = "/WEB-INF/Enseignant/listePosteEnseignant.jsp";
    public static final String PAGE_LOGIN_ADMIN = "/WEB-INF/Admin/listePosteAdmin.jsp";

    // Champs connexion
    public static final String CHAMP_LOGIN = "champLogin";
    public static final String CHAMP_PASSWORD = "champPassword";

    // Message d'erreur
    public static final String MESSAGE_ERREUR_CREDENTIALS_KO = "Infos de connexion non valides. Merci de les saisir à nouveau";

}
