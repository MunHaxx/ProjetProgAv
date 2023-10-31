package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.EnseignantEntity;
import fr.efrei.projetTAN.entities.EtudeEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class EtudeSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de toutes les études
    public List<EtudeEntity> getToutesEtudes(){
        requete = entityManager.createNamedQuery("recupTousEtudes");
        return  requete.getResultList();
    }

    // Permet d'obtenir une étude à partir de son ID
    public EtudeEntity getEtudeParId(int id) {
        requete = entityManager.createNamedQuery("recupEtudeId" );
        requete.setParameter("id", id);
        return (EtudeEntity) requete.getSingleResult();
    }

    // Permet de créer une nouvelle étude
    public void ajouterEtude(EtudeEntity etudeACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(etudeACreer);
        entityManager.getTransaction().commit();
    }

    // Permet de modifier une étude
    public void modifierEtude(EtudeEntity etudeAModifier) {
        entityManager.getTransaction().begin();
        entityManager.persist(etudeAModifier);
        entityManager.getTransaction().commit();
    }
}
