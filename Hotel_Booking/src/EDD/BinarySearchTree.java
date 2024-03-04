/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class BinarySearchTree <T> {

    public BinarySearchTree(Nodo root) {
        this.root = root;
    }
    private Nodo root;
    
    public boolean isEmpty(){
        return (getRoot()!=null);
    }
    
    /**
     *
     * @param data
     * @param parent
     */
    public void insert(int data, Nodo root){
        if(!isEmpty()){
            if ((int)root.getData()>data) {
                
            }
        }
    }

    
    
    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }
    
    
}
