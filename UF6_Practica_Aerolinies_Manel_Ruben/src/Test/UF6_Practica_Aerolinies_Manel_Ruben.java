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
import Model.Ticket;
import Utilities.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private static String nombre, DNI, apellido1, apellido2, codigo;
    private static int edad;

    public static void main(String[] args) {
        // TODO code application logic here
        DAOFactory factory = new DAOFactory();
        AeropuertoDAO aeropueto;
        AerolineaDAO aerolinea;
        AvionDAO avion=factory.crateAvionDAO();
        PassajeroDAO passajero=factory.cratePassajeroDAO();
        TicketDAO ticket=factory.crateTicketDAO();
        Scanner sc = new Scanner(System.in);
        int num = 0;

        try {
            Connection con = ConnectDB.openConnection();
            PreparedStatement preparedStatement;
            do {
                escribirMenu();
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Introduce el destino");
                        codigo = sc.next();
                        String query = "SELECT v.codigo_avion FROM aviones as v WHERE codigo_aerolinea_fk in (SELECT l.codigo_aerolinea from aerolineas as l where l.codigo_aeropuerto_fk like (SELECT codigo_aeropuerto from aeropuertos WHERE nombre like ?))";
                        preparedStatement=con.prepareStatement(query);
                        preparedStatement.setString(1, codigo);  
                        
                        ResultSet rs =preparedStatement.executeQuery();
                        rs.next();
                        codigo = rs.getString("codigo_avion");
                        if (!codigo.isEmpty()) {
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
                            Passajero p = new Passajero(DNI, codigo, nombre, apellido1, apellido2, edad);
                            passajero.addPasajero(p, con);
                        }
                        preparedStatement.close();
                        break;
                    case 2:
                        System.out.println("Vamos a a�adir un ticket.");
                        System.out.println("Introduce el codigo de ticket deseado:");
                        codigo=sc.next();
                        System.out.println("Introduce DNI cliente:");
                        DNI=sc.next();
                        query="INSERT INTO ticked(codigo_ticked, DNI_fk) VALUES (?,?)";
                        preparedStatement=con.prepareStatement(query);
                        preparedStatement.setString(1,codigo);
                        preparedStatement.setString(2, DNI);
                        Ticket t= new Ticket(codigo, DNI);
                        ticket.addTicket(t, con);
                        preparedStatement.close();
                        break;
                    case 3:
                        System.out.println("Para proceder a buscar un avion, inserte el codigo del avion");
                        codigo=sc.next();
                        avion.buscarAvion(codigo, con);
                        break;
                    case 4:
                        System.out.println("Esto es una lista de todos los passajeros actuales");
                      passajero.listarPassajero(con);
                        break;
                    case 5:
                        System.out.println("Para proceder a listar los tiquets de un avion, inserte el codigo dek avion");
                        codigo = sc.next();
                        ticket.listarTicketAvion(con, codigo);
                        break;
                    case 6:
                        System.out.println("Para proceder a listar avion de una aerolinea, inserte el codigo de una aerolinea");
                        codigo=sc.next();
                        avion.listarAvionAerolinea(con, codigo);  
                        break;
                    case 7:
                        System.out.println("Para proceder a listar avion de una aeropuerto, inserte el codigo de una aeropuerto");
                        codigo=sc.next();
                        avion.listarAvionAeropuerto(con, codigo);
                        break;
                    case 8:
                        System.out.println("Para proceder a eliminar un billete, introduce su codigo");
                        codigo=sc.next();
                        ticket.eliminarTicket(codigo, con);
                        break;
                    case 9:
                        System.out.println("Para proceder a elminar un avion, Introduce su codigo");
                        codigo=sc.next();
                       avion.elliminarAvion(con, codigo);
                        break;
                    case 10:
                        System.out.println("Exit");
                        ConnectDB.closeConnection();
                        break;
                    default:
                        break;

                }
                con.close();
                
            } while (num != 5);
        } catch (SQLException ex) {
            Logger.getLogger(UF6_Practica_Aerolinies_Manel_Ruben.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   private static void escribirMenu() {
        System.out.println("");
        System.out.println("-------  AeroPlane.SL Program   -------");
        System.out.println("1- Anadir Passajero\n" //ruben//done
                + "2- Anadir billete\n"//manel//Done
                + "3- Buscar avion\n"//ruben
                + "4- Listar passajeros\n"//manel//Done
                + "5- Listar Tickets vendidos de un Avion\n"//ruben//done
                + "6- Listar Aviones de una Aerolinea\n"//manel
                + "7- Listar Aviones actuales en un Aeropuerto\n"//ruben//done
                + "8- Cancelar/Elimnar Billete\n"//manel
                + "9- Elimniar Aviones de un aeropuerto\n"//ruben//done
                + "10- Salir\n"//manel//done
                + "Que quieres hacer?\n"
                + "----------------------------------------------------------");
    }

}
