package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.RemarqueEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class RemarqueSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet de créer un nouveau
    public void ajouterRemarque(RemarqueEntity remarqueACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(remarqueACreer);
        entityManager.getTransaction().commit();
    }

    // Permet de modifier une remarque
    public void modifierRemarque(RemarqueEntity remarqueAModifier) {
        entityManager.getTransaction().begin();
        entityManager.merge(remarqueAModifier);
        entityManager.getTransaction().commit();
    }
}
