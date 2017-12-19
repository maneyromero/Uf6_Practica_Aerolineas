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

    public String getDni() {
        return dni;
    }

    public String getCodigo_avion_fk() {
        return codigo_avion_fk;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getEdad() {
        return edad;
    }

}
