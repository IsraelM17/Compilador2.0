/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatas;

import automatasII.itcelaya.Settings;

/**
 *
 * @author Lau Rodríguez, Fer Lazaro, Isra Moreno
 */
public class AfdCondicion {

   public boolean  aceptado;
   public String[] token;
   
   public void inicio(int contador)
    {
        token = Settings.cadena.split(" ");
        q0(contador);
    }

     private boolean q0(int contador) {
        aceptado = false;
        if(contador < Settings.token.length)
            if(Integer.parseInt(Settings.token[contador])>100 || Integer.parseInt(Settings.token[contador]) > 50){
                Settings.contador ++;
                q1(Settings.contador);
            }
            else 
               Settings.e.qError(18);
        return aceptado;
    }
    
    private boolean q1(int contador) {
        aceptado = false;
        if(contador < Settings.token.length)
            if(Settings.token[contador].equals("34") || Settings.token[contador].equals("35") || Settings.token[contador].equals("36") 
                    || Settings.token[contador].equals("37") || Settings.token[contador].equals("38") || Settings.token[contador].equals("39")){
                Settings.contador++;
                q2(Settings.contador);
            }
            else 
                Settings.e.qError(13);
        return aceptado;
    }
    
     private boolean q2(int contador) {
        aceptado = false;
        if(contador < Settings.token.length)
            if(Integer.parseInt(Settings.token[contador])>100 || Integer.parseInt(Settings.token[contador]) > 50){
                Settings.contador++;
                q3(Settings.contador);
            }
            else 
               Settings.e.qError(18);
        return aceptado;
    }
     
     private boolean q3(int contador) {
        aceptado = false;
        if(contador < Settings.token.length)
            if(Settings.token[contador].equals("33") || Settings.token[contador].equals("32")){
                Settings.contador++;
                q0(Settings.contador);
            }
            else {
                System.out.println("Se hizo bien la condicion");
               aceptado=true;
            }
        return aceptado;
    }
}
