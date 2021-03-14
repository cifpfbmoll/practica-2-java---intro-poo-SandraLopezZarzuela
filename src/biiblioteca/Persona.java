
package biiblioteca;
import java.util.Scanner;

public abstract class Persona {
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    
    private Scanner sc = new Scanner (System.in);

    public Persona() {
    }

        
    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        super ();
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }
    
    public Persona(Persona p1) {
        this.setNombre(p1.getNombre());
        this.setApellido1(p1.getApellido1());
        this.setEdad(p1.getEdad());
        this.setApellido2(p1.getApellido2());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", edad=" + edad + '}';
    }
    
    public void solicitarDatos (){
        System.out.println("Introduce tu nombre");
        this.setNombre(sc.nextLine());
        System.out.println("Introduce tu primer apellido");
        this.setApellido1(sc.nextLine());
        System.out.println("Introduce tu segundo apellido");
        this.setApellido2(sc.nextLine());
        System.out.println("Introduce tu edad");
        this.setEdad(sc.nextInt());
    }

    Object getContraseña() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
