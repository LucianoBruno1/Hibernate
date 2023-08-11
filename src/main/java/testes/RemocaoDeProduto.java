package testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.modelo.EntityManagerUtil;
import jakarta.persistence.EntityManager;

public class RemocaoDeProduto {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // Encontra o produto com código 3 e remove
            Produto produto = em.find(Produto.class, 3L);
            if (produto != null) {
                em.remove(produto);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            EntityManagerUtil.closeEntityManagerFactory();
        }
    }
}
