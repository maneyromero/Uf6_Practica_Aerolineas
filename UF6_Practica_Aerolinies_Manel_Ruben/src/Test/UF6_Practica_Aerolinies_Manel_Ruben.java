/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Dao.AerolineaDAO;
import Dao.AeropuertoDAO;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Dao.VueloDAO;
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
    private static String nombre, DNI, apellido1, apellido2, codigo, destino;

    public static void main(String[] args) {
        // TODO code application logic here
        DAOFactory factory = new DAOFactory();
        AeropuertoDAO aeropueto;
        AerolineaDAO aerolinea;
        VueloDAO vuelo = factory.crateVueloDAO();
        PassajeroDAO passajero = factory.cratePassajeroDAO();
        TicketDAO ticket = factory.crateTicketDAO();
        Scanner sc = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        int num = 0;
        Connection con = ConnectDB.openConnection();
        try {

            PreparedStatement preparedStatement;
            do {
                escribirMenu();
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Introduce el destino");
                        destino = sc.next();
                        String query = "SELECT codigo_vuelo FROM vuelos WHERE destino like ?";
                        preparedStatement = con.prepareStatement(query);
                        preparedStatement.setString(1, destino);

                        ResultSet rs = preparedStatement.executeQuery();
                        rs.next();

                        codigo = rs.getString("codigo_vuelo");
                        if (!codigo.isEmpty()) {
                            System.out.println("Introduce su DNI");
                            DNI = sc.next();
                            System.out.println("Introduce el nombre");
                            nombre = sc.next();
                            System.out.println("Introduce el primer apellido");
                            apellido1 = sc.next();
                            System.out.println("Introduce el segundo apellido");
                            apellido2 = sc.next();
                            System.out.println("Introduce la fecha de nacimiento");
                            destino = sc.next();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            java.sql.Date sqlDate = new java.sql.Date(sdf.parse(destino).getTime());
                            Passajero p = new Passajero(DNI, codigo, nombre, apellido1, apellido2, sqlDate);
                            passajero.addPasajero(p, con);

                            System.out.println("Vamos a a?adir un billete.");
                            String CodTicket = DNI.substring(5, 9) + codigo;
                            Ticket t = new Ticket(CodTicket, DNI);
                            ticket.addTicket(t, con);
                        }
                        con.close();
                        preparedStatement.close();
                        break;
                    case 2:
                        System.out.println("Para proceder a buscar un vuelo, inserte el codigo del avion");
                        codigo = sc.next();
                        vuelo.buscarVuelos(codigo, con);
                        break;
                    case 3:
                        System.out.println("Esto es una lista de todos los passajeros actuales");
                        passajero.listarPassajero(con);
                        break;
                    case 4:
                        System.out.println("Para proceder a listar vuelo de una aerolinea, inserte el codigo de una aerolinea");
                        codigo = sc.next();
                        vuelo.listarVueloAerolinea(con, codigo);
                        break;
                    case 5:
                        System.out.println("Para proceder a eliminar un billete, introduce su codigo");
                        codigo = sc.next();
                        ticket.eliminarTicket(codigo, con);
                        break;
                    case 6:
                        System.out.println("Para proceder a elminar un vuelo, Introduce su codigo");
                        codigo = sc.next();
                        vuelo.elliminarVuelo(con, codigo);
                        break;
                    case 7:
                        System.out.println("Exit");
                        ConnectDB.closeConnection();
                        con.close();
                        break;
                    default:
                        break;

                }

            } while (num != 5);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException pex) {
            System.out.println(pex.getMessage());
        } finally {
            ConnectDB.closeConnection();
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UF6_Practica_Aerolinies_Manel_Ruben.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static void escribirMenu() {
        System.out.println("");
        System.out.println("-------  AeroPlane.SL Program   -------");
        System.out.println("1- Anadir Passajero\n" //ruben//done================================> ok y echo
                + "2- Buscar vuelo\n"//ruben ===================================================> ok y echo
                + "3- Listar passajeros y tickets de un vuelo\n"//manel//Done===================> ok y no echo
                + "4- Listar vuelos de una Aerolinea\n"//manel==================================> ok y echo
                + "5- Cancelar/Elimnar Billete\n"//manel =======================================> ok y echo
                + "6- Elimniar vuelo\n"//ruben//done ===========================================> ok y echo
                + "7- Salir\n"//manel//done ====================================================> ok y echo
                + "Que quieres hacer?\n"
                + "----------------------------------------------------------");
    }

}
