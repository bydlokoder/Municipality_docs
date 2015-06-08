package com.company.entities;

public class QueryType {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DEPARTMENT_ID = "citizen_id";
    public static final String COLUMN_NAME = "query_type_id";

    private int id;
    private int departmentId;
    private String name;

    public QueryType(int id, int departmentId, String name) {
        this.id = id;
        this.departmentId = departmentId;
        this.name = name;
    }

    public QueryType(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }
}
