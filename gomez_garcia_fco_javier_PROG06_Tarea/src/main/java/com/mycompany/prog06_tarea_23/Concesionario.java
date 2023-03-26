package com.mycompany.prog06_tarea_23;
/**
 * @author Fº  Javier 
 */
public class Concesionario { // Clase Concesionario desde donde  implementamos todos los métodos 
                                                    // y funciones que son llamadas desde la clase principal
    Vehiculos[] aVehiculo = new Vehiculos[50];  // Array para 50 vehículos
    Clientes[] aCliente = new Clientes[20];         // Array para los 20 Clientes

    int contVehiculos;  // Contadores para ambos arrays
    int contClientes;
    /*
     //Insertar Cliente con todos sus parámetros---------------------------------------------------------------------------------------
    */
    public int insertarCliente(String DNI, String nombre, String apellidos, String direccion, String poblacion, int cod_post) {

        boolean encontrado = false;  // booleana para devolver resultado

        if (contClientes >= 20) {
            return -1;   // Si es mayor de 20 Clientes  -1, no ingresaría el cliente
        } else {          // aunque daría error del array de Clientes
            Clientes c;  // Objeto c de la clase Cliente para pasarle los parámetros en caso de éxito
            for (int i = 0; i < contClientes; i++) { // bucle para recorrer el array de Cliente
                c = aCliente[i];
                if (c.getDNI().equals(DNI)) {  // Si los dni del array de Clientes coinciden con el que le paso
                    encontrado = true;           // por el parámetro no podemos insertarlo,  pues existe.
                }
            }
            if (encontrado == true) {
                return -2;  // encontrado 
            } else {  // Ahora le insertamos un nuevo Cliente en el array de Clientes, pues es falso , no existe
                c = new Clientes(DNI, nombre, apellidos, direccion, poblacion, cod_post); // pasmos los parámetros
                aCliente[contClientes] = c; // ingresamos el Cliente en el array
                contClientes++;  // contamos los Clientes ingresados
                return 0;
            }
        }
    }
/*
   Insertamos Vehiculos con todos sus parámetros-----------------------------------------------------------------------------------------------------------------
*/
    public int insertarVehiculo(String matricula, String marca, int kilometros, String descripcion, double precio, String dni_propietario) {

        boolean encontrado = false; //Igual que el método anterior , para devolver el resultado

        if (contVehiculos >= 50) {  // Ahora si son mas de 50 coches
            return -1;                           // no podemos insertar un nuevo vehículo
        } else {
            Vehiculos v;  // El Objeto de la clase Vehiculo
            for (int i = 0; i < contVehiculos; i++) {
                v = aVehiculo[i];  // Dentro de un ' for '  recorremos los Vehiculos
                if (v.getMatricula().equals(matricula)) { // Si las matriculas que hay en el array
                    encontrado = true;                            // coinciden con las del parámetro, existe y no ingresamos el vehiculo
                }
            }
            if (encontrado == true) {
                return -2;   // -2 no podemos ingresar el vehículo
            } else {  // Si no se encuentra lo insertamos
                v = new Vehiculos(matricula, marca, kilometros, descripcion, precio, dni_propietario);
                aVehiculo[contVehiculos] = v;  // Insertamos
                contVehiculos++;  // Sumamos 
                return 0;
            }
        }
    }
/*
 Método para buscar el vehiculo dentro del Concesionario y mostrar los datos de su Propietario
   es de tipo boolean, recibe la matricula y si lo encuentra devuelve los datos del vehículo y su Cliente..
    */
    public boolean buscaVehiculo(String matricula) { // Tenmos como parámetro la matricula

        Vehiculos v;
        Clientes c;
  // con el bucle anidado recorremos tanto los vehiculos como los clientes
        for (int i = 0; i < contVehiculos; i++) {
            for (int z = 0; z < contClientes; z++) {
                v = aVehiculo[i];  //Recorremos los vehículos y los Clientes
                c = aCliente[z];    // Si las matriculas son iguales y el dni_propietario coincide con el DNI del Cliente
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
    Método para buscar Clientes comprobando el DNI
    recibe como parámetro un String de tipo DNI y devuelve los datos 
    del Cliente a través del toString(). 
    Se utliza para insertar un Vehiculo en el Concesionario
    */
    public boolean  buscaCliente(String DNI) {

       // variable de tipo String para devolver los Clientes
        Clientes c;  // el objeto cliente
            // Recorremos en un for los Clientes
        for (int i = 0; i < contClientes; i++) {
            c = aCliente[i];
            if (c.getDNI().equals(DNI)) { // Si hay algún dni dentro del array de clientes igual al del parámetro
             
                System.out.println( c.toString());   // lo imprimimos a través del toString();
                   return true;
            }
        }
        System.out.println("-------- No existe un Cliente en el Concesionario registrado con este DNI.....");
        return false;
    }
/*
   Con este método listamos los Clientes que tenemos en el Concesionario
    recorriendo con el bucle ' for ' el array y mostrándolo por pantalla en el toString();
    */
    public void listaClientes() {

        Clientes c;  //Mi objeto Cliente para el bucle

        for (int i = 0; i < contClientes; i++) {
            c = aCliente[i];
            System.out.println(c.toString()); // Imprimimos con el toString
        }                                                         
    }
    /*
    Método para listar los vehículos. Pasamos como parámetro el DNI
    Si el dni_propietario en Vehiculo es igual al DNI introducido, muestra
    los vehículos de dicho DNI
    */
  
    public void listaVehiculos(String DNI) {

        Vehiculos v;  // Objeto Vehiculo 

        for (int i = 0; i < contVehiculos; i++) {  // Bucle for para recorrer los vehículos
            v = aVehiculo[i];
            if (v.getDni_propietario().equals(DNI)) { // Si los dni coinciden
                System.out.println(v.toString()); // Mostramos los vehículos
            }
        }
    }
    /*
    Método para validar las matriculas con expresiones regulares
    Se le pasa por parámetro la matricula 
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

                if (apellidos.charAt(i) == ' ')  // si en la posición de 'i'  es igual a un espacio , lo sumamos
                espacios++;
            }
            if (espacios <= 0) {  // Si los espacios son menores de 0 es que solo ha introducido un apellido
                System.out.println(" Debe de tener un mínimo de un nombre y dos apellidos...");
                return false;
            }
        }
        return true; // Si esta todo correcto devolvemos un true a la clase Principal..
    }
    
}