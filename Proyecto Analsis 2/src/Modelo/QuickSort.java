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
 * @author Sebas
 */
public class QuickSort {

    int ambientes;
    private LinkedList<LinkedList<HashMap<String, String>>> registroAmbientes;
    private MetodosVarios metodos;

    public QuickSort() {
this.metodos = new MetodosVarios();
    }
    
//    public LinkedList<Nodo> generarNodos(LinkedList<LinkedList<HashMap<String, String>>> estados){
//        LinkedList<Nodo> nodos = new LinkedList<>();
//        LinkedList<String> guardados = new LinkedList<>();
//        for (LinkedList<HashMap<String, String>> estado : estados) {
//           if(!guardados.contains(estado.getFirst().get("idMio"))){
//               guardados.add(estado.getFirst().get("idMio"));
//               nodos.add(new Nodo(estado.getFirst().get("idPadre"), estado.getFirst().get("idMio"), estado.getFirst().get("nombre")));
//               
//           }
//        }
//        
//        return nodos;
//    }
    
    
//    private LinkedList<HashMap<String, String>> generarEstado(String nombreMetodo, int padre, int mio, int linea, int lineaSiguiente, HashMap<String, String> variables) {
//        HashMap<String, String> datos = new HashMap<>();
//        datos.put("nombre", nombreMetodo);
//        datos.put("idPadre", "" + padre);
//        datos.put("idMio", "" + mio);
//        datos.put("linea", "" + linea);
//        datos.put("lineaSiguiente", "" + lineaSiguiente);
//        LinkedList<HashMap<String, String>> estado = new LinkedList<>();
//        estado.add(datos);
//        estado.add(variables);
//        return estado;
//    }

//    private String arrayToString(int[] array) {
//        String salida = "[";
//        for (int i = 0; i < array.length; i++) {
//            if (i != array.length - 1) {
//                salida += array[i] + ", ";
//            } else {
//                salida += array[i] + "";
//            }
//
//        }
//        salida += "]";
//        return salida;
//    }

    public void QuickSort(int[] array) {
        this.ambientes = 1;
        this.registroAmbientes = new LinkedList<>();
        QuickSort(array, 0, array.length - 1, 0);
    }

    public void QuickSort(int[] array, int p, int r, int padre) {
        int idAmbiente = this.ambientes;
        HashMap<String, String> variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("p", p + "");
        variables.put("r", r + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 0, 1, variables));

        if (p < r) {

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("p", p + "");
            variables.put("r", r + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 1, 5, variables));

            this.ambientes++;
            int q = Partition(array, p, r, idAmbiente);

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("p", p + "");
            variables.put("r", r + "");
            variables.put("q", q + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 2, 3, variables));

            this.ambientes++;
            QuickSort(array, p, q - 1, idAmbiente);

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("p", p + "");
            variables.put("r", r + "");
            variables.put("q", q + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 3, 4, variables));

            this.ambientes++;
            QuickSort(array, q + 1, r, idAmbiente);

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("p", p + "");
            variables.put("r", r + "");
            variables.put("q", q + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 4, 0, variables));
        }else{
            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("p", p + "");
            variables.put("r", r + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("QuickSort", padre, idAmbiente, 0, 0, variables));
        }
    }

//    public void QuickSort(int[] array, int p, int r, int padre) {
//        if (p < r) {
//            int q = Partition(array, p, r, 0);
//            QuickSort(array, p, q - 1, 0);
//            QuickSort(array, q + 1, r, 0);
//        }
//    }
    public int Partition(int[] array, int p, int r, int padre) {//6
        int idAmbiente = this.ambientes;
        HashMap<String, String> variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("p", p + "");
        variables.put("r", r + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 5, 6, variables));

        int pivot = array[p];//7

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("p", p + "");
        variables.put("r", r + "");
        variables.put("pivot", pivot + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 6, 7, variables));

        int i = p;//8

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("p", p + "");
        variables.put("r", r + "");
        variables.put("pivot", pivot + "");
        variables.put("i", i + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 7, 8, variables));

        int j = r;//9

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("p", p + "");
        variables.put("r", r + "");
        variables.put("pivot", pivot + "");
        variables.put("i", i + "");
        variables.put("j", j + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 8, 9, variables));

        while (i < j) {//10

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("p", p + "");
            variables.put("r", r + "");
            variables.put("pivot", pivot + "");
            variables.put("i", i + "");
            variables.put("j", j + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 9, 10, variables));

            while (array[i] <= pivot && i < r) {//11

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("p", p + "");
                variables.put("r", r + "");
                variables.put("pivot", pivot + "");
                variables.put("i", i + "");
                variables.put("j", j + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 10, 11, variables));

                i++;//12

                if (array[i] <= pivot && i < r) {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("p", p + "");
                    variables.put("r", r + "");
                    variables.put("pivot", pivot + "");
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 11, 10, variables));
                } else {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("p", p + "");
                    variables.put("r", r + "");
                    variables.put("pivot", pivot + "");
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 11, 12, variables));
                }

            }
            while (array[j] > pivot && j >= p) {//13

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("p", p + "");
                variables.put("r", r + "");
                variables.put("pivot", pivot + "");
                variables.put("i", i + "");
                variables.put("j", j + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 12, 13, variables));

                j--;//14

                if (array[j] > pivot && j >= p) {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("p", p + "");
                    variables.put("r", r + "");
                    variables.put("pivot", pivot + "");
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 13, 12, variables));
                } else {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("p", p + "");
                    variables.put("r", r + "");
                    variables.put("pivot", pivot + "");
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 13, 14, variables));
                }
            }
            if (i < j) {//15

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("p", p + "");
                variables.put("r", r + "");
                variables.put("pivot", pivot + "");
                variables.put("i", i + "");
                variables.put("j", j + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 14, 15, variables));

                int aux = array[i];//16

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("p", p + "");
                variables.put("r", r + "");
                variables.put("pivot", pivot + "");
                variables.put("i", i + "");
                variables.put("j", j + "");
                variables.put("aux", aux + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 15, 16, variables));

                array[i] = array[j];//17

                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("p", p + "");
                variables.put("r", r + "");
                variables.put("pivot", pivot + "");
                variables.put("i", i + "");
                variables.put("j", j + "");
                variables.put("aux", aux + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 16, 17, variables));

                array[j] = aux;//18

                if (i < j) {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("p", p + "");
                    variables.put("r", r + "");
                    variables.put("pivot", pivot + "");
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    variables.put("aux", aux + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 17, 9, variables));
                } else {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("p", p + "");
                    variables.put("r", r + "");
                    variables.put("pivot", pivot + "");
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    variables.put("aux", aux + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 17, 18, variables));
                }

            } else {
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("p", p + "");
                variables.put("r", r + "");
                variables.put("pivot", pivot + "");
                variables.put("i", i + "");
                variables.put("j", j + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 14, 18, variables));
            }
        }
        int aux = array[p];//19

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("p", p + "");
        variables.put("r", r + "");
        variables.put("pivot", pivot + "");
        variables.put("i", i + "");
        variables.put("j", j + "");
        variables.put("aux", aux + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 18, 19, variables));

        array[p] = array[j];//20
        
        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("p", p + "");
        variables.put("r", r + "");
        variables.put("pivot", pivot + "");
        variables.put("i", i + "");
        variables.put("j", j + "");
        variables.put("aux", aux + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 19, 20, variables));
        
        array[j] = aux;//21
        
        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("p", p + "");
        variables.put("r", r + "");
        variables.put("pivot", pivot + "");
        variables.put("i", i + "");
        variables.put("j", j + "");
        variables.put("aux", aux + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("Partition", padre, idAmbiente, 20, 2, variables));
        
        return j;//22
    }

//    public int Partition(int[] array, int p, int r, int padre) {
//        int pivot = array[p];
//        int i = p;
//        int j = r;
//        while (i < j) {
//            while (array[i] <= pivot && i < r) {
//                i++;
//            }
//            while (array[j] > pivot && j >= p) {
//                j--;
//            }
//            if (i < j) {
//                int aux = array[i];
//                array[i] = array[j];
//                array[j] = aux;
//            }
//        }
//        int aux = array[p];
//        array[p] = array[j];
//        array[j] = aux;
//        return j;
//    }
    /**
     * @return the registroQuickSort
     */
    public LinkedList<LinkedList<HashMap<String, String>>> getRegistroAmbientes() {
        return registroAmbientes;
    }
}
