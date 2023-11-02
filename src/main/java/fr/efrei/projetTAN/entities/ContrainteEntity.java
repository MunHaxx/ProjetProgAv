package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contrainte", schema = "prj_progav")
public class ContrainteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Contrainte", nullable = false)
    private int idContrainte;
    @Basic
    @Column(name = "Contrainte", nullable = true, length = 50)
    private String contrainte;
    @ManyToMany
    @JoinTable( name = "Contient_contrainte",
            joinColumns = @JoinColumn( name = "ID_Contrainte" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Poste" ) )
    private List<PosteEntity> listePostes;

    public int getIdContrainte() {
        return idContrainte;
    }

    public void setIdContrainte(int idContrainte) {
        this.idContrainte = idContrainte;
    }

    public String getContrainte() {
        return contrainte;
    }

    public void setContrainte(String contrainte) {
        this.contrainte = contrainte;
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
        if (!(o instanceof ContrainteEntity)) return false;
        ContrainteEntity that = (ContrainteEntity) o;
        return getIdContrainte() == that.getIdContrainte() && Objects.equals(getContrainte(), that.getContrainte()) && Objects.equals(getListePostes(), that.getListePostes());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdContrainte(), getContrainte(), getListePostes());
    }*/
}
