package com.company.entities;

import java.sql.Date;

public class Query {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CITIZEN_ID = "citizen_id";
    public static final String COLUMN_QUERYTYPE_ID = "query_type_id";
    public static final String COLUMN_SOLUTION_ID = "sol_id";
    public static final String COLUMN_EMPLOYEE_ID = "emp_id";
    public static final String COLUMN_REG_DATE = "reg_date";
    public static final String COLUMN_END_DATE = "end_date";

    private int id;
    private int citizenId;
    private int queryTypeId;
    private int solutionId;
    private int employeeId;
    private Date registerDate;
    private Date endDate;

    public Query(int id, int citizenId, int queryTypeId, int solutionId,
                 int employeeId, Date registerDate, Date endDate) {
        this.id = id;
        this.citizenId = citizenId;
        this.queryTypeId = queryTypeId;
        this.solutionId = solutionId;
        this.employeeId = employeeId;
        this.registerDate = registerDate;
        this.endDate = endDate;
    }

    public Query(int citizenId, int queryTypeId, int solutionId, int employeeId, Date registerDate, Date endDate) {
        this.citizenId = citizenId;
        this.queryTypeId = queryTypeId;
        this.solutionId = solutionId;
        this.employeeId = employeeId;
        this.registerDate = registerDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public int getQueryTypeId() {
        return queryTypeId;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
