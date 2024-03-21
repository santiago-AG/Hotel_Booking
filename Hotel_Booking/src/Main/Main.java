/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import EDD.*;
import EDD.Hotel.Habitacion;
import EDD.Hotel.Reserva;
import GUI.*;


/**
 *
 * @author santi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExcelManager manager = new ExcelManager();
        LNode res = manager.getReservas().getRoot();
        System.out.println(res);
        //Reserva resr = (Reserva) res;
        Reserva cliente = (Reserva) manager.getReservas().search(100, manager.getReservas().getRoot());
        System.out.println(cliente);
        //System.out.println(cliente);
        
        
    }
    
}
