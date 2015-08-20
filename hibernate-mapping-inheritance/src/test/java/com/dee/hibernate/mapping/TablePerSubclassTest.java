package com.dee.hibernate.mapping;

import org.hibernate.Session;
import org.junit.Assert;

import com.dee.hibernate.mapping.tablepersubclass.CustomerModel;
import com.dee.hibernate.mapping.tablepersubclass.EmployeeModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class TablePerSubclassTest extends TestCase{
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testCreateTables() {
        
        EmployeeModel employee = new EmployeeModel();
        employee.setDepartment("IT");
        employee.setEmail("nmdien61@gmail.com");
        
        CustomerModel customer = new CustomerModel();
        customer.setEmail("nguyenminhdien1506@gmail.com");
        customer.setPhone("1234560000");
        customer.setType("Retailer");
        
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(customer);
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        
        session = SessionUtil.getSession();
        CustomerModel pCustomer = (CustomerModel) session.get(CustomerModel.class, customer.getId());
        EmployeeModel pEmployee = (EmployeeModel) session.get(EmployeeModel.class, employee.getId());
        
        Assert.assertNotNull(pCustomer);
        Assert.assertEquals("Retailer", pCustomer.getType());
        
        Assert.assertNotNull(pEmployee);
        Assert.assertEquals("IT", pEmployee.getDepartment());
        
    }
}
