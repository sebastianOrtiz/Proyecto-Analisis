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
public class CodigoParaGraficarTabla {
    private LinkedList<String> lineas;
    private int lineaSeleccionada;

    @Override
    public String toString() {
        String salida = "<table class=\"table-responsive\"><tbody>";
        for (int i = 0; i < this.lineas.size(); i++) {
            if(i == lineaSeleccionada){
                salida+="<tr style=\"background-color: #1b6d85\"><td>"+this.lineas.get(i)+"</td></tr>";
            }else{
                salida+="<tr><td>"+this.lineas.get(i)+"</td></tr>";
            }
            
            
        }
        salida+="</tbody></table>";
        return salida;
    }

    /**
     * @return the lineas
     */
    public LinkedList<String> getLineas() {
        return lineas;
    }

    /**
     * @param lineas the lineas to set
     */
    public void setLineas(LinkedList<String> lineas) {
        this.lineas = lineas;
    }

    /**
     * @return the lineaSeleccionada
     */
    public int getLineaSeleccionada() {
        return lineaSeleccionada;
    }

    /**
     * @param lineaSeleccionada the lineaSeleccionada to set
     */
    public void setLineaSeleccionada(int lineaSeleccionada) {
        this.lineaSeleccionada = lineaSeleccionada;
    }
}
