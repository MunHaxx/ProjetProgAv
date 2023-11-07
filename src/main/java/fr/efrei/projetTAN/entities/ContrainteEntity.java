package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.EntityConst.*;

@Entity
@Table(name = "contrainte", schema = "prj_progav")
@NamedQueries(
        {
                @NamedQuery(name = "recupTousLesContraintes", query = SELECT_TOUTES_LES_CONTRAINTES)
                , @NamedQuery(name = "recupContrainteId", query = SELECT_UNE_CONTRAINTE)
        }
)
public class ContrainteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Contrainte", nullable = false)
    private int idContrainte;
    @Basic
    @Column(name = "Contrainte", nullable = true, length = 50)
    private String nomContrainte;
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

    public String getNomContrainte() {
        return nomContrainte;
    }

    public void setNomContrainte(String nomContrainte) {
        this.nomContrainte = nomContrainte;
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
        return getIdContrainte() == that.getIdContrainte() && Objects.equals(getNomContrainte(), that.getNomContrainte());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdContrainte(), getNomContrainte());
    }*/
}
