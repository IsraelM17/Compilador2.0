package Automatas;

import automatasII.itcelaya.Settings;

/**
 *
 * @author Lau Rodríguez
 */
public class AfdAcciones {

    static void Inicio(String cadena, int contador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean  aceptado;
    public String[] token; 
    String cadena;
    
    public void inicio(int contador) {
        token           = Settings.cadena.split(" ");
        q0(contador);
    }
       
    private boolean q0(int contador) {
        aceptado = false;
        if(contador < token.length)
            if((Integer.parseInt(token[contador]))>50 && (Integer.parseInt(token[contador]))<100)
                token[contador]="50";
            switch(token[contador]){
                case "17"://int
                    Settings.afdDec.inicio(contador);
                    aceptado = true;
                    break;
                 case "18"://char
                    Settings.afdChar.inicio(contador);
                    aceptado = true;
                    break;
                 case "21": //while
                    Settings.aw.inicio(contador);
                     aceptado = true;
                     break;
                  case "19"://if
                      Settings.afdIf.inicio(contador);
                      aceptado = true;
                    break;
                  case "23": //output
                      Settings.afdOutput.inicio(contador);
                      aceptado = true;
                    break;
                  case  "50":
                      Settings.afAsg.inicio(contador);
                      aceptado=true;
                      break;
                case  "31":
                    //Settings.afAsg.inicio(contador);
                    //aceptado=true;
                    break;
                  default:
                      //aceptado = true;
                      break;
            }
        return aceptado;
    }
    
    
    
}
