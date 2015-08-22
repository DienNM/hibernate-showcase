package com.dee.hibernate.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import com.dee.hibernate.jpa.componentmapping.collection.PhoneCase01Model;
import com.dee.hibernate.jpa.componentmapping.collection.PhoneCase02Model;
import com.dee.hibernate.jpa.componentmapping.collection.UserCase01Model;
import com.dee.hibernate.jpa.componentmapping.collection.UserCase02Model;

/**
 * @author dien.nguyen
 */
public class ComponentMappingTCollectionest extends TestCase{
    
    public void testComponentMappingCase01() {
        PhoneCase01Model phone1 = new PhoneCase01Model();
        phone1.setNumber("00000001");
        phone1.setExt("1");
        
        PhoneCase01Model phone2 = new PhoneCase01Model();
        phone2.setNumber("00000001");
        phone2.setExt("2");
        
        UserCase01Model user = new UserCase01Model();
        user.setUsername("diennm");

        Set<PhoneCase01Model> phones = new HashSet<PhoneCase01Model>();
        phones.add(phone1);
        phones.add(phone2);
        user.setPhones(phones);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
    
    public void testComponentMappingCase02() {
        PhoneCase02Model phone1 = new PhoneCase02Model();
        phone1.setNumber("00000001");
        phone1.setExt("1");
        
        PhoneCase02Model phone2 = new PhoneCase02Model();
        phone2.setNumber("00000001");
        phone2.setExt("2");
        
        UserCase02Model user = new UserCase02Model();
        user.setUsername("diennm");

        Set<PhoneCase02Model> phones = new HashSet<PhoneCase02Model>();
        phones.add(phone1);
        phones.add(phone2);
        user.setPhones(phones);
        
        phone1.setUser(user);
        phone2.setUser(user);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
    
}
