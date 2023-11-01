package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.CompetenceConst.*;
import static fr.efrei.projetTAN.utils.GlobalConst.*;

@Entity
@Table(name = "competence", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousCompt", query = SELECT_TOUTES_LES_COMPETENCES)
                , @NamedQuery(name = "recupUneCompt", query = SELECT_UNE_COMPETENCE)
                , @NamedQuery(name = "modifUneCompt", query = MODIF_UNE_COMPETENCE)
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
    private NiveauCompetence niveau;

    public CompetenceEntity(int idCompetence, String nom, NiveauCompetence niveau) {
        this.idCompetence = idCompetence;
        this.nom = nom;
        this.niveau = niveau;
    }

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

    public NiveauCompetence getNiveau() {
        return niveau;
    }

    public void setNiveau(NiveauCompetence niveau) {
        this.niveau = niveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetenceEntity)) return false;
        CompetenceEntity that = (CompetenceEntity) o;
        return getIdCompetence() == that.getIdCompetence() && Objects.equals(getNom(), that.getNom()) && getNiveau() == that.getNiveau();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCompetence(), getNom(), getNiveau());
    }
}


