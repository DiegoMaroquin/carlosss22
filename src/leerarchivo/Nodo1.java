/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerarchivo;

/**
 *
 * @author DELL
 */
public class Nodo1 {
    private String informacion;
    private Nodo1 padre;
    private Nodo1 nodoIzquierdo;
    private Nodo1 nodoDerecho;
    
    
    public Nodo1(){
    
     this.informacion="";
    this.nodoIzquierdo=null;
    this.nodoDerecho=null;
    this.padre=null;
    
    }
    
    public Nodo1(String informacion){
    
     this.informacion=informacion;
    this.nodoIzquierdo=null;
    this.nodoDerecho=null;
    this.padre=null;
    
    }
    public Nodo1(Nodo1 op1, String pop, Nodo1 op2){
    
    this.nodoDerecho=op1;
    this.informacion=pop;
    this.nodoIzquierdo=op2;
    this.padre=null;
    
    
    }

   

   

    

    public Nodo1 getpadre(){
    return padre;
    }
    public void setpadre(Nodo1 padre){
    this.padre = padre;
    
    }
    
     public String getinformacion(){
    return informacion;
    }
    public void setinformacion(String informacion){
    this.informacion = informacion;
    
    }
    
 public Nodo1 getNodoIzquierdo(){
    return nodoIzquierdo;
    }
    public void setNodoIzquierdo(Nodo1 Izquierdo){
    this.nodoIzquierdo = Izquierdo;
    
    }
    
    public Nodo1 getNodoDerecho(){
    return nodoDerecho;
    }
    public void setDerecho(Nodo1 Derecho){
    this.nodoDerecho = Derecho;
    
    }
}

    

