package org.spring.petclinic.services.map;

import org.spring.petclinic.model.BaseEntity;
import org.spring.petclinic.services.CrudRepository;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudRepository<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T t) {
        if(t != null){
            if(t.getId() == null){
                t.setId(getNextId());
            }
            map.put(t.getId(), t);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return t;
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public void delete(T t) {
        map.entrySet()
            .removeIf(entry->entry.getValue().equals(t));
    }

    private Long getNextId() {
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
