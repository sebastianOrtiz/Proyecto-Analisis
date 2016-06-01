/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.*;
import java.math.MathContext;
import java.util.LinkedList;

/**
 *
 * @author Sebas
 */
public class NewMain {

    public  void QuickSortAl(){
        
    }
    

    public static void main(String[] args) {
        int[] arreglo = {2,3,4,2};
        
//        arreglo[0]=2;
//        arreglo[1]=3;
//        arreglo[2]=5;
//        arreglo[3]=3;
//        arreglo[4]=14;
//        arreglo[5]=12;
//        arreglo[6]=5;
//        arreglo[7]=18;
//        arreglo[8]=1;
//        arreglo[9]=9;
        
        Sudoku s = new Sudoku();
        s.cargarSudoku();
        s.imprimir(s.getTablero());
        s.resolver(s.getTablero());
        s.imprimir(s.getTablero());
//        
//        MetodosVarios metodos= new MetodosVarios();
//        for (int i = 0; i < arreglo.length; i++) {
//            System.out.print(" "+arreglo[i]);
//            
//        }
//        
//        HeapSort q = new HeapSort();
//        Mmatriz m = new Mmatriz();
//        System.out.println("\n");
//        
//        System.out.println(m.mult(arreglo));
        
        //q.heapSort(arreglo);
//        
//        for (int i = 0; i < arreglo.length; i++) {
//            System.out.print(" "+arreglo[i]);
//            
//        }
//        
//        System.out.println("\n"+q.getRegistroAmbientes().toString());
//
//        System.out.println(metodos.generarNodos(q.getRegistroAmbientes()));
    }
    

}
