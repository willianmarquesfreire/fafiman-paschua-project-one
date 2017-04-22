package com.wmfsystem.paschua.paschuaprojectone.bd;

import com.wmfsystem.paschua.paschuaprojectone.domain.Estoque;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class EstoqueDao {

    public Estoque save(Estoque estoque) {
        estoque.setId(Integer.toUnsignedLong(BD.estoque.size() + 1));
        if (estoque.getProduto().getId() > BD.produtos.size() + 1) {
            throw new RuntimeException("Produto Não existente!");
        }
        int idProduto = estoque.getProduto().getId().intValue() - 1;

        estoque.setProduto(BD.produtos.get(idProduto));
        BD.estoque.add(estoque);
        return estoque;
    }

    public Estoque find(int id) {
        return BD.estoque.get(id);
    }

    public List<Estoque> findAll() {
        return BD.estoque;
    }

    public void delete(int id) {
        BD.produtos.remove(id);
    }


}
