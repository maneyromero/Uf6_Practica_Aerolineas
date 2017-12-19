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
public interface PassajeroDAO {

    public void addPasajero(Passajero p, Connection con);

    public ArrayList<Passajero> listarPassajero(Connection con);

    public Passajero buscarPassajero(String dni, Connection con);
}
