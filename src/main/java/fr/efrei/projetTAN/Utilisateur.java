package fr.efrei.projetTAN;

public class Utilisateur {

    private String identifiant;
    private String motDePasse;
    private String role;
    private int idRole;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdRole() { return idRole; }

    public void setIdRole(int idRole) { this.idRole = idRole; }
}
