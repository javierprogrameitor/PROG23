package cuentas;
//clase Cuenta Empresa que hereda de cuenta corriente y de cuenta bancaria
// es imprimible, de la interfaz y serializable para guardar en ficheros..........
import clases.Persona;
import java.io.Serializable;

public class CuentaCorrienteEmpresa extends CuentaCorriente implements Imprimible, Serializable {
//Atributos para la clase
    private final int max_desc;
    private final float interes_desc;
    private final float comision_desc;

    public CuentaCorrienteEmpresa(Double saldo, String IBAN, Persona titular, int max_desc, float interes_desc, float comision_desc) {
        super(saldo, IBAN, titular);// 'super' , hereda de clase abstracta cuenta corriente que a su vez lo hace de cuenta bancaria
        this.max_desc = max_desc;
        this.interes_desc = interes_desc;
        this.comision_desc = comision_desc;
    }

    @Override // método implementado de la interfaz
    public String devolverInfoString() {
        return "Cuenta Corriente de Empresa------------------------------------" + "\n"
                + " Nombre : " + titular.getNombre() + "\n"
                + " Apellidos : " + titular.getApellidos() + "\n"
                + " Fecha de Nacimiento : " + titular.getFecha_nacimiento() + "\n"
                + " IBAN : " + IBAN + "\n"
                + " Saldo :  " + saldo+ "\n"
                + " Cantidad máxima descubierto  : " + max_desc + "\n"
                + " Interés del descubierto :  " + interes_desc + "\n"
                + " Comision del descubierto : " + comision_desc + "\n"
                + " Lista de Entidades para cobrar recibos domiciliados " + listaentidades;
    }
}
