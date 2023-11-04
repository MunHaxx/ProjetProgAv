package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import static fr.efrei.projetTAN.utils.Entity.RecruteurConst.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "recruteur", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousLesRecruteurs", query = SELECT_TOUS_LES_RECRUTEURS)
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

    @OneToMany(mappedBy = "recruteurRespo")
    private List<PosteEntity> estRespoListePostes;

    public RecruteurEntity() {

    }
    public RecruteurEntity(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.estRespoListePostes = new ArrayList<PosteEntity>();
    }

    public int getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(int idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecruteurEntity)) return false;
        RecruteurEntity that = (RecruteurEntity) o;
        return getIdRecruteur() == that.getIdRecruteur() && Objects.equals(getNom(), that.getNom()) && Objects.equals(getPrenom(), that.getPrenom()) && Objects.equals(getEstRespoListePostes(), that.getEstRespoListePostes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRecruteur(), getNom(), getPrenom(), getEstRespoListePostes());
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

    public List<PosteEntity> getEstRespoListePostes() {
        return estRespoListePostes;
    }

    public void setEstRespoListePostes(List<PosteEntity> estRespoListePostes) {
        this.estRespoListePostes = estRespoListePostes;
    }
}

