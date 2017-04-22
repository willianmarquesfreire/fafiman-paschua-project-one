package com.wmfsystem.paschua.paschuaprojectone.dao.impl;

import com.wmfsystem.paschua.paschuaprojectone.dao.interfaces.GenericDAO;
import com.wmfsystem.paschua.paschuaprojectone.dao.interfaces.ProdutoDAO;
import com.wmfsystem.paschua.paschuaprojectone.domain.Produto;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class ProdutoDAOImpl extends GenericDAO<Produto, Long> implements ProdutoDAO {


    public ProdutoDAOImpl(Class<Produto> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Produto> findByDescricao(String descricao) {
        TypedQuery<Produto> query = getEntityManager().createNamedQuery("Produto.findByDescricao", Produto.class);
        query.setParameter("descricao", descricao);
        return query.getResultList();
    }
}
