package com.company.persistance;

import com.company.entities.Solution;
import com.company.persistance.interfaces.SolutionDBClassI;

import java.sql.*;

public class SolutionDBClassImpl implements SolutionDBClassI {
    @Override
    public Solution getSolution(int id) {
        Solution result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        String sql = "SELECT * FROM solutions WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.first()) {
                int solutionId = resultSet.getInt(Solution.COLUMN_ID);
                Date execDate = resultSet.getDate(Solution.COLUMN_EXEC_DATE);
                String protocolPath = resultSet.getString(Solution.COLUMN_PROTOCOL_PATH);
                result = new Solution(solutionId, execDate, protocolPath);
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
    public int createSolution(Solution solution) {
        int result = 0;
        String insertSolutionSQL = "INSERT INTO solutions" + "(" + Solution.COLUMN_EXEC_DATE + ","
                + Solution.COLUMN_PROTOCOL_PATH + ")" + " VALUES " + "(?,?)";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(insertSolutionSQL);
            statement.setDate(1, solution.getExecDate());
            statement.setString(2, solution.getProtocolPath());
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
    public int deleteSolution(int id) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String delSolutionSQL = "DELETE FROM solutions WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(delSolutionSQL);
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
    public int updateSolution(Solution solution) {
        int result = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        String updateSolutionSQL = "UPDATE solutions SET " + Solution.COLUMN_EXEC_DATE + "=?, " + Solution.COLUMN_PROTOCOL_PATH + "=? WHERE id=?";
        try {
            connection = DBManager.getConnection();
            statement = connection.prepareStatement(updateSolutionSQL);
            statement.setDate(1, solution.getExecDate());
            statement.setString(2, solution.getProtocolPath());
            statement.setInt(3, solution.getId());
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
