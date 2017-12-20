/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Dao.AerolineaDAO;
import Dao.AeropuertoDAO;
import Dao.AvionDAO;
import Dao.DAOFactory;
import Dao.PassajeroDAO;
import Dao.TicketDAO;
import Model.Passajero;
import Utilities.ConnectDB;
import Utilities.MYSQLDBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manel
 */
public class UF6_Practica_Aerolinies_Manel_Ruben {

    /**
     * @param args the command line arguments
     */
    private static String nombre, DNI, apellido1, apellido2, codigo_avion;
    private static int edad;

    public static void main(String[] args) {
        // TODO code application logic here
        DAOFactory factory = new DAOFactory();
        AeropuertoDAO aeropueto;
        AerolineaDAO aerolinea;
        AvionDAO avion;
        PassajeroDAO passajero=factory.cratePassajeroDAO();
        TicketDAO ticket;
        Scanner sc = new Scanner(System.in);
        int num = 0;

        try {
            Connection con = ConnectDB.openConnection();
            do {
                escribirMenu();
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Introduce el destino");
                        codigo_avion = sc.next();
                        String query = "SELECT v.codigo_avion FROM aviones as v WHERE codigo_aerolinea_fk in (SELECT l.codigo_aerolinea from aerolineas as l where l.codigo_aeropuerto_fk like (SELECT codigo_aeropuerto from aeropuertos WHERE nombre like ?))";
                        PreparedStatement preparedStatement=con.prepareStatement(query);
                        preparedStatement.setString(1, codigo_avion);  
                        ResultSet rs =preparedStatement.executeQuery();
                        rs.next();
                        codigo_avion = rs.getString("codigo_avion");
                        if (!codigo_avion.isEmpty()) {
                            System.out.println("Introduce su DNI");
                            DNI = sc.next();
                            System.out.println("Introduce el nombre");
                            nombre = sc.next();
                            System.out.println("Introduce el primer apellido");
                            apellido1 = sc.next();
                            System.out.println("Introduce el segundo apellido");
                            apellido2 = sc.next();
                            System.out.println("Introduce la edad");
                            edad = sc.nextInt();
                            Passajero p = new Passajero(DNI, codigo_avion, nombre, apellido1, apellido2, edad);
                            passajero.addPasajero(p, con);
                        }
                        con.close();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        
                        break;
                    case 6:
                        break;
                    case 8:
                        break;
                    case 9:
                        System.out.println("Para proceder a elminar un billete, Introduce su codigo");
                        num=sc.nextInt();
                        String query1 = "DELETE FROM empleados WHERE ID like '" + num + "'";
                        Connection con1 = DriverManager.getConnection(MYSQLDBConnection.url, MYSQLDBConnection.username, MYSQLDBConnection.password);
                        Statement stmt1 = con1.createStatement();
                        stmt1.executeUpdate(query1);
                        break;
                    case 10:
                        System.out.println("Exit");
                        break;
                    default:
                        break;

                }
            } while (num != 5);
        } catch (SQLException ex) {
            Logger.getLogger(UF6_Practica_Aerolinies_Manel_Ruben.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void escribirMenu() {
        System.out.println("");
        System.out.println("-------  AeroPlane.SL Program   -------");
        System.out.println("1- Añadir Passajero\n"
                + "2- Añadir billete de vuelo\n"
                + "3- Buscar avion de un vuelo\n"
                + "4- Listar passajeros\n"
                + "5- Listar Tickets vendidos de un Avion\n"
                + "6- Listar Aviones de una Aerolinea\n"
                + "7- Listar Aviones actuales en un Aeropuerto\n"
                + "8- Cancelar/Elimnar Billete\n"
                + "9- Elimniar Aviones de un destino\n"
                + "10- Salir\n"
                + "Que quieres hacer?\n"
                + "----------------------------------------------------------");
    }

}
