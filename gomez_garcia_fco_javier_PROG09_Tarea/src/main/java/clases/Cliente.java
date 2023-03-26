
package clases;

import java.io.Serializable;

/**
 *
 * @author javier
 */
public class Cliente  implements Serializable{

String nombre;
String iban;

    public Cliente() {
    }

    public Cliente(String nombre, String iban) {
        this.nombre = nombre;
        this.iban = iban;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Cliente con nombre : "  + nombre + " Numero de cuenta : " + iban ;
    }

    
}