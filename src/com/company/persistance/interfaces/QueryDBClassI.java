package com.company.persistance.interfaces;

import com.company.entities.Query;
import java.sql.SQLException;

public interface QueryDBClassI {
    Query getQuery(int id) throws SQLException;

    int createQuery(Query query) throws SQLException;

    int deleteQuery(int id) throws SQLException;

    int updateQuery(Query query) throws SQLException;
}
