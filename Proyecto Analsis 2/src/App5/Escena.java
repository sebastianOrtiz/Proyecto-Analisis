package App5;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JPanel;
import Vista.*;
import Modelo.*;

/**
 * Creado por hadexexplade el 01 de febrero del 2016
 */
public class Escena extends JPanel {

    private ArbolGeneral<String> arbolGeneral;
    

    public ArbolGeneral<String> generarArbol(LinkedList<Nodo> nodos) {
        this.arbolGeneral = new ArbolGeneral<String>();

        Stack<Elemento<String>> pila = new Stack<>();
        pila.add(arbolGeneral.insertarRaiz(nodos.getFirst().getIdPropio()));

        while (!pila.isEmpty()) {
            Elemento<String> elemento = pila.pop();
            for (Nodo nodo : nodos) {
                if (nodo.getIdPadre().equalsIgnoreCase(elemento.getElemento())) {
                    pila.push(arbolGeneral.insertarHijo(elemento, nodo.getIdPropio()));
                }
            }
        }
        
        return arbolGeneral;
        
    }

    public ArbolGeneral<String> Escena(LinkedList<Nodo> nodos) {
        this.arbolGeneral = new ArbolGeneral<String>();
        return arbolGeneral=generarArbol(nodos);
//        this.arbolGeneral = new ArbolGeneral<String>();
//        Elemento<String> elemento = arbolGeneral.insertarRaiz(nodos.get(0).getDato());
//        arbolGeneral.insertarHijo(elemento, nodos.get(1).getDato());
//        arbolGeneral.insertarHijo(elemento, nodos.get(2).getDato());
//        elemento = arbolGeneral.insertarHijo(elemento, "D");
//        arbolGeneral.insertarHijo(elemento, "C");
//        arbolGeneral.insertarHijo(elemento, "E");
//        elemento = arbolGeneral.insertarHijo(elemento, "G");
//        arbolGeneral.insertarHijo(elemento, "F");
//        elemento = arbolGeneral.insertarHijo(arbolGeneral.getRaiz(), "I");
//        arbolGeneral.insertarHijo(elemento, "H");
//        arbolGeneral.insertarHijo(elemento, "L");
//        elemento = arbolGeneral.insertarHijo(arbolGeneral.getRaiz(), "O");
//        arbolGeneral.insertarHijo(elemento, "M");
//        this.vista = new PanelArbol<String>(arbolGeneral);
//        this.setLayout(new BorderLayout());
//        add(vista, BorderLayout.CENTER);

    }
}
