package fr.efrei.projetTAN.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.PosteConst.*;
import static fr.efrei.projetTAN.utils.GlobalConst.*;

@Entity
@Table(name = "poste", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousPostes", query = SELECT_TOUS_POSTES)
                , @NamedQuery(name = "recupPosteId", query = SELECT_POSTE_PAR_ID)
        }
)
public class PosteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Poste", nullable = false)
    private int idPoste;
    @Basic
    @Column(name = "Nom", nullable = true, length = 50)
    private String nom;
    @ManyToOne
    @JoinColumn(name = "ID_Ecole")
    private EcoleEntity ecole;
    @Enumerated(EnumType.STRING)
    @Column(name = "Type_contrat", nullable = true, length = 50)
    private EnumTypeContrat typeContrat;
    @Basic
    @Column(name = "Periode", nullable = true, length = 50)
    private String periode;
    @ManyToOne
    @JoinColumn(name = "ID_NivEtudiant")
    private NiveauEtudiantEntity pourNivEtudiant;
    @ManyToOne
    @JoinColumn(name = "ID_Recruteur")
    private RecruteurEntity recruteurRespo;
    @ManyToMany
    @JoinTable( name = "Contient_contrainte",
            joinColumns = @JoinColumn( name = "ID_Poste" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Contrainte" ) )
    private List<ContrainteEntity> listeContraintes;

    @ManyToMany
    @JoinTable( name = "Contient_remarque",
            joinColumns = @JoinColumn( name = "ID_Poste" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Remarque" ) )
    private List<RemarqueEntity> listeRemarques;
    @OneToMany(mappedBy = "poste")
    private List<CandidatureEntity> listeCandid;

    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public EcoleEntity getEcole() {
        return ecole;
    }

    public void setEcole(EcoleEntity ecole) {
        this.ecole = ecole;
    }

    public EnumTypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(EnumTypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public NiveauEtudiantEntity getPourNivEtudiant() {
        return pourNivEtudiant;
    }

    public void setPourNivEtudiant(NiveauEtudiantEntity pourNivEtudiant) {
        this.pourNivEtudiant = pourNivEtudiant;
    }

    public RecruteurEntity getRecruteurRespo() {
        return recruteurRespo;
    }

    public void setRecruteurRespo(RecruteurEntity recruteurRespo) {
        this.recruteurRespo = recruteurRespo;
    }

    public List<ContrainteEntity> getListeContraintes() {
        return listeContraintes;
    }

    public void setListeContraintes(List<ContrainteEntity> listeContraintes) {
        this.listeContraintes = listeContraintes;
    }

    public List<RemarqueEntity> getListeRemarques() {
        return listeRemarques;
    }

    public void setListeRemarques(List<RemarqueEntity> listeRemarques) {
        this.listeRemarques = listeRemarques;
    }

    public List<CandidatureEntity> getListeCandid() {
        return listeCandid;
    }

    public void setListeCandid(List<CandidatureEntity> listeCandid) {
        this.listeCandid = listeCandid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PosteEntity)) return false;
        PosteEntity that = (PosteEntity) o;
        return getIdPoste() == that.getIdPoste() && Objects.equals(getNom(), that.getNom()) && Objects.equals(getEcole(), that.getEcole()) && getTypeContrat() == that.getTypeContrat() && Objects.equals(getPeriode(), that.getPeriode()) && Objects.equals(getPourNivEtudiant(), that.getPourNivEtudiant()) && Objects.equals(getRecruteurRespo(), that.getRecruteurRespo()) && Objects.equals(getListeContraintes(), that.getListeContraintes()) && Objects.equals(getListeRemarques(), that.getListeRemarques()) && Objects.equals(getListeCandid(), that.getListeCandid());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdPoste(), getNom(), getEcole(), getTypeContrat(), getPeriode(), getPourNivEtudiant(), getRecruteurRespo(), getListeContraintes(), getListeRemarques(), getListeCandid());
    }*/
}
