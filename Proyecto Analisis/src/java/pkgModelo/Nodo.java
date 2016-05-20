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
    private String dato;
    private LinkedList<Nodo> hijos;

    public Nodo(String dato) {
        this.dato = dato;
        this.hijos = new LinkedList<>();
    }
    
    public String obtenerEstructuraDeNososJSON(){
        String json = "{\"text\": {\"desc\": \""+this.dato+"\"}";
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
    public void adicionarHijo(String dato){
        this.hijos.add(new Nodo(dato));
    }
    
    public boolean esHoja(){
        return this.hijos.isEmpty();
    }

    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(String dato) {
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
