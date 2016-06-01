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
    
    public String determinarComplejidad() {
        return "Θ(n log n)";
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
        this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 0, 1, variables));

        final int N = array.length;//1

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("N", N + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 1, 2, variables));

        for (int nodo = N / 2; nodo >= 0; nodo--) {//2

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("N", N + "");
            variables.put("nodo", nodo + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 2, 9, variables));

            this.ambientes++;
            hacerMonticulo(array, nodo, N - 1, idAmbiente);//3

            if (nodo >= 0) {
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("N", N + "");
                variables.put("nodo", nodo + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 3, 2, variables));
            } else {
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("N", N + "");
                variables.put("nodo", nodo + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 3, 4, variables));
            }
        }
        for (int nodo = N - 1; nodo >= 0; nodo--) {//4

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("N", N + "");
            variables.put("nodo", nodo + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 4, 5, variables));

            int tmp = array[0];//5

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("N", N + "");
            variables.put("nodo", nodo + "");
            variables.put("tmp", tmp + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 5, 6, variables));

            array[0] = array[nodo];//6

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("N", N + "");
            variables.put("nodo", nodo + "");
            variables.put("tmp", tmp + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 6, 7, variables));

            array[nodo] = tmp;//7

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("N", N + "");
            variables.put("nodo", nodo + "");
            variables.put("tmp", tmp + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 7, 9, variables));

            this.ambientes++;
            hacerMonticulo(array, 0, nodo - 1, idAmbiente);//8

            if (nodo >= 0) {
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("N", N + "");
                variables.put("nodo", nodo + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 8, 4, variables));
            } else {
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("N", N + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("HeapSort", padre, idAmbiente, 8, 0, variables));
            }

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
        HashMap<String, String> variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("nodo", nodo + "");
        variables.put("fin", fin + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 9, 10, variables));

        int izq = 2 * nodo + 1;//10

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("nodo", nodo + "");
        variables.put("fin", fin + "");
        variables.put("izq", izq + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 10, 11, variables));

        int der = izq + 1;//11

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("nodo", nodo + "");
        variables.put("fin", fin + "");
        variables.put("izq", izq + "");
        variables.put("der", der + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 11, 12, variables));

        int may;//12

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("nodo", nodo + "");
        variables.put("fin", fin + "");
        variables.put("izq", izq + "");
        variables.put("der", der + "");
        variables.put("may", "null");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 12, 13, variables));

        if (izq > fin) {//13
            if (this.getRegistroAmbientes().get(this.getRegistroAmbientes().size() - 5).get(0).get("linea").equalsIgnoreCase("2")) {
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("nodo", nodo + "");
                variables.put("fin", fin + "");
                variables.put("izq", izq + "");
                variables.put("der", der + "");
                variables.put("may", "null");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 13, 3, variables));
            } else if (this.getRegistroAmbientes().get(this.getRegistroAmbientes().size() - 5).get(0).get("linea").equalsIgnoreCase("7")) {
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("nodo", nodo + "");
                variables.put("fin", fin + "");
                variables.put("izq", izq + "");
                variables.put("der", der + "");
                variables.put("may", "null");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 13, 8, variables));
            } else if ((this.getRegistroAmbientes().get(this.getRegistroAmbientes().size() - 5).get(0).get("linea").equalsIgnoreCase("25"))) {
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("nodo", nodo + "");
                variables.put("fin", fin + "");
                variables.put("izq", izq + "");
                variables.put("der", der + "");
                variables.put("may", "null");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 13, 26, variables));
            }

            return;//14
        } else {
            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", "null");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 13, 15, variables));
        }
        if (der > fin) {//15

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", "null");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 15, 16, variables));

            may = izq;//16

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", may + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 16, 22, variables));

        } else {//17

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", "null");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 15, 18, variables));

            if (array[izq] > array[der]) {//18

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("nodo", nodo + "");
                variables.put("fin", fin + "");
                variables.put("izq", izq + "");
                variables.put("der", der + "");
                variables.put("may", "null");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 18, 19, variables));

                may = izq;//19

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("nodo", nodo + "");
                variables.put("fin", fin + "");
                variables.put("izq", izq + "");
                variables.put("der", der + "");
                variables.put("may", may + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 19, 22, variables));

            } else {//20

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("nodo", nodo + "");
                variables.put("fin", fin + "");
                variables.put("izq", izq + "");
                variables.put("der", der + "");
                variables.put("may", "null");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 18, 21, variables));

                may = der;//21

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("nodo", nodo + "");
                variables.put("fin", fin + "");
                variables.put("izq", izq + "");
                variables.put("der", der + "");
                variables.put("may", may + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 21, 22, variables));
            }

        }

        boolean entra = false;
        if (array[nodo] < array[may]) {//22
            entra = true;
            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", may + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 22, 23, variables));

            int tmp = array[nodo];//23

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", may + "");
            variables.put("tmp", tmp + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 23, 24, variables));

            array[nodo] = array[may];//24

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", may + "");
            variables.put("tmp", tmp + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 24, 25, variables));

            array[may] = tmp;//25

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", may + "");
            variables.put("tmp", tmp + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 25, 9, variables));

            this.ambientes++;
            hacerMonticulo(array, may, fin, idAmbiente);//26
        }
        if (entra) {
            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", may + "");
            int anter = this.hallarLineaAnterior();
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 26, anter, variables));
        } else {
            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("nodo", nodo + "");
            variables.put("fin", fin + "");
            variables.put("izq", izq + "");
            variables.put("der", der + "");
            variables.put("may", may + "");
            int anter = this.hallarLineaAnterior();
            this.getRegistroAmbientes().add(this.metodos.generarEstado("hacerMonticulo", padre, idAmbiente, 26, anter, variables));
        }
        int a = 2;

    }

    private int hallarLineaAnterior() {

        int num = -1;
        for (int i = this.getRegistroAmbientes().size() - 1; i >= 0; i--) {
            if (this.getRegistroAmbientes().get(i).get(0).get("linea").equalsIgnoreCase("9")) {
                int n = Integer.parseInt(this.getRegistroAmbientes().get(i - 1).get(0).get("linea"));
                num = (n + 1);
                break;
            }
        }
        return num;
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
