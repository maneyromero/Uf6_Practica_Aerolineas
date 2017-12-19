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

/**
 *
 * @author Manel
 */
public class TicketDAOImp implements TicketDAO {

    @Override
    public void addTicket(Ticket ticket, Connection con) {

    }

    @Override
    public ArrayList<Ticket> listarTicket(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ticket buscarTicket(String codigo, Connection con) {
        Ticket ticket = null;
        try (PreparedStatement stmt = con.prepareStatement("Select * FROM ticked Where codigo_ticked like ?")) {
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

}
