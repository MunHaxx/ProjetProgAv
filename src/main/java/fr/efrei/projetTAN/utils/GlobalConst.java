package fr.efrei.projetTAN.utils;

import jakarta.persistence.*;

public class GlobalConst {
    public enum EnumTypeContrat {
        CDI, CDD, Interim
    }

    // Pas d'accents dans les enums !
    public enum EnumNivCompt {
        Debutant, Intermediaire, Confirme, Expert
    }

    public enum EnumNivEtudiant {
        L1, L2, L3, M1, M2
    }
}
