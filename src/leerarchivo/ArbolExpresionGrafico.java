/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerarchivo;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class ArbolExpresionGrafico extends JPanel {
    
    private ArboldeExpresiones miArbol;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0,0);
    private FontMetrics fm = null;
    
     public ArbolExpresionGrafico(ArboldeExpresiones miArbol)
     {
         
         this.miArbol = miArbol;
         this.setBackground(Color.WHITE);
         posicionNodos = new HashMap();
         subtreeSizes =new HashMap();
         dirty = true;
         repaint();
    }
     
     private void calcularposiciones()
     {
     posicionNodos.clear();
     subtreeSizes.clear();
     Nodo1 root = this.miArbol.getRaiz();
     if(root != null)
     {
     calcularTamañoSubarbol(root);
     calcularposicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
     }
 }
     private Dimension calcularTamañoSubarbol (Nodo1 n)
     {
     if (n == null)
         return new Dimension(0,0);
     
     Dimension id = calcularTamañoSubarbol(n.getNodoIzquierdo());
     Dimension rd = calcularTamañoSubarbol(n.getNodoDerecho());
         
     int h = fm.getHeight() + parent2child + Math.max(id.height,rd.height);
     int w = id.width + child2child + rd.width;
     
     Dimension d = new Dimension(w, h);
     subtreeSizes.put(n,d);
     return d;
     
     }
    
     private void calcularposicion (Nodo1 n, int left, int right, int top)
     {
         if (n == null)
             return;
         
         Dimension id = (Dimension) subtreeSizes.get(n.getNodoIzquierdo());
         if (id == null);
         id = empty;
         
         Dimension rd = (Dimension) subtreeSizes.get(n.getNodoDerecho());
         if (rd == null)
             rd = empty;
         
         int center =0;
         
         if (right != Integer.MAX_VALUE)
             center =right - rd.width - child2child/2;
         else if (left != Integer.MAX_VALUE)
             center =  left + id.width + child2child/2;
         int width = fm.stringWidth(n.getinformacion()+"");
         
         posicionNodos.put(n, new Rectangle(center - width/2 - 3, top, width + 6, fm.getHeight()));
         
         calcularposicion(n.getNodoIzquierdo(), Integer.MAX_VALUE, center - child2child/2,top + fm.getHeight()+ parent2child);
          calcularposicion(n.getNodoDerecho(), center+child2child/2, Integer.MAX_VALUE,top + fm.getHeight()+ parent2child);
     }
     
         private void dibujarArbol(Graphics2D g, Nodo1 n, int puntox, int puntoy, int yoffs)
         {
         if (n == null)
             return;
         
         Rectangle r =(Rectangle) posicionNodos.get(n);
         g.draw(r);
         g.drawString(n.getinformacion()+"", r.x + 3, r.y + yoffs);
        
         if (puntox != Integer.MAX_VALUE)
             
             g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);
         
         dibujarArbol(g, n.getNodoIzquierdo(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
         dibujarArbol(g, n.getNodoDerecho(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
         
         
         }
         
         
         public void paint(Graphics g)
         {
         super.paint(g);
         fm = g.getFontMetrics();
         
         if(dirty)
         {
         
       calcularposiciones();
         dirty =false;
         }
         Graphics2D g2d =(Graphics2D) g;
         g2d.translate(getWidth() / 2, parent2child);
          dibujarArbol(g2d, this.miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE,
           fm.getLeading() + fm.getAscent());
       
         fm=null;
         }       

    
}

  