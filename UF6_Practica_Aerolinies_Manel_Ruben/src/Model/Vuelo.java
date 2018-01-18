/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Manel
 */
public class Vuelo {

    private String codigo_vuelo;
    private String codigo_aerolinea_fk;
    private String destino;
    private String origen;

    public Vuelo(String codigo_vuelo, String codigo_aerolinea_fk, String destino, String origen) {
        this.codigo_vuelo = codigo_vuelo;
        this.codigo_aerolinea_fk = codigo_aerolinea_fk;
        this.destino = destino;
        this.origen = origen;
    }

    public String getCodigo_vuelo() {
        return codigo_vuelo;
    }

    public String getCodigo_aerolinea_fk() {
        return codigo_aerolinea_fk;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigen() {
        return origen;
    }

}
