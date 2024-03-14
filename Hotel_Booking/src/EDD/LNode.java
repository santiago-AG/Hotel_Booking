/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class LNode {
    private int key;
    private int height;
    private LNode left;
    private LNode right;

    public LNode(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
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
    
    public LNode getRight() {
        return right;
    }

    public void setRight(LNode right) {
        this.right = right;
    }

    public LNode getLeft() {
        return left;
    }

    public void setLeft(LNode left) {
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
