package com.company.persistance.interfaces;

import com.company.entities.QueryType;

import java.sql.SQLException;

public interface QueryTypeDBClassI {
    QueryType getQueryType(int id) throws SQLException;

    int createQueryType(QueryType query) throws SQLException;

    int deleteQueryType(int id) throws SQLException;

    int updateQueryType(QueryType query) throws SQLException;
}
