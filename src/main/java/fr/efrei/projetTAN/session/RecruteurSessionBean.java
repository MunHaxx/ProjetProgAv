package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.RecruteurEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class RecruteurSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de tous les recruteurs
    public List<RecruteurEntity> getToutesLesExperiences(){
        requete = entityManager.createNamedQuery("recupTousRecruteurs");
        return  requete.getResultList();
    }

    // Permet d'obtenir un recruteur à partir de son ID
    public RecruteurEntity getCompetenceParId(int id) {
        requete = entityManager.createNamedQuery("recupRecruteurId" );
        requete.setParameter("id", id);
        return (RecruteurEntity) requete.getSingleResult();
    }

    // Permet de modifier un recruteur
}
