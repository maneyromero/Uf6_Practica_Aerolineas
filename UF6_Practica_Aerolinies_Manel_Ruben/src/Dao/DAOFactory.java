/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Manel
 */
public class DAOFactory {

    public VueloDAO crateVueloDAO() {
        return new VueloDAOImp();
    }

    public AerolineaDAO crateAerolineaDAO() {
        return new AerolineaDAOImp();
    }

    public AeropuertoDAO crateAeropuertoDAO() {
        return new AeropuertoDAOImp();
    }

    public PassajeroDAO cratePassajeroDAO() {
        return new PassajeroDAOImp();
    }

    public TicketDAO crateTicketDAO() {
        return new TicketDAOImp();
    }
}
