package com.company.persistance.interfaces;

import com.company.entities.QueryType;

public interface QueryTypeDBClassI {
    void getAnswer(int id);

    void createAnswer(QueryType type);

    void deleteAnswer(int id);

    void updateAnswer(QueryType type);
}
