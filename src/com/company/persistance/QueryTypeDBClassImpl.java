package com.company.persistance;

import com.company.entities.QueryType;
import com.company.persistance.interfaces.QueryTypeDBClassI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryTypeDBClassImpl implements QueryTypeDBClassI {
    @Override
    public QueryType getQueryType(int id) throws SQLException {
        QueryType result = null;
        String sql = "SELECT * FROM query_types WHERE id=?";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.first()) {
            int queryTypeId = resultSet.getInt(QueryType.COLUMN_ID);
            int departmentID = resultSet.getInt(QueryType.COLUMN_DEPARTMENT_ID);
            String name = resultSet.getString(QueryType.COLUMN_NAME);
            result = new QueryType(queryTypeId, departmentID, name);
        }
        return result;
    }

    @Override
    public int createQueryType(QueryType type) throws SQLException {
        String insertQueryTypeSQL = "INSERT INTO query_types" + "(" + QueryType.COLUMN_DEPARTMENT_ID + ","
                + QueryType.COLUMN_NAME + ")" + " VALUES " + "(?,?)";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertQueryTypeSQL);
        statement.setInt(1, type.getDepartmentId());
        statement.setString(2, type.getName());
        return statement.executeUpdate();
    }

    @Override
    public int deleteQueryType(int id) throws SQLException {
        String delQueryTypeSQL = "DELETE FROM query_types WHERE id=?";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(delQueryTypeSQL);
        statement.setInt(1, id);
        return statement.executeUpdate();
    }

    @Override
    public int updateQueryType(QueryType type) throws SQLException {
        String updateQueryTypeSQL = "UPDATE query_types SET " + QueryType.COLUMN_DEPARTMENT_ID + "=?, "
                + QueryType.COLUMN_NAME + "=? WHERE id=?";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateQueryTypeSQL);
        statement.setInt(1, type.getDepartmentId());
        statement.setString(2, type.getName());
        statement.setInt(3, type.getId());
        return statement.executeUpdate();
    }
}
