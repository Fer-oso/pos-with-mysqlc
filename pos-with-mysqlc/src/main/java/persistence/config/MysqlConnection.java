package persistence.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistence.dao.exceptios.DaoExceptions;

public class MysqlConnection {

    static protected Connection connection;

    static protected PreparedStatement preparedStatement;

    static protected ResultSet resultSet;

    protected static Connection startConnection() throws DaoExceptions {

        try {
            connection = Config.getConnection();

            connection.setAutoCommit(false);

            return connection;

        } catch (SQLException ex) {

            throw new DaoExceptions("SQL Connection error", ex);
        }
    }

    protected void closeConnection() throws DaoExceptions {

        try {
            if (!connection.isClosed()) {

                connection.close();
            }

        } catch (SQLException e) {

            throw new DaoExceptions(e.getMessage());
        }
    }

    protected void rollbackTransaction() throws DaoExceptions {

        try {
            connection.rollback();

        } catch (SQLException e) {

            throw new DaoExceptions("Rollback error" + e);
        }
    }
}
