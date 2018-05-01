package Automatas;


import automatasII.itcelaya.Settings;

/**
 *
 * @author israel
 */
public class AfdChar {
    
   public boolean  aceptado;
   public String[] token;
   
   public void inicio(int contador)
    {
        token = Settings.cadena.split(" ");
         q0(contador);
    }

    //Se espera 'char'
    private boolean q0(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("18")){
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
            if(Integer.parseInt(token[contador]) > 50){
                Settings.contador++;
                q2(Settings.contador);
            }
            else 
                Settings.e.qError(1);
        return aceptado;
    }
    //Se espera ';' si no, pasa a q3
     private boolean q2(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("11")){
                aceptado=true;
            }
            else 
               q3(Settings.contador);
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
    
    //Se espera comilla " ' "
    private boolean q4(int contador){
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("10")){
                Settings.contador++;
                q5(Settings.contador);
            }
            else 
              Settings.e.qError(9);
        return aceptado;
    }
    
    //Se espera caracter
    private boolean q5(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].length() < 2)
                if(!token[contador].equals("10")){
                    Settings.contador++;
                    q6(Settings.contador);
                }
                else 
                    System.out.println("Falta caracter");
            else
                System.out.println("Hay mas de 1 caracter");
        else 
              Settings.e.qError(14);
        return aceptado;
    }
    
    //Se espera " ' " 
    private boolean q6(int contador){
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("10")){
                Settings.contador++;
                q7(Settings.contador);
            }
            else 
              Settings.e.qError(9);
        return aceptado;
    }
    
    //Se espera ';'
    private boolean q7(int contador) {
        aceptado = false;
        if(contador < token.length)
            if(token[contador].equals("11")){
                aceptado=true;
                System.out.println("Se hizo bien el char");
            }
            else 
               Settings.e.qError(4);
        return aceptado;
    }
    
}
