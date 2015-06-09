package com.company.persistance.interfaces;

import com.company.entities.Employee;

public interface EmployeeDBClassI {
    Employee getEmployee(int id);

    int createEmployee(Employee employee);

    int deleteEmployee(int id);

    int updateEmployee(Employee employee);
}
