package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.ActiviteEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ActiviteSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet de créer une nouvelle activite
    public void ajouterActivite(ActiviteEntity activiteACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(activiteACreer);
        entityManager.getTransaction().commit();
    }

    // Permet de modifier une activite
    public void modifierActivite(ActiviteEntity activiteAModifier) {
        entityManager.getTransaction().begin();
        entityManager.merge(activiteAModifier);
        entityManager.getTransaction().commit();
    }
}
