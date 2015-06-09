package com.company.persistance;

import com.company.entities.Employee;
import com.company.persistance.interfaces.EmployeeDBClassI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDBClassImpl implements EmployeeDBClassI {
    @Override
    public Employee getEmployee(int id) {
        Employee result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM employees WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                int employeeId = resultSet.getInt(Employee.COLUMN_ID);
                int depID = resultSet.getInt(Employee.COLUMN_DEPARTMENT_ID);
                String fName = resultSet.getString(Employee.COLUMN_FIRST_NAME);
                String lName = resultSet.getString(Employee.COLUMN_LAST_NAME);
                result = new Employee(id, depID, fName, lName);
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
    public int createEmployee(Employee employee) {
        int result = 0;
        String insertEmployeeSQL = "INSERT INTO employees" + "(" + Employee.COLUMN_LAST_NAME + ","
                + Employee.COLUMN_FIRST_NAME + "," + Employee.COLUMN_DEPARTMENT_ID + ")" + " VALUES " + "(?,?,?)";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(insertEmployeeSQL);
            statement.setString(1, employee.getLName());
            statement.setString(2, employee.getFName());
            statement.setInt(3, employee.getDepId());
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
    public int deleteEmployee(int id) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String delEmployeeSQL = "DELETE FROM employees WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(delEmployeeSQL);
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
    public int updateEmployee(Employee employee) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String updateEmployeeSQL = "UPDATE employees SET " + Employee.COLUMN_LAST_NAME + "=?, "
                + Employee.COLUMN_FIRST_NAME + "=?, " + Employee.COLUMN_DEPARTMENT_ID + "=? WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(updateEmployeeSQL);
            statement.setString(1, employee.getLName());
            statement.setString(2, employee.getFName());
            statement.setInt(3, employee.getDepId());
            statement.setInt(4, employee.getId());
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
