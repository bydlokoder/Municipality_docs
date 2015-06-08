package com.company.persistance;

import com.company.entities.Department;
import com.company.persistance.interfaces.DepartmentDBClassI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDBClassImpl implements DepartmentDBClassI {
    @Override
    public Department getDepartment(int id) throws SQLException {
        Department result = null;
        String sql = "SELECT * FROM departments WHERE id=?";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.first()) {
            int departmentId = resultSet.getInt(Department.COLUMN_ID);
            String name = resultSet.getString(Department.COLUMN_NAME);
            result = new Department(departmentId, name);
        }
        return result;
    }

    @Override
    public int createDepartment(Department department) throws SQLException {
        String insertDepartmentSQL = "INSERT INTO departments" + "(" + Department.COLUMN_NAME + ")" + " VALUES " + "(?)";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertDepartmentSQL);
        statement.setString(1, department.getName());
        return statement.executeUpdate();
    }

    @Override
    public int deleteDepartment(int id) throws SQLException {
        return 0;
    }

    @Override
    public int updateDepartment(Department department) throws SQLException {
        return 0;
    }
}
