/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class BSTree <T> {

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
    
    public void  insert(LNode root, int key) { 
  
        //Perform the normal BST insertion
        if (root != null){ 
            if (key < root.getKey()){
                if (root.hasLeft()) {
                    insert(root.getLeft(), key);
                }else{
                    LNode newLeaf = new LNode(key);
                    root.setLeft(newLeaf);   
                }
            }else if (key > root.getKey()){
                if (root.hasRight()) {
                    insert(root.getRight(), key);
                }else{
                    LNode newLeaf = new LNode(key);
                    root.setRight(newLeaf);   
                }
            }else{ // Duplicate keys not allowed 
                System.out.println("duplicate keys not allowed");
            }
        }else{
            LNode newLeaf = new LNode(key);
            setRoot(newLeaf); 
        }    
  
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
    
    public LNode deleteNode(LNode root, int key) {
        if (root == null){
            return root;
        }
        
        if (root.getKey() > key) {
            root.setLeft(deleteNode(root.getLeft(), key));
            return root;
        } else if (root.getKey() < key) {
            root.setRight(deleteNode(root.getRight(), key));
            return root;
        }

        if (root.getLeft() == null) {
            LNode temp = root.getRight();
            return temp;
        } else if (root.getRight() == null) {
            LNode temp = root.getLeft();
            return temp;
        }

        else {
            LNode succParent = root;

            LNode succ = root.getRight();
            while (succ.getLeft() != null) {
                succParent = succ;
                succ = succ.getLeft();
            }
 
            if (succParent != root)
                succParent.setLeft(succ.getRight());
            else
                succParent.setRight(succ.getRight());

            root.setKey(succ.getKey());

            return root;
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
            toPrint += inOrder(leaf.getLeft()); 
            toPrint += preOrder(leaf.getRight()); 
            toPrint += (leaf.getKey()) + " "; 
        }
        return toPrint;
    }
    
    
    
    
    
    
}
