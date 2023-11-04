package fr.efrei.projetTAN.session;

import java.util.List;

import fr.efrei.projetTAN.entities.PosteEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class PosteSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de toutes les candidatures
    public List<PosteEntity> getTousLesPostes(){
        requete = entityManager.createNamedQuery("recupTousLesPostes");
        return  requete.getResultList();
    }

    // Permet d'obtenir une candidature à partir de son ID
    public PosteEntity getPosteParId(int id) {
        requete = entityManager.createNamedQuery("recupPosteId" );
        requete.setParameter("id", id);
        return (PosteEntity) requete.getSingleResult();
    }

    // Permet de créer un nouveau poste
    public void ajouterPoste(PosteEntity posteACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(posteACreer);
        entityManager.getTransaction().commit();
    }

}