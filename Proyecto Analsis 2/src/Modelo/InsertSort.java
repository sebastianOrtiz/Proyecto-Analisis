package Modelo;

public class InsertSort {
    
    

    public InsertSort() {
    }

    private int Sort(int[] arr,int maxIndex) {
        if (maxIndex <= 1) {
            //En este punto MaxIndex apunta al segundo elemento del arreglo
            return maxIndex;
        }

        maxIndex = Sort(arr,maxIndex - 1);  // recursive call

        // guarda una copia del valor que esta en la variable 'key'.
        // este valor sera posicionado en la posicion correcta.
        
        int key = arr[maxIndex];  

        int i = maxIndex - 1;

        // compara el valor de 'key' con todos los elementos del arreglo
        // que van despues del elemento
        while ((i >= 0) && (arr[i] > key)) {
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = key;
        
        return maxIndex + 1;
    }
}
