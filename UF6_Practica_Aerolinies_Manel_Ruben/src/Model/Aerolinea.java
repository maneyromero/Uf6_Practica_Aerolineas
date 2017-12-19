/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.activation.CommandInfo;

/**
 *
 * @author Manel
 */
public class Aerolinea {
   private String codigo_aerolinea;
   private String codigo_aeropuerto_fk;
   private String nombre;

    public Aerolinea(String codigo_aerolinea, String codigo_aeropuerto_fk, String nombre) {
        this.codigo_aerolinea = codigo_aerolinea;
        this.codigo_aeropuerto_fk = codigo_aeropuerto_fk;
        this.nombre = nombre;
    }

    public String getCodigo_aerolinea() {
        return codigo_aerolinea;
    }

    public String getCodigo_aeropuerto_fk() {
        return codigo_aeropuerto_fk;
    }

    public String getNombre() {
        return nombre;
    }
    
   
}
