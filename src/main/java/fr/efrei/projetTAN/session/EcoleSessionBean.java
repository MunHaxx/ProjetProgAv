package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.EcoleEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class EcoleSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de toutes les écoles
    public List<EcoleEntity> getToutesEtudes(){
        requete = entityManager.createNamedQuery("recupToutesEcoles");
        return  requete.getResultList();
    }

    // Permet d'obtenir une école à partir de son ID
    public EcoleEntity getEtudeParId(int id) {
        requete = entityManager.createNamedQuery("recupEcoleId" );
        requete.setParameter("id", id);
        return (EcoleEntity) requete.getSingleResult();
    }

    // Permet de créer une nouvelle école
    public void ajouterEcole(EcoleEntity ecoleACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(ecoleACreer);
        entityManager.getTransaction().commit();
    }
}
