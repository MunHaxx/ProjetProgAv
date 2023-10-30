package fr.efrei.projetTAN.utils;

import jakarta.persistence.*;

public class GlobalConst {
    public enum EnumTypeContrat {
        CDI, CDD, Interim
    }

    public enum EnumNivCompt {
        Débutant, Intermédiaire, Confirmé, Expert
    }

    @DiscriminatorColumn(name="Classe") @Table(name="Niveau_etudiant")
    public enum EnumNivEtudiant {
        L1, L2, L3, M1, M2
    }
}
