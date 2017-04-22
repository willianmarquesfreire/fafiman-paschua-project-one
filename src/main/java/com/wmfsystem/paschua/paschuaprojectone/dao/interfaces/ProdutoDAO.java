package com.wmfsystem.paschua.paschuaprojectone.dao.interfaces;

import com.wmfsystem.paschua.paschuaprojectone.domain.Produto;

import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
public interface ProdutoDAO extends DAO<Produto, Long> {

    List<Produto> findByDescricao(String descricao);

}
