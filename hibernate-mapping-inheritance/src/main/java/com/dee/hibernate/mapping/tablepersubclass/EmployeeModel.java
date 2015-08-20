package com.dee.hibernate.mapping.tablepersubclass;

import javax.persistence.Entity;

/**
 * @author dien.nguyen
 **/

@Entity(name = "employee_03")
public class EmployeeModel extends UserModel{

    private String department;
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
