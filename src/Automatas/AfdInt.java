package Automatas;

import automatasII.itcelaya.Settings;

/**
 *
 * @author Lau Rodríguez
 */
public class AfdInt {
   
   public boolean  aceptado;
   public String[] token;
   
   public void inicio(int contador)
    {
        token = Settings.cadena.split(" ");
         q0(contador);
    }

    //Se espera 'int'
    private boolean q0(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("17")){
                Settings.contador++;
                q1(Settings.contador);
            }
            else 
               Settings.e.qError(27);
        return aceptado;
    }
    
    //se espera identificador (id > 50)
    private boolean q1(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(Integer.parseInt(token[contador]) > 50 && Integer.parseInt(token[contador]) < 100){
                Settings.contador++;
                q2(Settings.contador);
            }
            else 
                Settings.e.qError(1);
        return aceptado;
    }
    
    //Se espera ';' si no pasa a q3
     private boolean q2(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("11")){
                aceptado=true;
            }
            else 
               q3(contador);
        return aceptado;
    }
    
    //Se espera '=' 
    private boolean q3(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("31")){
                Settings.contador++;
                q4(Settings.contador);
            }
            else 
              Settings.e.qError(2);
        return aceptado;
    }
    
    //Se espera valor, ya sea de un id, digito o cadena;
    private boolean q4(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(Integer.parseInt(token[contador]) > 50 || Integer.parseInt(token[contador]) > 100 ){
                Settings.contador++;
                q5(Settings.contador);
            }
            else 
              Settings.e.qError(19);
        return aceptado;
    }
    
    //Se espera ';'
    private boolean q5(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("11")){
                aceptado=true;
                System.out.println("Se hizo bien el int");
            }
            else 
               Settings.e.qError(4);
        return aceptado;
    }
     
}
