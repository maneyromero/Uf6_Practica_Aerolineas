/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Aeropuerto;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public class AeropuertoDAOImp implements AeropuertoDAO{

    @Override
    public Aeropuerto buscarAeropuerto(String codigo, Connection con) {
        Aeropuerto Aeropuerto = null;
        return Aeropuerto;
    }

    @Override
    public ArrayList<Aeropuerto> listarAeropuerto(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}