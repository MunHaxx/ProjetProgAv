package fr.efrei.projetTAN.entities;

import jakarta.persistence.*;

import java.util.Objects;

import static fr.efrei.projetTAN.utils.NiveauEtudiantConst.*;
import static fr.efrei.projetTAN.utils.GlobalConst.EnumNivEtudiant;


@Entity
@Table(name = "Niveau_etudiant", schema = "prj_progav")

@NamedQueries(
        {
                @NamedQuery(name = "recupTousLesNiveauxEtudiants", query = SELECT_TOUTES_NIVETUD)
                , @NamedQuery(name = "recupNiveauEtudiantParId", query = SELECT_NIVETUD_PAR_ID)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NiveauEtudiantEntity)) return false;
        NiveauEtudiantEntity that = (NiveauEtudiantEntity) o;
        return getIdNivEtud() == that.getIdNivEtud() && Objects.equals(getNiveau(), that.getNiveau());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNivEtud(), getNiveau());
    }
}
