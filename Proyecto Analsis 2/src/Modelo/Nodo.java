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
public class Nodo {
    private String idPadre;
    private String idPropio;
    private String dato;

    public Nodo(String idPadre, String idPropio, String dato) {
        this.idPadre = idPadre;
        this.idPropio = idPropio;
        this.dato = dato;
    }

    @Override
    public String toString() {
        return idPadre+" "+ idPropio+" "+dato ; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the idPadre
     */
    public String getIdPadre() {
        return idPadre;
    }

    /**
     * @param idPadre the idPadre to set
     */
    public void setIdPadre(String idPadre) {
        this.idPadre = idPadre;
    }

    /**
     * @return the idPropio
     */
    public String getIdPropio() {
        return idPropio;
    }

    /**
     * @param idPropio the idPropio to set
     */
    public void setIdPropio(String idPropio) {
        this.idPropio = idPropio;
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
}
