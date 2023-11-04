package fr.efrei.projetTAN.entities;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.EnseignantConst.*;

@Entity
@Table(name = "enseignant", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousLesEnseignants", query = SELECT_TOUS_LES_ENSEIGNANTS)
                , @NamedQuery(name = "recupEnseignantId", query = SELECT_ENSEIGNANT_PAR_ID)
        }
)

public class EnseignantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDenseignant", nullable = false)
    private int idEnseignant;
    @Basic
    @Column(name = "Nom", nullable = false, length = 50)
    private String nom;
    @Basic
    @Column(name = "Prenom", nullable = false, length = 50)
    private String prenom;
    @ManyToOne
    @JoinColumn(name = "ID_recruteur")
    private RecruteurEntity recoParRecruteur;
    @ManyToOne
    @JoinColumn(name = "ID_Ecole")
    private EcoleEntity recoParEcole;
    @Basic
    @Column(name = "Mail", nullable = true, length = 50)
    private String mail;
    @Basic
    @Column(name = "Telephone", nullable = true, length = 50)
    private String telephone;
    @Basic
    @Column(name = "Site_web", nullable = true, length = 50)
    private String siteWeb;
    @OneToMany(mappedBy = "enseignant")
    private List<EtudeEntity> listeEtudes;
    @OneToMany(mappedBy = "enseignant")
    private List<ExperienceEntity> listeExperiences;
    @ManyToOne
    @JoinColumn(name = "ID_NivEtudiant")
    private NiveauEtudiantEntity prefereNivEtudiant;
    @ManyToMany
    @JoinTable( name = "fait_activite",
            joinColumns = @JoinColumn( name = "IDenseignant" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Activite" ) )
    private List<ActiviteEntity> listeActivites;
    @ManyToMany
    @JoinTable( name = "est_interesse",
            joinColumns = @JoinColumn( name = "IDenseignant" ),
            inverseJoinColumns = @JoinColumn( name = "ID_Interet" ) )
    private List<InteretEntity> listeInterets;
    @OneToMany(mappedBy = "enseignant")
    private List<CandidatureEntity> listeCandid;

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public RecruteurEntity getRecoParRecruteur() {
        return recoParRecruteur;
    }

    public void setRecoParRecruteur(RecruteurEntity recoParRecruteur) {
        this.recoParRecruteur = recoParRecruteur;
    }

    public EcoleEntity getRecoParEcole() {
        return recoParEcole;
    }

    public void setRecoParEcole(EcoleEntity recoParEcole) {
        this.recoParEcole = recoParEcole;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public List<EtudeEntity> getListeEtudes() {
        return listeEtudes;
    }

    public void setListeEtudes(List<EtudeEntity> listeEtudes) {
        this.listeEtudes = listeEtudes;
    }

    public List<ExperienceEntity> getListeExperiences() {
        return listeExperiences;
    }

    public void setListeExperiences(List<ExperienceEntity> listeExperiences) {
        this.listeExperiences = listeExperiences;
    }

    public NiveauEtudiantEntity getPrefereNivEtudiant() {
        return prefereNivEtudiant;
    }

    public void setPrefereNivEtudiant(NiveauEtudiantEntity prefereNivEtudiant) {
        this.prefereNivEtudiant = prefereNivEtudiant;
    }

    public List<ActiviteEntity> getListeActivites() {
        return listeActivites;
    }

    public void setListeActivites(List<ActiviteEntity> listeActivites) {
        this.listeActivites = listeActivites;
    }

    public List<InteretEntity> getListeInterets() {
        return listeInterets;
    }

    public void setListeInterets(List<InteretEntity> listeInterets) {
        this.listeInterets = listeInterets;
    }

    public List<CandidatureEntity> getListeCandid() {
        return listeCandid;
    }

    public void setListeCandid(List<CandidatureEntity> listeCandid) {
        this.listeCandid = listeCandid;
    }


}
