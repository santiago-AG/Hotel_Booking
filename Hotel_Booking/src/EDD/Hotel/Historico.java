/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD.Hotel;
import EDD.Node;
import EDD.Node;

/**
 *
 * @author santi
 */
public class Historico<T> extends Node<T>{
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String llegada;
    private int num_hab;

    public Historico(T ci, String nombre, String apellido, String email, String genero, String llegada, int num_hab) {
        super(ci);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
        this.num_hab = num_hab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public int getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
    }
    
    @Override
    public String toCSV(){
        String toPrint = String.valueOf(getData()) + "," + getNombre() + "," + getApellido() + "," + getEmail()+ "," + getGenero()+ "," +getLlegada()+ "," +getNum_hab();
        return toPrint;
    }
    
    @Override
    public String toPrint(){
        String toPrint = "Cedula: "+String.valueOf(getData()) + "\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nEmail: " + getEmail()+ "\nGenero: " + getGenero()
                + "\nLlegada: " +getLlegada()+"\n";
        
        return toPrint;
    }
    
}
