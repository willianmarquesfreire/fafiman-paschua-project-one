package com.wmfsystem.paschua.paschuaprojectone.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class Generic<T> implements Serializable {

    private static final long serialVersionUID = 1l;
    private T id;

    public Generic() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

}

