/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD.Hotel;

import EDD.*;
import EDD.LNode;
import EDD.List;

/**
 *
 * @author santi
 */
public class Habitacion extends LNode {
    protected String tipo_hab;
    protected int piso;
    protected List huespedes;

    public Habitacion(int num_hab, String tipo_hab, int piso) {
        super(num_hab);
        this.tipo_hab = tipo_hab;
        this.piso = piso;
        this.huespedes = new List();
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
    
    @Override
    public String toCSV(){
        String toPrint="";
        Node aux = getHuespedes().getpFirst();
        
        while(aux!= null){
            if (aux.getpNext()!=null) {    
            toPrint+=aux.toCSV()+"\n";    
            }else{
            toPrint+=aux.toCSV();  
            }
            aux=aux.getpNext();
        }
        return toPrint;
    }
    
    public String printHistory(){
        String toPrint="";
        Node aux = getHuespedes().getpFirst();
        
        while(aux!= null){
            if (aux.getpNext()!=null) {    
            toPrint+=aux.toPrint()+"\n";    
            }else{
            toPrint+=aux.toPrint();  
            }
            aux=aux.getpNext();
        } 
        return toPrint;
    }

}
