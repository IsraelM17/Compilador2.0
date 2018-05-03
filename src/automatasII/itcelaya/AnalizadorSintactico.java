/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatasII.itcelaya;

import Automatas.AfdBegin;

/**
 *
 * @author Lau Rodríguez
 */
public class AnalizadorSintactico {
    
    AfdBegin begin = new AfdBegin();
    
    public boolean lecturaTabla(String cadena){
        boolean sintactico = false;
        System.out.println(cadena);
        begin.AfdBegin(cadena); //Se envía la cadena de ID's al primer automata BEGIN
        
        if(begin.aceptado){
            System.out.println("Se ha hecho bien el begin");
            sintactico = true;
        }
        return sintactico;
    }
}
