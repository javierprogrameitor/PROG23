package com.mycompany.prog06_tarea_23;
/**
 * @author javier
 *  * 
 * Clase Vehiculos en la que tengo los atributos, los getter y setters. el constructor y el toString
 * Son generados automáticamente por NetBeans y las he reutilizado del proyecto anterior
 */
public class Vehiculos {
    private String marca;
    private String matricula;
    private int kilometros;
    private String descripcion;
    private double precio;
    private String dni_propietario;

    public Vehiculos(String matricula, String marca, int kilometros, String descripcion, double precio, String dni_propietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.descripcion = descripcion;
        this.precio = precio;
        this.dni_propietario = dni_propietario;
    }



    public Vehiculos() {
    }



    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(String dni_propietario) {
        this.dni_propietario = dni_propietario;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "marca=" + marca + ", matricula=" + matricula + ", kilometros=" + kilometros + ", descripcion=" + descripcion + ", precio=" + precio + ", dni_propietario=" + dni_propietario + '}';
    }

 
    
    
}
