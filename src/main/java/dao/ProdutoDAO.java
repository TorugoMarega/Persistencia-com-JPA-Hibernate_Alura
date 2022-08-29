package dao;

import model.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }
    public void create(Produto produto){
        this.em.persist(produto);
    }
}
