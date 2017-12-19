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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Manel
 */
public class UF6_Practica_Aerolinies_Manel_Ruben {

    /**
     * @param args the command line arguments
     */
    private static String nombre,DNI,apellido1,apellido2,codigo_avion;
    private static int edad;

    public static void main(String[] args) {
        // TODO code application logic here
        DAOFactory factory = new DAOFactory();
        AeropuertoDAO aeropueto;
        AerolineaDAO aerolinea;
        AvionDAO avion;
        PassajeroDAO passajero = null;
        TicketDAO ticket;
        Scanner sc = new Scanner(System.in);
        int num = 0;
        
        try {
            Connection con=ConnectDB.openConnection();
            do {
                escribirMenu();
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        String query="SELECT v.codigo_avion FROM aviones as v WHERE codigo_aerolinea_fk in (SELECT l.codigo_aerolinea from aerolineas as l where l.codigo_aeropuerto_fk like (SELECT codigo_aeropuerto from aeropuertos WHERE nombre like '"+codigo_avion+"'))";
                        System.out.println("Introduce el destino");
                        codigo_avion=sc.next();
                        System.out.println("Introduce su DNI");
                        DNI=sc.next();
                        System.out.println("Introduce el nombre");
                        nombre=sc.next();
                        System.out.println("Introduce el primer apellido");
                        apellido1=sc.next();
                        System.out.println("Introduce el segundo apellido");
                        apellido2=sc.next();
                        System.out.println("Introduce la edad");
                        edad=sc.nextInt();
                        Passajero p=new Passajero(DNI, codigo_avion, nombre, apellido1, apellido2, edad);
                        passajero.addPasajero(p, con);
                        con.close();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Exit");
                        break;
                    default:
                        break;

                }
            } while (num != 5);
        } catch (SQLException ex) {

        }

    }

    private static void escribirMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1- Añadir Passajero\n"
                + "2- Buscar avion de un vuelo\n"
                + "3- Hacer billete de vuelo\n"
                + "4- Listar passajeros");
    }

}
