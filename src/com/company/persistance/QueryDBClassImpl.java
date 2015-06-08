package com.company.persistance;

import com.company.entities.Query;
import com.company.persistance.interfaces.QueryDBClassI;

import java.sql.*;

public class QueryDBClassImpl implements QueryDBClassI {
    @Override
    public Query getQuery(int id) throws SQLException {
        Query result = null;
        String sql = "SELECT * FROM queries WHERE id=?";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
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
        return result;
    }

    @Override
    public int createQuery(Query query) throws SQLException {
        String insertQuerySQL = "INSERT INTO queries" + "(" + Query.COLUMN_CITIZEN_ID + ","
                + Query.COLUMN_QUERYTYPE_ID + "," + Query.COLUMN_SOLUTION_ID + "," + Query.COLUMN_EMPLOYEE_ID
                + "," + Query.COLUMN_REG_DATE + "," + Query.COLUMN_END_DATE + ")" + " VALUES " + "(?,?,?,?,?,?)";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertQuerySQL);
        statement.setInt(1, query.getCitizenId());
        statement.setInt(2, query.getQueryTypeId());
        statement.setInt(3, query.getSolutionId());
        statement.setInt(4, query.getEmployeeId());
        statement.setDate(5, query.getRegisterDate());
        statement.setDate(6, query.getEndDate());
        return statement.executeUpdate();
    }

    @Override
    public int deleteQuery(int id) throws SQLException {
        String delQuerySQL = "DELETE FROM queries WHERE id=?";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(delQuerySQL);
        statement.setInt(1, id);
        return statement.executeUpdate();
    }

    @Override
    public int updateQuery(Query query) throws SQLException {
        String updateQuerySQL = "UPDATE queries SET " + Query.COLUMN_CITIZEN_ID + "=?, " + Query.COLUMN_QUERYTYPE_ID
                + "=?, " + Query.COLUMN_SOLUTION_ID + "=?," + Query.COLUMN_EMPLOYEE_ID + "=?," + Query.COLUMN_REG_DATE
                + "=?," + Query.COLUMN_END_DATE + "=? WHERE id=?";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateQuerySQL);
        statement.setInt(1, query.getCitizenId());
        statement.setInt(2, query.getQueryTypeId());
        statement.setInt(3, query.getSolutionId());
        statement.setInt(4, query.getEmployeeId());
        statement.setDate(5, query.getRegisterDate());
        statement.setDate(6, query.getEndDate());
        statement.setInt(7, query.getId());
        return statement.executeUpdate();
    }
}
