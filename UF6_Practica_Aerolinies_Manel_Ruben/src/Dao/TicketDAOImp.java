/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manel
 */
public class TicketDAOImp implements TicketDAO {

    @Override
    public boolean comprobarTickets(Connection con) {
        boolean vacio = false;
        try (PreparedStatement stmt1 = con.prepareStatement("select * FROM ticket")) {

            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                vacio = true;
            } else {
                vacio = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vacio;
    }

    @Override
    public void addTicket(Ticket ticket, Connection con) {
        try (PreparedStatement stmt = con.prepareStatement("INSERT INTO ticket VALUES (?,?)")) {
            stmt.setString(1, ticket.getCodigo_ticked());
            stmt.setString(2, ticket.getDni());
            if (stmt.executeUpdate() != 1) {
                System.out.println("Error Ticket NO echo");
            } else {
                System.out.println("Ticket echo!!");
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }

    }

    @Override
    public ArrayList<Ticket> listarTicketAvion(Connection con, String codigo) {
        ArrayList<Ticket> ticket = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM `ticket` WHERE `DNI_fk` IN (SELECT DNI from pasajeros WHERE codigo_vuelo_fk LIKE (SELECT codigo_vuelo from Vuelos where codigo_vuelo like ?))")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ticket.add(new Ticket(rs.getString("codigo_ticked"), rs.getString("DNI_fk")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ticket;
    }

    @Override
    public Ticket buscarTicket(String codigo, Connection con) {
        Ticket ticket = null;
        try (PreparedStatement stmt = con.prepareStatement("Select * FROM ticket Where codigo_ticked like ?")) {
            ResultSet rs = stmt.executeQuery();
            stmt.setString(1, codigo);
            if (!rs.next()) {
                return ticket;
            } else {
                ticket = new Ticket(rs.getString("codigo_ticked"), rs.getString("DNI_fk"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return ticket;
    }

    public void eliminarTicket(String codigo, Connection con) {
        try (PreparedStatement stmt = con.prepareStatement("delete FROM ticket Where codigo_ticked like ?")) {
            stmt.setString(1, codigo);
            int i = stmt.executeUpdate();
            if (i >= 1) {
                System.out.println("se ha eliminado");
            } else {
                System.out.println("no se ha eliminado");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
