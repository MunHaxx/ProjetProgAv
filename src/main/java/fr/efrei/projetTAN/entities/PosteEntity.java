package fr.efrei.projetTAN.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.EntityConst.*;
import static fr.efrei.projetTAN.utils.GlobalConst.*;

@Entity
@Table(name = "poste", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousLesPostes", query = SELECT_TOUS_LES_POSTES)
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
    private String nomPoste;
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
    @JoinTable( name = "requiert_compt",
            joinColumns = @JoinColumn( name = "ID_Poste" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Competence" ) )
    private ArrayList<CompetenceEntity> listeCompetences;
    @ManyToMany
    @JoinTable( name = "Contient_contrainte",
            joinColumns = @JoinColumn( name = "ID_Poste" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Contrainte" ) )
    private ArrayList<ContrainteEntity> listeContraintes;
    @ManyToMany
    @JoinTable( name = "Contient_remarque",
            joinColumns = @JoinColumn( name = "ID_Poste" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Remarque" ) )
    private ArrayList<RemarqueEntity> listeRemarques;
    @OneToMany(mappedBy = "poste")
    private ArrayList<CandidatureEntity> listeCandid;

    public PosteEntity(){}

    public PosteEntity(String nomPoste, EcoleEntity ecole, EnumTypeContrat typeContrat, String periode,
                       NiveauEtudiantEntity pourNivEtudiant, RecruteurEntity recruteurRespo) {
        this.nomPoste = nomPoste;
        this.ecole = ecole;
        this.typeContrat = typeContrat;
        this.periode = periode;
        this.pourNivEtudiant = pourNivEtudiant;
        this.recruteurRespo = recruteurRespo;
        this.listeCandid = new ArrayList<>();
        this.listeCompetences = new ArrayList<>();
        this.listeContraintes = new ArrayList<>();
        this.listeRemarques = new ArrayList<>();
    }

    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public String getNomPoste() {
        return nomPoste;
    }

    public void setNomPoste(String nomPoste) {
        this.nomPoste = nomPoste;
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

    public List<CompetenceEntity> getListeCompetences() {
        return listeCompetences;
    }

    public void setListeCompetences(ArrayList<CompetenceEntity> listeCompetences) {
        this.listeCompetences = listeCompetences;
    }

    public ArrayList<ContrainteEntity> getListeContraintes() {
        return listeContraintes;
    }

    public void setListeContraintes(ArrayList<ContrainteEntity> listeContraintes) {
        this.listeContraintes = listeContraintes;
    }

    public ArrayList<RemarqueEntity> getListeRemarques() {
        return listeRemarques;
    }

    public void setListeRemarques(ArrayList<RemarqueEntity> listeRemarques) {
        this.listeRemarques = listeRemarques;
    }

    public ArrayList<CandidatureEntity> getListeCandid() {
        return (ArrayList<CandidatureEntity>) listeCandid;
    }

    public void setListeCandid(ArrayList<CandidatureEntity> listeCandid) {
        this.listeCandid = listeCandid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PosteEntity)) return false;
        PosteEntity that = (PosteEntity) o;
        return getIdPoste() == that.getIdPoste() && Objects.equals(getNomPoste(), that.getNomPoste()) && Objects.equals(getEcole(), that.getEcole()) && getTypeContrat() == that.getTypeContrat() && Objects.equals(getPeriode(), that.getPeriode()) && Objects.equals(getPourNivEtudiant(), that.getPourNivEtudiant()) && Objects.equals(getRecruteurRespo(), that.getRecruteurRespo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPoste(), getNomPoste(), getEcole(), getTypeContrat(), getPeriode(), getPourNivEtudiant(), getRecruteurRespo());
    }
}
