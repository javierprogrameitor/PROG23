package com.mycompany.prog08_tarea;

/**
 *
 * @author javier
 *
 * Clase Clientes en la que tengo los atributos, los getter y setters. el
 * constructor y el toString Son generados automáticamente por NetBeans y las he
 * reutilizado del proyecto anterior
 */
public class Clientes implements Comparable<Clientes> {  
// Atributos  de la clase Clientes
    private String DNI;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String poblacion;
    private Integer cod_post;    // Atributos con la clase envoltorio
// Constructor de la clse
    public Clientes(String DNI, String nombre, String apellidos, String direccion, String poblacion, Integer cod_post) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.cod_post = cod_post;

    }

    @Override// Método que implementa Comparable, para comparar y buscar por DNI
    public int compareTo(Clientes c) {
        return this.DNI.compareTo(c.getDNI());
    }

    public Clientes() {  // Constructor vacio
    }
// Todos sus Getter ySetter
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

    public void setCod_post(Integer cod_post) {
        this.cod_post = cod_post;
    }

    @Override  // Método toString para imprimir
    public String toString() {
        return "Cliente " + "DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", poblacion=" + poblacion + ", cod_post=" + cod_post + '}';
    }

}
