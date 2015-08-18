package com.dee.hibernate.dao.one2many;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.junit.Assert;

import com.dee.hibernate.SessionUtil;
import com.dee.hibernate.model.one2many.case02.AddressModel;
import com.dee.hibernate.model.one2many.case02.CustomerModel;

/**
 * @author dien.nguyen
 **/

//Create 2 tables: Address, Customer

public class One2ManyCase02Test extends TestCase {
    
    public void testOne2ManyCase01_1() {
        
        CustomerModel customer = new CustomerModel();
        customer.setEmail("nmdien61@gmail.com");
        
        AddressModel address1 = new AddressModel();
        address1.setAddress("111 Cong Hoa, Ho Chi Minh");
        address1.setCustomer(customer);
        
        AddressModel address2 = new AddressModel();
        address2.setAddress("58 Tran Phu, Ho Chi Minh");
        address2.setCustomer(customer);
        
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(customer);
        session.save(address1);
        session.save(address2);
        session.getTransaction().commit();
        session.close();
        
        session = SessionUtil.getSession();
        CustomerModel pCustomer = (CustomerModel) session.get(CustomerModel.class, customer.getId());
        AddressModel pAddress1 = (AddressModel) session.get(AddressModel.class, address1.getId());
        AddressModel pAddress2 = (AddressModel) session.get(AddressModel.class, address2.getId());
        session.close();
        
        Assert.assertNotNull(pCustomer);
        Assert.assertNotNull(pAddress1);
        Assert.assertNotNull(pAddress2);
        
        Assert.assertNotNull(pAddress1.getCustomer());
        Assert.assertNotNull(pAddress2.getCustomer());
    }
    
}
