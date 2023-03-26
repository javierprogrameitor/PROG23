package PROG07_Tarea;
//clase Cuenta Personal que hereda de cuenta corriente y de cuenta bancaria

public class CuentaCorrientePersonal extends CuentaCorriente {

    private final float comision;  // Su nuevo atriuto
//Constructor para la clase

    public CuentaCorrientePersonal(double saldo, String IBAN, Persona titular, float comision) {
        super(saldo, IBAN, titular); // 'super' , hereda de clase abstracta cuenta corriente que a su vez lo hace de cuenta bancaria
        this.comision = comision;
    }
    CuentaBancaria c; // Objeto de la Cuenta Bancaria

    @Override // método implementado de la interfaz
    public String devolverInfoString() {
        return "Cuenta Corriente Personal----------------------------------------" + "\n"
                + " Nombre : " + titular.getNombre() + "\n"
                + " Apellidos : " + titular.getApellidos() + "\n"
                + " Fecha de Nacimiento : " + titular.getFecha_nacimiento() + "\n"
                + " Comision de Mantenimiento: " + comision + "\n"
                + " Saldo :  " + c.getSaldo() + "\n"
                + " IBAN : " + c.getIBAN() + "\n"
                + " Lista de Entidades para cobrar recibos domiciliados " + listaentidades;
    }
}
