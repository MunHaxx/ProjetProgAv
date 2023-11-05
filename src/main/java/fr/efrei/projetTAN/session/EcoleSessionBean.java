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
    public List<EcoleEntity> getToutesEcoles(){
        requete = entityManager.createNamedQuery("recupToutesLesEcoles");
        return  requete.getResultList();
    }

    // Permet d'obtenir une école à partir de son nom / raison sociale
    public List<EcoleEntity> getEcoleParRaisonSociale(String nom){
        requete = entityManager.createNamedQuery("recupEcoleNom" );
        requete.setParameter("nom", nom);
        return requete.getResultList();
    }

    // Permet d'obtenir une école à partir de son ID
    public List<EcoleEntity> getEcoleParId(int id) {
        requete = entityManager.createNamedQuery("recupEcoleId" );
        requete.setParameter("id", id);
        return requete.getResultList();
    }

    // Permet de créer une nouvelle école
    public void ajouterEcole(EcoleEntity ecoleACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(ecoleACreer);
        entityManager.getTransaction().commit();
    }
}
