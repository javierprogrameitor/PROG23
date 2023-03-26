package PROG07_Tarea;
/**
 *
 * @author fco javier gomez garcia
 */
public class Banco {

    CuentaBancaria[] cuentas = new CuentaBancaria[100];
    int contCuentas; // Contador de cuentas
    double total;      // variable para ingresos y retiradas de efectivo.

    public boolean abrirCuenta(CuentaBancaria cuenta) {

        if (cuenta != null) {

            cuentas[contCuentas] = cuenta;
            contCuentas++;
            System.out.println(" Cuenta Creada....");
            return true;

        } else {
            System.out.println(" No se ha podido abrir la cuenta.....");
        }
        return false;
    }

    public void listadoCuentas() {

        CuentaBancaria cb;

        for (int i = 0; i < contCuentas; i++) {
            cb = cuentas[i];
            System.out.println(cb.devolverInfoString());
        }
    }

    public String informacionCuenta(String iban) {

        CuentaBancaria cb;

        for (int i = 0; i < contCuentas; i++) {
            cb = cuentas[i];
            if (cb.getIBAN().equals(iban)) {
                System.out.println(cb.devolverInfoString());
            }
        }
        return null;
    }

    public boolean ingresoCuenta(String iban, Double ingreso) {

        CuentaBancaria cb;

        for (int i = 0; i < contCuentas; i++) {
            cb = cuentas[i];
            if (cb.getIBAN().equals(iban)) {
                total = cb.getSaldo() + ingreso;
                cb.setSaldo(total);
                System.out.println(" Su nuevo saldo es : " + total);
                return true;
            }
        }
        return false;
    }

    public boolean retiradaCuenta(String iban, Double retirado) {

        CuentaBancaria cb;

        for (int i = 0; i < contCuentas; i++) {
            cb = cuentas[i];
            if (cb.getIBAN().equals(iban) && cb.getSaldo()>=retirado) {
                total = cb.getSaldo() - retirado;
                cb.setSaldo(total);
                System.out.println(" Su nuevo saldo es : " + total);
                return true;
            }
        }
        return false;
    }

    public int obtenerSaldo(String iban) {

        CuentaBancaria cb = null;

        for (int i = 0; i < contCuentas; i++) {
            cb = cuentas[i];
            if (cb.getIBAN().equals(iban)) {
                System.out.println(" Saldo : " + cb.getSaldo());
                return 0;
            }
        }
          return -1;
    }

    public boolean validarIBAN(String iban) {

        if (iban.matches("ES[0-9]{20}")) { // Cadena regular
            return true;  // Devuelve true en caso de ingresar correcto
        } else {
            System.out.println("El formato correcto para el IBAN es ES + 20 digitos...");
        }
        return false; // Indicamos que el formato de matricula no es correcto
    }

}
