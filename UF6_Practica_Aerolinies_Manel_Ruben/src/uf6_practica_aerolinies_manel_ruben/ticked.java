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
public class ticked {
    private String codigo_ticked;
    private String dni;

    public ticked(String codigo_ticked, String dni) {
        this.codigo_ticked = codigo_ticked;
        this.dni = dni;
    }

    public String getCodigo_ticked() {
        return codigo_ticked;
    }

    public String getDni() {
        return dni;
    }
    
    
}
