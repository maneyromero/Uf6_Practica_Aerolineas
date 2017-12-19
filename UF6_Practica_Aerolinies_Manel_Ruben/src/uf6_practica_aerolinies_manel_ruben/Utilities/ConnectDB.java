/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf6_practica_aerolinies_manel_ruben;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;
import java.sql.DriverManager;
import javax.activation.CommandInfo;

/**
 *
 * @author Manel
 */
public class ConnectDB {
   private static Connection connection;
   
   private ConnectDB(){
       
   }
   
   public static Connection openConnection() {
       if(connection==null){
           connection=DriverManager.getConnection(MYSQLDBConnection.url, MYSQLDBConnection.username, MYSQLDBConnection.password);
           System.out.println("Open database");
       }
       return connection;
   }
   
   public static void closeConnection(){
       if(connection!=null){
           connection.close();
           connection=null;
           System.out.println("Database closed");
       }
   }
    
   
}
