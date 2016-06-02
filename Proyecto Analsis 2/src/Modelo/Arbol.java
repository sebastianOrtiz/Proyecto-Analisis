/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.fsf
 */
package Modelo;

import java.util.LinkedList;

/**
 *
 * @author Sebas
 */
public class Arbol {

    private NodoArbol raiz;
    private int xMax = 30;
    private int yMax = 0;

    public Arbol() {
        this.raiz = null;
    }

    public void armarArbolDesdeListaDeNodos(LinkedList<Nodo> nodos, String algPp) {
        this.setRaiz(null);
        boolean ppl = false;
        if (nodos.get(0).getDato().equalsIgnoreCase(algPp)) {
            ppl = true;
        }
        this.setRaiz(new NodoArbol(nodos.get(0).getIdPropio(), ppl));
        this.insertarHijos(raiz, nodos, algPp);
    }
    LinkedList<Integer> ps;

    public int profundidadPromedio() {
        ps = new LinkedList<>();
        if (!raiz.esHoja()) {
            llenarProfundidades(raiz, 1);
            int sum = 0;
            for (Integer p : ps) {
                sum += p;
            }
            return sum / ps.size();
        } else {
            return 0;
        }

    }

    public LinkedList<Integer> obtenerProfundidades() {
        ps = new LinkedList<>();
        if (!raiz.esHoja()) {
            llenarProfundidades(raiz, 1);
        }
        return ps;
    }

    public LinkedList<Integer> obtenerProfundidadesQuickSort() {
        ps = new LinkedList<>();
        if (!raiz.esHoja()) {
            llenarProfundidadesQuickSort(raiz, 1);
        }
        return ps;
    }

    private void llenarProfundidades(NodoArbol nodo, int altura) {
        if (nodo.esHoja()) {
            this.ps.add(altura);
        } else {
            for (NodoArbol nodo1 : nodo.getHijos()) {
                llenarProfundidades(nodo1, altura + 1);
            }
        }
    }

    private void llenarProfundidadesQuickSort(NodoArbol nodo, int altura) {
        if (nodo.esHoja()) {
            this.ps.add(altura);
        } else {
            for (int i = 1; i < nodo.getHijos().size(); i++) {
                llenarProfundidadesQuickSort(nodo.getHijos().get(i), altura + 1);
            }
        }
    }

    public int profundidadMaxima(NodoArbol nodo, int altura) {
        if (nodo.esHoja()) {
            return altura;
        } else {
            int mayor = 0;
            for (NodoArbol nodo1 : nodo.getHijos()) {
                int temp = profundidadMaxima(nodo1, altura + 1);
                mayor = mayor < temp ? temp : mayor;
            }
            return mayor;
        }
    }

    public int profundidadMinima() {
        if (raiz.esHoja()) {
            return 0;
        } else {
            return profundidadMinima(raiz, Integer.MAX_VALUE);
        }

    }

    private int profundidadMinima(NodoArbol nodo, int minima) {
        if (nodo.esHoja()) {
            return minima;
        } else {
            int menor = 0;
            for (NodoArbol nodo1 : nodo.getHijos()) {
                int temp = profundidadMaxima(nodo1, minima + 1);
                menor = menor > temp ? temp : menor;
            }
            return menor;
        }
    }

    public void resetxMax() {
        this.xMax = 30;
    }

    private void insertarHijos(NodoArbol nodo, LinkedList<Nodo> nodos, String nomPp) {
        for (int i = 1; i < nodos.size(); i++) {
            if (nodos.get(i).getIdPadre().equalsIgnoreCase(nodo.getIdMio())) {
                boolean ppl = false;
                if(nodos.get(i).getDato().equalsIgnoreCase(nomPp)){
                    ppl = true;
                }
                nodo.adicionarHijo(nodos.get(i).getIdPropio(), ppl);
            }
        }
        if (!nodo.esHoja()) {
            for (NodoArbol nodoArbol : nodo.getHijos()) {
                this.insertarHijos(nodoArbol, nodos, nomPp);
            }
        }
    }

    private String imprimirArbol(NodoArbol nodo) {
        String salida = nodo.getIdMio();
        if (!nodo.esHoja()) {
            salida += "[";
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                salida += " " + this.imprimirArbol(nodo.getHijos().get(i));
            }
            salida += "]";
        }
        return salida;
    }

    @Override
    public String toString() {
        return this.imprimirArbol(getRaiz()); //To change body of generated methods, choose Tools | Templates.
    }

    public void reajustarPosiciones(int pivote) {
        int cantidad = pivote - raiz.getX();
        reajustar(cantidad, raiz);
    }

    private void reajustar(int cantidad, NodoArbol nodo) {
        nodo.setX(nodo.getX() + cantidad);
        if (!nodo.esHoja()) {
            for (NodoArbol nodo1 : nodo.getHijos()) {
                reajustar(cantidad, nodo1);
            }
        }
    }

    public void darPosiciones(NodoArbol nodo, int y) {
        if (y > getyMax()) {
            yMax = y;
        }

        if (nodo.esHoja()) {
            nodo.setX(this.getxMax());
            nodo.setY(y);
            this.xMax += 60;
        } else {
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                this.darPosiciones(nodo.getHijos().get(i), y + 60);
            }
            int maxXHijo = nodo.getHijos().getLast().getX();
            int minXHijo = nodo.getHijos().getFirst().getX();
            int xPadre = minXHijo + (maxXHijo - minXHijo) / 2;
            nodo.setX(xPadre);
            nodo.setY(y);
        }
    }

    /**
     * @return the raiz
     */
    public NodoArbol getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    /**
     * @return the xMax
     */
    public int getxMax() {
        return xMax;
    }

    /**
     * @return the yMax
     */
    public int getyMax() {
        return yMax;
    }

}
