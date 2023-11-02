package fr.efrei.projetTAN.entities;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import static fr.efrei.projetTAN.utils.Entity.EnseignantConst.*;

@Entity
@Table(name = "enseignant", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousEnseignants", query = SELECT_TOUS_ENSEIGNANTS)
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
    @Basic
    @Column(name = "Mail", nullable = true, length = 50)
    private String mail;
    @Basic
    @Column(name = "Telephone", nullable = true, length = 50)
    private String telephone;
    @Basic
    @Column(name = "Site_web", nullable = true, length = 50)
    private String siteWeb;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnseignantEntity)) return false;
        EnseignantEntity that = (EnseignantEntity) o;
        return getIdEnseignant() == that.getIdEnseignant() && Objects.equals(getNom(), that.getNom()) && Objects.equals(getPrenom(), that.getPrenom()) && Objects.equals(getMail(), that.getMail()) && Objects.equals(getTelephone(), that.getTelephone()) && Objects.equals(getSiteWeb(), that.getSiteWeb()) && Objects.equals(getPrefereNivEtudiant(), that.getPrefereNivEtudiant()) && Objects.equals(getListeActivites(), that.getListeActivites()) && Objects.equals(getListeInterets(), that.getListeInterets()) && Objects.equals(getListeCandid(), that.getListeCandid());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdEnseignant(), getNom(), getPrenom(), getMail(), getTelephone(), getSiteWeb(), getPrefereNivEtudiant(), getListeActivites(), getListeInterets(), getListeCandid());
    }*/
}
