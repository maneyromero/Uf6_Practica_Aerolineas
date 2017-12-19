/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Manel
 */
public class ConnectDB {

    private static Connection connection;

    private ConnectDB() {

    }

    public static Connection openConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(MYSQLDBConnection.url, MYSQLDBConnection.username, MYSQLDBConnection.password);
                System.out.println("Open database");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database closed");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

}
