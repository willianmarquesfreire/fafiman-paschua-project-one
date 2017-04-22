package com.wmfsystem.paschua.paschuaprojectone.domain;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class Venda extends Generic<Long> {

    private Estoque estoque;

    private Double quantidade;

    public Venda() {
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
