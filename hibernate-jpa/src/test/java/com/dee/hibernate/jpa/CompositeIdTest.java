package com.dee.hibernate.jpa;

import javax.persistence.EntityManager;

import org.junit.Assert;

import com.dee.hibernate.jpa.compositeid.OrderDetailCase01Model;
import com.dee.hibernate.jpa.compositeid.OrderDetailCase02Model;
import com.dee.hibernate.jpa.compositeid.OrderDetailCase03Model;
import com.dee.hibernate.jpa.compositeid.OrderDetailId02;
import com.dee.hibernate.jpa.compositeid.OrderDetailId03;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 */
public class CompositeIdTest extends TestCase{
    
    public void testCompoisteIdCase01() {
        OrderDetailCase01Model orderDetail = new OrderDetailCase01Model();
        orderDetail.setAmount(10);
        orderDetail.setItemId("IT01");
        orderDetail.setOrderId("OR01");
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(orderDetail);
        em.getTransaction().commit();
        em.close();
        
    }
    
    public void testCompoisteIdCase02() {
        OrderDetailCase02Model orderDetail = new OrderDetailCase02Model();
        orderDetail.setAmount(10);
        orderDetail.setItemId("IT01");
        orderDetail.setOrderId("OR01");
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(orderDetail);
        em.getTransaction().commit();
        em.close();
        
        OrderDetailId02 orderDetailId02 = new OrderDetailId02();
        orderDetailId02.setItemId("IT01");
        orderDetailId02.setOrderId("OR01");
        
        em = EntityManagerUtil.getEntityManager();
        OrderDetailCase02Model pOrderDetail = em.find(OrderDetailCase02Model.class, orderDetailId02);
        
        Assert.assertNotNull(pOrderDetail);
    }
    
    public void testCompoisteIdCase03() {
        
        OrderDetailId03 orderDetailId03 = new OrderDetailId03();
        orderDetailId03.setItemId("IT01");
        orderDetailId03.setOrderId("OR01");
        
        OrderDetailCase03Model orderDetail = new OrderDetailCase03Model();
        orderDetail.setAmount(10);
        orderDetail.setId(orderDetailId03);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(orderDetail);
        em.getTransaction().commit();
        em.close();
        
        em = EntityManagerUtil.getEntityManager();
        OrderDetailCase03Model pOrderDetail = em.find(OrderDetailCase03Model.class, orderDetailId03);
        Assert.assertNotNull(pOrderDetail);
    }
    
}
