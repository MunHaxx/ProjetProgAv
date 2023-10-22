package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.CandidatureEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class CandidatureSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de toutes les candidatures
    public List<CandidatureEntity> getToutesEtudes(){
        requete = entityManager.createNamedQuery("recupToutesCandidatures");
        return  requete.getResultList();
    }

    // Permet d'obtenir une candidature à partir de son ID
    public CandidatureEntity getEtudeParId(int id) {
        requete = entityManager.createNamedQuery("recupCandidatureId" );
        requete.setParameter("id", id);
        return (CandidatureEntity) requete.getSingleResult();
    }

    // Permet d'obtenir une candidature à partir de l'ID de l'enseignant
    public CandidatureEntity getEtudeParIdEnseignant(int id) {
        requete = entityManager.createNamedQuery("recupCandidatureIdEnseignant" );
        requete.setParameter("id", id);
        return (CandidatureEntity) requete.getSingleResult();
    }

    // Permet d'obtenir une candidature à partir de l'ID du poste
    public CandidatureEntity getEtudeParIdPoste(int id) {
        requete = entityManager.createNamedQuery("recupCandidatureIdPoste" );
        requete.setParameter("id", id);
        return (CandidatureEntity) requete.getSingleResult();
    }

    // Permet de modifier une candidature
}
