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
import java.sql.Statement;

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
    public ArrayList<Avion> listarAvion(Connection con) {
       ArrayList<Avion> avion=new ArrayList<>();
        try(Statement statement= con.createStatement()){
            String query="Select * from Aviones";
            ResultSet rs=statement.executeQuery(query);
            
            while(rs.next()){
                avion.add(new Avion(rs.getString("codigo_avion"),rs.getString("codigo_aerolinea_fk"),rs.getString("modelo")));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return avion;
    }

}
