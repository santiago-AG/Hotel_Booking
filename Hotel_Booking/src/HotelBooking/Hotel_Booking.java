/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HotelBooking;

import EDD.*;
import GUI.*;


/**
 *
 * @author santi
 */
public class Hotel_Booking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Home home = new Home();
        home.setVisible(true);


        AVLTree tree = new AVLTree();
  
        /* Constructing tree given in the above figure */
        tree.setRoot(tree.insert(tree.getRoot(), 1)); 
        tree.setRoot(tree.insert(tree.getRoot(), 15)); 
        tree.setRoot(tree.insert(tree.getRoot(), 5)); 
        tree.setRoot(tree.insert(tree.getRoot(), 11)); 
        tree.setRoot(tree.insert(tree.getRoot(), 10)); 
        tree.setRoot(tree.insert(tree.getRoot(), 16)); 
        tree.setRoot(tree.insert(tree.getRoot(), 4)); 
        tree.setRoot(tree.insert(tree.getRoot(), 6)); 
        tree.setRoot(tree.insert(tree.getRoot(), 14)); 
        tree.setRoot(tree.insert(tree.getRoot(), 12)); 
        
        System.out.println(tree.getRoot().getKey());
  
        System.out.println(tree.inOrder(tree.getRoot())); 
    }
    
}
