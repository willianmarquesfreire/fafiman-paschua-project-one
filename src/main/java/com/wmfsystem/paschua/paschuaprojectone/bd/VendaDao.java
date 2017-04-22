package com.wmfsystem.paschua.paschuaprojectone.bd;

import com.wmfsystem.paschua.paschuaprojectone.domain.Estoque;
import com.wmfsystem.paschua.paschuaprojectone.domain.Venda;

import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class VendaDao {

    public Venda save(Venda venda) {
        venda.setId(Integer.toUnsignedLong(BD.vendas.size()+1));
        if (venda.getEstoque().getId() > BD.produtos.size() + 1) {
            throw new RuntimeException("Estoque Não existente!");
        }

        int idProduto = venda.getEstoque().getId().intValue() - 1;

        Estoque estoque = BD.estoque.get(idProduto);
        if (venda.getQuantidade() > estoque.getQuantidade()) {
            throw  new RuntimeException("Quantidade Impossibilitada!");
        }

        estoque.setQuantidade(estoque.getQuantidade() - venda.getQuantidade());

        venda.setEstoque(BD.estoque.get(idProduto));
        BD.vendas.add(venda);
        return venda;
    }

    public Venda find(int id){
        return BD.vendas.get(id);
    }

    public List<Venda> findAll() {
        return BD.vendas;
    }

    public void delete(int id) {
        BD.produtos.remove(id);
    }
}
