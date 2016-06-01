/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Principal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Sebas
 */
public class Sudoku {

    public static final int DIMENSION = 9;
    private int[][] tablero;
    private int ambientes;
    private LinkedList<LinkedList<HashMap<String, String>>> registroAmbientes;
    private MetodosVarios metodos;

    public Sudoku() {
        this.metodos = new MetodosVarios();
    }

    public int[][] cadenaToMatriz(String cadena) {
        String[] elementos = cadena.split(",");
        int[][] mat = new int[DIMENSION][DIMENSION];
        int k = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                mat[i][j] = Integer.parseInt(elementos[k]);
                k++;
            }

        }
        return mat;
    }

    public void cargarSudoku() {
        this.setTablero(new int[DIMENSION][DIMENSION]);
        File a = new File("Sudoku.txt");
        FileReader fr;
        try {
            fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                String[] l = linea.split(",");
                for (int j = 0; j < DIMENSION; j++) {
                    getTablero()[i][j] = Integer.parseInt(l[j]);
                }
                i++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void imprimir(int[][] tablero) {
        for (int i = 0; i < DIMENSION; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            for (int j = 0; j < DIMENSION; j++) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    public boolean resolver(int[][] tablero) {
        this.ambientes = 1;
        this.registroAmbientes = new LinkedList<>();
        HashMap<String, String> variables = new HashMap<>();
        variables.put("tablero", this.lineaDeTablero(tablero));
        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", 0, 1, 0, 7, variables));
        return resolver(tablero, 0);
    }

    public String lineaDeTablero(int[][] tablero) {
        String salida = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (j == tablero.length - 1 && i == tablero.length - 1) {
                    salida += tablero[i][j] + "";
                } else {
                    salida += tablero[i][j] + ",";
                }
            }

        }
        return salida;
    }

//    public boolean resolver(int[][] tablero, int padre) {//0
//        int idAmbiente = this.ambientes;
//        HashMap<String, String> variables = new HashMap<>();
//        variables.put("tablero", this.lineaDeTablero(tablero));
//        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 0, 1, variables));
//
//        for (int i = 0; i < DIMENSION; i++) {//1
//
//            variables = new HashMap<>();
//            variables.put("tablero", this.lineaDeTablero(tablero));
//            variables.put("i", i + "");
//            this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 1, 2, variables));
//
//            for (int j = 0; j < DIMENSION; j++) {//2
//
//                variables = new HashMap<>();
//                variables.put("tablero", this.lineaDeTablero(tablero));
//                variables.put("i", i + "");
//                variables.put("j", j + "");
//                this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 2, 3, variables));
//
//                if (tablero[i][j] != 0) {//3
//
//                    variables = new HashMap<>();
//                    variables.put("tablero", this.lineaDeTablero(tablero));
//                    variables.put("i", i + "");
//                    variables.put("j", j + "");
//                    this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 3, 5, variables));
//
//                    continue;//4
//
//                } else {
//                    variables = new HashMap<>();
//                    variables.put("tablero", this.lineaDeTablero(tablero));
//                    variables.put("i", i + "");
//                    variables.put("j", j + "");
//                    this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 3, 5, variables));
//                }
//                for (int k = 1; k <= 9; k++) {//5
//
//                    variables = new HashMap<>();
//                    variables.put("tablero", this.lineaDeTablero(tablero));
//                    variables.put("i", i + "");
//                    variables.put("j", j + "");
//                    variables.put("k", k + "");
//                    this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 5, 6, variables));
//
//                    if (esPosibleInsertar(tablero, i, j, k)) {//6
//
//                        variables = new HashMap<>();
//                        variables.put("tablero", this.lineaDeTablero(tablero));
//                        variables.put("i", i + "");
//                        variables.put("j", j + "");
//                        variables.put("k", k + "");
//                        variables.put("esPosibleInsertar", "true");
//                        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 6, 7, variables));
//
//                        tablero[i][j] = k;//7
//
//                        variables = new HashMap<>();
//                        variables.put("tablero", this.lineaDeTablero(tablero));
//                        variables.put("i", i + "");
//                        variables.put("j", j + "");
//                        variables.put("k", k + "");
//                        variables.put("esPosibleInsertar", "true");
//                        variables.put("tablero[i][j]", tablero[i][j] + "");
//                        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 7, 0, variables));
//
//                        boolean b = resolver(tablero, idAmbiente);//8
//
//                        variables = new HashMap<>();
//                        variables.put("tablero", this.lineaDeTablero(tablero));
//                        variables.put("i", i + "");
//                        variables.put("j", j + "");
//                        variables.put("k", k + "");
//                        variables.put("esPosibleInsertar", "true");
//                        variables.put("tablero[i][j]", tablero[i][j] + "");
//                        variables.put("b", b + "");
//                        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 8, 9, variables));
//
//                        if (b) {//9
//
//                            variables = new HashMap<>();
//                            variables.put("tablero", this.lineaDeTablero(tablero));
//                            variables.put("i", i + "");
//                            variables.put("j", j + "");
//                            variables.put("k", k + "");
//                            variables.put("esPosibleInsertar", "true");
//                            variables.put("tablero[i][j]", tablero[i][j] + "");
//                            variables.put("b", b + "");
//                            this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 9, 8, variables));
//
//                            return true;//10
//                        } else {
//                            variables = new HashMap<>();
//                            variables.put("tablero", this.lineaDeTablero(tablero));
//                            variables.put("i", i + "");
//                            variables.put("j", j + "");
//                            variables.put("k", k + "");
//                            variables.put("esPosibleInsertar", "true");
//                            variables.put("tablero[i][j]", tablero[i][j] + "");
//                            variables.put("b", b + "");
//                            this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 9, 11, variables));
//                        }
//                        tablero[i][j] = 0;//11
//
//                    }
//
//                    if (k <= 9) {
//                        variables = new HashMap<>();
//                        variables.put("tablero", this.lineaDeTablero(tablero));
//                        variables.put("i", i + "");
//                        variables.put("j", j + "");
//                        variables.put("k", k + "");
//                        variables.put("esPosibleInsertar", "true");
//                        variables.put("tablero[i][j]", tablero[i][j] + "");
//                        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 11, 5, variables));
//                    } else {
//                        variables = new HashMap<>();
//                        variables.put("tablero", this.lineaDeTablero(tablero));
//                        variables.put("i", i + "");
//                        variables.put("j", j + "");
//                        variables.put("k", k + "");
//                        variables.put("esPosibleInsertar", "true");
//                        variables.put("tablero[i][j]", tablero[i][j] + "");
//                        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 11, 8, variables));
//                    }
//                }
//                return false;//12
//            }
//            if (i < DIMENSION) {
//                variables = new HashMap<>();
//                variables.put("tablero", this.lineaDeTablero(tablero));
//                this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 11, 1, variables));
//            }
//
//        }
//        variables = new HashMap<>();
//        variables.put("tablero", this.lineaDeTablero(tablero));
//        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 11, 8, variables));
//
//        return true;//15
//    }
    public boolean resolver(int[][] tablero, int padre) {//0
        int idAmbiente = this.ambientes;

        for (int i = 0; i < DIMENSION; i++) {//1
            for (int j = 0; j < DIMENSION; j++) {//2
                if (tablero[i][j] != 0) {//3
                    continue;//4

                }
                for (int k = 1; k <= 9; k++) {//5
                    if (esPosibleInsertar(tablero, i, j, k)) {//6
                        tablero[i][j] = k;//7
                        HashMap<String, String>variables = new HashMap<>();
                        variables.put("tablero", this.lineaDeTablero(tablero));
                        variables.put("tablero[i][j]", tablero[i][j] + "");
                        variables.put("k", k+"");
                        variables.put("j", j+"");
                        variables.put("i", i+"");
                        
                        this.getRegistroAmbientes().add(this.metodos.generarEstado("resolver", padre, idAmbiente, 7, 0, variables));
                        this.ambientes++;
                        boolean b = resolver(tablero, idAmbiente);//8
                        if (b) {//9
                            return true;//10
                        }
                        tablero[i][j] = 0;//11
                    }
                }
                return false;//12
            }
        }
        return true;//15
    }
//    public boolean resolver(int[][] tablero) {//0
//        for (int i = 0; i < DIMENSION; i++) {//1
//            for (int j = 0; j < DIMENSION; j++) {//2
//                if (tablero[i][j] != 0) {//3
//                    continue;//4
//
//                }
//                for (int k = 1; k <= 9; k++) {//5
//                    if (esPosibleInsertar(tablero, i, j, k)) {//6
//                        tablero[i][j] = k;//7
//                        boolean b = resolver(tablero);//8
//                        if (b) {//9
//                            return true;//10
//                        }
//                        tablero[i][j] = 0;//11
//                    }
//                }
//                return false;//12
//            }
//        }
//        return true;//15
//    }

    public boolean esPosibleInsertar(int[][] tablero,
            int i, int j, int valor) {
//Comprueba columna
        for (int a = 0; a < DIMENSION; a++) {
            if (a != i && tablero[a][j] == valor) {
                return false;
            }
        }
//Comprueba fila
        for (int a = 0; a < DIMENSION; a++) {
            if (a != j && tablero[i][a] == valor) {
                return false;
            }
        }
//Comprueba cuadardo
        int y = (i / 3) * 3;
        int x = (j / 3) * 3;
        for (int a = 0; a < DIMENSION / 3; a++) {
            for (int b = 0; b < DIMENSION / 3; b++) {
                if (a != i && b != j && tablero[y + a][x + b] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return the tablero
     */
    public int[][] getTablero() {
        return tablero;
    }

    /**
     * @param tablero the tablero to set
     */
    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    /**
     * @return the registroAmbientes
     */
    public LinkedList<LinkedList<HashMap<String, String>>> getRegistroAmbientes() {
        return registroAmbientes;
    }
}
