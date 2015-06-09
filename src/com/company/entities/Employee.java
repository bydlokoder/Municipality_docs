package com.company.entities;

public class Employee {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LAST_NAME = "lname";
    public static final String COLUMN_FIRST_NAME = "fname";
    public static final String COLUMN_DEPARTMENT_ID = "dep_id";

    private int id, depId;
    private String fName, lName;

    public Employee(int id, int depId, String fName, String lName) {
        this.id = id;
        this.depId = depId;
        this.fName = fName;
        this.lName = lName;
    }

    public Employee(int depId, String fName, String lName) {
        this.depId = depId;
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        return id;
    }

    public int getDepId() {
        return depId;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }
}
