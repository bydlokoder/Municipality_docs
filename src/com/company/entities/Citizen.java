package com.company.entities;

public class Citizen {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LAST_NAME = "lname";
    public static final String COLUMN_FIRST_NAME = "fname";
    public static final String COLUMN_PASS_NUM = "pass_no";
    public static final String COLUMN_ADDRESS = "address";

    private int id;
    private String lastName;
    private String firstName;
    private String passNum;
    private String address;

    public Citizen(int id, String lastName, String firstName, String passNum, String address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.passNum = passNum;
        this.address = address;
    }

    public Citizen(String lastName, String firstName, String passNum, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.passNum = passNum;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassNum() {
        return passNum;
    }

    public String getAddress() {
        return address;
    }
}
