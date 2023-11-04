package fr.efrei.projetTAN.session;
import fr.efrei.projetTAN.entities.EnseignantEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

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
        entityManager.merge(enseignantAModifier);
        entityManager.getTransaction().commit();
    }

    // Permet d'obtenir la liste de tous les enseignants
    public List<EnseignantEntity> getTousEnseignants(){
        requete = entityManager.createNamedQuery("recupTousLesEnseignants");
        return  requete.getResultList();
    }

    // Permet d'obtenir un enseignant à partir de son ID
    public EnseignantEntity getEnseignantParId(int id) {
        requete = entityManager.createNamedQuery("recupEnseignantId" );
        requete.setParameter("id", id);
        return (EnseignantEntity) requete.getSingleResult();
    }
}
