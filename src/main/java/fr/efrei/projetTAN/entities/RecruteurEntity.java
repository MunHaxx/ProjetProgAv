package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.Objects;

import static fr.efrei.projetTAN.utils.RecruteurConst.*;

@Entity
@Table(name = "recruteur", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousRecruteurs", query = SELECT_TOUS_RECRUTEUR)
                , @NamedQuery(name = "recupRecruteurId", query = SELECT_RECRUTEUR_PAR_ID)
        }
)

public class RecruteurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "ID_recruteur", nullable = false)
    private int idRecruteur;

    @Basic
    @Column(name = "Nom", nullable = true, length = 50)
    private String nom;

    @Basic
    @Column(name = "Prenom", nullable = true, length = 50)
    private String prenom;

    public int getIdRecruteur() {
        return idRecruteur;
    }
    public void setIdRecruteur(int idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecruteurEntity)) return false;
        RecruteurEntity that = (RecruteurEntity) o;
        return getIdRecruteur() == that.getIdRecruteur() && Objects.equals(getNom(), that.getNom()) && Objects.equals(getPrenom(), that.getPrenom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRecruteur(), getNom(), getPrenom());
    }
}

