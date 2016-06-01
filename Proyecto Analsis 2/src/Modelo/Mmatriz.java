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
public class Mmatriz {

    int ambientes;
    private LinkedList<LinkedList<HashMap<String, String>>> registroAmbientes;
    private MetodosVarios metodos;

    public Mmatriz() {
        this.metodos = new MetodosVarios();
    }
    
    public String determinarComplejidad() {
        return "Θ(k^n) con 1,4 < k < 3 y n >= 2";
    }

    public int mult(int[] array) {//
        this.ambientes = 0;
        this.registroAmbientes = new LinkedList<>();
        return this.multiplicaionmatrices(array, 0);
    }

    private int multiplicaionmatrices(int[] array, int padre) {//0
//        int idAmbiente = this.ambientes;
//        HashMap<String, String> variables = new HashMap<>();
//        variables.put("array", this.metodos.arrayToString(array));
//        this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 0, 1, variables));

        int i = 1;//1

//        variables = new HashMap<>();
//        variables.put("array", this.metodos.arrayToString(array));
//        variables.put("i", i + "");
//        this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 1, 2, variables));

        int j = array.length - 1;//2

//        variables = new HashMap<>();
//        variables.put("array", this.metodos.arrayToString(array));
//        variables.put("i", i + "");
//        variables.put("j", j + "");
//        this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 2, 4, variables));

        return MatrixChainOrder(array, i, j, 0);//3
    }

    private int MatrixChainOrder(int[] array, int i, int j, int padre) {//4
        this.ambientes++;
        int idAmbiente = this.ambientes;
        HashMap<String, String> variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("i", i + "");
        variables.put("j", j + "");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 4, 5, variables));

        if (i == j) {//5
            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("i", i + "");
            variables.put("j", j + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 5, hallarLineaAnterior(), variables));
            return 0;//6
        } else {
            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("i", i + "");
            variables.put("j", j + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 5, 7, variables));
        }
        int min = Integer.MAX_VALUE;//7

        variables = new HashMap<>();
        variables.put("array", this.metodos.arrayToString(array));
        variables.put("i", i + "");
        variables.put("j", j + "");
        variables.put("min", "∞");
        this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 7, 8, variables));

        for (int k = i; k < j; k++) {//8

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("i", i + "");
            variables.put("j", j + "");
            variables.put("min", min == 2147483647?"∞":min+"");
            variables.put("k", k + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 8, 4, variables));

            int conjunto1 = MatrixChainOrder(array, i, k, idAmbiente);//9

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("i", i + "");
            variables.put("j", j + "");
            variables.put("min", min == 2147483647?"∞":min+"");
            variables.put("k", k + "");
            variables.put("conjunto1", conjunto1 + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 9, 4, variables));

            int conjunto2 = MatrixChainOrder(array, k + 1, j, idAmbiente);//10

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("i", i + "");
            variables.put("j", j + "");
            variables.put("min", min == 2147483647?"∞":min+"");
            variables.put("k", k + "");
            variables.put("conjunto1", conjunto1 + "");
            variables.put("conjunto2", conjunto2 + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 10, 11, variables));

            int count = conjunto1 + conjunto2 + array[i - 1] * array[k] * array[j];//11

            variables = new HashMap<>();
            variables.put("array", this.metodos.arrayToString(array));
            variables.put("i", i + "");
            variables.put("j", j + "");
            variables.put("min", min == 2147483647?"∞":min+"");
            variables.put("k", k + "");
            variables.put("conjunto1", conjunto1 + "");
            variables.put("conjunto2", conjunto2 + "");
            variables.put("count", count + "");
            this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 11, 12, variables));

            boolean entro = false;
            if (count < min) {//12
                entro = true;
                variables = new HashMap<>();
                variables.put("array", this.metodos.arrayToString(array));
                variables.put("i", i + "");
                variables.put("j", j + "");
                variables.put("min", min == 2147483647?"∞":min+"");
                variables.put("k", k + "");
                variables.put("conjunto1", conjunto1 + "");
                variables.put("conjunto2", conjunto2 + "");
                variables.put("count", count + "");
                this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 12, 13, variables));

                min = count;//13
            }
            if (entro) {
                if (k < j) {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    variables.put("min", min == 2147483647?"∞":min+"");
                    variables.put("k", k + "");
                    variables.put("conjunto1", conjunto1 + "");
                    variables.put("conjunto2", conjunto2 + "");
                    variables.put("count", count + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 13, 8, variables));
                } else {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    variables.put("min", min == 2147483647?"∞":min+"");
                    variables.put("k", k + "");
                    variables.put("conjunto1", conjunto1 + "");
                    variables.put("conjunto2", conjunto2 + "");
                    variables.put("count", count + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 13, this.hallarLineaAnterior(), variables));
                }
            } else {
                if (k < j) {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    variables.put("min", min == 2147483647?"∞":min+"");
                    variables.put("k", k + "");
                    variables.put("conjunto1", conjunto1 + "");
                    variables.put("conjunto2", conjunto2 + "");
                    variables.put("count", count + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 12, 8, variables));
                } else {
                    variables = new HashMap<>();
                    variables.put("array", this.metodos.arrayToString(array));
                    variables.put("i", i + "");
                    variables.put("j", j + "");
                    variables.put("min", min == 2147483647?"∞":min+"");
                    variables.put("k", k + "");
                    variables.put("conjunto1", conjunto1 + "");
                    variables.put("conjunto2", conjunto2 + "");
                    variables.put("count", count + "");
                    this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 12, this.hallarLineaAnterior(), variables));
                }
            }

        }
        return min;//14
    }

    private int hallarLineaAnterior() {

        int num = -1;
        for (int i = this.getRegistroAmbientes().size() - 1; i >= 0; i--) {
            if (this.getRegistroAmbientes().get(i).get(0).get("linea").equalsIgnoreCase("4")) {
                int n = Integer.parseInt(this.getRegistroAmbientes().get(i - 1).get(0).get("linea"));
                num = (n + 1);
                break;
            }
        }
        return num;
    }
//    private int multiplicaionmatrices(int[] array,int padre) {
//        int idAmbiente = this.ambientes;
//        HashMap<String, String> variables = new HashMap<>();
//        variables.put("array", this.metodos.arrayToString(array));
//        this.getRegistroAmbientes().add(this.metodos.generarEstado("multiplicacionMatrices", padre, idAmbiente, 0, 1, variables));
//        
//        int i = 1;
//        int j = array.length - 1;
//        return MatrixChainOrder(array, i, j, idAmbiente);
//    }
//
//    private int MatrixChainOrder(int[] array, int i, int j, int padre) {
//        if (i == j) {
//            return 0;
//        }
//        int min = Integer.MAX_VALUE;
//        for (int k = i; k < j; k++) {
//            
//            
//            int count = MatrixChainOrder(array, i, k)+ MatrixChainOrder(array, k + 1, j)+ array[i - 1] * array[k] * array[j];
//            if (count < min) {
//                min = count;
//            }
//        }
//        return min;
//    }

    /**
     * @return the registroAmbientes
     */
    public LinkedList<LinkedList<HashMap<String, String>>> getRegistroAmbientes() {
        return registroAmbientes;
    }
}
