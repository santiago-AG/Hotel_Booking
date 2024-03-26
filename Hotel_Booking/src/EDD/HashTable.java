/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import EDD.Hotel.Estado;

/**
 *
 * @author santi
 */
public class HashTable {
    protected Estado[] tablaEstados;
    protected int size;
 
    public HashTable(int num) {
        this.tablaEstados = new Estado[nextPrime(num)];
        this.size = 0;
    }
    
    public int hash(String texto){
        int index=0;
        for (int i = 0; i < texto.length(); i++) {
            index+=texto.codePointAt(i);
        }
        return index%getTablaEstados().length;
    }

    /**
     * @return the tablaEstados
     */
    public Estado[] getTablaEstados() {
        return tablaEstados;
    }

    /**
     * @param tablaEstados the tablaEstados to set
     */
    public void setTablaEstados(Estado[] tablaEstados) {
        this.tablaEstados = tablaEstados;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }


    public boolean isPrime(int n) 
    { 
        if (n <= 1) return false; 
        if (n <= 3) return true; 

        if (n % 2 == 0 || n % 3 == 0) return false; 
         
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
            return false; 
         
        return true; 
    } 
     
    public int nextPrime(int N) 
    { 
        if (N <= 1) 
            return 2; 
     
        int prime = N; 
        boolean found = false; 

        while (!found) 
        { 
            prime++; 
     
            if (isPrime(prime)) 
                found = true; 
        } 
     
        return prime; 
    } 
    
    public void insert(String key, Estado data){
        int index = hash(key);
        if (getTablaEstados()[index]==null) {      
            getTablaEstados()[index] = data;
        }else{
            getTablaEstados()[index].setpNext(data);
        }
        setSize(getSize()+1);
    }
    
    public Node search(String key){
        key = key.toLowerCase().replace(" ", "");
        int index = hash(key); 
        Estado estado = getTablaEstados()[index];
        while (estado!=null){
            String nombre = estado.getName().toLowerCase().replace(" ", "");
            String apellido = estado.getApellido().toLowerCase().replace(" ", "");
            String name = nombre+apellido;
            if (name.equals(key)) {
                return estado; 
            }else{
                estado = (Estado) estado.getpNext();
            }
        }
        
        return null;
    }
    
    public Node delete(String key){
        key = key.toLowerCase().replace(" ", "");
        int index = hash(key); 
        Estado estado = getTablaEstados()[index];
            while (estado!=null){
                String nombre = estado.getName().toLowerCase().replace(" ", "");
                String apellido = estado.getApellido().toLowerCase().replace(" ", "");
                String name = nombre+apellido;
                if (name.equals(key)) {
                    Estado aux = estado;
                    getTablaEstados()[index] = (Estado) estado.getpNext();
                    return aux; 
                }else{
                    estado = (Estado) estado.getpNext();
                }
            }
        return null;
    }
    
    public String ocupados(){
        String habOcupado = "";
        for (int i = 0; i < getTablaEstados().length; i++) {
            if (getTablaEstados()[i]!=null) {
                Node aux = getTablaEstados()[i];
                habOcupado+=","+aux.getData()+",";
                while (aux.getpNext()!=null) {
                    aux=aux.getpNext();
                    habOcupado+=","+aux.getData()+",";
                }
            } 
        }
        return habOcupado;
    }
    
    public String toCSV(){
        String habOcupado = "";
        for (int i = 0; i < getTablaEstados().length; i++) {
            if (getTablaEstados()[i]!=null) {
                Node aux = getTablaEstados()[i];
                habOcupado+=aux.toCSV()+"\n";
                while (aux.getpNext()!=null) {
                    aux=aux.getpNext();
                    habOcupado+=aux.toCSV()+"\n";
                }
            } 
        }
        return habOcupado;
    }
    
}
