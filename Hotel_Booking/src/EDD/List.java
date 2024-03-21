/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class List {
    protected Node pFirst;
    protected Node pLast;
    protected int iN;

    /**
     * @return the pFirst
     */
    public Node getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Node pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Node getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Node pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the iN (returns the number of nodes)
     */
    public int getiN() {
        return iN;
    }

    /**
     * @param iN the iN to set
     */
    public void setiN(int iN) {
        this.iN = iN;
    }
    
    
    /**
     * Deletes all data in List
     */
    public String emptyList(){
            setpFirst(null);
            setpLast(null);
            setiN(0);  
        return "La lista esta vacia";
    }
    
    /**
     * @return if the list is empty
     */
    public boolean isEmpty(){
        return getpFirst()==null;
    }

    /**
     * Creates a node and adds it to the end of List
     */
    public void insertLast(Node pNew){
        //Node pNew= new Node(x);
        if (isEmpty()){
            setpFirst(pNew);
            setpLast(pNew);
        }else{
            getpLast().setpNext(pNew);
            setpLast(pNew);    
        }
        setiN(getiN() + 1);
    }

    /**
     * Creates a node and adds it to the start of List
     */
    public void insertFirst(Node pNew){
        //Node pNew=new Node(x);
        if (isEmpty()){
             pFirst=pNew;
             pLast=pNew;
        }else{
            pNew.setpNext(pFirst);
            pFirst=pNew;    
        }
        iN++;
    }

    /**
     * Checks if an element is in List
     */
    public Node search (String elemento){
            Node aux = getpFirst();
            while (aux != null){
                if(aux.getData().equals(elemento)){
                    return aux;
                }else{
                    aux=aux.getpNext();
                }
            }
        return null;
    }
    
    /**
     * Deletes the first element of List
     */
    public void deleteFirst(){
        if (pFirst != null){
            Node aux = pFirst;
            pFirst = pFirst.getpNext();
            aux.setpNext(null);
            setiN(getiN() -1);
        }
    }
    
    /**
     * Deletes any element of List
     */
    public void deleteNode(Node x){
        Node aux = pFirst;
        Node aux1 = x;
        if (pFirst != null) {
            if (pFirst == aux1) {
               this.deleteFirst();
            }else{
                while(aux.getpNext()!=aux1){
                    aux=aux.getpNext();
                }
                aux.setpNext(aux1.getpNext());
                aux1.setpNext(null);
                setiN(getiN()- 1 );
                if (pLast==x) {
                    setpLast(aux);
                }
            }  
        }
    }
 
 
 
 
 
}
 


