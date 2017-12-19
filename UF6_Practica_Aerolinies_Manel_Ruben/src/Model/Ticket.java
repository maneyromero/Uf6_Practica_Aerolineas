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
public class Ticket {

    private String codigo_ticked;
    private String dni;

    public Ticket(String codigo_ticked, String dni) {
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
