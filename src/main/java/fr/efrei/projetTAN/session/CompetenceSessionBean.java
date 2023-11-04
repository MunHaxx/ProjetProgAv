package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.CompetenceEntity;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class CompetenceSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de toutes les compétences
    public List<CompetenceEntity> getToutesLesCompetences(){
        requete = entityManager.createNamedQuery("recupTousLesCompt");
        return  requete.getResultList();
    }

    // Permet d'obtenir une compétence à partir de son ID
    public CompetenceEntity getCompetenceParId(int id) {
        requete = entityManager.createNamedQuery("recupComptId" );
        requete.setParameter("id", id);
        return (CompetenceEntity) requete.getSingleResult();
    }

    // Permet de créer une nouvelle compétence
    public void ajouterCompetence(CompetenceEntity comptACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(comptACreer);
        entityManager.getTransaction().commit();
    }

    // Permet de modifier une compétence
    public void modifierCompetence(CompetenceEntity comptAModifier) {
        entityManager.getTransaction().begin();
        entityManager.merge(comptAModifier);
        entityManager.getTransaction().commit();
    }
}
