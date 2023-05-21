/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerarchivo;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 *
 * @author DELL
 */
public class SimuladorArbolBinario {
  ArboldeExpresiones miArbol =new ArboldeExpresiones();
  
public SimuladorArbolBinario(){
 }
public boolean insertar (String dato){
return (this.miArbol.contruir(dato));
}
public ArboldeExpresiones getMiArbol(){
return miArbol;
}

public String borrar(Integer dato){
return ("No existe el dato en el arbol");
}
public JPanel getDibujo(){
return this.miArbol.getdibujo();


}

   
}
