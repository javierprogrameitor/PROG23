package ficheros;

import clases.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
/*
 * @author Fco Javier Gómez García
 */

public class RegistroClientes {
//_______________________________________________________________________________________________________________________
//-------------------------------------------------------------------Fichero para crear Clientes----------------------------------------------------------------
//----------------------------------------------------------------Añadimos nueva funcionalidad--------------------------------------------------------------
//======================================================================

    File cl;

    public boolean crearClientesCCC() { // Creo el fichero para los clientes y su CCC  'en el resto del programa como iban '

        try {
            cl = new File("ListadoClientesCCC.txt");
        } catch (Exception e) {
        }
        return cl.exists();
    }

    //----------------------------------------------------------------------Escribir e Insertar Clientes-------------------------------------------------------------------------------
    public void escribirClientesCCC(Cliente cli) throws IOException {

        FileWriter fw = new FileWriter(cl, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(cli.toString());
        pw.flush();
        pw.close();

    }

    public void insertarClientesCCC(Cliente cli) throws IOException {

        FileWriter fw = new FileWriter(cl, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(cli.toString());
        pw.flush();
        pw.close();

        //----------------------------------------------------------------------HashSet  para almacenar y leer los Clientes----------------------------------------------------------------------------------
    }

    public HashSet<Cliente> leerClientesCCC() throws FileNotFoundException, IOException {

        HashSet<Cliente> cli = new HashSet<>();

        FileReader fr = new FileReader(cl);

        BufferedReader br = new BufferedReader(fr);

        String cad = br.readLine();

        while (cad != null) {
            System.out.println(cad);
            cad = br.readLine();
        }
        return cli;

    }
    
}