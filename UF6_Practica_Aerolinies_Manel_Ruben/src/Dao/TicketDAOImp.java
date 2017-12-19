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
import java.sql.Statement;

/**
 *
 * @author Manel
 */
public class TicketDAOImp implements TicketDAO {

    @Override
    public void addTicket(Ticket ticket, Connection con) {
        try(PreparedStatement stmt =con.prepareStatement("INSERT INTO ticked VALUES (?,?)")){
            stmt.setString(1, ticket.getCodigo_ticked());
            stmt.setString(2, ticket.getDni());
            if(stmt.executeUpdate()!=1){
                System.out.println("Error Ticket NO echo");
            }else{
                System.out.println("Ticked echo!!");
            }
        }catch(SQLException ex){
            System.out.println("Error "+ex);
        }

    }

    @Override
    public ArrayList<Ticket> listarTicket(Connection con) {
      ArrayList<Ticket> ticket=new ArrayList<>();
        try(Statement statement= con.createStatement()){
            String query="Select * from ticked";
            ResultSet rs=statement.executeQuery(query);
            
            while(rs.next()){
                ticket.add(new Ticket(rs.getString("codigo_ticked"),rs.getString("DNI_fk")));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return ticket;
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
