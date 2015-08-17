package com.dee.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author dien.nguyen
 **/

public interface GenericDao<Entity extends Serializable, Id extends Serializable> {

    Entity find(Id id);
    
    List<Entity> findAll();
    
    Entity save(Entity entity);
    
    void update(Entity entity);
    
    Id remove(Id id);
    
}
