/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public Arbol() {
        this.raiz = null;
    }

    public void armarArbolDesdeListaDeNodos(LinkedList<Nodo> nodos) {
        this.setRaiz(null);
        this.setRaiz(new NodoArbol(nodos.get(0).getIdPropio()));
        this.insertarHijos(raiz, nodos);
    }
    
    public void resetxMax(){
        this.xMax = 30;
    }
    private void insertarHijos(NodoArbol nodo, LinkedList<Nodo> nodos) {
        for (int i = 1; i < nodos.size(); i++) {
            if (nodos.get(i).getIdPadre().equalsIgnoreCase(nodo.getIdMio())) {
                nodo.adicionarHijo(nodos.get(i).getIdPropio());
            }
        }
        if (!nodo.esHoja()) {
            for (NodoArbol nodoArbol : nodo.getHijos()) {
                this.insertarHijos(nodoArbol, nodos);
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

    public void darPosiciones(NodoArbol nodo, int y) {
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
            int xPadre = minXHijo+(maxXHijo-minXHijo)/2;
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

}
