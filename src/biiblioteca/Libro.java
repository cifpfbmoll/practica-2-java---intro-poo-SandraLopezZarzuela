
package biiblioteca;
import java.util.Scanner;
import java.util.ArrayList;

public class Libro {
    private static int contadorLibro;
    private String titulo;
    private String autor;
    private String editorial;
    private int numCopias;
    private int numCopiasDisponibles;
    private int isbn;
    private static ArrayList <Libro> listaLibros = new ArrayList();
    
    private static Scanner sc = new Scanner (System.in);

    public Libro(String titulo, String autor, String editorial, int numCopias, int numCopiasDisponibles, int isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.numCopias = numCopias;
        this.numCopiasDisponibles = numCopiasDisponibles;
        this.isbn = isbn;
    }

    public Libro() {
    }

    public static ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public static void setListaLibros(ArrayList<Libro> listaLibros) {
        Libro.listaLibros = listaLibros;
    }
    
    public Libro(Libro l1) {
        this.setAutor(l1.getAutor());
        this.setEditorial(l1.getEditorial());
        this.setIsbn(l1.getIsbn());
        this.setNumCopias(l1.getNumCopias());
        this.setNumCopiasDisponibles(l1.getNumCopiasDisponibles());
        this.setTitulo(l1.getTitulo());
    }

    public static int getContadorLibro() {
        return contadorLibro;
    }

    public static void setContadorLibro(int contadorLibro) {
        Libro.contadorLibro = contadorLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }

    public int getNumCopiasDisponibles() {
        return numCopiasDisponibles;
    }

    public void setNumCopiasDisponibles(int numCopiasDisponibles) {
        this.numCopiasDisponibles = numCopiasDisponibles;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", numCopias=" + numCopias + ", numCopiasDisponibles=" + numCopiasDisponibles + ", isbn=" + isbn + '}';
    }
    
    public void añadirLibro(ArrayList <Libro> listaLibros){
        
        System.out.println("Introduce el isbn");
        this.setIsbn(sc.nextInt());
        System.out.println("Introduce el titulo");
        this.setTitulo(sc.nextLine());
        System.out.println("Introduce el autor");
        this.setAutor(sc.nextLine());
        System.out.println("Introduce la editorial");
        this.setEditorial(sc.nextLine());
        System.out.println("Introduce el numero de copias");
        this.setNumCopias(sc.nextInt());
        System.out.println("Introduce el numero de copias disponibles");
        this.setNumCopiasDisponibles(sc.nextInt());
        
        listaLibros.add(this);
    }
    
    public static void eliminarLibro (ArrayList <Libro> listaLibros){
        
        Libro b1 = new Libro ();
        System.out.println("Introduzca el isbn del libro que quiera eliminar");
        int isbn = sc.nextInt();
        
        for (int i =0; i<listaLibros.size();i++){
            if (listaLibros.get(i).getIsbn()==isbn){
                if (listaLibros.get(i).getNumCopiasDisponibles()>=listaLibros.get(i).getNumCopias()){
                    System.out.println("El libro se ha eliminado");
                    listaLibros.remove(i);
            }else{
                System.out.println("No se puede eliminar puesto que el libro esta reservado actualmente");
            }
        }else{
                System.out.println("El isbn no es correcto");
            }
        }
    }
    public static void bucarTitulo(ArrayList <Libro> listaLibros){
        Libro b1 = new Libro();
        System.out.println("Introduce el titulo del libro que desees eliminar");
        String titulo = sc.nextLine();
        
        for (int i = 0; i<listaLibros.size();i++){
            if (listaLibros.get(i).getTitulo().contains(titulo)){
                System.out.println(i);
            }else{
                System.out.println("No se ha encontrado ningun libro con ese titulo");
            }
        }
    }
    
    public static int buscarIsbn(ArrayList <Libro> listaLibros){
        Libro b1 = new Libro ();
        System.out.println("Introduce el isbn del libro que desea buscar");
        int isbn = sc.nextInt();
        
        for (int i = 0;i<listaLibros.size();i++){
            if (listaLibros.get(i).getIsbn()==isbn){
                System.out.println(i);
                return i;
            }else{
                System.out.println("Libro no encontrado");
            }
        }
        return -1;
    }
    
    public static int menuModificar(){
        
        int opcion;
        System.out.println("Que dato quieres cambiar del libro? ");
        System.out.println("1) ISBN");
        System.out.println("2) Titulo");
        System.out.println("3) Autor");
        System.out.println("4) Editorial");
        System.out.println("5) Cantidad de copias");
        System.out.println("6) Cantidad de copias disponibles");
        opcion = sc.nextInt();
        
        return opcion;
    }
    public static void modificarDatos(int opcion,Libro b1){
        
        switch (opcion){
            case 1:
                System.out.println("Introduce el isbn");
                b1.setIsbn(sc.nextInt());
                break;
            case 2:
                System.out.println("Introduce el titulo");
                b1.setTitulo(sc.nextLine());
                break;
            case 3:
                System.out.println("Introduce el autor");
                b1.setAutor(sc.nextLine());
                break;
            case 4:
                System.out.println("Introduce la editorial");
                b1.setEditorial(sc.nextLine());
                break;
            case 5:
                System.out.println("Introduce el numero de copias");
                b1.setNumCopias(sc.nextInt());
                break;
            case 6:
                System.out.println("Introduce el numero de copias disponibles");
                b1.setNumCopiasDisponibles(sc.nextInt());
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;    
        }
        
    }
    
    public static void añadirCopia(ArrayList <Libro> listaLibros, Libro b1){
        
        Libro copia = new Libro (b1,listaLibros);
        System.out.println("Copia de libro creada");
        
        boolean bool = false;
        while(!bool){
            
            System.out.println("Quieres cambiar algun dato del libro?");
            System.out.println("1) Si");
            System.out.println("2) No");
            int cambiarDato = sc.nextInt();
            sc.nextLine();
            if(cambiarDato == 1){
                int opcion = menuModificar();
                copia = modificarDatos(copia, opcion);
            }else if(cambiarDato == 2){
                bool = true;

            }else{
                System.out.println("No has introducido un valor correcto");
            }
        }
        return copia;
    }
}


