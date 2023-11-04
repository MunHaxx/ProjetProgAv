package fr.efrei.projetTAN.session;

import java.util.List;

import fr.efrei.projetTAN.entities.ActiviteEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ActiviteSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de toutes les candidatures
    public List<ActiviteEntity> getToutesActivites(){
        requete = entityManager.createNamedQuery("recupToutesLesActivites");
        return  requete.getResultList();
    }

    // Permet d'obtenir une candidature à partir de son ID
    public ActiviteEntity getActiviteParId(int id) {
        requete = entityManager.createNamedQuery("recupActiviteId" );
        requete.setParameter("id", id);
        return (ActiviteEntity) requete.getSingleResult();
    }

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
