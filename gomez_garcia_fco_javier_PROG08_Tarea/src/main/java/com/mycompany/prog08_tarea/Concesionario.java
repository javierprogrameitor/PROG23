package com.mycompany.prog08_tarea;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Fº Javier Gómez García
 */
public class Concesionario { // Clase Concesionario desde donde  implementamos todos los métodos 

    ArrayList<Vehiculos> aVehiculo = new ArrayList<>();      // ArrayList de Vehiculos y Clientes.....
    ArrayList<Clientes> aCliente = new ArrayList<>();
    /*
     //Insertar Cliente con todos sus parámetros---------------------------------------------------------------------------------------
     */
    public int insertarCliente(String DNI, String nombre, String apellidos, String direccion, String poblacion, Integer cod_post) {

        boolean encontrado = false;  // booleana para devolver resultado

        for (Clientes i : aCliente) {  // Bucle 'for' mejorado indicado para recorrer las listas y conjuntos
            if (i.getDNI().equals(DNI)) {
                encontrado = true;   // Si los dni del array de Clientes coinciden con el que le paso                
            }
        }
        if (encontrado == true) {
            return -1;  // encontrado 
        } else {
            Clientes c;// Ahora le insertamos un nuevo Cliente en el ArrayList  de Clientes, pues es falso , no existe
            aCliente.add(c = new Clientes(DNI, nombre, apellidos, direccion, poblacion, cod_post)); // pasamos los parámetros
            Collections.sort(aCliente); // Ordenamos el arraylist
            return 0;
        }
    }
    /*
   Insertamos Vehiculos con todos sus parámetros-----------------------------------------------------------------------------------------------------------------
     */
    public int insertarVehiculo(String matricula, String marca, Integer kilometros, String descripcion, Double precio, String dni_propietario) {

        boolean encontrado = false; //Igual que el método anterior , para devolver el resultado

        for (Vehiculos i : aVehiculo) {
            if (i.getMatricula().equals(matricula)) { // Si las matriculas que hay en el array
                encontrado = true;                            // coinciden con las del parámetro, existe y no ingresamos el vehiculo
            }
        }
        if (encontrado == true) {
            return -1;   //  no podemos ingresar el vehículo
        } else {  // Si no se encuentra lo insertamos
            Vehiculos v;
            aVehiculo.add(v = new Vehiculos(matricula, marca, kilometros, descripcion, precio, dni_propietario)); // Añadimos el ArrayList
            Collections.sort(aVehiculo);   // Ordenamos
            return 0;
        }
    }
    /*
 Método para buscar el vehiculo dentro del Concesionario y mostrar los datos de su Propietario
     */
    public boolean buscaVehiculo(String matricula) { // Tenemos como parámetro la matricula

        for (Vehiculos v : aVehiculo) {
            for (Clientes c : aCliente) {  // Bucle for mejorado para Vehículos y Clientes
                if (v.getMatricula().equals(matricula) && v.getDni_propietario().equals(c.getDNI())) {
                    System.out.println(v.toString());  // Mostramos los datos, del vehiculo con su Cliente...
                    System.out.println(c.toString());
                    return true;
                }
            }
        }
        System.out.println(" Esta matricula no está registrada en el Concesionario.......");
        return false;
    }
    /*
    Método para buscar Clientes, comprobando el DNI ,recibe como parámetro un String de tipo DNI y devuelve los datos 
    del Cliente a través del toString(). Se utliza para insertar un Vehiculo en el Concesionario
     */
    public boolean buscaCliente(String DNI) {

        for (Clientes i : aCliente) {  // Bucle for mejorado para
            if (i.getDNI().equals(DNI)) { // Si hay algún dni dentro del ArrayList de clientes igual al del parámetro
               // System.out.println(i.toString());   // lo imprimimos a través del toString();
                return true;
            }
        }
        System.out.println("-------- No existe un Cliente en el Concesionario registrado con este DNI.....");
        return false;
    }
    /*
   Con este método listamos los Clientes que tenemos en el Concesionario
    recorriendo con el bucle ' for mejorado ' y mostrándolo por pantalla en el toString();
     */
    public void listaClientes() {

        for (Clientes i : aCliente) {  // Bucle 'for' mejorado para
            System.out.println(i.toString()); // listar con el toString
        }
    }
    /*
    Método para listar los vehículos. Pasamos como parámetro el DNI
    Si el dni_propietario en Vehiculo es igual al DNI introducido, muestra  los vehículos de dicho DNI
     */
    public void listaVehiculos(String DNI) {

        for (Vehiculos v : aVehiculo) {  // Bucle for para recorrer los vehículos 
            if (v.getDni_propietario().equals(DNI)) { // Si los dni coinciden
                System.out.println(v.toString()); // Mostramos los vehículos
            }
        }
    }
    public boolean eliminarVehiculo(String matricula){  // Método para eliminar vehiculos
        
       for (Vehiculos v : aVehiculo) { // 'for' para recorrer los vehiculos
            if (v.getMatricula().equals(matricula)) {  // Si coinciden las matriculas
                aVehiculo.remove(v);                            // eliminamos
                System.out.println(" Vehículo eliminado del Concesionario..");
                return true;
            }
       }
        return false;
    }
    /*
    Método para validar las matriculas con expresiones regulares. Se le pasa por parámetro la matricula 
    Es un boolean y devuelve true o le indica al usuario que ha ingresado mal la matricula
     */
    public boolean validarMatricula(String matricula) {

        if (matricula.matches("^[0-9]{4}[A-Z]{3}$")) { // Cadena regular
            return true;  // Devuelve true en caso de ingresar correcto
        } else {
            System.out.println("El formato correcto para matricula es NNNNLLL");
        }
        return false; // Indicamos que el formato de matricula no es correcto
    }
    /*
    Método que pasa por parámetro el DNI y devuelve la cadena o false en caso contrario
     */
    public boolean validarDNI(String DNI) {
// Expresion regular que indica las letras del DNI y si contiene 8 numeros del 0 al 9.
        return DNI.matches("^[0-9]{7,8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$");
    }

    public boolean validarNombre(String nombre, String apellidos) {
// Método para validar el nombre y apellidos
        int espacios = 0;
        String cadena = nombre + apellidos;

        if (cadena.length() >= 40) {  // los parametros los añado en cadena para contarlos
            System.out.println(" Este nombre y apellidos son demasiado largo..."); // Más de 40
            return false;
        } else { // si es menos de 40entramos en el else y recorremos con un bucle los apellidos
            for (int i = 0; i < apellidos.length(); i++) {

                if (apellidos.charAt(i) == ' ') // si en la posición de 'i'  es igual a un espacio , lo sumamos
                {
                    espacios++;
                }
            }
            if (espacios <= 0) {  // Si los espacios son menores de 0 es que solo ha introducido un apellido
                System.out.println(" Debe de tener un mínimo de un nombre y dos apellidos...");
                return false;
            }
        }
        return true; // Si esta todo correcto devolvemos un true a la clase Principal..
    }
}