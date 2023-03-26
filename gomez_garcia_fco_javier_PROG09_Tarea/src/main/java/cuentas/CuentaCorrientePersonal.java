package cuentas;
//clase Cuenta Personal que hereda de cuenta corriente y de cuenta bancaria
// es imprimible, de la interfaz y serializable para guardar en ficheros..........
import clases.Persona;
import java.io.Serializable;

public class CuentaCorrientePersonal extends CuentaCorriente implements Imprimible, Serializable {

    private final float comision;  // Su nuevo atriuto

//Constructor para la clase
    public CuentaCorrientePersonal(Double saldo, String IBAN, Persona titular, float comision) {
        super(saldo, IBAN, titular); // 'super' , hereda de clase abstracta cuenta corriente que a su vez lo hace de cuenta bancaria
        this.comision = comision;
    }

    @Override // método implementado de la interfaz
    public String devolverInfoString() {
        return "Cuenta Corriente Personal----------------------------------------" + "\n"
                + " Nombre : " + titular.getNombre() + "\n"
                + " Apellidos : " + titular.getApellidos() + "\n"
                + " Fecha de Nacimiento : " + titular.getFecha_nacimiento() + "\n"
                + " Comision de Mantenimiento: " + comision + "\n"
                + " Saldo :  " + saldo + "\n"
                + " IBAN : " + IBAN + "\n"
                + " Lista de Entidades para cobrar recibos domiciliados " + listaentidades;
    }
}
