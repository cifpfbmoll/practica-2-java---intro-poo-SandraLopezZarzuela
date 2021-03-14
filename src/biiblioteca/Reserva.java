/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biiblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Reserva implements Material {

    private static Scanner sc = new Scanner(System.in);
    private Libro libro;
    private LocalDate fecha;
    private LocalTime hora;
    private int cantidadReservada;
    private Usuario usuario;

    public Reserva() {
    }

    public Reserva(Libro libro, LocalDate fecha, LocalTime hora, int cantidadReservada, Usuario usuario) {
        this.setLibro(libro);
        this.setFecha(fecha);
        this.setHora(hora);
        this.setCantidadReservada(cantidadReservada);
        this.setUsuario(usuario);
    }
    public Reserva(Reserva r1) {
        this.setLibro(r1.getLibro());
        this.setFecha(r1.getFecha());
        this.setHora(r1.getHora());
        this.setCantidadReservada(r1.getCantidadReservada());
        this.setUsuario(r1.getUsuario());
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "libro=" + libro +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", cantidadReservada=" + cantidadReservada +
                ", usuario=" + usuario +
                '}';
    }
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getCantidadReservada() {
        return cantidadReservada;
    }

    public void setCantidadReservada(int cantidadReservada) {
        this.cantidadReservada = cantidadReservada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void reservarLibro(ArrayList <Libro> listaLibros,Usuario usuario){
        System.out.println("Introduce el isbn del libro");
        int isbn = sc.nextInt();
        
        System.out.println("Cuantos libros quieres reservar?");
        int libros = sc.nextInt();

        }
    
    public static void hacerReserva(ArrayList <Persona> listaPersonas, ArrayList <Libro> listaLibro){
        
        int posicionUs = Usuario.inicioUsuario(listaPersonas);
        //si se ha registrado correctamente
        if (posicionUs != -1){
            //hago el registro
            Usuario usuario = ((Usuario)listaPersonas.get(posicionUs));
            if (usuario.getListaReservas().size()< 10){
                int posicionLibro = Libro.buscarIsbn(listaLibro);
                if (posicionLibro !=-1){
                    if (listaLibro.get(posicionLibro).getNumCopiasDisponibles()> 0){
                        //quito un libro disponible
                        listaLibro.get(posicionLibro).setNumCopiasDisponibles(listaLibro.get(posicionLibro).getNumCopiasDisponibles()-1);
                        //añado a reserva el libro
                        Reserva nueva = new Reserva(listaLibro.get(posicionLibro));
                        //añado la reserva a la lista
                        usuario.getListaReservas().add(nueva);
                        System.out.println("Reserva ");
                    
                    
                    }else{
                        System.out.println("No existen copias disponibles del libro");
                    }
                }
            }else{
                System.out.println("No se pueden reservar mas de 10 libros");
            }
        }
        
    public static void devolverLibro (ArrayList <Persona> listaPersonas, ArrayList <Libro> listaLibro){
            
            int posicionUs = Usuario.inicioUsuario(listaPersonas);
            
            if (posicionUs != -1){
                Usuario usuario = (Usuario)listaPersonas.get(posicionUs);
                if (usuario.getListaReservas().size()>0){
                    int encontrar = Libro.buscarIsbn(listaLibro);
                    if (encontrar != -1){
                        //eliminamos la reserva
                        usuario.getListaReservas().remove(encontrar);
                        //buscamos el libro otra vez y le añadimos una copia disponible
                        Libro libro = listaLibro.get(Libro.buscarIsbn(listaLibro));
                        libro.setNumCopiasDisponibles(libro.getNumCopiasDisponibles()+1);
                        System.out.println("Se ha devuelto el libro");
                        
                    }
                }else{
                    System.out.println("No hay libros reservados");
                }
            }                                  
        }     
    @Override
    public LocalDate mostrarFechaDevolucion() {
        return this.getFecha().plusMonths(1);
    }

    @Override
    public void mostrarInfoChula() {
        System.out.println("---INFORMACION SOBRE LA RESERVA---");
        System.out.println("Titulo: "+this.getLibro().getTitulo());
        System.out.println("ISBN: " + this.getLibro().getIsbn());
        System.out.println("Autor: " + this.getLibro().getAutor());
        System.out.println("Editorial: " + this.getLibro().getEditorial());
        System.out.println("Tiempo de la reserva: ");
        System.out.println("Fecha: " + this.getFecha());
        System.out.println("Hora: " + this.getHora());
        System.out.println("Persona que ha reservado la reserva: ");
        System.out.println("Nombre: " + this.getUsuario().getNombre());
        System.out.println("Apellidos: " + this.getUsuario().getApellido1() + " " + getUsuario().getApellido2());
        System.out.println("Telefono: " + this.getUsuario().getTelefono());
        System.out.println("Correo electronico: " + this.getUsuario().getCorreo());
        
    }
}
