/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Sebas
 */
public class InsertionSort {

    public void InsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int copiaNumero = array[i];
            int j = i;
            while (j > 0 && copiaNumero < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = copiaNumero;
        }
    }
}

