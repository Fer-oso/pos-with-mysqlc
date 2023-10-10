package persistence.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String USER = "root";
    private final static String PASSWORD = "";
    private final static String DATABASE = "pos";
    private final static String URL = "jdbc:mysql://localhost:3306/" + DATABASE;

    private Config() {
    }

    public static Connection getConnection() {

        try {

            Class.forName(DRIVER);

            System.out.println("conectado");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {

            System.out.println(e);
        }

        return null;
    }

}
