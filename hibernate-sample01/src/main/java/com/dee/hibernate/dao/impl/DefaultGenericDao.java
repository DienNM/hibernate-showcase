package com.dee.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dee.hibernate.SessionUtil;
import com.dee.hibernate.dao.GenericDao;

/**
 * @author dien.nguyen
 **/

public class DefaultGenericDao<Entity extends Serializable, Id extends Serializable> implements GenericDao<Entity, Id> {
    
    private Class<Entity> clazz;
    
    public DefaultGenericDao(Class<Entity> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Entity find(Id id) {
        if(id == null) {
            return null;
        }
        Session session = SessionUtil.getSession();
        try {
            return (Entity) session.get(clazz, id);
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Entity> findAll() {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("from " + clazz.getName() + " e");
            return query.list();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public Entity save(Entity entity) {
        if(entity == null) {
            return null;
        }
        Session session = SessionUtil.getSession();
        try {
            session.getTransaction().begin();
            Id id = (Id) session.save(entity);
            session.flush();
            session.getTransaction().commit();
            
            return find(id);
        } catch (Exception ex) { 
            session.getTransaction().rollback();
            return null;
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Entity entity) {
        if(entity == null) {
            return;
        }
        Session session = SessionUtil.getSession();
        try {
            session.getTransaction().begin();
            session.update(entity);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception ex) { 
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public Id remove(Id id) {
        if(id == null) {
            return null;
        }
        Session session = SessionUtil.getSession();
        try {
            session.getTransaction().begin();
            Entity entity = find(id);
            if(entity == null) {
                return null;
            }
            session.delete(entity);
            session.getTransaction().commit();
            return id;
        } catch (Exception ex) { 
            session.getTransaction().rollback();
            return null;
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

}
