package PROG07_Tarea;

public class Persona implements Imprimible { // la clase Persona implementa imprimible

    //Atributos para crear la persona
    private String nombre;
    private String apellidos;
    private String fecha_nacimiento;

// Metodo de la interfaz
    @Override
    public String devolverInfoString() {
        return "";
    }

// constructor de la clase Persona
    public Persona(String nombre, String apellidos, String fecha_nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
    }
// Getter y Setter de la clase Persona
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

}
