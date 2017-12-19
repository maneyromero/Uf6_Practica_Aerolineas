/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Aerolinea;
import Model.Aeropuerto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class AerolineaDAOImp implements AerolineaDAO {

    @Override
    public Aerolinea buscarAerolinea(String codigo, Connection con) {
        Aerolinea aerolinea = null;
        try (PreparedStatement stmt = con.prepareStatement("Select * FROM aerolinea Where codigo_aerolinea like ?")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return aerolinea;
            } else {
                aerolinea = new Aerolinea(rs.getString("codigo_aerolinea"), rs.getString("codigo_aeropuerto_fk"), rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Aerolinea Aerolinea = null;
        return aerolinea;
    }

    @Override
    public ArrayList<Aerolinea> listarAerolinea(Connection con) {
        try (Statement statement = con.createStatement()) {
            String query = "Select * from Aerolinea";
            ResultSet rs = statement.executeQuery(query);
            ArrayList<Aerolinea> aerolinea = new ArrayList<>();
            while (rs.next()) {
                aerolinea.add(new Aerolinea(rs.getString("codigo_aerolinea"), rs.getString("codigo_aeropuerto_fk"), rs.getString("nombre")));
            }
            return aerolinea;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
return null;
}}
