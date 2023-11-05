package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import static fr.efrei.projetTAN.utils.Entity.EtudeConst.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "etude", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupToutesLesEtudes", query = SELECT_TOUTES_LES_ETUDES)
                , @NamedQuery(name = "recupEtudeId", query = SELECT_ETUDE_PAR_ID)
        }
)

public class EtudeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Etude", nullable = false)
    private int idEtude;
    @Basic
    @Column(name = "Titre", nullable = true, length = 50)
    private String titre;
    @Basic
    @Column(name = "Date_obtention", nullable = true)
    private Date dateObtention;
    @ManyToOne
    @JoinColumn(name = "IDenseignant")
    private EnseignantEntity enseignant;

    public EtudeEntity() {

    }

    public int getIdEtude() {
        return idEtude;
    }

    public void setIdEtude(int idEtude) {
        this.idEtude = idEtude;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }

    public EnseignantEntity getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(EnseignantEntity enseignant) {
        this.enseignant = enseignant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtudeEntity)) return false;
        EtudeEntity that = (EtudeEntity) o;
        return getIdEtude() == that.getIdEtude() && Objects.equals(getTitre(), that.getTitre()) && Objects.equals(getDateObtention(), that.getDateObtention()) && Objects.equals(getEnseignant(), that.getEnseignant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEtude(), getTitre(), getDateObtention(), getEnseignant());
    }
}
