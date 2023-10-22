package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.ExperienceEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class ExperienceSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de toutes les compétences
    public List<ExperienceEntity> getToutesLesExperiences(){
        requete = entityManager.createNamedQuery("recupTousXp");
        return  requete.getResultList();
    }

    // Permet d'obtenir une compétence à partir de son ID
    public ExperienceEntity getCompetenceParId(int id) {
        requete = entityManager.createNamedQuery("recupXpId" );
        requete.setParameter("id", id);
        return (ExperienceEntity) requete.getSingleResult();
    }

    // Permet de modifier une expérience (/!\ liste compétences)

}
