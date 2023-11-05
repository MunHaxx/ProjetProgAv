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

    // Permet d'obtenir la liste de toutes les études
    public List<EcoleEntity> getToutesEtudes(){
        requete = entityManager.createNamedQuery("recupToutesLesEcoles");
        return  requete.getResultList();
    }

    // Permet d'obtenir une étude à partir de son ID
    public EcoleEntity getEtudeParId(int id) {
        requete = entityManager.createNamedQuery("recupEcoleId" );
        requete.setParameter("id", id);
        return (EcoleEntity) requete.getSingleResult();
    }

    // Permet de créer une nouvelle etude
    public void ajouterEcole(EcoleEntity ecoleACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(ecoleACreer);
        entityManager.getTransaction().commit();
    }
}
