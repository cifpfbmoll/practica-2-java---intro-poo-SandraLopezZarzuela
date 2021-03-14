/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biiblioteca;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Usario
 */
public class Usuario extends Persona {
    
    private String telefono;
    private String direccion;
    private int codigoPostal;
    private String correo;
    
    private ArrayList <Reserva> listaReservas = new ArrayList();
    
    
    private static Scanner sc = new Scanner (System.in);

    public Usuario() {
    }

    
    public Usuario(String direccion, String telefono, int codigoPostal, String correo, String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.correo = correo;
        this.direccion = direccion;
    }
    
    //constructor copia
    public Usuario (Usuario u1){
        this.setNombre(u1.getNombre());
        this.setApellido1(u1.getApellido1());
        this.setApellido2(u1.getApellido2());
        this.setEdad(u1.getEdad());
        this.setCodigoPostal(u1.getCodigoPostal());
        this.setCorreo(u1.getCorreo());
        this.setDireccion(u1.getDireccion());
        this.setTelefono(u1.getTelefono());
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return super.toString()+ "Usuario{" + "telefono=" + telefono + ", codigoPostal=" + codigoPostal + ", correo=" + correo + ", listaUsuarios=" + listaUsuarios + '}';
    }
    
    @Override
    public void solicitarDatos() {
	super.solicitarDatos();
	System.out.println("Introduce tu direccion");
        this.setDireccion(sc.nextLine());
        System.out.println("Introduce tu correo electronico");
        this.setCorreo(sc.nextLine());
        System.out.println("Introduce tu codigo postal");
        this.setCodigoPostal(sc.nextInt());
        System.out.println("Introduce tu telefono");
        this.setTelefono(sc.nextLine());
        
	}
        
    //añadimos el usuario a la lista
        public void crearUsuario(ArrayList <Persona> listaPersonas){
            Usuario nuevou1 = new Usuario ();
            nuevou1.solicitarDatos();
            listaPersonas.add(nuevou1);
        }
        
        public static int inicioUsuario(ArrayList <Persona> listaPersonas){
            
            System.out.println("Introduce tu correo");
            String correoElectronico = sc.nextLine();
            System.out.println("Introduce tu telefono");
            String movil = sc.nextLine();
            
            boolean identificacion = false;
            
            for (int i = 0; i<listaPersonas.size();i++){
                if (listaPersonas.get(i) instanceof Usuario){
                    if ((Usuario)listaPersonas.get(i).getCorreo().equals(correoElectronico)){
                        if((Usuario)listaPersonas.get(i).getTelefono().equals(movil)){
                            System.out.println("Te has registrado");
                            identificacion = true;
                        }else{
                            System.out.println("Numero de telefono incorrecto");
                        }
                    }else{
                        System.out.println("El correo electronico no existe");
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
    
        
        
    
    

