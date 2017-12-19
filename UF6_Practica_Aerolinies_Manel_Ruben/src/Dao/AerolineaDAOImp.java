/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Aerolinea;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class AerolineaDAOImp implements AerolineaDAO{

    @Override
    public Aerolinea buscarAerolinea(String codigo, Connection con) {
        try(PreparedStatement stmt=con.prepareStatement("Select * ")){
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        Aerolinea Aerolinea = null;
      return Aerolinea;
    }

    @Override
    public ArrayList<Aerolinea> listarAerolinea(Connection con) {
        try(Statement statement= con.createStatement()){
            String query="Select * from Aerolinea";
            ResultSet rs=statement.executeQuery(query);
            ArrayList<Aerolinea> aerolinea=new ArrayList<>();
            while(rs.next()){
                aerolinea.add(new Aerolinea(rs.getString("codigo_aerolinea"),rs.getString("codigo_aeropuerto_fk"),rs.getString("nombre")));
            }
            return aerolinea;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    
   
}
