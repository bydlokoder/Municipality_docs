package com.company.persistance.interfaces;

import com.company.entities.Answer;
import com.company.entities.Department;

import java.sql.SQLException;

public interface DepartmentDBClassI {
    Answer getDepartment(int id) throws SQLException;

    int createDepartment(Department department) throws SQLException;

    int deleteDepartment(int id) throws SQLException;

    int updateDepartment(Department department) throws SQLException;
}
