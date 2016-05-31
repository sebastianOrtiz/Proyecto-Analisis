package Modelo;

import java.io.File;
import java.util.ArrayList;

public class Arbol {

    /**
     * @param args the command line arguments
     */
    private Nodoarbol raiz;
    GraphViz graficador = new GraphViz();

    public Arbol() {
        raiz = null;
        graficador.addln(graficador.start_graph());
    }

    public Nodoarbol buscarRecursivo(int data) {
        return (buscarRecursivo(raiz, data));
    }

    //Sobre carga de funciones/métodos
    Nodoarbol resultado = null;

    private Nodoarbol buscarRecursivo(Nodoarbol node, int valorBuscado) {
        if (node == null) {
            resultado = null;
        }

        if (valorBuscado == node.valor) {
            resultado = node;
        }

        for (Nodoarbol tmp : node.hijos) {
            buscarRecursivo(tmp, valorBuscado);
        }

        return resultado;
    }

    public void insertarNodo(int valor, int padre) {
        raiz = insertarNodo(raiz, valor, padre);
    }

    private Nodoarbol insertarNodo(Nodoarbol nodo, int valor, int padre) {
        if (nodo == null) {
            nodo = new Nodoarbol(valor);
        } else {
            Nodoarbol nodoPadre = buscarRecursivo(padre);
            if (nodoPadre != null) {
                nodoPadre.hijos.add(new Nodoarbol(valor));
            } else {
                nodo.hijos.add(new Nodoarbol(valor));
            }
        }
        return nodo;
    }

    //Devolvemos el numero de nodo, buscandolo por valor
    public int buscarNodo(int valorNodo) {
        return nodosVisitados.indexOf(valorNodo);
    }

    public void finalizarGrafica() {
        System.out.println("\n");
        graficador.addln(graficador.end_graph());
        System.out.println(graficador.getDotSource());

        String type = "gif";
        File out = new File("arbol." + type);
        graficador.writeGraphToFile(graficador.getGraph(graficador.getDotSource(), type), out);
    }

    static int contadorNodos = 0;
    static int contadorNulos = 0;
    static ArrayList<Integer> nodosVisitados = new ArrayList<>();

    private void encontrarNodos(Nodoarbol nodo, Arbol arbol) {
        if (nodo != null) {
            //System.out.println("\nEstoy en el nodo " + nodo.valor + " ");
            String nulo = "null";
            //Creación del nodo

            graficador.addln(String.format(
                    "%d [ label=<%d>]", contadorNodos, nodo.valor));
            nodosVisitados.add(nodo.valor);
            //System.out.println("Nuevo nodo registrado: " + nodo.valor + " con indice: " + contadorNodos);
            contadorNodos++;

            for (Nodoarbol tmp : nodo.hijos) {
                if (tmp == null) {
                    nulo = "null" + contadorNulos;
                    contadorNulos++;
                    graficador.addln(String.format("%s[shape=point]", nulo));
                }
                encontrarNodos(tmp, arbol);
            }

        }
    }
    static int nuevoContadorNulos = 0;

    public void asignarPadreHijo(Nodoarbol nodo, Arbol arbol) {
        if (nodo != null) {
            for (Nodoarbol tmp : nodo.hijos) {
                if (tmp != null) //Agregamos el hijo izquierdo a la gráfica
                {
                    graficador.addln(String.format(
                            "%d -> %d", buscarNodo(nodo.valor), buscarNodo(tmp.valor)));
                } else {
                    graficador.addln(String.format(
                            "%d -> %s", buscarNodo(nodo.valor), "null" + nuevoContadorNulos++));
                }
                asignarPadreHijo(tmp, arbol);
            }
        }
    }

    public void graficarArbol(Arbol arbol) {
        graficador.addln("ordering = out");
        encontrarNodos(raiz, arbol);
        asignarPadreHijo(raiz, arbol);
        finalizarGrafica();
    }

    static int tamaño = 0;

    public int obtenerTamaño(Nodoarbol nodo, Arbol arbol) {
        if (nodo != null) {
            tamaño++;
            for (Nodoarbol tmp : nodo.hijos) {
                obtenerTamaño(tmp, arbol);
            }
        }
        return tamaño;
    }
}
