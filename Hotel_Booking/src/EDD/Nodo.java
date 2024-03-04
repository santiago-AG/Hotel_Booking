/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class Nodo <T>{
    private Nodo <T> sonR;
    private Nodo <T> sonL;
    private T data;

    public Nodo(T data) {
        this.data = data;
        this.sonR = null;
        this.sonL = null;
    }
    
    public boolean isFull(){
        return (getSonR()!=null && getSonL()!=null);
    }
    
    public boolean isLeaf(){
        return (getSonR()==null && getSonL()==null);
    }

    public boolean hasLeft(){
        return (getSonL()!=null);
    }

    public boolean hasRight(){
        return (getSonR()!=null);
    }
    
    public Nodo <T> getSonR() {
        return sonR;
    }

    public void setSonR(Nodo <T> sonR) {
        this.sonR = sonR;
    }

    public Nodo <T> getSonL() {
        return sonL;
    }

    public void setSonL(Nodo <T> sonL) {
        this.sonL = sonL;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    
}
