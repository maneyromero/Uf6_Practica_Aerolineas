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
public interface AerolineaDAO {
    public Aerolinea buscarAerolinea(String codigo,Connection con);
    public ArrayList<Aerolinea> listarAerolinea(Connection con);
}