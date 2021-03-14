
package biiblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static Biblioteca b1 = new Biblioteca();
    static Libro l1 = new Libro();
    static Bibliotecario bi1= new Bibliotecario();
    static Usuario u1 = new Usuario();
    static ArrayList <Libro> listaLibros = new ArrayList();
    static ArrayList <Persona> listaPersonas = new ArrayList();
    
    public static void main(String[] args) {
        
        boolean salir = false;
        int opcion;
        
        while (!salir) {
            
            System.out.println("1.Opciones Libros");
            System.out.println("2.Opciones Bibliotecario/Usuario");
            System.out.println("3.Opciones Biblioteca");
            System.out.println("4.Salir");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    opcionesLibro();
                    break;
                case 2:
                    opcionesBibliotecario();
                    break;
                case 3:
                    opcionesBiblioteca();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");         
            }
        }
    }
    
    public static void opcionesLibro() {
        boolean salir = false;
        int opcion;
        
        while (!salir) {
            System.out.println("1.Añadir Libro");
            System.out.println("2.Modificar libro");
            System.out.println("3.Eliminar Libro");
            System.out.println("4.Buscar libro por ISBN");
            System.out.println("5.Buscar libro por titulo");
            System.out.println("6.Hacer copia Libro");
            System.out.println("7.Reservar Libro");
            System.out.println("8.Devolver Libro");
            System.out.println("9.Volver");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Libro.añadirLibro(listaLibros);
                    break;
                case 2:
                    Libro.menuModificar(listaLibros);
                    break;
                case 3:
                    Libro.eliminarLibro(listaLibros);
                    break;
                case 4:
                    Libro.buscarIsbn(listaLibros);
                    break;
                case 5:
                    Libro.buscarTitulo(listaLibros);
                    break;
                case 6:
                    Libro.añadirCopia(listaLibros);
                    break;
                case 7:
                    Bibliotecario.reservarLibro(listaLibros);
                    break;
                case 8:
                    Bibliotecario.devolverLibro(listaLibros);
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }
    
    public static void opcionesBibliotecario() {
        
        boolean salir = false;
        int opcion;

            while (!salir) {
                System.out.println("1.Añadir Bibliotecario");
                System.out.println("2.Añadir Usuario");
                System.out.println("3.Cambiar contraseña bibliotecario");
                System.out.println("4.Cambiar contraseña usuario");
                System.out.println("5.Volver");
                int opcion= sc.nextInt();
                
                switch (opcion) {
                    case 1:
                        bi1.crearBibiotecario(listaPersonas);
                        break;
                    case 2:
                        u1.crearUsuario(listaPersonas);
                        break;
                    case 3:
                        bi1.inicioBilbiotecario(listaPersonas);
                        break;
                    case 4:
                        u1.cambiarContraseña(usuario, contraseña);
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            }
        }
    
    public static void opcionesBiblioteca() {

        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1.Mostrar Libros");
            System.out.println("2.Mostrar Personas");
            System.out.println("3.Mostrar Bibliotecarios");
            System.out.println("4.Mostrar Usuarios");
            System.out.println("5.Volver");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    b1.mostrarLibros(listaLibros);
                    break;
                case 2:
                    b1.mostrarPersonas(listaPersonas);
                    break;
                case 3:
                    b1.mostrarBibliotecario(listaPersonas);
                    break;
                case 4:
                    b1.mostrarUsuarios(listaPersonas);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }
}


    

    
    

