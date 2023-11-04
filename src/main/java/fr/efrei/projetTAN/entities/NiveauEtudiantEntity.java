package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.Objects;


import java.util.List;

import static fr.efrei.projetTAN.utils.Entity.NiveauEtudiantConst.*;
import static fr.efrei.projetTAN.utils.GlobalConst.EnumNivEtudiant;


@Entity
@Table(name = "Niveau_etudiant", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousLesNiveauxEtudiants", query = SELECT_TOUS_LES_NIVETUD)
                , @NamedQuery(name = "recupNiveauEtudiantId", query = SELECT_NIVETUD_PAR_ID)
        }
)
public class NiveauEtudiantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_NivEtudiant", nullable = false)
    private int idNivEtud;
    @Column(name = "Niveau")
    @Enumerated(EnumType.STRING)
    private EnumNivEtudiant niveau;
    @OneToMany(mappedBy = "prefereNivEtudiant")
    private List<EnseignantEntity> EnseignantsPreferentNivEtud;
    @OneToMany(mappedBy = "pourNivEtudiant")
    private List<PosteEntity> PostesPourNivEtud;


    public int getIdNivEtud() {
        return idNivEtud;
    }

    public void setIdNivEtud(int idNivEtud) {
        this.idNivEtud = idNivEtud;
    }

    public EnumNivEtudiant getNiveau() {
        return niveau;
    }

    public void setNiveau(EnumNivEtudiant niveau) {
        this.niveau = niveau;
    }

    public List<EnseignantEntity> getEnseignantsPreferentNivEtud() {
        return EnseignantsPreferentNivEtud;
    }

    public void setEnseignantsPreferentNivEtud(List<EnseignantEntity> enseignantsPreferentNivEtud) {
        EnseignantsPreferentNivEtud = enseignantsPreferentNivEtud;
    }

    public List<PosteEntity> getPostesPourNivEtud() {
        return PostesPourNivEtud;
    }

    public void setPostesPourNivEtud(List<PosteEntity> postesPourNivEtud) {
        PostesPourNivEtud = postesPourNivEtud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NiveauEtudiantEntity)) return false;
        NiveauEtudiantEntity that = (NiveauEtudiantEntity) o;
        return getIdNivEtud() == that.getIdNivEtud() && getNiveau() == that.getNiveau() && Objects.equals(getEnseignantsPreferentNivEtud(), that.getEnseignantsPreferentNivEtud()) && Objects.equals(getPostesPourNivEtud(), that.getPostesPourNivEtud());
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(getIdNivEtud(), getNiveau(), getEnseignantsPreferentNivEtud(), getPostesPourNivEtud());
    }*/
}
