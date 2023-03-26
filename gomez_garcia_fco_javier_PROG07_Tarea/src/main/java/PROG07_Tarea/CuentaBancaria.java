package PROG07_Tarea;

public abstract class CuentaBancaria implements Imprimible { // Clase Cuenta Bancaria que implementa la interfaz
    // es abstracta y contiene a la clase Persona
    // Atributos

    private double saldo;
    private String IBAN;
    Persona titular;// la clse Persona
// constructor

    public CuentaBancaria(double saldo, String IBAN, Persona titular) {
        this.saldo = saldo;
        this.IBAN = IBAN;
        this.titular = titular;
    }
//método de la interfaz

    @Override
    public abstract String devolverInfoString();
//Getter y Setter  necesarios

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }
}
