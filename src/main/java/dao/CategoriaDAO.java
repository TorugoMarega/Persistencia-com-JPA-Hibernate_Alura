package dao;

import model.Categoria;
import model.Produto;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Categoria categoria){
        this.em.persist(categoria);
    }

    public void update(Categoria categoria){
        this.em.merge(categoria);
    }

    public Categoria find(Long id){
        Categoria categoria = this.em.find(Categoria.class, new Long(id));
        em.detach(categoria);
        return categoria;
    }

}
