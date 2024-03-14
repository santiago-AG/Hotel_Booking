/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class AVLTree <T> {

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
    
    public LNode insert(LNode leaf, int key) { 
  
        //Perform the normal BST insertion
        if (leaf == null){ 
            return (new LNode(key));
        }
  
        if (key < leaf.getKey()){ 
            leaf.setLeft(insert(leaf.getLeft(), key));  
        }else if (key > leaf.getKey()){ 
            leaf.setRight(insert(leaf.getRight(), key)); 
        }else{ // Duplicate keys not allowed 
            return leaf;
        }    
  
        //Update height ancestor leaf
        leaf.setHeight(1 + max(height(leaf.getLeft()), height(leaf.getRight()))); 
        
        return rebalance(leaf,key);    
    } 
    
    public LNode rebalance(LNode leaf, int key){
        int balance = getBalance(leaf); 
 
        //Left Left Case 
        if (balance > 1 && key < leaf.getLeft().getKey()){
            return rightRotate(leaf); 
        } 
  
        // Right Right Case 
        if (balance < -1 && key > leaf.getRight().getKey()){ 
            return leftRotate(leaf); 
        }
  
        // Left Right Case 
        if (balance > 1 && key > leaf.getLeft().getKey()) { 
            leaf.setLeft(leftRotate(leaf.getLeft())); 
            return rightRotate(leaf); 
        } 
  
        // Right Left Case 
        if (balance < -1 && key < leaf.getRight().getKey()) { 
            leaf.setRight(rightRotate(leaf.getRight())); 
            return leftRotate(leaf); 
        } 
  
        //Return leaf pointer
        return leaf;
    }
    
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
    public String preOrder(LNode leaf) { 
        String toPrint = "";
        if (leaf != null) { 
            toPrint += (leaf.getKey()) + " "; 
            toPrint += preOrder(leaf.getLeft()); 
            toPrint += preOrder(leaf.getRight()); 
        }
        return toPrint;
    }
    
    public String inOrder(LNode leaf) { 
        String toPrint = "";
        if (leaf != null) { 
            toPrint += inOrder(leaf.getLeft()); 
            toPrint += (leaf.getKey()) + " "; 
            toPrint += inOrder(leaf.getRight()); 
        }
        return toPrint;
    }
    
    public String postOrder(LNode leaf) { 
        String toPrint = "";
        if (leaf != null) { 
            toPrint += postOrder(leaf.getLeft()); 
            toPrint += postOrder(leaf.getRight()); 
            toPrint += (leaf.getKey()) + " "; 
        }
        return toPrint;
    }
    
    
    
    
    
    
}
