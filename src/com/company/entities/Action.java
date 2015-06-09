package com.company.entities;

public class Action {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SOLUTION_ID = "sol_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NOTES = "notes";

    private int id;
    private int solutionId;
    private String name;
    private String notes;

    public Action(int id, int solutionId, String name, String notes) {
        this.id = id;
        this.solutionId = solutionId;
        this.name = name;
        this.notes = notes;
    }

    public Action(int solutionId, String name, String notes) {
        this.solutionId = solutionId;
        this.name = name;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }
}
