package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import static fr.efrei.projetTAN.utils.Entity.EntityConst.*;

@Entity
@Table(name = "activite", schema = "prj_progav")
@NamedQueries(
        {
                @NamedQuery(name = "recupToutesLesActivites", query = SELECT_TOUTES_LES_ACTIVITES)
                , @NamedQuery(name = "recupActiviteId", query = SELECT_UNE_ACTIVITE)
        }
)
public class ActiviteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Activite", nullable = false)
    private int idActivite;
    @Basic
    @Column(name = "activite", nullable = true, length = 50)
    private String nomActivite;
    @ManyToMany
    @JoinTable( name = "fait_activite",
            joinColumns = @JoinColumn( name = "ID_Activite" ),
            inverseJoinColumns = @JoinColumn( name = "IDenseignant" ) )
    private List<EnseignantEntity> listeEnseignants;

    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public List<EnseignantEntity> getListeEnseignants() {
        return listeEnseignants;
    }

    public void setListeEnseignants(List<EnseignantEntity> listeEnseignants) {
        this.listeEnseignants = listeEnseignants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActiviteEntity)) return false;
        ActiviteEntity that = (ActiviteEntity) o;
        return getIdActivite() == that.getIdActivite() && Objects.equals(getNomActivite(), that.getNomActivite()) && Objects.equals(getListeEnseignants(), that.getListeEnseignants());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdRemarque(), getRemarque(), getListeEnseignants());
    }*/
}
