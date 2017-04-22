package com.wmfsystem.paschua.paschuaprojectone.converter;

import com.wmfsystem.paschua.paschuaprojectone.domain.Produto;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by wmfsystem on 4/22/17.
 */
@FacesConverter(value="produtoConverter", forClass=Produto.class)
class produtoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        System.out.println("Converter1");
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return ((Produto) arg2).getDescricao();
    }
}