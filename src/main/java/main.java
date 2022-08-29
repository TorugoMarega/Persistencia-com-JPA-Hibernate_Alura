import dao.ProdutoDAO;
import model.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class main {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Samsung s22");
        celular.setDescricao("Muito legal");
        celular.setPreco(BigDecimal.valueOf(5000.00));

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO dao = new ProdutoDAO(em);

        dao.create(celular);

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
