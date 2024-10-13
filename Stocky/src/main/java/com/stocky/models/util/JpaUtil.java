package com.stocky.models.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase que sirve como la utilidad de la persistencia. Su función es ser implementada para gestionar el acceso a
 * la persistencia
 * @author selene.pacheco
 */
public class JpaUtil {
    private static final EntityManagerFactory EMF;
    static{
        EMF = buildEntityManagerFactory();
    }

    /**
     * Método que crea un EntityManagerFactory para toda la app a partir de la unidad de persistencia
     * @return El EntityManagerFactory de la app
     */
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("Stocky");
    }

    /**
     * Método que crea un EntityManager por cada conexión a partir del ENTITY_MANAGER_FACTORY
     * @return El EntityManager de cada conexión
     */
    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
}
