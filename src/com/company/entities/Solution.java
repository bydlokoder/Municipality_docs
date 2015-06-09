package com.company.entities;

import java.sql.Date;

public class Solution {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EXEC_DATE = "exec_date";
    public static final String COLUMN_PROTOCOL_PATH = "protocol_path";

    private int id;
    private Date execDate;
    private String protocolPath;

    public Solution(int id, Date execDate, String protocolPath) {
        this.id = id;
        this.execDate = execDate;
        this.protocolPath = protocolPath;
    }

    public Solution(Date execDate, String protocolPath) {
        this.execDate = execDate;
        this.protocolPath = protocolPath;
    }

    public int getId() {
        return id;
    }

    public Date getExecDate() {
        return execDate;
    }

    public String getProtocolPath() {
        return protocolPath;
    }
}
