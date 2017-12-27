/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Avion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class AvionDAOImp implements AvionDAO {

    @Override
    public Avion buscarAvion(String codigo, Connection con) {
        Avion avion = null;
        try (PreparedStatement stmt = con.prepareStatement("Select * FROM aviones Where codigo_avion like ?")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return avion;
            } else {
                avion = new Avion(rs.getString("codigo_avion"), rs.getString("codigo_aerolinea_fk"), rs.getString("modelo"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return avion;
    }

    @Override
    public ArrayList<Avion> listarAvionAerolinea(Connection con,String codigo) {
        ArrayList<Avion> avion = new ArrayList<>();
        //hacer bien el select
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM `aviones` WHERE `codigo_aerolinea_fk`like (SELECT codigo_aerolinea FROM aerolineas WHERE codigo_aerolinea like ?)")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                avion.add(new Avion(rs.getString("codigo_avion"), rs.getString("codigo_aerolinea_fk"), rs.getString("modelo")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return avion;
    }
    @Override
    public ArrayList<Avion> listarAvionAeropuerto(Connection con,String codigo) {
        ArrayList<Avion> avion = new ArrayList<>();
        //hacer bien el select
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM `aviones` WHERE `codigo_aerolinea_fk`in (SELECT codigo_aerolinea FROM aerolineas WHERE codigo_aeropuerto_fk LIKE(SELECT codigo_aeropuerto FROM aeropuertos WHERE codigo_aeropuerto LIKE ?))")) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                avion.add(new Avion(rs.getString("codigo_avion"), rs.getString("codigo_aerolinea_fk"), rs.getString("modelo")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return avion;
    }

    @Override
    public void elliminarAvion(Connection con,String codigo) {
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
