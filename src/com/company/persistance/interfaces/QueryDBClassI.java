package com.company.persistance.interfaces;

import javax.management.Query;

public interface QueryDBClassI {
    void getAnswer(int id);

    void createAnswer(Query query);

    void deleteAnswer(int id);

    void updateAnswer(Query query);
}
