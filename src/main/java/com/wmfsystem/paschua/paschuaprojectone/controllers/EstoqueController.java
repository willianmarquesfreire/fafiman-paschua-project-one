package com.wmfsystem.paschua.paschuaprojectone.controllers;

import com.wmfsystem.paschua.paschuaprojectone.bd.EstoqueDao;
import com.wmfsystem.paschua.paschuaprojectone.bd.ProdutoDao;
import com.wmfsystem.paschua.paschuaprojectone.domain.Estoque;
import com.wmfsystem.paschua.paschuaprojectone.domain.Produto;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
//@ManagedBean
@Named("estoqueController")
@RequestScoped
@ManagedBean
public class EstoqueController implements Serializable {
    private Estoque estoque;

    private List<Estoque> estoques;

    private EstoqueDao estoqueDao= new EstoqueDao();

    @PostConstruct
    public void init() {
        estoque = new Estoque();
        estoque.setProduto(new Produto());
        estoques = estoqueDao.findAll();
    }

    public Estoque save() {
        return estoqueDao.save(estoque);
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }

    public void ListaTodos() {
        this.estoques = estoqueDao.findAll();
    }
}
