package cuentas;

import clases.Persona;
import java.io.Serializable;

public abstract class CuentaBancaria implements Imprimible, Serializable { // Clase Cuenta Bancaria que implementa la interfaz
    // es abstracta y contiene a la clase Persona
    // Atributos

    private static final long serialVersionUID = 1L;

    Double saldo;  // Si estos atributos son declarados private no podemos
    String IBAN;     // acceder a ellos desde otras clases, y por lo tanto no podemos leerlos
    Persona titular;// la clase Persona

    public CuentaBancaria(Double saldo, String IBAN, Persona titular) { // Constructor
        this.saldo = saldo;
        this.IBAN = IBAN;
        this.titular = titular;
    }
//método de la interfaz

    @Override
    public abstract String devolverInfoString();
//Getter y Setter  necesarios para desarrollar el programa

    public Double getSaldo() {
        return saldo;
    }

    public Double setSaldo(Double saldo) {
        this.saldo = saldo;
        return saldo;
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
