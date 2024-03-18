/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HotelBooking;


import EDD.Hotel.*;
import EDD.*;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class ExcelManager {    
 
    public AVLTree readReservas(){
        try {
            File csv = new File("DataFiles/Reservas.csv");
            Scanner myReader = new Scanner(csv);
            
            AVLTree tree = new AVLTree();
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] cliente = data.split(",");
                if (!cliente[0].contains("ci")) {
                    int ci = Integer.parseInt(cliente[0].replace(".",""));
                    Reserva reserva = new Reserva(ci,cliente[1],cliente[2],cliente[3],cliente[4],cliente[5],cliente[6],cliente[7],cliente[8]);
                    tree.setRoot(tree.insertNode(tree.getRoot(), reserva));
                }
            }
            myReader.close();
            return tree;
        }catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }  
    }
    
    public AVLTree readHabitaciones(){
        try {
            File csv = new File("DataFiles/Habitaciones.csv");
            Scanner myReader = new Scanner(csv);
            
            AVLTree tree = new AVLTree();
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] cliente = data.split(",");
                if (!cliente[0].contains("num")) {
                    Habitaciones habitacion = new Habitaciones(Integer.parseInt(cliente[0]),cliente[1],Integer.parseInt(cliente[2]));
                    tree.setRoot(tree.insertNode(tree.getRoot(), habitacion));
                }
            }
            myReader.close();
            return tree;
        }catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
    
    public void readHistorico(){
        try {
            File csv = new File("DataFiles/Historico.csv");
            Scanner myReader = new Scanner(csv);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] cliente = data.split(",");
                if (!cliente[0].contains("ci")) {
                    int ci = Integer.parseInt(cliente[0].replace(".",""));
                    Historico historico = new Historico(ci,cliente[1],cliente[2],cliente[3],cliente[4],cliente[5],Integer.parseInt(cliente[6]));
                }
            }
            myReader.close();
        }catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void readEstado(){
        try {
            File csv = new File("DataFiles/Estado.csv");
            Scanner myReader = new Scanner(csv);
            
            AVLTree tree = new AVLTree();
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] cliente = data.split(",");
                if (!cliente[0].contains("num")&&(cliente[0]!="")) {
                    System.out.println(cliente[0]);
                    Estado estado = new Estado(Integer.parseInt(cliente[0]),cliente[1],cliente[2],cliente[3],cliente[4],cliente[5],cliente[6]);
                }
            }
            myReader.close();
        }catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
}
