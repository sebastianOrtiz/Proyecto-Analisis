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
public class QuickSort {
    
    public void QuickSort(int[] array) {
        QuickSort(array, 0, array.length-1);
    }

    public void QuickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = Partition(array, p, r);
            QuickSort(array, p, q - 1);
            QuickSort(array, q + 1, r);
        }
    }

    public int Partition(int[] array, int p, int r) {
        int pivot = array[p];
        int i = p;
        int j = r;
        while (i < j) {
            while (array[i] <= pivot && i < r) {
                i++;
            }
            while (array[j] > pivot && j >= p) {
                j--;
            }
            if (i < j) {
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }
        int aux = array[p];
        array[p] = array[j];
        array[j] = aux;
        return j;
    }
}
