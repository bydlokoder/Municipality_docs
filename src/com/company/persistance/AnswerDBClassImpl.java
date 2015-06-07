package com.company.persistance;

import com.company.entities.Answer;
import com.company.persistance.interfaces.AnswerDBClassI;

import java.sql.*;

public class AnswerDBClassImpl implements AnswerDBClassI {
    @Override
    public Answer getAnswer(int id) throws SQLException {
        Answer result = null;
        String sql = "SELECT * FROM answers WHERE id=?";
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
        String insertAnswerSQL = "INSERT INTO answers" + "(" + Answer.COLUMN_QUERY_ID + ","
                + Answer.COLUMN_REG_DATE + "," + Answer.COLUMN_ANSWER + ")" + " VALUES "
                + "(?,?,?)";
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertAnswerSQL);
        statement.setInt(1, answer.getQueryId());
        statement.setDate(2, answer.getRegDate());
        statement.setString(3, answer.getAnswer());
        return statement.executeUpdate();
    }

    @Override
    public void deleteAnswer(int id) {

    }

    @Override
    public void updateAnswer(Answer answer) {

    }
}
