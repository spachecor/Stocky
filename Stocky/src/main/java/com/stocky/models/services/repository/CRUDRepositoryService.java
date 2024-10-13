package com.stocky.models.services.repository;

import com.stocky.models.entities.Entidad;

import java.util.List;
import java.util.Optional;

/**
 * Interface que define los métodos CRUD de los servicios que accedan a la base de datos.
 * Paso final, utiliza el repository para acceder a la base de datos.
 * @param <T> entidad que herede de Entidad
 * @see CRUDRepository
 * @see GenericRepositoryImpl
 * @author Selene
 * @version 1.0
 */
public interface CRUDRepositoryService<T extends Entidad> {
    /**
     * Método que lista todas las entidades de la tabla a la que pertenezca la entidad t
     * @return Un objeto de tipo List con una lista de entidades encontradas
     */
    List<T> listar();

    /**
     * Método que busca una entidad por el id proporcionado
     * @param id El id de la entidad a buscar
     * @return Un objeto Optional que englobará la entidad encontrada o null
     */
    Optional<T> porId(Integer id);

    /**
     * Método que guarda o actualiza la entidad que se le pase. Se realiza la transacción.
     * @param t La entidad a actualizar/guardar
     */
    void guardar(T t);

    /**
     * Método que elimina la entidad cuyo id coincida con el proporcionado
     * @param id El id de la enitidad a eliminar
     */
    void eliminar(Integer id);
}
