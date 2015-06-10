package com.company.persistance.interfaces;

import com.company.entities.Query;

import java.util.List;

public interface QueryDBClassI {
    Query getQuery(int id);

    int createQuery(Query query);

    int deleteQuery(int id);

    int updateQuery(Query query);

    List<Query> getQueryListForCitizen(int citizenId);

    List<Query> getQueryListWithStatus(String status);

    List<Query> getExpiredQueryList();

    List<Query> getQueryListAssignedTo(int employeeId);

    int getQueriesNumForDepartmentWithStatus(int departmentId, String string);
}
