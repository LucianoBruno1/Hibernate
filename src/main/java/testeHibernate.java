import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

public class testeHibernate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contestoque");
        emf.close();
    }
}
