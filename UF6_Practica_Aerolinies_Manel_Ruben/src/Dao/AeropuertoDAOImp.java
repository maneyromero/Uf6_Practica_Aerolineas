/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Aeropuerto;
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
public class AeropuertoDAOImp implements AeropuertoDAO {

    @Override
    public Aeropuerto buscarAeropuerto(String codigo, Connection con) {
        Aeropuerto aeropuerto = null;
        try (PreparedStatement stmt = con.prepareStatement("Select * FROM aeropuerto Where codigo_aeropuerto like '" + codigo + "'")) {

            ResultSet rs = stmt.executeQuery();
            stmt.setString(1, codigo);
            if (!rs.next()) {
                return aeropuerto;
            } else {
                aeropuerto = new Aeropuerto(rs.getString("codigo_aeropuerto"), rs.getString("nombre"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return aeropuerto;
    }

    @Override
    public ArrayList<Aeropuerto> listarAeropuerto(Connection con) {
        ArrayList<Aeropuerto> aeropuerto = new ArrayList<>();
        try (Statement statement = con.createStatement()) {
            String query = "Select * from Aeropuertos";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                aeropuerto.add(new Aeropuerto(rs.getString("codigo_aeropuerto_fk"), rs.getString("nombre")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return aeropuerto;
    }
}
