package com.company.persistance;

import com.company.entities.Answer;
import com.company.persistance.interfaces.AnswerDBClassI;

import java.sql.*;

public class AnswerDBClassImpl implements AnswerDBClassI {
    public static final String ANSWERS_TABLE = "answers";

    @Override
    public Answer getAnswer(int id) throws SQLException {
        Answer result = null;
        String sql = String.format("SELECT * FROM %s WHERE %s=?", ANSWERS_TABLE, Answer.COLUMN_ID);
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.first()) {
            int answerId = resultSet.getInt(Answer.COLUMN_ID);
            int queryID = resultSet.getInt(Answer.COLUMN_QUERY_ID);
            String answer = resultSet.getString(Answer.COLUMN_ANSWER);
            Date regDate = resultSet.getDate(Answer.COLUMN_REG_DATE);
            result = new Answer(answerId, queryID, answer, regDate);
        }
        return result;
    }

    @Override
    public int createAnswer(Answer answer) throws SQLException {
        String insertAnswerSQL = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)", ANSWERS_TABLE, Answer.COLUMN_QUERY_ID, Answer.COLUMN_REG_DATE, Answer.COLUMN_ANSWER);
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertAnswerSQL);
        statement.setInt(1, answer.getQueryId());
        statement.setDate(2, answer.getRegDate());
        statement.setString(3, answer.getAnswer());
        return statement.executeUpdate();
    }

    @Override
    public int deleteAnswer(int id) throws SQLException {
        String delAnswerSQL = String.format("DELETE FROM %s WHERE %s=?", ANSWERS_TABLE, Answer.COLUMN_ID);
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(delAnswerSQL);
        statement.setInt(1, id);
        return statement.executeUpdate();
    }

    @Override
    public int updateAnswer(Answer answer) throws SQLException {
        String updateAnswerSQL = String.format("UPDATE %s SET %s=?, %s=?, %s=? WHERE %s=?", ANSWERS_TABLE, Answer.COLUMN_QUERY_ID, Answer.COLUMN_ANSWER, Answer.COLUMN_REG_DATE, Answer.COLUMN_ID);
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateAnswerSQL);
        statement.setInt(1, answer.getQueryId());
        statement.setString(2, answer.getAnswer());
        statement.setDate(3, answer.getRegDate());
        statement.setInt(4, answer.getId());
        return statement.executeUpdate();
    }
}
