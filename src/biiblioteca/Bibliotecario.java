
package biiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotecario extends Persona {
    
    private String NIF;
    private String puestoTrabajo;
    private String contraseña;
    
    private static Scanner sc = new Scanner (System.in);

    public Bibliotecario() {
    }

    public Bibliotecario(String NIF, String puestoTrabajo, String contraseña, Persona p1) {
        super(p1);
        this.NIF = NIF;
        this.puestoTrabajo = puestoTrabajo;
        this.contraseña = contraseña;
    }

    public Bibliotecario(Bibliotecario b1,String NIF, String puestoTrabajo, String contraseña, String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.setNIF(b1.getNIF());
        this.setContraseña(b1.getContraseña());
        this.setPuestoTrabajo(b1.getPuestoTrabajo());
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "NIF=" + NIF + ", puestoTrabajo=" + puestoTrabajo + ", contrase\u00f1a=" + contraseña + '}';
    }

    @Override
    public void solicitarDatos() {
	super.solicitarDatos();
	System.out.println("Introduce tu contraseña");
        this.setPuestoTrabajo(sc.nextLine());
        System.out.println("Introduce tu puesto de trabajo");
        this.setContraseña(sc.nextLine());
        System.out.println("Introduce tu NIF");
        this.setNIF(sc.nextLine());

	}
        //añadimos el bibliotecario a la lista
        public void crearBibiotecario (ArrayList <Persona> listaPersonas){
            Bibliotecario nuevob1 = new Bibliotecario();
            nuevob1.solicitarDatos();
            listaPersonas.add(nuevob1);
            System.out.println("Se ha añadido un nuevo bibliotecario");
            
        }
        
        public static void inicioBibliotecario (ArrayList <Persona> listaPersonas){
            
            System.out.println("Introduce tu dni"); 
            String nif = sc.nextLine();
            System.out.println("Introduce tu contraseña");
            String contra = sc.nextLine();
            
            boolean identificado = false;
            
           for (int i =0; i<listaPersonas.size();i++){
               if (listaPersonas.get(i) instanceof Bibliotecario){
                   if ((Bibliotecario)listaPersonas.get(i).getNIF().equals(nif)){
                       if ((Bibliotecario)listaPersonas.get(i).getContraseña().equals(contra)){
                           identificado = true;
                           System.out.println("Te has registrado");
               }else{
                           System.out.println("Contraseña incorrecta");
                       }
           }else{
                       System.out.println("El NIF no corresponde con ningun bibliotecario");
                   } 
        }
    }
           
}
    @Override
    public boolean cambiarContraseña(String usuario, String contraseña){
        if(this.getNif().equals(usuario)){
            this.setContraseña(contraseña);
            System.out.println("Se ha cambiado la contraseña");
            return true;
        }
        return false;
    }

}

    

    

