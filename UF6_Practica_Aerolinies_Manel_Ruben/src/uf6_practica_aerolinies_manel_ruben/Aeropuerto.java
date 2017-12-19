/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf6_practica_aerolinies_manel_ruben;

/**
 *
 * @author Manel
 */
public class Aeropuerto {
    private String codigo_aeropuerto;
    private String nombre;

    public Aeropuerto(String codigo_aeropuerto, String nombre) {
        this.codigo_aeropuerto = codigo_aeropuerto;
        this.nombre = nombre;
    }

    public String getCodigo_aeropuerto() {
        return codigo_aeropuerto;
    }

    public String getNombre() {
        return nombre;
    }
    
}
