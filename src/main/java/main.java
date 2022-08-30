import dao.CategoriaDAO;
import dao.ProdutoDAO;
import model.Categoria;
import model.Produto;
import util.JPAUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class main {
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        System.out.println("\n\n-------------PRODUTO PELO ID-------------");
        Produto p = produtoDAO.findById(1L);
        System.out.println("ID: "+p.getId()+"\nNome: "+p.getNome()+"\nDescricao: "+p.getDescricao()+"\nPreco: "+p.getPreco()+"\nCategoria: "+p.getCategoria().getNome() );
        System.out.println("\n------------------------------------------------\n");

        System.out.println("\n\n-------------TODOS OS PRODUTOS-------------");
        List<Produto> allProducts = produtoDAO.findAll();
        allProducts.forEach(p2 -> System.out.println("ID: "+p.getId()+"\nNome: "+p.getNome()+"\nDescricao: "+p.getDescricao()+"\nPreco: "+p.getPreco()+"\nCategoria: "+p.getCategoria().getNome()));
        System.out.println("\n------------------------------------------------\n");

        System.out.println("\n\n-------------PRODUTOS POR NOME-------------");
        List<Produto> productsByName = produtoDAO.findByName("Samsung s22");
        productsByName.forEach(p2 -> System.out.println("ID: "+p.getId()+"\nNome: "+p.getNome()+"\nDescricao: "+p.getDescricao()+"\nPreco: "+p.getPreco()+"\nCategoria: "+p.getCategoria().getNome()));
        System.out.println("\n------------------------------------------------\n");

        System.out.println("\n\n-------------PRODUTOS POR CATEGORIA-------------");
        List<Produto> productsByCategoryName = produtoDAO.findByCategoryName("Celulares");
        productsByCategoryName.forEach(p2 -> System.out.println("ID: "+p.getId()+"\nNome: "+p.getNome()+"\nDescricao: "+p.getDescricao()+"\nPreco: "+p.getPreco()+"\nCategoria: "+p.getCategoria().getNome()));
        System.out.println("\n------------------------------------------------\n");

        System.out.println("\n\n-------------NOME DO PRODUTO POR ID-------------");
        String productName = produtoDAO.findNameById(1L);
        System.out.println("ID: "+p.getId()+"\nNome: "+productName);
        System.out.println("\n------------------------------------------------\n");
    }

    public static void cadastrarProduto(){
        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Samsung s22", "Muito legal", BigDecimal.valueOf(5000.00), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();
        categoriaDAO.create(celulares);
        produtoDAO.create(celular);
        em.getTransaction().commit();
    }
}
