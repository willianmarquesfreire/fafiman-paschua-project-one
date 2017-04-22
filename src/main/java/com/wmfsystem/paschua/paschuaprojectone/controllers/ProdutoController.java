package com.wmfsystem.paschua.paschuaprojectone.controllers;

import com.wmfsystem.paschua.paschuaprojectone.dao.interfaces.ProdutoDAO;
import com.wmfsystem.paschua.paschuaprojectone.domain.Produto;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
@Named
@RequestScoped
public class ProdutoController implements Serializable {

    @Inject
    private ProdutoDAO produtoDAO;

    private Produto produto;

    private List<Produto> produtos;

    @PostConstruct
    public void init() {
        produto = new Produto();
        produtos = produtoDAO.findAll();
    }

    public String save() {
        produtoDAO.save(produto);
        return "Saved!";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
