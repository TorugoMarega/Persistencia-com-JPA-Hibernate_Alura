//import model.Produto;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.math.BigDecimal;
//
//public class CadastroDeProdutoTest {
//    public static void main(String[] args) {
//        Produto celular = new Produto();
//        celular.setNome("Samsung s22");
//        celular.setDescricao("Muito legal");
//        celular.setPreco(BigDecimal.valueOf(5000.00));
//
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(celular);
//        em.getTransaction().commit();
//        em.close();
//    }
//}
