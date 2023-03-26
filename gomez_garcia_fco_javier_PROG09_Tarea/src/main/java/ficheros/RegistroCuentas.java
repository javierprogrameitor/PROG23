package ficheros;


import cuentas.CuentaAhorro;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorrienteEmpresa;
import cuentas.CuentaCorrientePersonal;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class RegistroCuentas {

//-----------------------------------------------------------------------------Crear Fichero Cuentas Bancarias----------------------------------------------------------------
    File c;

    public boolean crearFichero() {

        try {
            c = new File("datoscuentasbancarias.dat");
        } catch (Exception e) {
        }
        return c.exists();
    }
//------------------------------------------------------Cuentas de Ahorro------------------------------------------------------------------------------------------------

    public void escribirAhorro(CuentaAhorro ahorro) {

        try (FileOutputStream escReg = new FileOutputStream(c); ObjectOutputStream obj = new ObjectOutputStream(escReg);) {
            obj.writeObject(ahorro);
            obj.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarAhorro(CuentaAhorro ahorro) {

        try (FileOutputStream escReg = new FileOutputStream(c, true); MiObjectOutputStream obj = new MiObjectOutputStream(escReg)) {
            obj.writeObject(ahorro);
            obj.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------------------------------Cuentas Personales-------------------------------------------------------------------------------------
    public void escribirPersonal(CuentaCorrientePersonal personal) {

        try (FileOutputStream escReg = new FileOutputStream(c); ObjectOutputStream obj = new ObjectOutputStream(escReg);) {
            obj.writeObject(personal);
            obj.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarPersonal(CuentaCorrientePersonal personal) {

        try (FileOutputStream escReg = new FileOutputStream(c, true); MiObjectOutputStream obj = new MiObjectOutputStream(escReg)) {

            obj.writeObject(personal);
            obj.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//------------------------------------------------------------------------Cuentas Empresa------------------------------------------------------------------------------------------
    public void escribirEmpresa(CuentaCorrienteEmpresa empresa) {

        try (FileOutputStream escReg = new FileOutputStream(c); ObjectOutputStream obj = new ObjectOutputStream(escReg);) {
            obj.writeObject(empresa);
            obj.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarEmpresa(CuentaCorrienteEmpresa empresa) {

        try (FileOutputStream escReg = new FileOutputStream(c, true); MiObjectOutputStream obj = new MiObjectOutputStream(escReg)) {
            obj.writeObject(empresa);
            obj.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//------------------------------------------------------------ArrayList para ingresar las cuentas-----------------------------------------------------

    public ArrayList<CuentaBancaria> leerCuentas() {

        ArrayList<CuentaBancaria> cb = new ArrayList<>();
        try {
            try (FileInputStream leer = new FileInputStream(c); ObjectInputStream obj = new ObjectInputStream(leer)) {

                CuentaBancaria cuenta;
                cuenta = (CuentaBancaria) obj.readObject();

                while (cuenta != null) {
                    cb.add(cuenta);
                    cuenta = (CuentaBancaria) obj.readObject();
                }
            } catch (EOFException e1) {
            }
        } catch (IOException | ClassNotFoundException e) {
        }
        return cb;
    }

}
