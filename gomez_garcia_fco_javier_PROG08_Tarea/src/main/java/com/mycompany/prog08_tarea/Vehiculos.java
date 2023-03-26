package com.mycompany.prog08_tarea;
/**
 * @author javier
 *  * 
 * Clase Vehiculos en la que tengo los atributos, los getter y setters. el constructor y el toString
 * Son generados automáticamente por NetBeans y las he reutilizado del proyecto anterior
 */
public class Vehiculos implements Comparable <Vehiculos>{  
    private String marca;  // Atributos privados de la clase
    private String matricula;
    private Integer kilometros;
    private String descripcion;
    private Double precio;              // Atributos con la clase envoltorios
    private String dni_propietario;
// Constructor
    public Vehiculos(String matricula, String marca, int kilometros, String descripcion, double precio, String dni_propietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.descripcion = descripcion;
        this.precio = precio;
        this.dni_propietario = dni_propietario;
    }
    
    @Override   // Método que implementa Comparable, para comparar y buscar por matricula
    public int compareTo(Vehiculos v) {
           return this.marca.compareTo(v.getMatricula());
    }

    public Vehiculos() {   // Constructor vacio
    }
// Todos los setter y getters
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

    public void setKilometros(Integer kilometros) {
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

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(String dni_propietario) {
        this.dni_propietario = dni_propietario;
    }

    @Override // Método toString para imprimir por pantalla los resultados
    public String toString() {
        return "Vehiculos{" + "marca=" + marca + ", matricula=" + matricula + ", kilometros=" + kilometros + ", descripcion=" + descripcion + ", precio=" + precio + ", dni_propietario=" + dni_propietario + '}';
    }

}