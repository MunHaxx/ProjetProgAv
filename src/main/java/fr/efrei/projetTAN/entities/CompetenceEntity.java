package fr.efrei.projetTAN.entities;

import fr.efrei.projetTAN.utils.GlobalConst.EnumNivCompt;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.EntityConst.*;

@Entity
@Table(name = "competence", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousLesCompt", query = SELECT_TOUTES_LES_COMPETENCES)
                , @NamedQuery(name = "recupComptId", query = SELECT_UNE_COMPETENCE_PAR_ID)
                , @NamedQuery(name = "recupComptNom", query = SELECT_UNE_COMPETENCE_PAR_NOM)
        }
)

public class CompetenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Competence", nullable = false)
    private int idCompetence;

    @Basic
    @Column(name = "Nom", nullable = true, length = 50)
    private String nomCompetence;

    @Enumerated(EnumType.STRING)
    @Column(name = "niveau", nullable = true, length = 50)
    private EnumNivCompt niveau;

    @ManyToMany
    @JoinTable( name = "requiert_compt",
            joinColumns = @JoinColumn( name = "ID_Competence" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Poste" ) )
    private List<PosteEntity> listePostes;

    public CompetenceEntity() { }

    public CompetenceEntity(String nomCompetence) {
        this.nomCompetence = nomCompetence;
        this.niveau = null;
        this.listePostes = new ArrayList<PosteEntity>();
    }
    public CompetenceEntity(String nomCompetence, PosteEntity poste) {
        this.nomCompetence = nomCompetence;
        this.niveau = null;
        this.listePostes = new ArrayList<>();
        this.listePostes.add(poste);
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
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
        return getIdCompetence() == that.getIdCompetence() && Objects.equals(getNomCompetence(), that.getNomCompetence()) && getNiveau() == that.getNiveau();
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdCompetence(), getNomCompetence(), getNiveau());
    }*/
}


