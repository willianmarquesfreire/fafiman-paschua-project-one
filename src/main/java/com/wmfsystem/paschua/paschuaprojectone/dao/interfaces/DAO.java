package com.wmfsystem.paschua.paschuaprojectone.dao.interfaces;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
public interface DAO<T, K> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T merge(T entity);

    T findById(K id);

    List<T> findAll();

    EntityManager getEntityManager();

    Class<T> getEntityClass();
}
