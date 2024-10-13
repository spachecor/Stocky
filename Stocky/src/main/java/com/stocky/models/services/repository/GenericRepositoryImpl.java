package com.stocky.models.services.repository;

import com.stocky.models.entities.Entidad;
import jakarta.persistence.EntityManager;

import java.util.List;

/**
 * Clase que define el comportamiento del repositorio. Sus métodos tendrán acceso directo a la base de datos.
 * Sus métodos se usarán a través del servicio correspondiente y no directamente.
 * @param <T> entidad que herede de Entidad
 * @see GenericRepositoryServiceImpl
 * @author Selene
 * @version 1.0
 */
public class GenericRepositoryImpl<T extends Entidad> implements CRUDRepository<T> {
    private EntityManager em;
    private Class<T> entityClass;

    protected GenericRepositoryImpl(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    @Override
    public List<T> listar() {
        return em.createQuery("select t from "+entityClass.getSimpleName() + " t").getResultList();
    }

    @Override
    public T porId(Integer id) {
        return em.find(entityClass, id);
    }

    @Override
    public void guardar(T t) {
        if(t.getId()!=null&&t.getId()>0&&porId(t.getId())!=null) em.merge(t);
        else em.persist(t);
    }

    @Override
    public void eliminar(Integer id) {
        em.remove(porId(id));
    }
}
