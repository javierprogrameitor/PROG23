package com.mycompany.prog08_tarea;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author fº javier
 */
public class Principal {   // Clase Principal con su main

    public static void main(String[] args) {
// Objeto concesionario
        Concesionario conces = new Concesionario();
// Variables  para ingresar los clientes y los vehículos
        String DNI;
        String nombre;
        String apellidos;
        String direccion;
        String poblacion;
        Integer cod_post;
        //---------------------------------------------------------

        String matricula;
        String marca;
        Integer kilometros;
        String descripcion;
        Double precio;

        Scanner sn = new Scanner(System.in);  // El Scanner para leer los datos del usuario

        String opciones;   // Variable para la opciones del menú

        do {  // El menú dentro de un do_while, hasta que la opción sea salir
            opciones = JOptionPane.showInputDialog("Menu"
                    + "\n1 . Nuevo Cliente \n2. "
                    + " Listar Clientes\n3. "
                    + " Ventas Vehículo\n4. "
                    + " Listar Vehículos vendidos a un Cliente\n5. "
                    + " Buscar Vehículo\n6. "
                    + " Eliminar Vehículo\n7. "
                    + " Salir ");
            switch (opciones) {
                case "1": //-------------------------------------------------------Opción para crear el cliente con las llamadas a sus metodos--------
                    System.out.println("------------------------------------------Crear un Nuevo Cliente-----------------------------");
                    do {
                        System.out.println("¿Cual es el DNI del Cliente : ? ");
                        DNI = sn.nextLine();
                    } while (conces.validarDNI(DNI) == false && conces.buscaCliente(DNI) == false); // Comprobamos que el dni en su formato es correcto

                    do {
                        System.out.println("¿Cual es el nombre  del Cliente : ? ");
                        nombre = (sn.nextLine());
                        // Recojo el nombre
                        System.out.println("¿Cuales son los apellidos  del Cliente : ? ");
                        apellidos = (sn.nextLine());
                    } while (conces.validarNombre(nombre, apellidos) == false);

                    // Los apellidos
                    System.out.println("¿Cual es la direccion del Cliente : ? ");
                    direccion = (sn.nextLine());

                    // La dirección                 
                    System.out.println("¿Cual es la poblacion del Cliente : ? ");
                    poblacion = (sn.nextLine());

                    // La Pobación
                    System.out.println("¿Cual es el  Código Postal del Cliente 'Solo numeros...': ? ");
                    cod_post = (sn.nextInt());
                    // Y el código postal
                    sn.nextLine();
                    // si está todo correcto insertamos el Cliente
                    switch (conces.insertarCliente(DNI, nombre, apellidos, direccion, poblacion, cod_post)) {
                        case -1:
                            System.out.println("Usuario Registrado en el Concesionario......");
                            break;
                        case 0:
                            System.out.println("Exito:  'Usuario Ingresado ' ");
                            break;

                    }
                    break;
                case "2"://----------------------------------------------------------Opción para listar los Clientes-----------------------

                    System.out.println("------------------------------------Lista de todos los Clientes del Concesionario----- ");
                    conces.listaClientes();  // Su llamada al método listar Cliente

                    break;
                case "3"://----------------------------------------------------------Opción para insertar los vehículos a sus Clientes 

                    System.out.println("-------------------------------------- Insertar Ventas de Vehiculos a Clientes----------");

                    do {
                        System.out.println("¿Cual es el DNI del Cliente : ? ");
                        DNI = sn.nextLine();
                    } while (conces.buscaCliente(DNI) == false);

                    // Recojo la matricula
                    do {
                        System.out.println("¿Cual es la matricula del vehiculo : ? ");
                        matricula = sn.nextLine();
                    } while (conces.validarMatricula(matricula) == false);
                    // la marca
                    System.out.println("¿Cual es la marca del vehiculo : ? ");
                    marca = sn.nextLine();
                    // los Kilometros
                    System.out.println("¿Cuantos Kilometros tiene su vehiculo : ? ");
                    kilometros = sn.nextInt();
                    sn.nextLine();
                    // descripcion
                    System.out.println("¿Una breve descripcion del vehiculo : ? ");
                    descripcion = sn.nextLine();
                    //precio
                    System.out.println("¿Cual es el precio del vehiculo : ? ");
                    precio = sn.nextDouble();
                    sn.nextLine();
                    //Si está todo correcto insertamos el vehículo en el array vehículo a través de la llamada al método
                    switch (conces.insertarVehiculo(matricula, marca, kilometros, descripcion, precio, DNI)) {
                        case -1:
                            System.out.println("Esta matricula esta en el Concesionario......");
                            break;
                        case 0:
                            System.out.println("Exito:  'Vehiculo Ingresado ' ");
                            break;
                    }
                    break;
                case "4"://-------------------------Opción para listar los vehículos de un Cliente--------------------------------------
                    System.out.println("------------------------------ Listar los Vehiculos vendidos a un Cliente : ------------");
                    do {
                        System.out.println("¿Cual es el DNI del Cliente : ? ");
                        DNI = sn.nextLine();
                    } while (conces.buscaCliente(DNI) == false); // Buscamos el DNI

                    conces.listaVehiculos(DNI); // llamada al método correspondiente con DNI 

                    break;
                case "5"://--------------------------------------Opción para buscar los vehículos por su matricula----------------
                    System.out.println("---------------- Buscar un vehiculo por matricula----------------------------------------- ");
                    do {
                        System.out.println("¿Cual es la matricula del vehiculo : ? "); //Preguntamos su matricula
                        matricula = sn.nextLine();
                    } while (conces.buscaVehiculo(matricula) == false);  // llamada al método correspondiente con la matrícula

                    break;
                case "6"://--------------------------------------Opción para Eliminar los vehículos por su matricula----------------
                    System.out.println("---------------- Eliminar un vehiculo por matricula----------------------------------------- ");
                    do {
                        System.out.println("¿Que vehiculo deseas eliminar...... ?");
                        System.out.println("Introduce su matricula :  "); //Preguntamos su matricula
                        matricula = sn.nextLine();
                    } while (conces.eliminarVehiculo(matricula) == false);  // llamada al método correspondiente con la matrículaI 

                    break;
                case "7"://----------------------------------------------------------Salir--------------------------------------------------------------
                    System.out.println("Salir de la Aplicación..");

                    break;  // Opción de salir
                default:  //----------------------Si introducimos un número diferente---------------------------------------------------------
                    System.out.println("Opcion incorrecta");
            }

        } while (!opciones.equals("7"));
    }
}
