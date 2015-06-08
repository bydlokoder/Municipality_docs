package com.company.persistance;

import com.company.entities.QueryType;
import com.company.persistance.interfaces.QueryTypeDBClassI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryTypeDBClassImpl implements QueryTypeDBClassI {
    @Override
    public QueryType getQueryType(int id) {
        QueryType result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM query_types WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                int queryTypeId = resultSet.getInt(QueryType.COLUMN_ID);
                int departmentID = resultSet.getInt(QueryType.COLUMN_DEPARTMENT_ID);
                String name = resultSet.getString(QueryType.COLUMN_NAME);
                result = new QueryType(queryTypeId, departmentID, name);
            }
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
    public int createQueryType(QueryType type) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String insertQueryTypeSQL = "INSERT INTO query_types" + "(" + QueryType.COLUMN_DEPARTMENT_ID + ","
                + QueryType.COLUMN_NAME + ")" + " VALUES " + "(?,?)";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(insertQueryTypeSQL);
            statement.setInt(1, type.getDepartmentId());
            statement.setString(2, type.getName());
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
    public int deleteQueryType(int id) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String delQueryTypeSQL = "DELETE FROM query_types WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(delQueryTypeSQL);
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
    public int updateQueryType(QueryType type) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String updateQueryTypeSQL = "UPDATE query_types SET " + QueryType.COLUMN_DEPARTMENT_ID + "=?, "
                + QueryType.COLUMN_NAME + "=? WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(updateQueryTypeSQL);
            statement.setInt(1, type.getDepartmentId());
            statement.setString(2, type.getName());
            statement.setInt(3, type.getId());
            result = statement.executeUpdate();
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
