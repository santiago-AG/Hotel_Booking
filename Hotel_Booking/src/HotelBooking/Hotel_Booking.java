/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HotelBooking;

import EDD.AVLTree;
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
        tree.setRoot(tree.insert(tree.getRoot(), 10)); 
        tree.setRoot(tree.insert(tree.getRoot(), 20)); 
        tree.setRoot(tree.insert(tree.getRoot(), 30)); 
        tree.setRoot(tree.insert(tree.getRoot(), 40)); 
        tree.setRoot(tree.insert(tree.getRoot(), 50)); 
        tree.setRoot(tree.insert(tree.getRoot(), 25)); 
  

        System.out.println("Preorder traversal" + 
                        " of constructed tree is : "); 
        tree.preOrder(tree.getRoot()); 
    }
    
}
