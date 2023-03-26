package cuentas;
//cuenta de ahorro hereda de cuenta bancaria es imprimible de la interfaz y serializable para
// guardar los datos en ficheros
import clases.Persona;
import java.io.Serializable;

public class CuentaAhorro extends CuentaBancaria implements Imprimible, Serializable {

    private static final long serialVersionUID = 1L;

    private final float interes; // su atributo de la clase

//Constructor
    public CuentaAhorro(Double saldo, String IBAN, Persona titular, float interes) {
        super(saldo, IBAN, titular); // 'super' herencia de CuentaBancaria
        this.interes = interes;
    }
    @Override
    public String devolverInfoString() {  // Método implementado de la interfaz imprimible
        return "Cuenta Ahorro---------------------------------------------------------" + "\n"
                + " Nombre : " + titular.getNombre() + "\n"
                + " Apellidos : " + titular.getApellidos() + "\n"
                + " Fecha de Nacimiento : " + titular.getFecha_nacimiento() + "\n"
                + " Saldo : " +saldo + "\n"
                + " IBAN :  " + IBAN+ "\n"
                + " Interes : " + interes;
    }
}