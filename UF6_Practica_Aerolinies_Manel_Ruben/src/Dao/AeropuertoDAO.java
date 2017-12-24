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
public interface AeropuertoDAO {

    public Aeropuerto buscarAeropuerto(String codigo, Connection con);

    public ArrayList<Aeropuerto> listarAeropuerto(Connection con);
    
}
