package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.CandidatureConst.*;

@Entity
@Table(name = "candidature", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupToutesCandidatures", query = SELECT_TOUTES_CANDIDATURES)
                , @NamedQuery(name = "recupCandidatureId", query = SELECT_CANDIDATURE_PAR_ID)
                , @NamedQuery(name = "recupCandidatureIdEnseignant", query = SELECT_CANDIDATURE_PAR_IDENSEIGNANT)
                , @NamedQuery(name = "recupCandidatureIdPoste", query = SELECT_CANDIDATURE_PAR_IDPOSTE)
        }
)
public class CandidatureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Candidature", nullable = false)
    private int idCandidature;
    @Basic
    @Column(name = "ID_Poste", nullable = false)
    private int idPoste;
    @Basic
    @Column(name = "IDenseignant", nullable = false)
    private int idEnseignant;
    @Basic
    @Column(name = "Contacte_le", nullable = true)
    private Date dateCandid;
    @Basic
    @Column(name = "Decision", nullable = true, length = 50)
    private String decision;

    public CandidatureEntity(int idCandidature, int idPoste, int iDenseignant, Date dateCandid, String decision) {
        this.idCandidature = idCandidature;
        this.idPoste = idPoste;
        this.idEnseignant = iDenseignant;
        this.dateCandid = dateCandid;
        this.decision = decision;
    }
    public CandidatureEntity() {

    }


    public int getIdCandidature() {
        return idCandidature;
    }
    public void setIdCandidature(int idCandidature) {
        this.idCandidature = idCandidature;
    }

    public int getIdPoste() {
        return idPoste;
    }
    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public int getiDenseignant() {
        return idEnseignant;
    }
    public void setiDenseignant(int iDenseignant) {
        this.idEnseignant = iDenseignant;
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
        return getIdCandidature() == that.getIdCandidature() && getIdPoste() == that.getIdPoste() && getiDenseignant() == that.getiDenseignant() && Objects.equals(getDateCandid(), that.getDateCandid()) && Objects.equals(getDecision(), that.getDecision());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCandidature(), getIdPoste(), getiDenseignant(), getDateCandid(), getDecision());
    }
}
