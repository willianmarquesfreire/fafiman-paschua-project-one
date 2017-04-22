package com.wmfsystem.paschua.paschuaprojectone.domain;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class Estoque extends Generic<Long> {

    private Produto produto;

    private Double quantidade;

    public Estoque() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
