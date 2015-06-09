package com.company.persistance.interfaces;

import com.company.entities.Department;

public interface DepartmentDBClassI {
    Department getDepartment(int id);

    int createDepartment(Department department);

    int deleteDepartment(int id);

    int updateDepartment(Department department);
}
