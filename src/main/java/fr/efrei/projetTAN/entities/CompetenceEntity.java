package fr.efrei.projetTAN.entities;

import fr.efrei.projetTAN.utils.GlobalConst.EnumNivCompt;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.CompetenceConst.*;

@Entity
@Table(name = "competence", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousCompt", query = SELECT_TOUTES_LES_COMPETENCES)
                , @NamedQuery(name = "recupUneCompt", query = SELECT_UNE_COMPETENCE)
        }
)

public class CompetenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Competence", nullable = false)
    private int idCompetence;

    @Basic
    @Column(name = "Nom", nullable = true, length = 50)
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(name = "niveau", nullable = true, length = 50)
    private EnumNivCompt niveau;

    @ManyToMany
    @JoinTable( name = "requiert_compt",
            joinColumns = @JoinColumn( name = "ID_Competence" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Poste" ) )
    private List<PosteEntity> listePostes;

    public CompetenceEntity() {
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public EnumNivCompt getNiveau() {
        return niveau;
    }

    public void setNiveau(EnumNivCompt niveau) {
        this.niveau = niveau;
    }

    public List<PosteEntity> getListePostes() {
        return listePostes;
    }
    public void setListePostes(List<PosteEntity> listePostes) {
        this.listePostes = listePostes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenceEntity)) return false;
        CompetenceEntity that = (CompetenceEntity) o;
        return getIdCompetence() == that.getIdCompetence() && Objects.equals(getNom(), that.getNom()) && getNiveau() == that.getNiveau() && Objects.equals(getListePostes(), that.getListePostes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCompetence(), getNom(), getNiveau(), getListePostes());
    }
}


