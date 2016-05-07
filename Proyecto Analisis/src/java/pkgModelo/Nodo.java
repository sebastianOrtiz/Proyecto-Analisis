/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import java.util.LinkedList;

/**
 *
 * @author Sebas
 */
public class Nodo {
    private Dato dato;
    private LinkedList<Nodo> hijos;

    public Nodo(Dato dato) {
        this.dato = dato;
        this.hijos = new LinkedList<>();
    }
    
    public String obtenerEstructuraDeNososJSON(){
        String json = "{"+this.dato.toString();
        if(!this.esHoja()){
            json=json+",\"children\": [";
            for (int i = 0; i < this.hijos.size(); i++) {
                json=json+this.hijos.get(i).obtenerEstructuraDeNososJSON();
                if(i<this.hijos.size()-1){
                    json=json+",";
                }   
            }
            json= json+"]";
        }
        json = json+"}";
        return json;
    }
    public void adicionarHijo(Dato dato){
        this.hijos.add(new Nodo(dato));
    }
    
    public boolean esHoja(){
        return this.hijos.isEmpty();
    }

    /**
     * @return the dato
     */
    public Dato getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Dato dato) {
        this.dato = dato;
    }

    /**
     * @return the hijos
     */
    public LinkedList<Nodo> getHijos() {
        return hijos;
    }

    /**
     * @param hijos the hijos to set
     */
    public void setHijos(LinkedList<Nodo> hijos) {
        this.hijos = hijos;
    }
    
}
