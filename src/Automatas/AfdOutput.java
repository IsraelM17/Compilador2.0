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
public class AfdOutput {
   
   public boolean  aceptado;
   public String[] token;
   
   public void inicio(int contador)
    {
        token = Settings.cadena.split(" ");
        q0(contador);
    }
   
   //Se espera 'output'
    private boolean q0(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("23")){
                Settings.contador ++;
                q1(Settings.contador);
            }
            else 
               Settings.e.qError(26);
        return aceptado;
    }
    
    //Se espera '('
    private boolean q1(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("14")){
                Settings.contador ++;
                q2(Settings.contador);
            }
            else 
                Settings.e.qError(11);
        return aceptado;
    }
    
    //Se espera '"'
    private boolean q2(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("16")){
                Settings.contador ++;
                q3(Settings.contador);
            }
            else 
                Settings.e.qError(14);
        return aceptado;
    }
    
    //Se espera una cadena o '"' 
    private boolean q3(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(!token[contador].equals("16")){
                Settings.contador ++;
                q3(Settings.contador);
            }
            else 
                q4(Settings.contador);
        else
            Settings.e.qError(15);
        return aceptado;
    }
    
    //Se espera ' " '
    private boolean q4(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("16")){
                Settings.contador ++;
                q5(Settings.contador);
            }
            else 
                 Settings.e.qError(4);
        return aceptado;
    }
    
    //Se espera ')'
    private boolean q5(int contador){
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("15")){
                Settings.contador ++;
                q6(Settings.contador);
            }
            else 
                Settings.e.qError(contador);
        return aceptado;
    }
    
    //Se espera ';'
    private boolean q6(int contador){
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("11")){
                aceptado = true;
                System.out.println("Se hizo bien el output");
            }
            else 
                Settings.e.qError(contador);
        return aceptado;
    } 
}
