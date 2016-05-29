/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.*;
import java.util.LinkedList;

/**
 *
 * @author Sebas
 */
public class NewMain {

    public  void QuickSortAl(){
        
    }
    

    public static void main(String[] args) {
        int[] arreglo = new int[10];
        arreglo[0]=10;
        arreglo[1]=8;
        arreglo[2]=5;
        arreglo[3]=3;
        arreglo[4]=14;
        arreglo[5]=12;
        arreglo[6]=5;
        arreglo[7]=18;
        arreglo[8]=1;
        arreglo[9]=9;
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(" "+arreglo[i]);
            
        }
        
        QuickSort q = new QuickSort();
        System.out.println("\n");
        
        q.QuickSort(arreglo);
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(" "+arreglo[i]);
            
        }
        
        System.out.println("\n"+q.getRegistroAmbientes().toString());

        System.out.println(q.generarNodos(q.getRegistroAmbientes()));
    }
    

}
