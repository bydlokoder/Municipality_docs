package com.company.persistance;

import com.company.entities.Query;
import com.company.persistance.interfaces.QueryDBClassI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDBClassImpl implements QueryDBClassI {
    @Override
    public Query getQuery(int id) {
        Query result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM queries WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                int queryId = resultSet.getInt(Query.COLUMN_ID);
                int citizenId = resultSet.getInt(Query.COLUMN_CITIZEN_ID);
                int queryTypeId = resultSet.getInt(Query.COLUMN_QUERYTYPE_ID);
                int solutionId = resultSet.getInt(Query.COLUMN_SOLUTION_ID);
                int employeeId = resultSet.getInt(Query.COLUMN_EMPLOYEE_ID);
                Date registerDate = resultSet.getDate(Query.COLUMN_REG_DATE);
                Date endDate = resultSet.getDate(Query.COLUMN_END_DATE);
                result = new Query(queryId, citizenId, queryTypeId, solutionId, employeeId, registerDate, endDate);
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
    public int createQuery(Query query) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String insertQuerySQL = "INSERT INTO queries" + "(" + Query.COLUMN_CITIZEN_ID + ","
                + Query.COLUMN_QUERYTYPE_ID + "," + Query.COLUMN_SOLUTION_ID + "," + Query.COLUMN_EMPLOYEE_ID
                + "," + Query.COLUMN_REG_DATE + "," + Query.COLUMN_END_DATE + ")" + " VALUES " + "(?,?,?,?,?,?)";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(insertQuerySQL);
            statement.setInt(1, query.getCitizenId());
            statement.setInt(2, query.getQueryTypeId());
            statement.setInt(3, query.getSolutionId());
            statement.setInt(4, query.getEmployeeId());
            statement.setDate(5, query.getRegisterDate());
            statement.setDate(6, query.getEndDate());
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
    public int deleteQuery(int id) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String delQuerySQL = "DELETE FROM queries WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(delQuerySQL);
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
    public int updateQuery(Query query) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String updateQuerySQL = "UPDATE queries SET " + Query.COLUMN_CITIZEN_ID + "=?, " + Query.COLUMN_QUERYTYPE_ID
                + "=?, " + Query.COLUMN_SOLUTION_ID + "=?," + Query.COLUMN_EMPLOYEE_ID + "=?," + Query.COLUMN_REG_DATE
                + "=?," + Query.COLUMN_END_DATE + "=? WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(updateQuerySQL);
            statement.setInt(1, query.getCitizenId());
            statement.setInt(2, query.getQueryTypeId());
            statement.setInt(3, query.getSolutionId());
            statement.setInt(4, query.getEmployeeId());
            statement.setDate(5, query.getRegisterDate());
            statement.setDate(6, query.getEndDate());
            statement.setInt(7, query.getId());
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
    public List<Query> getQueryListForCitizen(int citizenId) {
        List<Query> result = new ArrayList<>();
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM queries q WHERE q.citizen_id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, citizenId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int queryId = resultSet.getInt(Query.COLUMN_ID);
                int queryTypeId = resultSet.getInt(Query.COLUMN_QUERYTYPE_ID);
                int solutionId = resultSet.getInt(Query.COLUMN_SOLUTION_ID);
                int employeeId = resultSet.getInt(Query.COLUMN_EMPLOYEE_ID);
                Date registerDate = resultSet.getDate(Query.COLUMN_REG_DATE);
                Date endDate = resultSet.getDate(Query.COLUMN_END_DATE);
                result.add(new Query(queryId, citizenId, queryTypeId, solutionId, employeeId, registerDate, endDate));
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
}
