/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Andres
 */
public class HeapSort {

    int ambientes;
    private LinkedList<LinkedList<HashMap<String, String>>> registroAmbientes;
    private MetodosVarios metodos;

    public HeapSort() {
        this.metodos = new MetodosVarios();
    }

    public void heapSort(int[] array) {
        this.ambientes = 1;
        this.registroAmbientes = new LinkedList<>();
        this.Sort(array, 0);
    }

    private void Sort(int[] array, int padre) {//0

        int idAmbiente = this.ambientes;
        HashMap<String, String> variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 0, 1, variables));

        final int N = array.length;//1

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("N", N + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 1, 2, variables));

        for (int nodo = N / 2; nodo >= 0; nodo--) {//2

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("N", N + "");
            variables.put("nodo", nodo + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 2, 9, variables));

            this.ambientes++;
            hacerMonticulo(array, nodo, N - 1, idAmbiente);//3
            
            if(nodo >= 0){
                
            }else{
                
            }
        }
        for (int nodo = N - 1; nodo >= 0; nodo--) {//4
            int tmp = array[0];//5
            array[0] = array[nodo];//6
            array[nodo] = tmp;//7

            this.ambientes++;
            hacerMonticulo(array, 0, nodo - 1, idAmbiente);//8
        }
    }
//    public void Sort(int[] v) {
//        final int N = v.length;
//        for (int nodo = N / 2; nodo >= 0; nodo--) {
//            hacerMonticulo(v, nodo, N - 1);
//        }
//        for (int nodo = N - 1; nodo >= 0; nodo--) {
//            int tmp = v[0];
//            v[0] = v[nodo];
//            v[nodo] = tmp;
//            hacerMonticulo(v, 0, nodo - 1);
//        }
//    }

    private void hacerMonticulo(int[] array, int nodo, int fin, int padre) {//9
        int idAmbiente = this.ambientes;

        int izq = 2 * nodo + 1;//10
        int der = izq + 1;//11
        int may;//12
        if (izq > fin) {//13
            return;//14
        }
        if (der > fin) {//15
            may = izq;//16
        } else {//17
            if (array[izq] > array[der]) {//18
                may = izq;//19
            } else {//20
                may = der;//21
            }

        }
        if (array[nodo] < array[may]) {//22
            int tmp = array[nodo];//23
            array[nodo] = array[may];//24
            array[may] = tmp;//25

            this.ambientes++;
            hacerMonticulo(array, may, fin, idAmbiente);//26
        }
    }

//    public static void hacerMonticulo(int[] v, int nodo, int fin) {
//        int izq = 2 * nodo + 1;
//        int der = izq + 1;
//        int may;
//        if (izq > fin) {
//            return;
//        }
//        if (der > fin) {
//            may = izq;
//        } else {
//            may = v[izq] > v[der] ? izq : der;
//        }
//        if (v[nodo] < v[may]) {
//            int tmp = v[nodo];
//            v[nodo] = v[may];
//            v[may] = tmp;
//            hacerMonticulo(v, may, fin);
//        }
//    }
    /**
     * @return the registroAmbientes
     */
    public LinkedList<LinkedList<HashMap<String, String>>> getRegistroAmbientes() {
        return registroAmbientes;
    }
}
