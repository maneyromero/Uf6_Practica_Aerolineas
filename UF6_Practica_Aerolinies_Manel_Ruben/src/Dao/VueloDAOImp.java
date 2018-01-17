/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Vuelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class VueloDAOImp implements VueloDAO {

    @Override
    public Vuelo buscarVuelos(String codigo, Connection con) {
        Vuelo vuelo = null;
        try (PreparedStatement stmt = con.prepareStatement("Select * FROM vuelos Where codigo_avion like ?")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return vuelo;
            } else {
                vuelo = new Vuelo(rs.getString("codigo_vuelo"), rs.getString("codigo_aerolinea_fk"), rs.getString("destino"), rs.getString("origen"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return vuelo;
    }

    @Override
    public ArrayList<Vuelo> listarVueloAerolinea(Connection con,String codigo) {
        ArrayList<Vuelo> vuelo = new ArrayList<>();
        //hacer bien el select
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM `vuelo` WHERE `codigo_aerolinea_fk`like (SELECT codigo_aerolinea FROM aerolineas WHERE codigo_aerolinea like ?)")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                vuelo.add(new Vuelo(rs.getString("codigo_vuelo"), rs.getString("codigo_aerolinea_fk"), rs.getString("destino"), rs.getString("origen")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return vuelo;
    }
    @Override
    public ArrayList<Vuelo> listarVueloAeropuerto(Connection con,String codigo) {
        ArrayList<Vuelo> vuelo = new ArrayList<>();
        //hacer bien el select
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM `vuelos` WHERE `codigo_aerolinea_fk`in (SELECT codigo_aerolinea FROM aerolineas WHERE codigo_aeropuerto_fk LIKE(SELECT codigo_aeropuerto FROM aeropuertos WHERE codigo_aeropuerto LIKE ?))")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                vuelo.add(new Vuelo(rs.getString("codigo_vuelo"), rs.getString("codigo_aerolinea_fk"), rs.getString("destino"), rs.getString("origen")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return vuelo;
    }

    @Override
    public void elliminarVuelo(Connection con,String codigo) {
        try (PreparedStatement stmt = con.prepareStatement("delete FROM aviones Where codigo_avion like ?")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("no se ha eliminado");
            } else {
                System.out.println("avion eliminado");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
}
