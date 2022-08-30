package dao;

import model.Categoria;
import model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }
    public void create(Produto produto){
        this.em.persist(produto);
    }

    public void update(Produto produto){
        this.em.merge(produto);
    }
    public void remove(Produto produto){
        produto = em.merge(produto);
        this.em.remove(produto);
    }

    public Produto findById(Long id){
        return em.find(Produto.class, id);
    }

    public List<Produto> findAll(){
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> findByName(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public List<Produto> findByCategoryName(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";
        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }
    public String findNameById(Long id){
        String jpql = "SELECT p.nome FROM Produto p WHERE p.id = ?1";
        return em.createQuery(jpql, String.class)
                .setParameter(1,id)
                .getSingleResult();
    }
}
