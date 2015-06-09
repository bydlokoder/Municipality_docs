package com.company.persistance.interfaces;

import com.company.entities.QueryType;

public interface QueryTypeDBClassI {
    QueryType getQueryType(int id);

    int createQueryType(QueryType query);

    int deleteQueryType(int id);

    int updateQueryType(QueryType query);
}
