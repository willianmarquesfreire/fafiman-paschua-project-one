package com.wmfsystem.paschua.paschuaprojectone.bd;

import com.wmfsystem.paschua.paschuaprojectone.domain.Produto;

import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class ProdutoDao {

    public Produto save(Produto produto) {
        produto.setId(Integer.toUnsignedLong(BD.produtos.size()+1));
        BD.produtos.add(produto);
        return produto;
    }

    public Produto find(int id){
        return BD.produtos.get(id);
    }

    public List<Produto> findAll() {
        return BD.produtos;
    }

    public void delete(int id) {
        BD.produtos.remove(id);
    }
}
