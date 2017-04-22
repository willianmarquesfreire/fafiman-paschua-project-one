package com.wmfsystem.paschua.paschuaprojectone.controllers;

import com.wmfsystem.paschua.paschuaprojectone.bd.ProdutoDao;
import com.wmfsystem.paschua.paschuaprojectone.bd.VendaDao;
import com.wmfsystem.paschua.paschuaprojectone.domain.Estoque;
import com.wmfsystem.paschua.paschuaprojectone.domain.Produto;
import com.wmfsystem.paschua.paschuaprojectone.domain.Venda;

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
@Named("vendaController")
@RequestScoped
@ManagedBean
public class VendaController implements Serializable {
    private Venda venda;

    private List<Venda> vendas;

    private VendaDao vendaDao= new VendaDao();

    @PostConstruct
    public void init() {
        venda = new Venda();
        venda.setEstoque(new Estoque());
        vendas = vendaDao.findAll();
    }

    public Venda save() {
        System.out.println("----> desc: " + venda.getEstoque());
        return vendaDao.save(venda);
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> venda) {
        this.vendas = venda;
    }

    public void ListaTodos() {
        this.vendas = vendaDao.findAll();
    }
}
