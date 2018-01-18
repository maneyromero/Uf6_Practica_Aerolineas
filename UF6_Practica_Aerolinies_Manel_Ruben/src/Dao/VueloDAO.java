/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Vuelo;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Manel
 */
public interface VueloDAO {

    public Vuelo buscarVuelos(String destino, String origen, Connection con);

    public Vuelo buscarVuelos(String destino, Connection con);

    public ArrayList<Vuelo> listarVueloAerolinea(Connection con, String codigo);

    public void elliminarVuelo(Connection con, String codigo);

    public ArrayList<Vuelo> listarVueloAeropuerto(Connection con, String codigo);

    public ArrayList<Vuelo> listarVuelos(Connection con);

    public ArrayList<Vuelo> listarVuelos(Connection con, String DNI);
}
