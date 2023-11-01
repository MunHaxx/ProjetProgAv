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
    public List<CandidatureEntity> getToutesCandidatures(){
        requete = entityManager.createNamedQuery("recupToutesCandidatures");
        return  requete.getResultList();
    }

    // Permet d'obtenir une candidature à partir de son ID
    public CandidatureEntity getEtudeParId(int id) {
        requete = entityManager.createNamedQuery("recupCandidatureId" );
        requete.setParameter("id", id);
        return (CandidatureEntity) requete.getSingleResult();
    }

    // Permet de créer une nouvelle candidature
    public void ajouterCandidature(CandidatureEntity candidACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(candidACreer);
        entityManager.getTransaction().commit();
    }

}
