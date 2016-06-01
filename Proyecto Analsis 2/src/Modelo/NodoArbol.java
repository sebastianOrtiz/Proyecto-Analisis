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
public class NodoArbol {
    private String idMio;
    private LinkedList<NodoArbol> hijos;
    private int x;
    private int y;

    public NodoArbol() {
    }

    public NodoArbol(String idMio) {
        this.idMio = idMio;
        this.hijos = new LinkedList<>();
    }
    
    public void adicionarHijo(String id){
        hijos.add(new NodoArbol(id));
    }
    
    public boolean esHoja(){
        return hijos.isEmpty();
    }
    /**
     * @return the idMio
     */
    public String getIdMio() {
        return idMio;
    }

    /**
     * @param idMio the idMio to set
     */
    public void setIdMio(String idMio) {
        this.idMio = idMio;
    }

    /**
     * @return the hijos
     */
    public LinkedList<NodoArbol> getHijos() {
        return hijos;
    }

    /**
     * @param hijos the hijos to set
     */
    public void setHijos(LinkedList<NodoArbol> hijos) {
        this.hijos = hijos;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
