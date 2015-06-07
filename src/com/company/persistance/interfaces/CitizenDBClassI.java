package com.company.persistance.interfaces;

import com.company.entities.Citizen;

import java.sql.SQLException;

public interface CitizenDBClassI {
    Citizen getCitizen(int id) throws SQLException;

    int createCitizen(Citizen citizen)throws SQLException;

    int deleteCitizen(int id)throws SQLException;

    int updateCitizen(Citizen citizen)throws SQLException;
}
