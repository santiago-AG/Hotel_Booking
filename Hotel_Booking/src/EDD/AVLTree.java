/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import EDD.Hotel.Reserva;

/**
 *
 * @author santi
 */
public class AVLTree{

//    public AVLTree(LNode root) {
//        this.root = root;
//    }
    private LNode root;
    
    
    /**
     * Utility function to check if tree is empty
     **/
    public boolean isEmpty(){
        return (getRoot()!=null);
    }
    
    /**
     * Utility function to get the height of the tree 
     **/
    public int height(LNode N) { 
        if (N == null) 
            return 0; 
  
        return N.getHeight(); 
    }
    
    /**
     * Utility function to get maximum of two integers 
     **/
    public int max(int a, int b) { 
        return (a > b) ? a : b; 
    }
    
    /**
     * Utility function to right rotate subtree rooted with y 
     **/
    public LNode rightRotate(LNode y) { 
        LNode x = y.getLeft(); 
        LNode T2 = x.getRight(); 
        //Rotation 
        x.setRight(y); 
        y.setLeft(T2); 
        //Update heights 
        y.setHeight(max( height(y.getLeft()), height(y.getRight())) + 1); 
        x.setHeight(max( height(x.getLeft()), height(x.getRight())) + 1);
        //Return new root 
        return x; 
    } 
    
    /**
     * Utility function to left rotate subTree rooted with x 
     **/
    public LNode leftRotate(LNode x) { 
        LNode y = x.getRight(); 
        LNode T2 = y.getLeft();
        //Rotation 
        y.setLeft(x); 
        x.setRight(T2); 
        //Update heights 
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1); 
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1); 
        // Return new root 
        return y; 
    } 
    
    /** 
     * Get Balance factor of LNode L 
     * */
    public int getBalance(LNode L) { 
        if (L == null){
            return 0; 
        } 
        return height(L.getLeft()) - height(L.getRight()); 
    }
    
    public LNode insert(LNode root, int key) { 
  
        //Perform the normal BST insertion
        if (root == null){ 
            return (new LNode(key));
        }
  
        if (key < root.getKey()){ 
            root.setLeft(insert(root.getLeft(), key));  
        }else if (key > root.getKey()){ 
            root.setRight(insert(root.getRight(), key)); 
        }else{ // Duplicate keys not allowed 
            return root;
        }    
  
        //Update height ancestor root
        root.setHeight(1 + max(height(root.getLeft()), height(root.getRight()))); 
        
        return rebalance(root,key);    
    } 
    
    public LNode rebalance(LNode root, int key){
        int balance = getBalance(root); 
 
        //Left Left Case 
        if (balance > 1 && key < root.getLeft().getKey()){
            return rightRotate(root); 
        } 
  
        // Right Right Case 
        if (balance < -1 && key > root.getRight().getKey()){ 
            return leftRotate(root); 
        }
  
        // Left Right Case 
        if (balance > 1 && key > root.getLeft().getKey()) { 
            root.setLeft(leftRotate(root.getLeft())); 
            return rightRotate(root); 
        } 
  
        // Right Left Case 
        if (balance < -1 && key < root.getRight().getKey()) { 
            root.setRight(rightRotate(root.getRight())); 
            return leftRotate(root); 
        } 
  
        //Return root pointer
        return root;
    }
    
    public LNode insertNode(LNode root, LNode key) { 
  
        //Perform the normal BST insertion
        if (root == null){ 
            return key;
        }
  
        if (key.getKey() < root.getKey()){ 
            root.setLeft(insertNode(root.getLeft(), key));  
        }else if (key.getKey() > root.getKey()){ 
            root.setRight(insertNode(root.getRight(), key)); 
        }else{ // Duplicate keys not allowed 
            return root;
        }    
  
        //Update height ancestor root
        int num1 = height(root.getLeft());
        int num2 = height(root.getRight());
        root.setHeight(1 + max(num1,num2)); 
        
        return rebalanceNode(root,key);    
    } 
    public LNode rebalanceNode(LNode root, LNode key){
        int balance = getBalance(root); 
 
        //Left Left Case 
        if (balance > 1 && key.getKey() < root.getLeft().getKey()){
            return rightRotate(root); 
        } 
  
        // Right Right Case 
        if (balance < -1 && key.getKey() > root.getRight().getKey()){ 
            return leftRotate(root); 
        }
  
        // Left Right Case 
        if (balance > 1 && key.getKey() > root.getLeft().getKey()) { 
            root.setLeft(leftRotate(root.getLeft())); 
            return rightRotate(root); 
        } 
  
        // Right Left Case 
        if (balance < -1 && key.getKey() < root.getRight().getKey()) { 
            root.setRight(rightRotate(root.getRight())); 
            return leftRotate(root); 
        } 
  
        //Return root pointer
        return root;
    }
    
    public LNode DeleteReserva(int Elem, Reserva ABB){
            Reserva resp= ABB;
            if (Elem< ABB.getKey()) {
                ABB.setLeft(DeleteReserva(Elem, (Reserva) ABB.getLeft()));
            }else{
                if(Elem > ABB.getKey()){
                    ABB.setRight(DeleteReserva(Elem, (Reserva) ABB.getRight()));
                }else{
                    if(ABB.getLeft()!= null && ABB.getRight()!= null){
                        LNode temp=ABB;
                        Reserva Max_Izq =(Reserva) Max(ABB.getLeft());
                        ABB.setKey(Max_Izq.getKey());
                        ABB.setNombre(Max_Izq.getNombre());
                        ABB.setApellido(Max_Izq.getApellido());
                        ABB.setEmail(Max_Izq.getEmail());
                        ABB.setGenero(Max_Izq.getGenero());
                        ABB.setTipo_hab(Max_Izq.getTipo_hab());
                        ABB.setCelular(Max_Izq.getCelular());
                        ABB.setLlegada(Max_Izq.getLlegada());
                        ABB.setSalida(Max_Izq.getSalida());
                        temp.setLeft(DeleteReserva(Max_Izq.getKey(), (Reserva) temp.getLeft()));
                       }else{
                            if(ABB.getLeft()!=null){
                                resp=(Reserva) ABB.getLeft();
                            }else{
                                if(ABB.getRight()!=null){
                                    resp=(Reserva)ABB.getRight();
                                }else{
                                    resp=null;
                                }
                            }
                    }
                }
            }
            return resp;
        }
        
    public LNode Max(LNode n) {
        if (n.getRight() == null) {
            return n;
        } else {
            return Max(n.getRight());
        }
    }
      
//    public LNode searchDelete(LNode root,int data){
//        LNode aux = root;
//        System.out.println(root.getKey()+" + "+data);
//        if (root.getKey()==data){
//            System.out.println("llegue");
//            System.out.println(root);
//            root = root.getRight();
//            System.out.println(root);
//            LNode aux1 = root.getLeft();
//            aux.setRight(null);
//            root.setLeft(aux.getLeft());
//            aux.setLeft(null);
//            LNode MaximoLeft = Max(root);
//            MaximoLeft.setRight(aux1);
//        }
//        if (aux.getKey()>data){
//            aux=searchDelete(root.getLeft(),data);
//        }
//        if(aux.getKey()<data){
//            aux=searchDelete(root.getRight(),data);
//        } 
//        return aux;  
//    }
    
    public LNode search(int data, LNode root){
        if (root!=null) {
            if (root.getKey()>data) {
                return search(data,root.getLeft());
            }else if (root.getKey()<data) {
                return search(data,root.getRight());   
            }else{
                return root;
            }
        }else{  
        return null;
        }
    }
            
    /**
     * @return the root of AVLTree
     */
    public LNode getRoot() {
        return root;
    }
    
    /**
     * @param Root the Root to set
     */
    public void setRoot(LNode root) {
        this.root = root;
    }
    
    // Utility function to print preorder of Tree. 
    public String preOrder(LNode root) { 
        String toPrint = "";
        if (root != null) { 
            toPrint += (root.getKey()) + " "; 
            toPrint += preOrder(root.getLeft()); 
            toPrint += preOrder(root.getRight()); 
        }
        return toPrint;
    }
    
    public String inOrder(LNode root) { 
        String toPrint = "";
        if (root != null) { 
            toPrint += inOrder(root.getLeft()); 
            toPrint += (root.getKey()) + "\n"; 
            toPrint += inOrder(root.getRight()); 
        }
        return toPrint;
    }
    
    public String postOrder(LNode root) { 
        String toPrint = "";
        if (root != null) { 
            toPrint += postOrder(root.getLeft()); 
            toPrint += postOrder(root.getRight()); 
            toPrint += (root.getKey()) + " "; 
        }
        return toPrint;
    }
    
    public String CSVinOrder(LNode root) { 
        String toPrint = "";
        if (root != null) { 
            toPrint += CSVinOrder(root.getLeft());
            toPrint += (root.toCSV()) + "\n"; 
            toPrint += CSVinOrder(root.getRight()); 
        }
        return toPrint;
    }
    
    
    
    
    
    
}
