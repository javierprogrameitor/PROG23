package com.mycompany.prog06_tarea_23;
/**
 *
 * @author javier 
 * 
 * Clase Clientes en la que tengo los atributos, los getter y setters. el constructor y el toString
 * Son generados automáticamente por NetBeans y las he reutilizado del proyecto anterior
 */
public class Clientes{

    private String DNI;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;
    private int cod_post;
   

    public Clientes(String DNI, String nombre, String apellidos, String direccion, String poblacion, int cod_post) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.cod_post = cod_post;
       
    }

    public Clientes() {
    }
    

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getCod_post() {
        return cod_post;
    }

    public void setCod_post(int cod_post) {
        this.cod_post = cod_post;
    }

    @Override
    public String toString() {
        return "Cliente " + "DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", poblacion=" + poblacion + ", cod_post=" + cod_post + '}';
    }

}