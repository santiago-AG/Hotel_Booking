/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD.Hotel;

import EDD.Node;

/**
 *
 * @author santi
 */
public class Estado <T> extends Node<T>{
    protected String name;
    protected String apellido;
    protected String email;
    protected String genero;
    protected String celular;
    protected String llegada;

    public Estado(T num_hab, String name, String apellido, String email, String genero, String celular, String llegada) {
        super(num_hab);
        this.name = name;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
        this.llegada = llegada;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the llegada
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * @param llegada the llegada to set
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }
    
    @Override
    public String toPrint(){
        String toPrint = "Numero de Habitacion: "+String.valueOf(getData()) + "\nNombre: " + getName() + "\nApellido: " + getApellido() + "\nEmail: " + getEmail()+ "\nGenero: " + getGenero()
                +"\nCelular: "+getCelular()+ "\nLlegada: " +getLlegada()+"\n";
        
        return toPrint;
    }
    
    
}
