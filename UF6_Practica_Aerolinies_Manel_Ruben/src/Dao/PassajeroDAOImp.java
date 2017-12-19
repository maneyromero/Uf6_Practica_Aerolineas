/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Aerolinea;
import Model.Passajero;
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

    }

    @Override
    public ArrayList<Passajero> listarPassajero(Connection con) {
        ArrayList<Passajero> passajero=new ArrayList<>();
        try(Statement statement= con.createStatement()){
            String query="Select * from pasajeros";
            ResultSet rs=statement.executeQuery(query);
            
            while(rs.next()){
                passajero.add(new Passajero(rs.getString("DNI"),rs.getString("codigo_avion_fk"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getInt("edad")));
            }
            
        }catch(SQLException ex){
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
                pasajero = new Passajero(rs.getString("DNI"), rs.getString("codigo_avion_fk"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getInt("edad"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return pasajero;
    }
}
