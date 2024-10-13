package com.stocky.models.services.repository;

import com.stocky.models.entities.Entidad;

import java.util.List;

/**
 * Interfaz que define los métodos CRUD de los repository de las entidades.
 * No accede directamente a la base de datos, es un paso intermedio
 * @see CRUDRepositoryService
 * @see GenericRepositoryImpl
 * @param <T> entidad que herede de Entidad
 * @author Selene
 * @version 1.0
 */
public interface CRUDRepository <T extends Entidad> {
    /**
     * Método que lista todas las entidades de la tabla a la que pertenece la entidad
     * @return devuelve un objeto List de T con la lista de entidades encontradas
     */
     List<T> listar();

    /**
     * Método que obtiene una entidad en concreto que coincida con el id indicado
     * @param id El id de la entidad solicitada
     * @return La entidad solicitada o null si no la encuentra
     */
    T porId(Integer id);

    /**
     * Método que comprueba si la entidad pasada existe en la base de datos. Si existe, la
     * actualiza, si no, la crea en el repositorio
     * @param t La entidad a actualizar/crear
     */
    void guardar(T t);

    /**
     * Método que elimina la entidad que coincide con el id indicado
     * @param id El id de la entidad a eliminar
     */
    void eliminar(Integer id);
}
