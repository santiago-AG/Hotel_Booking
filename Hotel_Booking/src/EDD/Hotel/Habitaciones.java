/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD.Hotel;

import EDD.*;

/**
 *
 * @author santi
 */
public class Habitaciones extends LNode {
    protected String tipo_hab;
    protected int piso;
    protected List huespedes;

    public Habitaciones(int num_hab, String tipo_hab, int piso) {
        super(num_hab);
        this.tipo_hab = tipo_hab;
        this.piso = piso;
        this.huespedes = null;
    }
    
    /**
     * @return the huespedes
     */
    public List getHuespedes() {
        return huespedes;
    }

    /**
     * @param huespedes the huespedes to set
     */
    public void setHuespedes(List huespedes) {
        this.huespedes = huespedes;
    }

    public String getTipo_hab() {
        return tipo_hab;
    }

    public void setTipo_hab(String tipo_hab) {
        this.tipo_hab = tipo_hab;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
}