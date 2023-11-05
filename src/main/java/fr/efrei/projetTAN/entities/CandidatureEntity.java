package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import static fr.efrei.projetTAN.utils.Entity.CandidatureConst.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "candidature", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupToutesLesCandidatures", query = SELECT_TOUTES_LES_CANDIDATURES)
                , @NamedQuery(name = "recupCandidatureId", query = SELECT_CANDIDATURE_PAR_ID)
        }
)
public class CandidatureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Candidature", nullable = false)
    private int idCandidature;
    @ManyToOne
    @JoinColumn(name = "ID_Poste")
    private PosteEntity poste;
    @ManyToOne
    @JoinColumn(name = "IDenseignant")
    private EnseignantEntity enseignant;
    @Basic
    @Column(name = "Contacte_le", nullable = true)
    private Date dateCandid;
    @Basic
    @Column(name = "Decision", nullable = true, length = 50)
    private String decision;

    public CandidatureEntity() { }

    public int getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(int idCandidature) {
        this.idCandidature = idCandidature;
    }

    public PosteEntity getPoste() {
        return poste;
    }

    public void setPoste(PosteEntity poste) {
        this.poste = poste;
    }

    public EnseignantEntity getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(EnseignantEntity enseignant) {
        this.enseignant = enseignant;
    }

    public Date getDateCandid() {
        return dateCandid;
    }

    public void setDateCandid(Date dateCandid) {
        this.dateCandid = dateCandid;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidatureEntity)) return false;
        CandidatureEntity that = (CandidatureEntity) o;
        return getIdCandidature() == that.getIdCandidature() && Objects.equals(getPoste(), that.getPoste()) && Objects.equals(getEnseignant(), that.getEnseignant()) && Objects.equals(getDateCandid(), that.getDateCandid()) && Objects.equals(getDecision(), that.getDecision());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCandidature(), getPoste(), getEnseignant(), getDateCandid(), getDecision());
    }

}
