package com.wmfsystem.paschua.paschuaprojectone.dao.interfaces;

import com.wmfsystem.paschua.paschuaprojectone.infrastructure.Connection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class GenericDAO<T, K> implements Serializable, DAO<T, K> {

    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            getEntityManager().getTransaction().rollback();
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void update(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            getEntityManager().getTransaction().rollback();
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public T merge(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            entity = getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
            return entity;
        } catch (Exception ex) {
            getEntityManager().getTransaction().rollback();
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public void delete(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            entity = getEntityManager().merge(entity);
            getEntityManager().remove(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            getEntityManager().getTransaction().rollback();
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            getEntityManager().close();
        }
    }

    @Override
    public T findById(K id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("select obj from ");
        sb.append(entityClass.getSimpleName());
        sb.append(" obj order by obj.id");
        Query query = getEntityManager().createQuery(sb.toString());
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return Connection.getEntityManager();
    }

    @Override
    public Class<T> getEntityClass() {
        return entityClass;
    }
}
