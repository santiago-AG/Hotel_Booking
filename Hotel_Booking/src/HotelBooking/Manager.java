/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HotelBooking;


import EDD.Hotel.Historico;
import EDD.Hotel.Reserva;
import EDD.Hotel.Estado;
import EDD.Hotel.Habitacion;
import EDD.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class Manager {
    protected AVLTree reservas;
    protected AVLTree hab_historico;
    protected HashTable estados;

    public Manager() {
        this.reservas = this.readReservas();
        this.hab_historico = this.readHabitaciones();
        this.estados = this.readEstado();
    }
 
    
    //Lee el CSV de las reservas y crea un arbol AVL utilizando esos datos.
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
                    LNode reserva = new Reserva(ci,cliente[1],cliente[2],cliente[3],cliente[4],cliente[5],cliente[6],cliente[7],cliente[8]);
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
    
    
    //Lee el CSV de las habitaciones y cea un AVLTree utilizando esos datos.
    public AVLTree readHabitaciones(){
        try {
            File csv = new File("DataFiles/Habitaciones.csv");
            Scanner myReader = new Scanner(csv);
            
            AVLTree tree = new AVLTree();
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] cliente = data.split(",");
                if (!cliente[0].contains("num")) {
                    LNode habitacion = new Habitacion(Integer.parseInt(cliente[0]),cliente[1],Integer.parseInt(cliente[2]));
//                    System.out.println(habitacion);
                    tree.setRoot(tree.insertNode(tree.getRoot(), habitacion));
                }
            }
            myReader.close();
            return readHistorico(tree);
        }catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
    
    public AVLTree readHistorico(AVLTree tree){
        try {
            File csv = new File("DataFiles/Historico.csv");
            Scanner myReader = new Scanner(csv);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] cliente = data.split(",");
                if (!cliente[0].contains("ci")) {
                    int ci = Integer.parseInt(cliente[0].replace(".",""));
                    Historico historico = new Historico(ci,cliente[1],cliente[2],cliente[3],cliente[4],cliente[5],Integer.parseInt(cliente[6]));
                    
                    //casteo de LNode a Habitacion via 
                    Habitacion room = (Habitacion) tree.search(historico.getNum_hab(), tree.getRoot());
                    room.getHuespedes().insertLastN(historico);
                    //System.out.println(room.getKey());
                    
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
    
    //Lee el CSV de el estado y crea un HashTable de los huespedes actualmente en el hotel.
    public HashTable readEstado(){
        try {
            File csv = new File("DataFiles/Estado.csv");
            Scanner myReader = new Scanner(csv);
            
            HashTable table = new HashTable(300);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] cliente = data.split(",");
                if (!cliente[0].contains("num")&&(cliente[0]!="")) {
                    //System.out.println(cliente[0]);
                    Estado estado = new Estado(Integer.parseInt(cliente[0]),cliente[1],cliente[2],cliente[3],cliente[4],cliente[5],cliente[6]);
                    table.insertarEstado(estado);
                }
            }
            myReader.close();
            return table;
        }catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return the reservas
     */
    public AVLTree getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(AVLTree reservas) {
        this.reservas = reservas;
    }

    /**
     * @return the hab_historico
     */
    public AVLTree getHab_historico() {
        return hab_historico;
    }

    /**
     * @param hab_historico the hab_historico to set
     */
    public void setHab_historico(AVLTree hab_historico) {
        this.hab_historico = hab_historico;
    }
    
    /**
     * @return the estados
     */
    public HashTable getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(HashTable estados) {
        this.estados = estados;
    }
    
    public void checkOut(){
        //funcion checkout del hash
        Estado checkout;
        Node pNew = new Historico(0,"a","a","a","a","a",0);
        Habitacion hab = (Habitacion) hab_historico.search(0, hab_historico.getRoot());
        hab.getHuespedes().insertLastN(pNew);
    }
    
    public void write_Reserva(){
        String info = "ci,primer_nombre,segundo_nombre,email,genero,tipo_hab,celular,llegada,salida\n";
        String path = "test/reserva.csv";
        info+=this.getReservas().CSVinOrder(this.getReservas().getRoot());
        
        
        try{
            File file = new File(path);
            PrintWriter pw = new PrintWriter(file);
            pw.print(info);
            pw.close(); 
            JOptionPane.showMessageDialog(null, "El archivo ha sido guardado de forma exitosa");
        }catch (Exception e){
            
        }
                
    }
    
    public void write_Historico(){
        String info = "ci,primer_nombre,apellido,email,genero,llegada,num_hab\n";
        String path = "test/historico.csv";
        info+=this.getHab_historico().CSVinOrder(this.getHab_historico().getRoot());
        
        String toPrint = "";
        String[] historial = info.split("\n");
        for (int i = 0; i < historial.length; i++) {
            if (!historial[i].isBlank()) {
                toPrint+=historial[i]+"\n";
            }   
        }
                
        
        try{
            File file = new File(path);
            PrintWriter pw = new PrintWriter(file);
            pw.print(toPrint);
            pw.close(); 
            JOptionPane.showMessageDialog(null, "El archivo ha sido guardado de forma exitosa");
        }catch (Exception e){
            
        }
                
    }
    
    
}
