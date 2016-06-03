package Modelo;

import java.util.HashMap;
import java.util.LinkedList;

public class InsertSort {

    private int ambientes;
    private LinkedList<LinkedList<HashMap<String, String>>> registroAmbientes;
    private MetodosVarios metodos;
    private int ejecuciones;
    private int tamañoEntradaDeDatos;

    public InsertSort() {
        this.metodos = new MetodosVarios();
        this.ejecuciones = 0;
    }

    public String determinarComplejidad() {
        String complejidad = "";
        if (ejecuciones == tamañoEntradaDeDatos) {
            complejidad = "T(n) = O(n)";
        } else {
            double pivote = ((((tamañoEntradaDeDatos * tamañoEntradaDeDatos) / 2) + (tamañoEntradaDeDatos / 2)) / 2) - (tamañoEntradaDeDatos / 2);
            if (ejecuciones <= pivote) {
                complejidad = "T(n) = O(n)";
            } else {
                complejidad = "T(n) = O(n^2)";
            }
        }

        return complejidad;
    }

    public void Sort(int[] array) {
        this.ejecuciones = 0;
        this.tamañoEntradaDeDatos = array.length;
        this.ambientes = 1;
        this.registroAmbientes = new LinkedList<>();
        Sort(array, array.length, 0);
    }

    public int Sort(int[] array, int maxIndex, int padre) {//0
        this.ejecuciones++;
        int idAmbiente = this.ambientes;
        HashMap<String, String> variables = new HashMap<>();
        variables.put("array", metodos.arrayToString(array));
        variables.put("maxIndex", maxIndex + "");
        this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 0, 1, variables));

        if (maxIndex <= 1) {//1
            variables = new HashMap<>();
            variables.put("array", metodos.arrayToString(array));
            variables.put("maxIndex", maxIndex + "");
            this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 1, 3, variables));
            //En este punto MaxIndex apunta al segundo elemento del arreglo
            return maxIndex;//2
        } else {
            variables = new HashMap<>();
            variables.put("array", metodos.arrayToString(array));
            variables.put("maxIndex", maxIndex + "");
            this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 1, 0, variables));
        }

        this.ambientes++;
        maxIndex = Sort(array, maxIndex - 1, idAmbiente);  // recursive call//3

        variables = new HashMap<>();
        variables.put("array", metodos.arrayToString(array));
        variables.put("maxIndex", maxIndex + "");
        this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 3, 4, variables));
        //guarda una copia del valor que esta en la variable 'key'.
        //este valor sera posicionado en la posicion correcta.

        int key = array[maxIndex];  //4

        variables = new HashMap<>();
        variables.put("array", metodos.arrayToString(array));
        variables.put("maxIndex", maxIndex + "");
        variables.put("key", key + "");
        this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 4, 5, variables));

        int i = maxIndex - 1;//5

        variables = new HashMap<>();
        variables.put("array", metodos.arrayToString(array));
        variables.put("maxIndex", maxIndex + "");
        variables.put("key", key + "");
        variables.put("i", i + "");
        this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 5, 6, variables));

        //compara el valor de 'key' con todos los elementos del arreglo
        //que van despues del elemento
        while ((i >= 0) && (array[i] > key)) { //6
            this.ejecuciones++;
            variables = new HashMap<>();
            variables.put("array", metodos.arrayToString(array));
            variables.put("maxIndex", maxIndex + "");
            variables.put("key", key + "");
            variables.put("i", i + "");
            this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 6, 7, variables));

            array[i + 1] = array[i]; //7

            variables = new HashMap<>();
            variables.put("array", metodos.arrayToString(array));
            variables.put("maxIndex", maxIndex + "");
            variables.put("key", key + "");
            variables.put("i", i + "");
            this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 7, 8, variables));

            i--;//8

            if ((i >= 0) && (array[i] > key)) {
                variables = new HashMap<>();
                variables.put("array", metodos.arrayToString(array));
                variables.put("maxIndex", maxIndex + "");
                variables.put("key", key + "");
                variables.put("i", i + "");
                this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 8, 6, variables));
            } else {
                variables = new HashMap<>();
                variables.put("array", metodos.arrayToString(array));
                variables.put("maxIndex", maxIndex + "");
                variables.put("key", key + "");
                variables.put("i", i + "");
                this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 8, 9, variables));
            }
        }
        array[i + 1] = key;//9

        variables = new HashMap<>();
        variables.put("array", metodos.arrayToString(array));
        variables.put("maxIndex", maxIndex + "");
        variables.put("key", key + "");
        variables.put("i", i + "");
        this.getRegistroAmbientes().add(metodos.generarEstado("InsertSort", padre, idAmbiente, 9, 3, variables));

        return maxIndex + 1;//10
    }

////    public int Sort2(int[] array, int maxIndex, int padre) {//0
////        int idAmbiente = this.ambientes;
////
////        if (maxIndex <= 1) {//1
////            //En este punto MaxIndex apunta al segundo elemento del arreglo
////            return maxIndex;//2
////        } 
////
////        this.ambientes++;
////        maxIndex = Sort2(array, maxIndex - 1, idAmbiente);  // recursive call//3
////
////        // guarda una copia del valor que esta en la variable 'key'.
////        // este valor sera posicionado en la posicion correcta.
////
////        int key = array[maxIndex];  //4
////
////        int i = maxIndex - 1;//5
////
////        // compara el valor de 'key' con todos los elementos del arreglo
////        // que van despues del elemento
////        while ((i >= 0) && (array[i] > key)) { //6
////            array[i + 1] = array[i]; //7
////            i--;//8
////
////        }
////        array[i + 1] = key;//9
////
////
////        return maxIndex + 1;//10
////    }
    /**
     * @return the registroAmbientes
     */
    public LinkedList<LinkedList<HashMap<String, String>>> getRegistroAmbientes() {
        return registroAmbientes;
    }
}
