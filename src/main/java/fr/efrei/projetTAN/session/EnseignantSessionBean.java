package fr.efrei.projetTAN.session;
import fr.efrei.projetTAN.entities.EnseignantEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;
import jakarta.ejb.Stateless;

@Stateless
public class EnseignantSessionBean {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projetTAN");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Query requete;
}
