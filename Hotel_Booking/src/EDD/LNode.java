/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class LNode{
    protected int key;
    protected int height;
    protected LNode left;
    protected LNode right;

    public LNode(int key) {
        this.key = key;
        this.height = 1;
        this.key = key;
        this.left = null;
        this.right = null;
    }


    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the left
     */
    public LNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(LNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public LNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(LNode right) {
        this.right = right;
    }
    
    public boolean isFull(){
        return (getRight()!=null && getLeft()!=null);
    }
    
    public boolean isLeaf(){
        return (getRight()==null && getLeft()==null);
    }

    public boolean hasLeft(){
        return (getLeft()!=null);
    }

    public boolean hasRight(){
        return (getRight()!=null);
    }
    
    public String toCSV(){
        String toPrint;
        toPrint=String.valueOf(getKey());
        
        return toPrint;
    }
    
    
    
    
}
