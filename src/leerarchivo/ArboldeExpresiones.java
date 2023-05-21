/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerarchivo;

import leerarchivo.Nodo1;

import java.util.*;
import javax.swing.JPanel;
import java.util.StringTokenizer;

/**
 *
 * @author DELL
 */
public class ArboldeExpresiones {
    Stack < Nodo1 > pOperandos = new Stack < Nodo1> ();
    Stack < String > POperadores = new Stack < String >();
    
    final String blanco;
    final String operadores;
    
    public ArboldeExpresiones(){
    blanco = " \t";
    operadores = ")+-*/%^(";
     }
    
    private Nodo1 raiz;

    
    public Nodo1 getRaiz(){
    
        return  this.raiz;
            
    }
    public void setRaiz(Nodo1 r){
    this.raiz =r;
    }
    
    public boolean contruir (String con){
    construirArbol(con);
    System.out.println(con);
    return true;
    }

    public Nodo1 construirArbol(String exprezion) {
    StringTokenizer tokenizer;
    String token;
    System.out.println(exprezion);
    tokenizer =new StringTokenizer(exprezion,blanco+operadores, true);
    while (tokenizer.hasMoreTokens()){
    token = tokenizer.nextToken();
    if (blanco.indexOf(token)>=0)
        ;
    else if (operadores.indexOf(token) < 0){
          Nodo1 a ;
    pOperandos.push( new Nodo1(token));
    
 }else if (token.equals(")")) {
    
    while (!POperadores.empty() && !POperadores.peek().equals("("))
    {
    guardarSubArbol();
   }   
    POperadores.pop();
   
    }else {
    if (!token.equals("(") && !POperadores.empty()){
    
    String op = (String) POperadores.peek();
    while (!op.equals("(") && !POperadores.empty() && operadores.indexOf(op) >= operadores.indexOf(token))
    guardarSubArbol();
    if ( !POperadores.empty()){
    op = (String)POperadores.peek();
     }
    
    }
    
    POperadores.push(token);
    }
   
    }
    
    raiz = (Nodo1)pOperandos.peek();
    
    while (!POperadores.empty()){
    if (POperadores.peek().equals("(")){
     POperadores.pop();
     }else{
    
    guardarSubArbol();
    raiz = (Nodo1)pOperandos.peek();
    }
   }
    return raiz;
  }
   
    private void guardarSubArbol() {
         //To change body of generated methods, choose Tools | Templates.
    Nodo1 op2 =(Nodo1) pOperandos.pop();
    Nodo1 op1 =(Nodo1) pOperandos.pop();
    pOperandos.push(new Nodo1(op2, POperadores.pop(),op1));
   }
 public void imprime (Nodo1 n){
 if(n !=null){
 
 imprime(n.getNodoDerecho());
 System.out.print(n.getinformacion()+" ");
 imprime(n.getNodoIzquierdo());
 
 
 }
 }
public JPanel getdibujo(){

return new ArbolExpresionGrafico(this);
      }
 public static void main (String[] pps){
 
  ArboldeExpresiones expr=new ArboldeExpresiones();
  
  Scanner leer =new Scanner(System.in);
  System.out.println("Digite la expresion aritmetica");
  String expresion = leer.nextLine();
  
  Nodo1 raiz = expr.construirArbol(expresion);
  System.out.print("El arbol es");
  expr.imprime(raiz);
  
 
 
 }

    
 
}

   

