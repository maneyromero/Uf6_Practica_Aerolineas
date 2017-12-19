/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Avion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class AvionDAOImp implements AvionDAO{

    @Override
    public Avion buscarAvion(String codigo, Connection con) {
        Avion Avion = null;
        return Avion;
    }

    @Override
    public ArrayList<Avion> listarAvion(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

  
    
}
