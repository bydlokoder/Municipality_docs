package com.company.persistance.interfaces;

import com.company.entities.Query;

public interface QueryDBClassI {
    Query getQuery(int id);

    int createQuery(Query query);

    int deleteQuery(int id);

    int updateQuery(Query query);
}
