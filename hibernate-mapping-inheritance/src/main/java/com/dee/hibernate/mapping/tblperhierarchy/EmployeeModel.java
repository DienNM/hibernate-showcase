package com.dee.hibernate.mapping.tblperhierarchy;

import javax.persistence.Entity;

/**
 * @author dien.nguyen
 **/

@Entity(name = "employee_01")
public class EmployeeModel extends UserModel{

    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
