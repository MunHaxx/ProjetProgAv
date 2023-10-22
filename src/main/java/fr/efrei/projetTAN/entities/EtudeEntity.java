package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.EtudeConst.*;

@Entity
@Table(name = "etude", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousEtudes", query = SELECT_TOUTES_ETUDES)
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

    public EtudeEntity(int idEtude, String titre, Date dateObtention) {
        this.idEtude = idEtude;
        this.titre = titre;
        this.dateObtention = dateObtention;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtudeEntity)) return false;
        EtudeEntity that = (EtudeEntity) o;
        return getIdEtude() == that.getIdEtude() && Objects.equals(getTitre(), that.getTitre()) && Objects.equals(getDateObtention(), that.getDateObtention());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEtude(), getTitre(), getDateObtention());
    }
}
