package com.wmfsystem.paschua.paschuaprojectone.controllers;

import com.wmfsystem.paschua.paschuaprojectone.bd.ProdutoDao;
import com.wmfsystem.paschua.paschuaprojectone.domain.Produto;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
//@ManagedBean
@Named("produtoController")
@RequestScoped
@ManagedBean
public class ProdutoController implements Serializable {
    private Produto produto;

    private List<Produto> produtos;

    private ProdutoDao produtoDao= new ProdutoDao();

    @PostConstruct
    public void init() {
        produto = new Produto();
        produtos = produtoDao.findAll();
    }

    public Produto save() {
        System.out.println("----> desc: " + produto.getDescricao());
        return produtoDao.save(produto);
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

    public void ListaTodos() {
        this.produtos = produtoDao.findAll();
    }
}
