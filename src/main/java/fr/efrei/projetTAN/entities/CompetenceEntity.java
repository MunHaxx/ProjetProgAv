package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.Objects;

import static fr.efrei.projetTAN.utils.CompetenceConst.*;

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

    @Basic
    @Column(name = "niveau", nullable = true, length = 50)
    private String niveau;

    public CompetenceEntity(Integer id, String nom, String niveau){
        this.idCompetence = id;
        this.nom = nom;
        this.niveau = niveau;
    }
    public CompetenceEntity() {
    }

    public int getIdCompetence() { return idCompetence; }
    public void setIdCompetence(int idCompetence) { this.idCompetence = idCompetence; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        fr.efrei.projetTAN.entities.CompetenceEntity that = (fr.efrei.projetTAN.entities.CompetenceEntity) o;

        if (idCompetence != that.idCompetence) return false;
        if (!Objects.equals(nom, that.nom)) return false;
        return Objects.equals(niveau, that.niveau);
    }

    @Override
    public int hashCode() {
        int result = idCompetence;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (niveau != null ? niveau.hashCode() : 0);
        return result;
    }
}


