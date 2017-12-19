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
public interface TicketDAO {

    public void addTicket(Ticket ticket, Connection con);

    public ArrayList<Ticket> listarTicket(Connection con);

    public Ticket buscarTicket(String codigo, Connection con);
}
