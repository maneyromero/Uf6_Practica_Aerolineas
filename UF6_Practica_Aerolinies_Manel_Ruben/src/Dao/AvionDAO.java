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
public interface AvionDAO {

    public Avion buscarAvion(String codigo, Connection con);

    public ArrayList<Avion> listarAvionAerolinea(Connection con,String codigo);

    public void elliminarAvion(Connection con,String codigo);
}
