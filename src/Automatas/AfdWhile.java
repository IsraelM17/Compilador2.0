/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatas;

import automatasII.itcelaya.Settings;

/**
 *
 * @author Lau Rodríguez
 */
public class AfdWhile {

   public boolean  aceptado;
   public String[] token;
   
   public boolean inicio(int contador)
    {
        token = Settings.cadena.split(" ");
        q0(contador);
        return aceptado;
    }
   
    //Se esperaba while
    private boolean q0(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("21")){
                Settings.contador++;
                q1(Settings.contador);
            }
            else 
                System.out.println("Se esperaba while");
        return aceptado;
    }
    
    //Se espera '('
    private boolean q1(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("14")){
                Settings.contador++;
                q2(Settings.contador);
            }
            else 
                Settings.e.qError(11);
        return aceptado;
    }
    
    //Se espera condicion 
    private boolean q2(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(!token[Settings.contador].equals("15")){
                Settings.afdCon.inicio(contador);
                //Settings.contador++;
                q2(Settings.contador);
            } 
            else 
                q3(Settings.contador);
        return aceptado;
     }
     
    //Se espera ')'
    private boolean q3(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("15")){
                Settings.contador++;
                q4(Settings.contador);
            }
            else 
                  Settings.e.qError(15);
        return aceptado;
    }
    
    //Se espera {
    private boolean q4(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("12")){
                Settings.contador++;
                q5(Settings.contador);
            }
            else 
                 Settings.e.qError(16);
        return aceptado;
    }
    
    //Se espera '}' o código
    private boolean q5(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(!token[Settings.contador].equals("13")){
                Settings.ac.inicio(contador);
                Settings.contador++;
                q5(Settings.contador);
            } 
            else 
                q6(Settings.contador);
        return aceptado;
    }
     
     private boolean q6(int contador) {
        if(contador < token.length)
            if(token[contador].equals("13")){
                 aceptado = true;
                 System.out.println("Ha hecho bien el while");
            }
            else if(!token[contador].equals("13"))
                 System.out.println("Se esperaba un }");
        return aceptado;
    }
     
   
}
