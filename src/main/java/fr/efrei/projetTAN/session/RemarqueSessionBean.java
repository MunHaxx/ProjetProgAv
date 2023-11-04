package fr.efrei.projetTAN.session;

import java.util.List;

import fr.efrei.projetTAN.entities.RecruteurEntity;
import fr.efrei.projetTAN.entities.RemarqueEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class RemarqueSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de tous les recruteurs
    public List<RemarqueEntity> getToutesLesRemarques(){
        requete = entityManager.createNamedQuery("recupToutesLesRemarques");
        return  requete.getResultList();
    }

    // Permet d'obtenir un recruteur à partir de son ID
    public RemarqueEntity getRemarqueParId(int id) {
        requete = entityManager.createNamedQuery("recupRemarqueId" );
        requete.setParameter("id", id);
        return (RemarqueEntity) requete.getSingleResult();
    }

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
