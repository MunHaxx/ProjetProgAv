package fr.efrei.projetTAN.entities;
import jakarta.persistence.*;

import java.util.Objects;

import static fr.efrei.projetTAN.utils.EcoleConst.*;

@Entity
@Table(name = "ecole", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupToutesEcoles", query = SELECT_TOUTES_ECOLES)
                , @NamedQuery(name = "recupEcoleId", query = SELECT_ECOLE_PAR_ID)
        }
)
public class EcoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Ecole", nullable = false)
    private int idEcole;
    @Basic
    @Column(name = "Raison_sociale", nullable = true, length = 50)
    private String raisonSociale;

    public EcoleEntity(int idEcole, String raisonSociale) {
        this.idEcole = idEcole;
        this.raisonSociale = raisonSociale;
    }
    public EcoleEntity(){
    }


    public int getIdEcole() {
        return idEcole;
    }
    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }
    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EcoleEntity)) return false;
        EcoleEntity that = (EcoleEntity) o;
        return getIdEcole() == that.getIdEcole() && Objects.equals(getRaisonSociale(), that.getRaisonSociale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEcole(), getRaisonSociale());
    }
}
