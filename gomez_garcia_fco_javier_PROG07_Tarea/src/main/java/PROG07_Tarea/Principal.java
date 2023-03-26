package PROG07_Tarea;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author fco javier gómez garcía
 */
public class Principal { // Clase principal contiene el main

    static Scanner entrada = new Scanner(System.in); // Scanneer para leer los datos

    public static void main(String[] args) {

        Banco banco = new Banco();  //Objeto banco 

        // Variables para crear los diferentes tipos de cuentas
        // y los clientes
        String nombre;
        String apellidos;
        String fecha_nacimiento;
        String iban;
        double saldo;
        float interes;
        float comision;
        int max_desc;
        float interes_desc;
        float comision_desc;
        double ingreso;
        double retirado;

        LocalDate fecha; // Pasar la fecha al formato 
        //Menu principal.
        String opciones; // Variable para el menu
        do {
            opciones = JOptionPane.showInputDialog("Menú\n1.Abrir una nueva cuenta \n2. "
                    + "Ver un listado de las cuentas disponibles\n3. "
                    + "Obtener los datos y realizar un ingreso en cuenta concreta\n4. "
                    + "Retirar efectivo de una cuenta\n5. "
                    + "Consultar el saldo actual de una cuenta\n6. "
                    + "Salir de la aplicación ");
            switch (opciones) {

                case "1":  // Creamos la cuenta
                    System.out.println("--------------------------------------Abrir Cuenta Nueva-------------------------------------");
                    System.out.println("------------------------------------------------------------------------------------------------------");
                    System.out.println(" Introduce su Nombre :");  // Pedimos los datos para crear la Persona
                    nombre = entrada.nextLine();
                    System.out.println(" Introduce sus Apellidos :");
                    apellidos = entrada.nextLine();
                    System.out.println(" Introduce tu fecha de nacimiento en formato(dd-mm-yyyy) : ");
                    fecha_nacimiento = entrada.nextLine();

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    fecha = LocalDate.parse(fecha_nacimiento, dtf);

                    Persona titular = new Persona(nombre, apellidos, fecha_nacimiento); // Creamos la persona

                    do {   // Pedimos el Iban y el Saldo para iniciar la cuenta
                        System.out.println("Introduce el Número de Cuenta Bancaria (20-dig): ");
                        iban = entrada.nextLine();
                    } while (banco.validarIBAN(iban) == false);

                    System.out.println(" ¿Cual es el Saldo para Iniciar la cuenta ?");
                    saldo = entrada.nextDouble();
                    entrada.nextLine();

                    String tipocuenta;  // Le pedimos el tipo de cuenta

                    tipocuenta = JOptionPane.showInputDialog("-----Tipo de cuenta que deseas abrir :-------"
                            + "\n1 .Cuenta de Ahorro "
                            + "\n2 .Cuenta Corriente Personal "
                            + "\n3 .Cuenta Corrienta Empresa  ");

                    switch (tipocuenta) {

                        case "1":
                            System.out.println("--------Cuenta de Ahorro :---------");

                            System.out.println(" Tipo de interes anual :");
                            interes = entrada.nextFloat();
                            entrada.nextLine();
                            // Cremos la cuenta y llamamos al metodo abrir cuenta de la clase banco
                            CuentaAhorro cuenta = new CuentaAhorro(saldo, iban, titular, interes);
                            banco.abrirCuenta(cuenta);

                            break;
                        case "2":
                            System.out.println("-------Cuenta Corriente Personal :------");

                            System.out.println(" Cantidad de Comision por mantenimiento :");
                            comision = entrada.nextFloat();
                            entrada.nextLine();
                            // si es una cuenta corriente personal pedimos el mantenimiento y creamos la cuenta llamando abrirCuenta
                            CuentaCorrientePersonal cuentapersonal = new CuentaCorrientePersonal(saldo, iban, titular, comision);
                            banco.abrirCuenta(cuentapersonal);

                            break;
                        case "3":
                            System.out.println("------Cuenta Corriente Empresa---------");

                            System.out.println(" Cantidad Máxima por descubierto permitido : ");
                            max_desc = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Interés por descubierto :");
                            interes_desc = entrada.nextFloat();
                            entrada.nextLine();
                            System.out.println(" Cantidad de comision fija por descubierto :");
                            comision_desc = entrada.nextFloat();
                            entrada.nextLine();
                            // Si es cuenta de empresa, con sus caracteristicas las pasamos igualmente abrircuenta
                            CuentaCorrienteEmpresa cuentaempresa = new CuentaCorrienteEmpresa(saldo, iban, titular, max_desc, interes_desc, comision_desc);
                            banco.abrirCuenta(cuentaempresa);

                            break;
                        default:
                            System.out.println(" Opcion Incorrecta..");
                    }
                    break;
                case "2":
                    System.out.println("---------------------------- Información de las cuentas creadas--------------------------");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    banco.listadoCuentas(); // Para listar las cuentas invocamos al metodo creado en la clase banco

                    break;
                case "3":
                    System.out.println("------------------------ Obtener datos y Realizar Ingreso----------------------------------");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    do { // Para la información e ingreso primero he comprobado que introduce bien el iban y después si existe en el banco
                        System.out.println("Introduce el Número de Cuenta Bancaria (20-dig) para realizar un Ingreso  en su cuenta");
                        iban = entrada.nextLine();
                    } while (banco.validarIBAN(iban) == false);

                    if (banco.informacionCuenta(iban) == null) {
                        System.out.println(" ¿Que cantidad vas a  Ingresar en la cuenta ?");
                        ingreso = entrada.nextDouble();
                        entrada.nextLine();

                        banco.ingresoCuenta(iban, ingreso);  // Finalmente ingresamos la cantidad

                    } else {
                        System.out.println(" No existe una cuenta con este IBAN ....");
                    }

                    break;
                case "4":
                    System.out.println("---------------------------Retirar efectivo de una Cuenta-----------------------------------");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
               do {// Para retirar la cantidad, primero compruebo la entrada del iban y después llamo a retirarCuenta
                        System.out.println("Introduce el Número de Cuenta Bancaria (20-dig) para Retirar una cantidad de su cuenta");
                        iban = entrada.nextLine();
                } while (banco.validarIBAN(iban) == false);

                    System.out.println(" ¿Que cantidad vas a  Retirar de  la cuenta ?");
                    retirado = entrada.nextDouble();
                    entrada.nextLine();

                    if (banco.retiradaCuenta(iban, retirado) == true){ // Si todo ha ido bien o no tiene saldo suficiente
                        System.out.println(" Retirada de efectivo con Exito..");
                    }else{
                        System.out.println(" No tienes Saldo suficiente");
                    }   
                    break;
                case "5":
                    System.out.println("----------------------Consultar el Saldo actual de una Cuenta--------------------------");
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                    do{ // Vuelvo a comprobar la entrada del iban
                    System.out.println("Introduce el Número de Cuenta Bancaria (20-dig) para consultar su Saldo");
                    iban = entrada.nextLine();
                    }while (banco.validarIBAN(iban) == false);
                    
                    if (banco.obtenerSaldo(iban) == -1) { // llamo a obtener y si es -1 no existe la cuenta en el banco
                        System.out.println(" No existe una cuenta con este IBAN ....");
                    }
                    break;
                case "6":
                    System.out.println("---------------------------------Salir de la Aplicacion------------------------------------------");
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                    
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (!opciones.equals("6"));

    }

}
