/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 * @param <T>
 */
public class Node <T>{   
    protected T data;
    protected Node <T> pNext;
    
    public Node (T elem){
    data=elem;
    pNext=null;
    }
        
    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public Node <T> getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Node <T> pNext) {
        this.pNext = pNext;
    }
    
    public String toCSV(){
        return (String) getData();
    }
    
}
