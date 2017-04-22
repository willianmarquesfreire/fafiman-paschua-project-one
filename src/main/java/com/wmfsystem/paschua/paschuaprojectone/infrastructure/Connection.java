package com.wmfsystem.paschua.paschuaprojectone.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

/**
 * Created by wmfsystem on 4/22/17.
 */
public class Connection implements Serializable {

    private static final String UNIT_NAME = "wmfsystempaschua";
    private static EntityManagerFactory factory;
    private static EntityManager manager;

    private Connection() {
        factory = Persistence.createEntityManagerFactory(UNIT_NAME);
    }

    private static void createEntityManager() {
        if (factory == null) {
            new Connection();
        }
        manager = factory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        if (manager == null || !manager.isOpen()) {
            createEntityManager();
        }
        return manager;
    }
}
