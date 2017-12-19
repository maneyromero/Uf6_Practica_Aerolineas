/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Aerolinea;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class AerolineaDAOImp implements AerolineaDAO{

    @Override
    public Aerolinea buscarAerolinea(String codigo, Connection con) {
        Aerolinea Aerolinea = null;
      return Aerolinea;
    }

    @Override
    public ArrayList<Aerolinea> listarAerolinea(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}
