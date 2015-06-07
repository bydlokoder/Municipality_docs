package com.company.entities;

import java.sql.Date;

public class Answer {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUERY_ID = "query_id";
    public static final String COLUMN_REG_DATE = "reg_date";
    public static final String COLUMN_ANSWER = "answer";

    private int id;
    private int queryId;
    private String answer;
    private Date regDate;

    public Answer(int id, int queryId, String answer, Date regDate) {
        this.id = id;
        this.queryId = queryId;
        this.answer = answer;
        this.regDate = regDate;
    }

    public Answer(int queryId, String answer, Date regDate) {
        this.queryId = queryId;
        this.answer = answer;
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public int getQueryId() {
        return queryId;
    }

    public String getAnswer() {
        return answer;
    }

    public Date getRegDate() {
        return regDate;
    }
}
