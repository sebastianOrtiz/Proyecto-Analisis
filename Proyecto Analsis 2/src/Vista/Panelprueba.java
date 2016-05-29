/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import App5.ArbolGeneral;
import App5.Elemento;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andres
 */
public class Panelprueba extends javax.swing.JPanel {

    public Panelprueba() {
        initComponents();
        this.coordenadas = new HashMap<Elemento<String>, Point>();
    }
    private int radio = 15;
    private int espacioVertical = 50;
    private ArbolGeneral<String> arbolGeneral;
    private HashMap<Elemento<String>, Point> coordenadas;

    public Panelprueba(ArbolGeneral<String> arbolGeneral) {
        this.arbolGeneral = arbolGeneral;
        this.coordenadas = new HashMap<Elemento<String>, Point>();
    }

    public void setarbol(ArbolGeneral<String> arbolGeneral) {
        this.arbolGeneral = arbolGeneral;
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (arbolGeneral != null && !arbolGeneral.estaVacia()) {
            dibujar(g, arbolGeneral.getRaiz(), getWidth() / 2, 30, getWidth() / 5);
        }
    }

    private void dibujar(Graphics g, Elemento<String> raiz, int x, int y, int espacioH) {
        g.drawOval(x - radio, y - radio, 2 * radio, 2 * radio);
        g.drawString(raiz.getElemento() + "", x - 4, y + 4);
        ArrayList<Elemento<String>> hijos = arbolGeneral.obtenerHijos(raiz);
        coordenadas.put(raiz, new Point(x, y));
        for (Elemento<String> hijo : hijos) {
            Point punto = coordenadas.get(arbolGeneral.obtenerPadre(hijo));
            dibujarLinea(g, x - espacioH, y + espacioVertical, punto.x, punto.y);
            dibujar(g, hijo, x - espacioH, y + espacioVertical, espacioH / hijos.size());
            x += espacioH;
        }
    }

    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(espacioVertical * espacioVertical + (x2 - x1) * (x2 - x1));
        int xx1 = (int) (x1 - radio * (x1 - x2) / d);
        int yy1 = (int) (y1 - radio * (y1 - y2) / d);
        int xx2 = (int) (x2 + radio * (x1 - x2) / d);
        int yy2 = (int) (y2 + radio * (y1 - y2) / d);

        g.drawLine(xx1, yy1, xx2, yy2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
