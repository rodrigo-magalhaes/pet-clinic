package org.spring.petclinic.services;

import java.util.Set;

public interface CrudRepository<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T t);

    void delete(T t);

    void deleteById(ID id);
}
