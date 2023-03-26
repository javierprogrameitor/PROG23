package PROG07_Tarea;
//cuenat de ahorro hereda de cuenta bancaria
class CuentaAhorro extends CuentaBancaria {

   private final  float interes; // su atributo de la clase lo declaro tambièn private y por lo tanto final
//Constructor
    public CuentaAhorro(double saldo, String IBAN, Persona titular, float interes) {
        super(saldo, IBAN, titular); // 'super' herencia de CuentaBancaria
        this.interes = interes;
    }
    CuentaBancaria c;//Objeto de la clase abstracta Cuenta Bancaria
    @Override
    public String devolverInfoString() {  // Método implementado de la interfaz imprimible
        return "Cuenta Ahorro---------------------------------------------------------" + "\n"
                + " Nombre : " + titular.getNombre() + "\n"
                + " Apellidos : " + titular.getApellidos() + "\n"
                + " Fecha de Nacimiento : " + titular.getFecha_nacimiento() + "\n"
                + " Saldo : " + c.getSaldo() + "\n"
                + " IBAN :  " + c.getIBAN() + "\n"
                + " Interes : " + interes;
    }
}
