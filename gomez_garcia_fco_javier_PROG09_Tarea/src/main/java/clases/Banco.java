package clases;

import cuentas.CuentaAhorro;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorrienteEmpresa;
import cuentas.CuentaCorrientePersonal;
import ficheros.RegistroClientes;
import ficheros.RegistroCuentas;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * @author fco javier gomez garcia
 */
public class Banco {

    RegistroCuentas registro = new RegistroCuentas(); // Objeto de RegistroCuentas
     RegistroClientes registroCliente = new RegistroClientes(); // Objeto de RegistroCuentas
    Double total;

    /*Creamos las cuentas llamando a los métodos de crearFichero,
*    escribir e insertar de los tres tipos de cuentas
-------------------------------Crear Cuenta de Ahorro--------------------------------------------------------------*/
    public boolean abrirAhorro(CuentaAhorro ahorro) {

        if (ahorro != null) {
            boolean crear;
            crear = registro.crearFichero();
            if (crear == false) {
                registro.escribirAhorro(ahorro);
            } else {
                registro.insertarAhorro(ahorro);
            }
            System.out.println(" Cuenta Creada....");
            return true;
        } else {
            System.out.println(" No se ha podido abrir la cuenta.....");
        }
        return false;
    }
//---------------------Crear Cuenta Corriente Personal----------------------------------------------------------------

    public boolean abrirPersonal(CuentaCorrientePersonal personal) {

        if (personal != null) {
            boolean crear;
            crear = registro.crearFichero();
            if (crear == false) {
                registro.escribirPersonal(personal);
            } else {
                registro.insertarPersonal(personal);
            }
            System.out.println(" Cuenta Creada....");
            return true;
        } else {
            System.out.println(" No se ha podido abrir la cuenta.....");
        }
        return false;
    }
//---------------------------------Crear Cuenta Corriente Empresa----------------------------------------------------

    public boolean abrirEmpresa(CuentaCorrienteEmpresa empresa) {

        if (empresa != null) {
            boolean crear;
            crear = registro.crearFichero();
            if (crear == false) {
                registro.escribirEmpresa(empresa);
            } else {
                registro.insertarEmpresa(empresa);
            }
            System.out.println(" Cuenta Creada....");
            return true;
        } else {
            System.out.println(" No se ha podido abrir la cuenta.....");
        }
        return false;
    }
//--------------------------------------------------Listar Cuentas----------------------------------------------------------------
// Através del arraylist de CuentaBancaria con su objeto,bucle y método imprimible--------------------    

    public void listadoCuentas() {

        System.out.println("----Listado de Cuentas--------------------");
        ArrayList<CuentaBancaria> cuentaB = new ArrayList<>();

        if (registro.crearFichero()) {

            cuentaB = registro.leerCuentas();
            for (int i = 0; i < cuentaB.size(); i++) {
                System.out.println(cuentaB.get(i).devolverInfoString());
            }
        }
    }
//-------------------------------------------------Leer la Cuenta por el CCC--------------------------------------------------

    public String informacionCuenta(String iban) {

        System.out.println("----Información de la cuenta por IBAN--------------------");

        ArrayList<CuentaBancaria> cuentaB = new ArrayList<>();

        if (registro.crearFichero()) {

            cuentaB = registro.leerCuentas();
            for (int i = 0; i < cuentaB.size(); i++) {
                if (cuentaB.get(i).getIBAN().equals(iban)) {
                    System.out.println(cuentaB.get(i).devolverInfoString());
                }
            }
        }
        return null;
    }
//-------------------------------------------------Ingresar por el CCC----------------------------------------------------------

    public boolean ingresoCuenta(String iban, Double ingreso) {

        ArrayList<CuentaBancaria> cuentaB = new ArrayList<>();

        if (registro.crearFichero()) {

            cuentaB = registro.leerCuentas();
            for (int i = 0; i < cuentaB.size(); i++) {
                if (cuentaB.get(i).getIBAN().equals(iban)) {
                    total = cuentaB.get(i).getSaldo() + ingreso;
                    cuentaB.get(i).setSaldo(total); // Envío al set , pero no cambia en el archivo             
                    System.out.println(" Su nuevo saldo es : " + total);
                }
            }
        }
        return false;
    }
//------------------------------------------Retirar por el CCC----------------------------------------------------------------

    public boolean retiradaCuenta(String iban, Double retirado) {

        ArrayList<CuentaBancaria> cuentaB = new ArrayList<>();

        if (registro.crearFichero()) {

            cuentaB = registro.leerCuentas();
            for (int i = 0; i < cuentaB.size(); i++) {
                if (cuentaB.get(i).getIBAN().equals(iban) && cuentaB.get(i).getSaldo() > retirado) {

                    total = cuentaB.get(i).getSaldo() - retirado;
                    cuentaB.get(i).setSaldo(total); // Envío al set , pero no cambia en el archivo             
                    System.out.println(" Su nuevo saldo es : " + total);
                    return true;
                }
            }
        }
        return false;
    }
//----------------------------------------------Obtener el saldo por una cuenta concreta-----------------------------

    public int obtenerSaldo(String iban) {

        ArrayList<CuentaBancaria> cuentaB = new ArrayList<>();

        if (registro.crearFichero()) {

            cuentaB = registro.leerCuentas();
            for (int i = 0; i < cuentaB.size(); i++) {
                if (cuentaB.get(i).getIBAN().equals(iban)) {
                    System.out.println(" Saldo : " + cuentaB.get(i).getSaldo());
                    return 0;
                }
            }
        }
        return -1;
    }
//---------------------------------------------------Crear el fichero de Clientes e Insertar los datos--------------------

    public boolean comprobarClientes(String iban) {

        ArrayList<CuentaBancaria> cuentaB = new ArrayList<>();

        if (registro.leerCuentas() != null) {
            cuentaB = registro.leerCuentas();

            for (int i = 0; i < cuentaB.size(); i++) {
                if (cuentaB.get(i).getIBAN().equals(iban)) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------
    public boolean crearCliente(Cliente cli) throws IOException {

       if (cli != null) {
            boolean crear;
            crear = registroCliente.crearClientesCCC();
            if (crear == true) {
                registroCliente.escribirClientesCCC(cli);
            } else {
                registroCliente.insertarClientesCCC(cli);
            }
            //System.out.println("Cliente Nuevo Registrado");
            return true;
        } else {
           System.out.println(" No se ha ingresado este Cliente.....");
       return false;
    }
    }
//------------------------------------------Leer el Nombre y el CCC para obtener una lista-----------------------------
    public void leerClientes() throws IOException {

        System.out.println("------------Clientes y Cuentas--------------------------------");
        HashSet<Cliente> cuentaC = new HashSet<>();
        

    if (registroCliente.crearClientesCCC()) {
            cuentaC = registroCliente.leerClientesCCC();

            for (int i = 0; i < cuentaC.size(); i++) {
                System.out.println(cuentaC.iterator().next());
            }
        }
    }
//---------------------------------------------Validacción simple del CCC-------------------------------------------------------
    public boolean validarIBAN(String iban) {

        if (iban.matches("ES[0-9]{20}")) { // Cadena regular
            return true;  // Devuelve true en caso de ingresar correcto
        } else {
            System.out.println("El formato correcto para el IBAN es ES + 20 digitos...");
        }
        return false; // Indicamos que el formato de matricula no es correcto
    }
//---------------------------------------------------------------------------------------------------------------------------------------
    public boolean validarNacimiento(String fechaNacimiento){
        try{
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaNacimiento, dtf);
        return true;
        }catch(Exception e){
            System.out.println("Introduce una fecha correcta....");
        }
        return false;
    }
    
}