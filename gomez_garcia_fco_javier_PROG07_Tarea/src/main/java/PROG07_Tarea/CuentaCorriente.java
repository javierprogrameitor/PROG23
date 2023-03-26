package PROG07_Tarea;

import java.util.ArrayList;

// clase abstracta que hereda de CuentaBancaria que contiene a Persona y una lista de entidades
public abstract class CuentaCorriente extends CuentaBancaria {

       ArrayList< String> listaentidades = new ArrayList<>(); // he utilizado un ArrayList para esta funcion
                                                                                                       // aunque creo que aún no se han visto,
                                                                                                      //podría haber utilizado un array
    public CuentaCorriente(double saldo, String IBAN, Persona titular) {
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