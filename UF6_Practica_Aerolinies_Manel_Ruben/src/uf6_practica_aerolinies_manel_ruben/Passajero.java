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
public class Passajero {
    private String dni;
    private String codigo_avion_fk;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    public Passajero(String dni, String codigo_avion_fk, String nombre, String apellido1, String apellido2, int edad) {
        this.dni = dni;
        this.codigo_avion_fk = codigo_avion_fk;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCodigo_avion_fk(String codigo_avion_fk) {
        this.codigo_avion_fk = codigo_avion_fk;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
