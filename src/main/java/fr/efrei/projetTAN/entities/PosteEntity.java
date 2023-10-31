package fr.efrei.projetTAN.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.PosteConst.*;
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
    private EcoleEntity ecole;
    @Enumerated(EnumType.STRING)
    @Column(name = "Type_contrat", nullable = true, length = 50)
    private EnumTypeContrat typeContrat;
    @Enumerated(EnumType.STRING)
    private EnumNivEtudiant nivEtudiant;
    @Basic
    @Column(name = "Periode", nullable = true, length = 50)
    private String periode;
    @Basic
    @Column(name = "ID_recruteur", nullable = false)
    private int idRecruteur;
    @Basic
    @Column(name = "Remarque", nullable = true, length = 50)
    private String remarque;
    @Basic
    @Column(name = "Classe", nullable = false, length = 50)
    private String classe;
    @ManyToOne
    private RecruteurEntity recruteurRespo;
    @OneToMany(mappedBy = "poste")
    private List<CandidatureEntity> listeCandid;

    public PosteEntity(int idPoste, String nom, EcoleEntity ecole, EnumTypeContrat typeContrat, EnumNivEtudiant nivEtudiant, String periode, int idRecruteur, String remarque, String classe, RecruteurEntity recruteurRespo, List<CandidatureEntity> listeCandid) {
        this.idPoste = idPoste;
        this.nom = nom;
        this.ecole = ecole;
        this.typeContrat = typeContrat;
        this.nivEtudiant = nivEtudiant;
        this.periode = periode;
        this.idRecruteur = idRecruteur;
        this.remarque = remarque;
        this.classe = classe;
        this.recruteurRespo = recruteurRespo;
        this.listeCandid = listeCandid;
    }

    public PosteEntity(){}

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

    public EnumNivEtudiant getNivEtudiant() {
        return nivEtudiant;
    }

    public void setNivEtudiant(EnumNivEtudiant nivEtudiant) {
        this.nivEtudiant = nivEtudiant;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public int getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(int idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public RecruteurEntity getRecruteurRespo() {
        return recruteurRespo;
    }

    public void setRecruteurRespo(RecruteurEntity recruteurRespo) {
        this.recruteurRespo = recruteurRespo;
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
        return getIdPoste() == that.getIdPoste() && getIdRecruteur() == that.getIdRecruteur() && Objects.equals(getNom(), that.getNom()) && Objects.equals(getEcole(), that.getEcole()) && getTypeContrat() == that.getTypeContrat() && getNivEtudiant() == that.getNivEtudiant() && Objects.equals(getPeriode(), that.getPeriode()) && Objects.equals(getRemarque(), that.getRemarque()) && Objects.equals(getClasse(), that.getClasse()) && Objects.equals(getRecruteurRespo(), that.getRecruteurRespo()) && Objects.equals(getListeCandid(), that.getListeCandid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPoste(), getNom(), getEcole(), getTypeContrat(), getNivEtudiant(), getPeriode(), getIdRecruteur(), getRemarque(), getClasse(), getRecruteurRespo(), getListeCandid());
    }
}
