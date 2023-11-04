package fr.efrei.projetTAN.session;

import java.util.List;

import fr.efrei.projetTAN.entities.ContrainteEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ContrainteSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de toutes les candidatures
    public List<ContrainteEntity> getToutesContraintes(){
        requete = entityManager.createNamedQuery("recupToutesLesContraintes");
        return  requete.getResultList();
    }

    // Permet d'obtenir une candidature à partir de son ID
    public ContrainteEntity getContrainteParId(int id) {
        requete = entityManager.createNamedQuery("recupContrainteId" );
        requete.setParameter("id", id);
        return (ContrainteEntity) requete.getSingleResult();
    }

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
