package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import static fr.efrei.projetTAN.utils.Entity.ExperienceConst.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "experience", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupToutesLesXp", query = SELECT_TOUTES_LES_EXPERIENCES)
                , @NamedQuery(name = "recupXpId", query = SELECT_EXPERIENCE_PAR_ID)
        }
)

public class ExperienceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDexperience", nullable = false)
    private int idExperience;
    @Basic
    @Column(name = "Ecole", nullable = true, length = 50)
    private String ecole;
    @Basic
    @Column(name = "Eval_ecole", nullable = true, length = 50)
    private String evalEcole;
    @Basic
    @Column(name = "Duree", nullable = true, length = 50)
    private String duree;

    @ManyToMany
    @JoinTable( name = "compt_lie_xp",
            joinColumns = @JoinColumn( name = "IDexperience" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Competence" ) )
    private List<CompetenceEntity> listeCompetences = new ArrayList<>();

    public ExperienceEntity(int idExperience, String ecole, String evalEcole, String duree, List<CompetenceEntity> listeCompetences) {
        this.idExperience = idExperience;
        this.ecole = ecole;
        this.evalEcole = evalEcole;
        this.duree = duree;
        this.listeCompetences = listeCompetences;
    }
    public ExperienceEntity() {

    }

    public int getiDexperience() {
        return idExperience;
    }

    public void setiDexperience(int iDexperience) {
        this.idExperience = iDexperience;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getEvalEcole() {
        return evalEcole;
    }

    public void setEvalEcole(String evalEcole) {
        this.evalEcole = evalEcole;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public List<CompetenceEntity> getListeCompetences() {
        return listeCompetences;
    }

    public void setListeCompetences(List<CompetenceEntity> listeCompetences) {
        this.listeCompetences = listeCompetences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperienceEntity)) return false;
        ExperienceEntity that = (ExperienceEntity) o;
        return getiDexperience() == that.getiDexperience() && Objects.equals(getEcole(), that.getEcole()) && Objects.equals(getEvalEcole(), that.getEvalEcole()) && Objects.equals(getDuree(), that.getDuree()) && Objects.equals(getListeCompetences(), that.getListeCompetences());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getiDexperience(), getEcole(), getEvalEcole(), getDuree(), getListeCompetences());
    }
}





