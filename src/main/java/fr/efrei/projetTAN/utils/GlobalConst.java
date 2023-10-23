package fr.efrei.projetTAN.utils;

import jakarta.persistence.*;

public class GlobalConst {
    public enum TypeContrat {
        CDI, CDD, Interim
    }

    public enum NiveauCompetence {
        Debutant, Intermediaire, Confirme, Expert
    }

    @DiscriminatorColumn(name="Classe") @Table(name="Niveau_etudiant")
    public enum NiveauEtudiant {
        L1, L2, L3, M1, M2
    }
}
