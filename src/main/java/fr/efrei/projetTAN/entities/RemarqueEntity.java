package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.EntityConst.*;

@Entity
@Table(name = "remarque", schema = "prj_progav")
@NamedQueries(
        {
                @NamedQuery(name = "recupToutesLesRemarques", query = SELECT_TOUTES_LES_REMARQUES)
                , @NamedQuery(name = "recupRemarqueId", query = SELECT_REMARQUE_PAR_ID)
        }
)
public class RemarqueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Remarque", nullable = false)
    private int idRemarque;
    @Basic
    @Column(name = "Remarque", nullable = true, length = 50)
    private String nomRemarque;
    @ManyToMany
    @JoinTable( name = "Contient_remarque",
            joinColumns = @JoinColumn( name = "ID_Remarque" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Poste" ) )
    private List<PosteEntity> listePostes;

    public int getIdRemarque() {
        return idRemarque;
    }

    public void setIdRemarque(int idRemarque) {
        this.idRemarque = idRemarque;
    }

    public String getNomRemarque() {
        return nomRemarque;
    }

    public void setNomRemarque(String nomRemarque) {
        this.nomRemarque = nomRemarque;
    }

    public List<PosteEntity> getListePostes() {
        return listePostes;
    }

    public void setListePostes(List<PosteEntity> listePostes) {
        this.listePostes = listePostes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RemarqueEntity)) return false;
        RemarqueEntity that = (RemarqueEntity) o;
        return getIdRemarque() == that.getIdRemarque() && Objects.equals(getNomRemarque(), that.getNomRemarque()) && Objects.equals(getListePostes(), that.getListePostes());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdRemarque(), getRemarque(), getListePostes());
    }*/
}
