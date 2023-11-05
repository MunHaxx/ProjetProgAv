package fr.efrei.projetTAN.utils;

import jakarta.persistence.*;

public class GlobalConst {
    public enum EnumTypeContrat {
        CDI, CDD, Interim
    }
    public static boolean estDansEnumTypeContrat(String contrat) {
        for (EnumTypeContrat value : EnumTypeContrat.values()) {
            if (value.name().equals(contrat))
                return true;
        }
        return false;
    }
    public static EnumTypeContrat stringVersEnumTypeContrat(String str) {
        try {
            return EnumTypeContrat.valueOf(str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    // Pas d'accents dans les enums !
    public enum EnumNivCompt {
        Debutant, Intermediaire, Confirme, Expert
    }
    public static boolean estDansEnumNivCompt(String nivEtudiant) {
        for (EnumNivCompt value : EnumNivCompt.values()) {
            if (value.name().equals(nivEtudiant))
                return true;
        }
        return false;
    }
    public static EnumNivCompt stringVersEnumNivCompt(String str) {
        try {
            return EnumNivCompt.valueOf(str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public enum EnumNivEtudiant {
        L1, L2, L3, M1, M2
    }
    public static boolean estDansEnumNivEtudiant(String nivEtudiant) {
        for (EnumNivEtudiant value : EnumNivEtudiant.values()) {
            if (value.name().equals(nivEtudiant))
                return true;
        }
        return false;
    }
    public static EnumNivEtudiant stringVersEnumNivEtudiant(String str) {
        try {
            return EnumNivEtudiant.valueOf(str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
