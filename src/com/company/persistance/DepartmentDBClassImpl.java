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
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM departments WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                int departmentId = resultSet.getInt(Department.COLUMN_ID);
                String name = resultSet.getString(Department.COLUMN_NAME);
                result = new Department(departmentId, name);
                connection.commit();
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int createDepartment(Department department) throws SQLException {
        String insertDepartmentSQL = "INSERT INTO departments" + "(" + Department.COLUMN_NAME + ")" + " VALUES " + "(?)";
        PreparedStatement statement = null;
        Connection connection = null;
        int result = 0;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(insertDepartmentSQL);
            statement.setString(1, department.getName());
            result = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int deleteDepartment(int id) throws SQLException {
        PreparedStatement statement = null;
        Connection connection = null;
        int result = 0;
        String delDepartmentSQL = "DELETE FROM departments WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(delDepartmentSQL);
            statement.setInt(1, id);
            result = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int updateDepartment(Department department) throws SQLException {
        PreparedStatement statement = null;
        Connection connection = null;
        int result = 0;
        String updateDepartmentSQL = "UPDATE departments SET " + Department.COLUMN_NAME + "=? WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(updateDepartmentSQL);
            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());
            result = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
