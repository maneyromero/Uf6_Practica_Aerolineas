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
public class Avion {

    private String codigo_avion;
    private String codigo_aerolinea_fk;
    private String modelo;

    public Avion(String codigo_avion, String codigo_aerolinea_fk, String modelo) {
        this.codigo_avion = codigo_avion;
        this.codigo_aerolinea_fk = codigo_aerolinea_fk;
        this.modelo = modelo;
    }

    public String getCodigo_avion() {
        return codigo_avion;
    }

    public String getCodigo_aerolinea_fk() {
        return codigo_aerolinea_fk;
    }

    public String getModelo() {
        return modelo;
    }

}
