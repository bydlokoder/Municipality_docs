package com.company.persistance;

import com.company.entities.Action;
import com.company.persistance.interfaces.ActionDBClassI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActionDBClassImpl implements ActionDBClassI {
    @Override
    public Action getAction(int id) {
        Action result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM actions WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                int actionId = resultSet.getInt(Action.COLUMN_ID);
                int solutionId = resultSet.getInt(Action.COLUMN_SOLUTION_ID);
                String name = resultSet.getString(Action.COLUMN_NAME);
                String notes = resultSet.getString(Action.COLUMN_NOTES);
                result = new Action(actionId, solutionId, name, notes);
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
    public int createAction(Action action) {
        int result = 0;
        String insertActionSQL = "INSERT INTO actions" + "(" + Action.COLUMN_SOLUTION_ID + ","
                + Action.COLUMN_NAME + "," + Action.COLUMN_NOTES + ")" + " VALUES "
                + "(?,?,?)";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(insertActionSQL);
            statement.setInt(1, action.getId());
            statement.setString(2, action.getName());
            statement.setString(3, action.getNotes());
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
    public int deleteAction(int id) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String delActionSQL = "DELETE FROM actions WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(delActionSQL);
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
    public int updateAction(Action action) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String updateAnswerSQL = "UPDATE actions SET " + Action.COLUMN_SOLUTION_ID + "=?, " + Action.COLUMN_NAME + "=?, "
                + Action.COLUMN_NOTES + "=? WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(updateAnswerSQL);
            statement.setInt(1, action.getSolutionId());
            statement.setString(2, action.getName());
            statement.setString(3, action.getNotes());
            statement.setInt(4, action.getId());
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
}
