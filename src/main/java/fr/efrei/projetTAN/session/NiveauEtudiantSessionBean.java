package fr.efrei.projetTAN.session;

import fr.efrei.projetTAN.entities.NiveauEtudiantEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class NiveauEtudiantSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;

    // Permet d'obtenir la liste de tous les recruteurs
    public List<NiveauEtudiantEntity> getTousNiveauxEtudiants(){
        requete = entityManager.createNamedQuery("recupTousRecruteurs");
        return  requete.getResultList();
    }

    // Permet d'obtenir un recruteur à partir de son ID
    public NiveauEtudiantEntity getNiveauEtudiantParId(int id) {
        requete = entityManager.createNamedQuery("recupNiveauEtudiantParId" );
        requete.setParameter("id", id);
        return (NiveauEtudiantEntity) requete.getSingleResult();
    }

    // Permet de créer un nouveau recruteur
    public void ajouterRecruteur(NiveauEtudiantEntity nivEtudACreer) {
        entityManager.getTransaction().begin();
        entityManager.persist(nivEtudACreer);
        entityManager.getTransaction().commit();
    }

    // Permet de modifier un recruteur
    public void modifierRecruteur(NiveauEtudiantEntity nivEtudAModifier) {
        entityManager.getTransaction().begin();
        entityManager.merge(nivEtudAModifier);
        entityManager.getTransaction().commit();
    }
}


