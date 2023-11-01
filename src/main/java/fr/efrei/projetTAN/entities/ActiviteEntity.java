package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "activite", schema = "prj_progav")
public class ActiviteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Activite", nullable = false)
    private int idRemarque;
    @Basic
    @Column(name = "activite", nullable = true, length = 50)
    private String remarque;
    @ManyToMany
    @JoinTable( name = "fait_activite",
            joinColumns = @JoinColumn( name = "ID_Activite" ),
            inverseJoinColumns = @JoinColumn( name = "IDenseignant" ) )
    private List<EnseignantEntity> listeEnseignants;

    public int getIdRemarque() {
        return idRemarque;
    }

    public void setIdRemarque(int idRemarque) {
        this.idRemarque = idRemarque;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
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
        return getIdRemarque() == that.getIdRemarque() && Objects.equals(getRemarque(), that.getRemarque()) && Objects.equals(getListeEnseignants(), that.getListeEnseignants());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdRemarque(), getRemarque(), getListeEnseignants());
    }*/
}
