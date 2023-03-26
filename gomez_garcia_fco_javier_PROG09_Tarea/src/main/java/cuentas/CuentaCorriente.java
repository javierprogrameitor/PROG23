package cuentas;

import clases.Persona;
import java.io.Serializable;
import java.util.ArrayList;

// clase abstracta que hereda de CuentaBancaria que contiene a Persona y una lista de entidades
public abstract class CuentaCorriente extends CuentaBancaria implements Imprimible, Serializable{

       ArrayList< String> listaentidades = new ArrayList<>(); //  Guardamos las entidades......
                                                                                                      
    public CuentaCorriente(Double saldo, String IBAN, Persona titular) {
        super(saldo, IBAN, titular); // herencia de CuentaBancaria y una lista de entidades agregadas
        listaentidades.add("Santander");
        listaentidades.add("La Caixa"); 
        listaentidades.add("BBVA"); 
        listaentidades.add("CajaExtremadura"); 
    }

//Getter y Setter necesarios
    public ArrayList<String> getListaentidades() {
        return listaentidades;
    }

    public void setListaentidades(ArrayList<String> listaentidades) {
        this.listaentidades = listaentidades;
    }
}