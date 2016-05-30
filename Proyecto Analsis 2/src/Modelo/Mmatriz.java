/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Andres
 */
public class Mmatriz {

    public Mmatriz() {
    }

    public int multiplicaionmatrices(int[] p) {
        int i = 1;
        int j = p.length - 1;
        return MatrixChainOrder(p, i, j);
    }

    private int MatrixChainOrder(int p[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder(p, i, k)+ MatrixChainOrder(p, k + 1, j)+ p[i - 1] * p[k] * p[j];
            if (count < min) {
                min = count;
            }
        }
        return min;
    }
}
