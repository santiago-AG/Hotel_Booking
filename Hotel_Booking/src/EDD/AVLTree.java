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

//    public AVLTree(Leaf root) {
//        this.root = root;
//    }
    private Leaf root;
    
    
    /**
     * Utility function to check if tree is empty
     **/
    public boolean isEmpty(){
        return (getRoot()!=null);
    }
    
    /**
     * Utility function to get the height of the tree 
     **/
    public int height(Leaf N) { 
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
    public Leaf rightRotate(Leaf y) { 
        Leaf x = y.getLeft(); 
        Leaf T2 = x.getRight(); 
        
        // Perform rotation 
        x.setRight(y); 
        y.setLeft(T2); 
  
        // Update heights 
        y.setHeight(max( height(y.getLeft()), height(y.getRight())) + 1); 
        x.setHeight(max( height(x.getLeft()), height(x.getRight())) + 1); 
  
        // Return new root 
        return x; 
    } 
    
    /**
     * Utility function to left rotate subTree rooted with x 
     **/
    public Leaf leftRotate(Leaf x) { 
        Leaf y = x.getRight(); 
        Leaf T2 = y.getLeft(); 
  
        // Perform rotation 
        y.setLeft(x); 
        x.setRight(T2); 
  
        //  Update heights 
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1); 
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1); 
  
        // Return new root 
        return y; 
    } 
    
    /** 
     * Get Balance factor of Leaf L 
     * */
    public int getBalance(Leaf L) { 
        if (L == null) 
            return 0; 
  
        return height(L.getLeft()) - height(L.getRight()); 
    }
    
    public Leaf insert(Leaf leaf, int key) { 
  
        /* 1.  Perform the normal BST insertion */
        if (leaf == null) 
            return (new Leaf(key)); 
  
        if (key < leaf.getKey()){ 
            leaf.setLeft(insert(leaf.getLeft(), key));  
        }else if (key > leaf.getKey()){ 
            leaf.setRight(insert(leaf.getRight(), key)); 
        }else{ // Duplicate keys not allowed 
            return leaf;
        }    
  
        /* 2. Update height of this ancestor leaf */
        leaf.setHeight(1 + max(height(leaf.getLeft()), height(leaf.getRight()))); 
  
        /* 3. Get the balance factor of this ancestor 
              leaf to check whether this leaf became 
              unbalanced */
        int balance = getBalance(leaf); 
  
        // If this leaf becomes unbalanced, then there 
        // are 4 cases Left Left Case 
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
  
        /* return the (unchanged) leaf pointer */
        return leaf; 
    } 
        
    /**
     * @return the root of AVLTree
     */
    public Leaf getRoot() {
        return root;
    }
    
    /**
     * @param Root the Root to set
     */
    public void setRoot(Leaf root) {
        this.root = root;
    }
    
    // A utility function to print preorder traversal 
    // of the tree. 
    // The function also prints height of every leaf 
    public void preOrder(Leaf leaf) { 
        if (leaf != null) { 
            System.out.print(leaf.getKey() + " "); 
            preOrder(leaf.getLeft()); 
            preOrder(leaf.getRight()); 
        } 
    }
    
    
}
