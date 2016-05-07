/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

/**
 *
 * @author Sebas
 */
public class Dato {
    private String idNodo;
    private String contenido;
    

    public Dato(String idNodo, String contenido) {
        this.idNodo = idNodo;
        this.contenido = contenido;
    }

    public Dato() {
    }

    @Override
    public String toString() {
        return "\"text\": {\"name\": \""+this.idNodo+"\",\"desc\": \""+this.contenido+"\"}";
    }

    /**
     * @return the idNodo
     */
    public String getIdNodo() {
        return idNodo;
    }

    /**
     * @param idNodo the idNodo to set
     */
    public void setIdNodo(String idNodo) {
        this.idNodo = idNodo;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
