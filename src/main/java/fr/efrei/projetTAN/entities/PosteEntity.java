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
    @Basic
    @Column(name = "Periode", nullable = true, length = 50)
    private String periode;
//    @DiscriminatorColumn(name="Remarque") @Table(name="Remarque")
//    @Column(name = "Remarque", nullable = true, length = 50)
    FAUT FAIRE TOUS LES ENTITIES T.T
    @OneToMany(mappedBy = "poste")
    private List<String> remarques;
    @ManyToOne
    private NiveauEtudiantEntity pourNivEtudiant;
    @ManyToOne
    private RecruteurEntity recruteurRespo;
    @OneToMany(mappedBy = "poste")
    private List<CandidatureEntity> listeCandid;
}
