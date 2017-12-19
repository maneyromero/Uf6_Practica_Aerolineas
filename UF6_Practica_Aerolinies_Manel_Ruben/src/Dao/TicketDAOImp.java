/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Model.Ticket;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class TicketDAOImp implements TicketDAO{

    @Override
    public void addTicket(Ticket ticket, Connection con) {
    
    }

    @Override
    public ArrayList<Ticket> listarTicket(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ticket buscarTicket(String codigo, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
