package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import static fr.efrei.projetTAN.utils.Entity.EntityConst.*;

@Entity
@Table(name = "interet", schema = "prj_progav")
@NamedQueries(
        {
                @NamedQuery(name = "recupTousLesInterets", query = SELECT_TOUS_LES_INTERETS)
                , @NamedQuery(name = "recupInteretId", query = SELECT_UN_INTERET)
        }
)
public class InteretEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Interet", nullable = false)
    private int idInteret;
    @Basic
    @Column(name = "Interet", nullable = true, length = 50)
    private String nomInteret;
    @ManyToMany
    @JoinTable( name = "est_interesse",
            joinColumns = @JoinColumn( name = "ID_Interet" ),
            inverseJoinColumns = @JoinColumn( name = "IDenseignant" ) )
    private List<EnseignantEntity> listeEnseignants;

    public int getIdInteret() {
        return idInteret;
    }

    public void setIdInteret(int idInteret) {
        this.idInteret = idInteret;
    }

    public String getNomInteret() {
        return nomInteret;
    }

    public void setNomInteret(String nomInteret) {
        this.nomInteret = nomInteret;
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
        if (!(o instanceof InteretEntity)) return false;
        InteretEntity that = (InteretEntity) o;
        return getIdInteret() == that.getIdInteret() && Objects.equals(getNomInteret(), that.getNomInteret());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdInteret(), getNomInteret());
    }
}
