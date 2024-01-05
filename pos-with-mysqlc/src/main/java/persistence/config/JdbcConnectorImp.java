package persistence.config;

import java.sql.Connection;
import java.sql.SQLException;
import persistence.dao.exceptios.DaoExceptions;

public class JdbcConnectorImp implements DbConnector {

    private static Connection connection;
    private static final long serialVersionUID = 1L;

    @Override
    public Connection startConnection() throws DaoExceptions {

        try {

            connection = Config.getConnection();

            connection.setAutoCommit(false);

            return connection;

        } catch (SQLException ex) {

            throw new DaoExceptions("SQL Connection error", ex);
        }
    }

    @Override
    public void closeConnection() throws DaoExceptions {

        try {

            if (!connection.isClosed()) {

                connection.close();
            }

        } catch (SQLException e) {

            throw new DaoExceptions(e.getMessage());
        }
    }

    @Override
    public void rollbackTransaction() throws DaoExceptions {

        try {
            
            connection.rollback();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    @Override
    public void commit() throws Exception {
        
       connection.commit();
    }
    
   
}
