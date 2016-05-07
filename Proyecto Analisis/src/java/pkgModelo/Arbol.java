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
public class Arbol {
    private Nodo raiz;

    public Arbol(Dato datoRaiz) {
        this.raiz = new Nodo(datoRaiz);
    }

    
    public String toJSONParaGraficar() {
        return "{\"chart\":{\"container\": \"#collapsable-example\", \"rootOrientation\":  \"WEST\", \"animateOnInit\": true, \"node\": { \"collapsable\": true}, \"animation\": {\"nodeAnimation\": \"easeOutBounce\", \"nodeSpeed\": 700, \"connectorsAnimation\": \"bounce\", \"connectorsSpeed\": 700}}, \"nodeStructure\":"+this.raiz.obtenerEstructuraDeNososJSON()+"}";
    }

    /**
     * @return the raiz
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    
}
