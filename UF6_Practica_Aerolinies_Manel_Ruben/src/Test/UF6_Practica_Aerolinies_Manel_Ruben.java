/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manel
 */
public class UF6_Practica_Aerolinies_Manel_Ruben {

    /**
     * @param args the command line arguments
     */
    private static String nombre;

    public static void main(String[] args) {
        // TODO code application logic here
        MYSQLDBConnection.url = "jdbc:mysql://localhost:3306/uf6_practica_aerolineas";
        MYSQLDBConnection.username = "root";
        MYSQLDBConnection.password = "";
        String query = "select * from aerolineas;";
        try (Connection con = DriverManager.getConnection(url, username, password);
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(query);) {
            while (rs.next()) {
                nombre = rs.getString("nombre");
                System.out.println("Nombre aerolinea: " + nombre);
            }
            con.close();
        } catch (SQLException ex) {

        }

    }

}
