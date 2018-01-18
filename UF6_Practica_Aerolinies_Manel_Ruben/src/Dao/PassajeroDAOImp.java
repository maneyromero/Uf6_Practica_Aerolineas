/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Passajero;
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
public class PassajeroDAOImp implements PassajeroDAO {

    @Override
    public void addPasajero(Passajero p, Connection con) {
        try (PreparedStatement stmt = con.prepareStatement("INSERT INTO  pasajeros VALUES (?,?,?,?,?,?)")) {
            stmt.setString(1, p.getDni());
            stmt.setString(2, p.getCodigo_avion_fk());
            stmt.setString(3, p.getNombre());
            stmt.setString(4, p.getApellido1());
            stmt.setString(5, p.getApellido2());
            stmt.setDate(6, p.getEdad());
            if (stmt.executeUpdate() != 1) {
                System.out.println("Error Passajero NO a�adido");
            } else {
                System.out.println("Passajero A�adido!!");
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }

    }

    @Override
    public ArrayList<Passajero> listarPassajero(Connection con, String codigo) {
        ArrayList<Passajero> passajero = new ArrayList<>();
        ArrayList<Ticket> ticket = new ArrayList<>();
        try (Statement statement = con.createStatement()) {
            String query = "SELECT p.*,t.* FROM pasajeros as p, ticket as t WHERE p.codigo_vuelo_fk LIKE (?) and p.DNI LIKE t.DNI_fk";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Ticket t = new Ticket(rs.getString("codigo_ticked"), rs.getString("DNI_fk"));
                passajero.add(new Passajero(rs.getString("DNI"), rs.getString("codigo_avion_fk"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getDate("fecha_nacimiento"), t));
                ticket.add(t);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return passajero;
    }

    @Override
    public Passajero buscarPassajero(String dni, Connection con) {
        Passajero pasajero = null;
        try (PreparedStatement stmt = con.prepareStatement("Select * FROM pasajeros Where dni like ?")) {
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return pasajero;
            } else {
                pasajero = new Passajero(rs.getString("DNI"), rs.getString("codigo_avion_fk"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getDate("fecha_nacimiento"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return pasajero;
    }

}
