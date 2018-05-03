package Automatas;

import automatasII.itcelaya.Errores;
import automatasII.itcelaya.Settings;

/**
 *
 * @author Lau Rodríguez
 */
public class AfdBegin {
    
   Errores error = new Errores();
   //public static int    contador = 0;
   public boolean       aceptado;
   public String[]      token;
   String               cadena;
   
   public void AfdBegin(String cadena)
    {
        this.cadena = cadena;
        token = Settings.cadena.split(" ");
        q0(Settings.contador);
    }
   
    //Se espera begin
    private boolean q0(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("25")){
                Settings.contador += 1;
                q1(Settings.contador);
            }
            else 
                error.qError(22);
        return aceptado;
    }
 
    //Se espera main 
    private boolean q1(int contador)
    {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("24")){
                Settings.contador += 1;
                q2(Settings.contador);
            }
            else
                error.qError(24);
        return aceptado;
    }
    
    //Se espera ( 
    private boolean q2(int contador)
    {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("14")){
                Settings.contador += 1;
                q3(Settings.contador);
            }
            else
                error.qError(11);
        return aceptado;
    }
    
    //Se espera ) 
    private boolean q3(int contador)
    {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("15")){
                Settings.contador += 1;
                q4(Settings.contador);
            }
            else
                error.qError(15);
        return aceptado;
    }
    
    //Se espera {
    private boolean q4(int contador)
    {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("12")){
                Settings.contador += 1;
                q5(Settings.contador);
            }
            else
                error.qError(16);
        return aceptado;
    }
    
    //Se espera } ó codigo
    private boolean q5(int contador)
    {
        aceptado = false;
        if(contador < token.length)
            if(!token[Settings.contador].equals("13")){
                Settings.ac.inicio(contador);
                Settings.contador++;
                q5(Settings.contador);
            } 
            else 
                q12(Settings.contador);
        else 
            error.qError(17);
        return aceptado;
    }
    
    //Se espera }
    private boolean q12(int contador)
    {
        aceptado = false;
        if(Settings.contador < token.length)
            if(token[Settings.contador].equals("13")){
                Settings.contador += 1;
                q13(Settings.contador);
            }
            else
                error.qError(17);
        return aceptado;
    }
    
    //Se espera end
    private boolean q13(int contador)
    {
        aceptado = false;
        if(Settings.contador < token.length)
            if(token[Settings.contador].equals("26")){
                aceptado = true;
                Settings.contador += 1;
                //q13(Settings.contador);
                //q3(Settings.contador+1);
            }
            else
                error.qError(23);
        return aceptado;
    }
    
    
}