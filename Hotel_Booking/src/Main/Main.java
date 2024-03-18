/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import EDD.*;
import GUI.*;
import HotelBooking.*;


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
        manager.readReservas();
    }
    
}
