/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class Leaf {
    private Leaf right;
    private Leaf left;
    private int height;
    private int key;

    public Leaf(int key) {
        this.key = key;
        this.height = 1;
        this.right = null;
        this.left = null;
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
    
    public Leaf getRight() {
        return right;
    }

    public void setRight(Leaf right) {
        this.right = right;
    }

    public Leaf getLeft() {
        return left;
    }

    public void setLeft(Leaf left) {
        this.left = left;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
