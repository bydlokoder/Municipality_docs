package com.company.persistance;

import com.company.entities.Citizen;
import com.company.persistance.interfaces.CitizenDBClassI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitizenDBClassImpl implements CitizenDBClassI {
    public static final String CITIZENS_TABLE = "citizens";
    @Override
    public Citizen getCitizen(int id) throws SQLException {
        Citizen result = null;
        String sql = String.format("SELECT * FROM %s WHERE %s=?", CITIZENS_TABLE, Citizen.COLUMN_ID);
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.first()) {
            int citizenId = resultSet.getInt(Citizen.COLUMN_ID);
            String lastName = resultSet.getString(Citizen.COLUMN_LAST_NAME);
            String firstName = resultSet.getString(Citizen.COLUMN_FIRST_NAME);
            String passNum = resultSet.getString(Citizen.COLUMN_PASS_NUM);
            String address = resultSet.getString(Citizen.COLUMN_ADDRESS);
            result = new Citizen(citizenId, lastName, firstName, passNum, address);
        }
        return result;
    }

    @Override
    public int createCitizen(Citizen citizen) throws SQLException {
        String insertCitizenSQL = String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES (?,?,?,?)", CITIZENS_TABLE, Citizen.COLUMN_LAST_NAME, Citizen.COLUMN_FIRST_NAME, Citizen.COLUMN_PASS_NUM, Citizen.COLUMN_ADDRESS);
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertCitizenSQL);
        statement.setString(1, citizen.getLastName());
        statement.setString(2, citizen.getFirstName());
        statement.setString(3, citizen.getPassNum());
        statement.setString(4, citizen.getAddress());
        return statement.executeUpdate();
    }

    @Override
    public int deleteCitizen(int id) throws SQLException {
        String delCitizenSQL = String.format("DELETE FROM %s WHERE %s=?", CITIZENS_TABLE, Citizen.COLUMN_ID);
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(delCitizenSQL);
        statement.setInt(1, id);
        return statement.executeUpdate();
    }

    @Override
    public int updateCitizen(Citizen citizen) throws SQLException {
        String updateAnswerSQL = String.format("UPDATE %s SET %s=?, %s=?, %s=?,%s=? WHERE %s=?", CITIZENS_TABLE, Citizen.COLUMN_LAST_NAME, Citizen.COLUMN_FIRST_NAME, Citizen.COLUMN_PASS_NUM, Citizen.COLUMN_ADDRESS, Citizen.COLUMN_ID);
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateAnswerSQL);
        statement.setString(1, citizen.getLastName());
        statement.setString(2, citizen.getFirstName());
        statement.setString(3, citizen.getPassNum());
        statement.setString(4, citizen.getAddress());
        statement.setInt(5, citizen.getId());
        return statement.executeUpdate();
    }
}
