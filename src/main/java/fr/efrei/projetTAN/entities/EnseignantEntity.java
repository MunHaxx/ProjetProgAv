package fr.efrei.projetTAN.entities;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "enseignant", schema = "prj_progav")
public class EnseignantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDenseignant", nullable = false)
    private int iDenseignant;
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
    @OneToMany(mappedBy = "enseignant")
    private List<CandidatureEntity> listeCandid;

    public EnseignantEntity(int iDenseignant, String nom, String prenom, String mail, String telephone, String siteWeb, List<CandidatureEntity> listeCandid) {
        this.iDenseignant = iDenseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.siteWeb = siteWeb;
        this.listeCandid = listeCandid;
    }

    public EnseignantEntity(){}

    public int getiDenseignant() {
        return iDenseignant;
    }

    public void setiDenseignant(int iDenseignant) {
        this.iDenseignant = iDenseignant;
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
        return getiDenseignant() == that.getiDenseignant() && Objects.equals(getNom(), that.getNom()) && Objects.equals(getPrenom(), that.getPrenom()) && Objects.equals(getMail(), that.getMail()) && Objects.equals(getTelephone(), that.getTelephone()) && Objects.equals(getSiteWeb(), that.getSiteWeb()) && Objects.equals(getListeCandid(), that.getListeCandid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getiDenseignant(), getNom(), getPrenom(), getMail(), getTelephone(), getSiteWeb(), getListeCandid());
    }
}
