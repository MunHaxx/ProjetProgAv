package fr.efrei.projetTAN.session;
import fr.efrei.projetTAN.entities.EcoleEntity;
import fr.efrei.projetTAN.entities.EnseignantEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;
import jakarta.ejb.Stateless;

@Stateless
public class EnseignantSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet de créer un nouvel enseignant
    public void ajouterEnseignant(EnseignantEntity enseignantACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(enseignantACreer);
        entityManager.getTransaction().commit();
    }

    // Permet de modifier un enseignant
    public void modifierEnseignant(EnseignantEntity enseignantAModifier) {
        entityManager.getTransaction().begin();
        entityManager.persist(enseignantAModifier);
        entityManager.getTransaction().commit();
    }
}
