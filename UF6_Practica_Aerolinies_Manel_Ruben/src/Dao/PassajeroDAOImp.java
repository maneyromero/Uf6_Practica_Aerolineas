/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Passajero;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class PassajeroDAOImp implements PassajeroDAO{
    

    @Override
    public void addPasajero(Passajero p, Connection con) {
      
    }

    @Override
    public ArrayList<Passajero> listarPassajero(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Passajero buscarPassajero(String dni, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
