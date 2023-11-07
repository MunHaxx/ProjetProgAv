package fr.efrei.projetTAN.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.EntityConst.*;

@Entity
@Table(name = "ecole", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupToutesLesEcoles", query = SELECT_TOUTES_LES_ECOLES)
                , @NamedQuery(name = "recupEcoleId", query = SELECT_ECOLE_PAR_ID)
                , @NamedQuery(name = "recupEcoleNom", query = SELECT_ECOLE_PAR_RAISON_SOCIALE)
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
    @OneToMany(mappedBy = "ecole")
    private List<PosteEntity> besoinListePostes;
    @OneToMany(mappedBy = "recoParEcole")
    private List<EnseignantEntity> listeEnseignantReco;

    public EcoleEntity(){}
    public EcoleEntity(String raisonSociale){
        this.raisonSociale = raisonSociale;
        this.besoinListePostes = new ArrayList<PosteEntity>();
        this.listeEnseignantReco = new ArrayList<EnseignantEntity>();
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

    public List<PosteEntity> getBesoinListePostes() {
        return besoinListePostes;
    }
    public void setBesoinListePostes(List<PosteEntity> besoinListePostes) {
        this.besoinListePostes = besoinListePostes;
    }

    public List<EnseignantEntity> getListeEnseignantReco() {
        return listeEnseignantReco;
    }

    public void setListeEnseignantReco(List<EnseignantEntity> listeEnseignantReco) {
        this.listeEnseignantReco = listeEnseignantReco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EcoleEntity)) return false;
        EcoleEntity that = (EcoleEntity) o;
        return getIdEcole() == that.getIdEcole() && Objects.equals(getRaisonSociale(), that.getRaisonSociale());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdEcole(), getRaisonSociale());
    }*/
}
