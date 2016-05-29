/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Sebas
 */
public class MetodosVarios {
    public LinkedList<Nodo> generarNodos(LinkedList<LinkedList<HashMap<String, String>>> estados){
        LinkedList<Nodo> nodos = new LinkedList<>();
        LinkedList<String> guardados = new LinkedList<>();
        for (LinkedList<HashMap<String, String>> estado : estados) {
           if(!guardados.contains(estado.getFirst().get("idMio"))){
               guardados.add(estado.getFirst().get("idMio"));
               nodos.add(new Nodo(estado.getFirst().get("idPadre"), estado.getFirst().get("idMio"), estado.getFirst().get("nombre")));
               
           }
        }
        
        return nodos;
    }
    
    
    public LinkedList<HashMap<String, String>> generarEstado(String nombreMetodo, int padre, int mio, int linea, int lineaSiguiente, HashMap<String, String> variables) {
        HashMap<String, String> datos = new HashMap<>();
        datos.put("nombre", nombreMetodo);
        datos.put("idPadre", "" + padre);
        datos.put("idMio", "" + mio);
        datos.put("linea", "" + linea);
        datos.put("lineaSiguiente", "" + lineaSiguiente);
        LinkedList<HashMap<String, String>> estado = new LinkedList<>();
        estado.add(datos);
        estado.add(variables);
        return estado;
    }
    
    public String arrayToString(int[] array) {
        String salida = "[";
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                salida += array[i] + ", ";
            } else {
                salida += array[i] + "";
            }

        }
        salida += "]";
        return salida;
    }
}
