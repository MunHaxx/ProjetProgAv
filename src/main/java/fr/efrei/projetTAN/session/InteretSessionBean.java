package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.InteretEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class InteretSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet de créer un nouvel interet
    public void ajouterInteret(InteretEntity interetACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(interetACreer);
        entityManager.getTransaction().commit();
    }

    // Permet de modifier un interet
    public void modifierInteret(InteretEntity interetAModifier) {
        entityManager.getTransaction().begin();
        entityManager.merge(interetAModifier);
        entityManager.getTransaction().commit();
    }
}
