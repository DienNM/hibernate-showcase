package com.dee.hibernate.jpa;

import javax.persistence.EntityManager;

import com.dee.hibernate.jpa.componentmapping.ContactCase01Model;
import com.dee.hibernate.jpa.componentmapping.ContactCase02Model;
import com.dee.hibernate.jpa.componentmapping.OrderCase01Model;
import com.dee.hibernate.jpa.componentmapping.OrderCase02Model;
import com.dee.hibernate.jpa.componentmapping.PhoneCase02Model;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 */
public class ComponentMappingTest extends TestCase{
    
    public void testComponentMappingCase01() {
        
        ContactCase01Model home = new ContactCase01Model();
        home.setAddress("Home Address");
        home.setName("Home");
        home.setPhone("08-home-phone");
        
        ContactCase01Model office = new ContactCase01Model();
        office.setAddress("Office Address");
        office.setName("Office");
        office.setPhone("08-office-phone");
        
        OrderCase01Model order = new OrderCase01Model();
        order.setTotal(170);
        order.setHomeContact(home);
        order.setOfficeContact(office);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.persist(order);
        em.getTransaction().commit();
        em.close();
    }
    
    public void testComponentMappingCase02_Nested() {
        
        ContactCase02Model home = new ContactCase02Model();
        home.setAddress("Home Address");
        home.setName("Home");
        
        PhoneCase02Model phoneHome = new PhoneCase02Model();
        phoneHome.setExt("1");
        phoneHome.setInternal(false);
        phoneHome.setNumber("08-home-phone");
        home.setPhone(phoneHome);
        
        ContactCase02Model office = new ContactCase02Model();
        office.setAddress("Office Address");
        office.setName("Office");
        PhoneCase02Model phoneOffice = new PhoneCase02Model();
        phoneOffice.setExt("2");
        phoneOffice.setInternal(true);
        phoneOffice.setNumber("08-officephone");
        office.setPhone(phoneOffice);
        
        OrderCase02Model order = new OrderCase02Model();
        order.setTotal(170);
        order.setHomeContact(home);
        order.setOfficeContact(office);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.persist(order);
        em.getTransaction().commit();
        em.close();
    }
    
}
