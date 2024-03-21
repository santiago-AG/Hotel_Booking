/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import EDD.Hotel.Estado;

public class HashTable {

    private Estado[] tablaEstados;
    private int size;
    private Estado dummy; // Objeto especial para marcar estados eliminados
    
        public Estado[] getTablaEstados() {
        return tablaEstados;
    }

    public void setTablaEstados(Estado[] tablaEstados) {
        this.tablaEstados = tablaEstados;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Estado getDummy() {
        return dummy;
    }

    public void setDummy(Estado dummy) {
        this.dummy = dummy;
    }

    // Constructor
    public HashTable(int capacidad) {
        this.size = capacidad;
        this.tablaEstados = new Estado[capacidad];
        this.dummy = new Estado(-1); // Suponiendo que -1 es un valor inválido para numeroHabitacion
    }

    // Función Hash para determinar el índice en el arreglo
    private int funcionHash(int numeroHabitacion) {
        return numeroHabitacion % size;
    }

    // Insertar un nuevo estado
    public void insertarEstado(Estado nuevoEstado) {
        int indice = funcionHash(nuevoEstado.getNum_hab());
        int contador = 0; // Para evitar un bucle infinito

        // Búsqueda lineal para encontrar un hueco o el final de la tabla
        while (tablaEstados[indice] != null && tablaEstados[indice].getNum_hab() != nuevoEstado.getNum_hab()&& tablaEstados[indice] != dummy && contador++ < size) {
            indice = (indice + 1) % size;
        }

        // Insertar el nuevo estado si no se encontró uno existente
        if (tablaEstados[indice] == null || tablaEstados[indice] == dummy) {
            tablaEstados[indice] = nuevoEstado;
        } else {
            System.out.println("¡ERROR! El estado ya está registrado.");
        }
    }

    // Verificar si un estado específico se encuentra en la hash
    public boolean contieneEstado(Estado estado) {
        int indice = funcionHash(estado.getNum_hab());
        int contador = 0;

        while (tablaEstados[indice] != null && contador++ < size) {
            if (tablaEstados[indice] != dummy && tablaEstados[indice].getNum_hab()== estado.getNum_hab()) {
                return true; // Encontrado
            }
            indice = (indice + 1) % size;
        }

        return false; // No encontrado
    }

    // Listar habitaciones disponibles
    // Nota: Este método podría requerir una implementación específica basada en cómo se definen las habitaciones disponibles
    public void listarDisponibles(List habitacionesDisponibles) {
        for (int i = 0; i < size; i++) {
            if (tablaEstados[i] == null || tablaEstados[i] == dummy) {
                habitacionesDisponibles.insertLast(i);
            }
        }
    }
}
