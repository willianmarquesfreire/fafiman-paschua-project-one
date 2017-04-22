package com.wmfsystem.paschua.paschuaprojectone.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wmfsystem on 4/22/17.
 */
@MappedSuperclass
public class Generic<T> implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;

    public Generic() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Generic<?> generic = (Generic<?>) o;

        return id != null ? id.equals(generic.id) : generic.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Generic{" + this.getClass().getName() +
                ",id=" + id + '}';
    }
}
