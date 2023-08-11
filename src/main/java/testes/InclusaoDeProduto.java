package testes;

import br.com.cursopcv.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InclusaoDeProduto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contestoque");

        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Produto prop = new Produto();
            prop.setNome("Panela");
            prop.setDescricao("Panela de Pressão 10 Litros");
            prop.setPreco(56.80);
            em.persist(prop);

            prop = new Produto();
            prop.setNome("Cama");
            prop.setDescricao("Cama de casal Big");
            prop.setPreco(450.68);
            em.persist(prop);

            prop = new Produto();
            prop.setNome("Caixa Som");
            prop.setDescricao("Caixa de Som JBL");
            prop.setPreco(160.00);
            em.persist(prop);

            em.getTransaction().commit();

            // Recuperar objeto do banco usando o método merge
            em.getTransaction().begin();
            Produto produtoRecuperado = em.merge(prop);
            em.getTransaction().commit();

            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }
}
