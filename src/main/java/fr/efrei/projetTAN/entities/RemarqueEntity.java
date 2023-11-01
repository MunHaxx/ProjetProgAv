package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "remarque", schema = "prj_progav")
public class RemarqueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Remarque", nullable = false)
    private int idRemarque;
    @Basic
    @Column(name = "Remarque", nullable = true, length = 50)
    private String remarque;
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

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
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
        return getIdRemarque() == that.getIdRemarque() && Objects.equals(getRemarque(), that.getRemarque()) && Objects.equals(getListePostes(), that.getListePostes());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdRemarque(), getRemarque(), getListePostes());
    }*/
}
