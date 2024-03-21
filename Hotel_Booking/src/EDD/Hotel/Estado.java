/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD.Hotel;

/**
 *
 * @author santi
 */
public class Estado {
    protected int num_hab;
    protected String name;
    protected String apellido;
    protected String email;
    protected String genero;
    protected String celular;
    protected String llegada;

    public Estado(int num_hab, String name, String apellido, String email, String genero, String celular, String llegada) {
        this.num_hab = num_hab;
        this.name = name;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
        this.llegada = llegada;
    }
    
    public Estado(int num_hab) {
        this.num_hab = num_hab;
        this.name = null;
        this.apellido = null;
        this.email = null;
        this.genero = null;
        this.celular = null;
        this.llegada = null;
    }


    /**
     * @return the num_hab
     */
    public int getNum_hab() {
        return num_hab;
    }

    /**
     * @param num_hab the num_hab to set
     */
    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
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
    
}
