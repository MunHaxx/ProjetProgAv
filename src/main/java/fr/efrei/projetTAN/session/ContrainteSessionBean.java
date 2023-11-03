package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.ContrainteEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ContrainteSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet de créer une nouvelle contrainte
    public void ajouterContrainte(ContrainteEntity contrainteACreer) {
            entityManager.getTransaction().begin();
            entityManager.persist(contrainteACreer);
            entityManager.getTransaction().commit();
    }

    // Permet de modifier une contrainte
    public void modifierContrainte(ContrainteEntity contrainteAModifier) {
            entityManager.getTransaction().begin();
            entityManager.merge(contrainteAModifier);
            entityManager.getTransaction().commit();
    }
}
