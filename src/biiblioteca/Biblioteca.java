
package biiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Persona> listaPersonas;
    private static Scanner sc = new Scanner(System.in);

    public Biblioteca() {
    }

    public Biblioteca(String nombre) {
        this.setbNombre(nombre);
        this.listaLibros = new ArrayList();
        this.listaPersonas = new ArrayList();
    }

    public Biblioteca(Biblioteca b1) {
        this.setbNombre(b1.getNombre());
        this.setListaLibros(b1.getListaLibros());
        this.setListaPersonas(b1.getListaPersonas());
    }
    
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setbNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    @Override
    public String toString() {
        return "biblioteca{" + "bNombre=" + nombre + ", listaLibros=" + listaLibros + ", listaPersonas=" + listaPersonas + '}';
    }
    
    public void mostrarLibros() {
        for (int i=0; i<listaLibros.size(); i++) {
            System.out.println(listaLibros.get(i));
        }
    }
    
    public void mostrarPersonas() {
        for (int i=0; i<this.getListaPersonas().size(); i++) {
            System.out.println(this.getListaPersonas().get(i));
        }
    }
    
    public void mostrarBibliotecario() {
        for (int i=0; i<this.getListaPersonas().size(); i++) {
            if (this.getListaPersonas().get(i) instanceof Bibliotecario) {
                System.out.println((Bibliotecario)this.getListaPersonas().get(i));
            }
        }
    }
    
    public void mostrarUsuario() {
        for (int i=0; i<this.getListaPersonas().size(); i++) {
            if (this.getListaPersonas().get(i) instanceof Usuario) {
                System.out.println((Usuario)this.getListaPersonas().get(i));
            }
        }
    }
}
