package com.company.entities;

public class Department {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
