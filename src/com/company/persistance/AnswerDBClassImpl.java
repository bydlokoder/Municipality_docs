package com.company.persistance;

import com.company.entities.Answer;
import com.company.persistance.interfaces.AnswerDBClassI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerDBClassImpl implements AnswerDBClassI {
    @Override
    public Answer getAnswer(int id) {
        Answer result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM answers WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                int answerId = resultSet.getInt(Answer.COLUMN_ID);
                int queryID = resultSet.getInt(Answer.COLUMN_QUERY_ID);
                String answer = resultSet.getString(Answer.COLUMN_ANSWER);
                Date regDate = resultSet.getDate(Answer.COLUMN_REG_DATE);
                result = new Answer(answerId, queryID, answer, regDate);
                connection.commit();
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int createAnswer(Answer answer) {
        int result = 0;
        String insertAnswerSQL = "INSERT INTO answers" + "(" + Answer.COLUMN_QUERY_ID + ","
                + Answer.COLUMN_REG_DATE + "," + Answer.COLUMN_ANSWER + ")" + " VALUES "
                + "(?,?,?)";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(insertAnswerSQL);
            statement.setInt(1, answer.getQueryId());
            statement.setDate(2, answer.getRegDate());
            statement.setString(3, answer.getAnswer());
            result = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int deleteAnswer(int id) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String delAnswerSQL = "DELETE FROM answers WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(delAnswerSQL);
            statement.setInt(1, id);
            result = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int updateAnswer(Answer answer) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String updateAnswerSQL = "UPDATE answers SET " + Answer.COLUMN_QUERY_ID + "=?, " + Answer.COLUMN_ANSWER + "=?, "
                + Answer.COLUMN_REG_DATE + "=? WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(updateAnswerSQL);
            statement.setInt(1, answer.getQueryId());
            statement.setString(2, answer.getAnswer());
            statement.setDate(3, answer.getRegDate());
            statement.setInt(4, answer.getId());
            result = statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public List<Answer> getAnswerListByQuery(int queryId) {
        List<Answer> result = new ArrayList<>();
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM answers a WHERE a.query_id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, queryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int answerId = resultSet.getInt(Answer.COLUMN_ID);
                int queryID = resultSet.getInt(Answer.COLUMN_QUERY_ID);
                String answer = resultSet.getString(Answer.COLUMN_ANSWER);
                Date regDate = resultSet.getDate(Answer.COLUMN_REG_DATE);
                result.add(new Answer(answerId, queryID, answer, regDate));
                connection.commit();
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
