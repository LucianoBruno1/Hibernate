package testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.modelo.EntityManagerUtil;
import jakarta.persistence.EntityManager;

public class AlteracaoDeProduto {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // Encontra o produto com código 2 e altera o preço
            Produto produto = em.find(Produto.class, 2L);
            if (produto != null) {
                produto.setPreco(345.00);
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
