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
        requete = entityManager.createNamedQuery("recupTousCompt");
        return  requete.getResultList();
    }

    // Permet d'obtenir une compétence à partir de son ID
    public CompetenceEntity getCompetenceParId(int id) {
        requete = entityManager.createNamedQuery("recupUneCompt" );
        requete.setParameter("id", id);
        return (CompetenceEntity) requete.getSingleResult();
    }

    // Permet de modifier une compétence
    public void modifierCompetence(CompetenceEntity comptAModifier) {
        requete = entityManager.createNamedQuery("modifUneCompt");
        requete.setParameter("id", comptAModifier.getIdCompetence());
        requete.setParameter("nom", comptAModifier.getNom());
        requete.setParameter("niveau", comptAModifier.getNiveau());
    }
}
