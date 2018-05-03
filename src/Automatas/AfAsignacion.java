/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatas;
import automatasII.itcelaya.Errores;
import automatasII.itcelaya.Settings;

/**
 *
 * @author fernando
 */
public class AfAsignacion {

    public boolean aceptado;
    public String[] token;

    public void inicio(int contador) {
        token = Settings.cadena.split(" ");
        q0(contador);
    }

    private boolean q0(int contador) {
        aceptado = false;
        if (contador < token.length) {
            if (Integer.parseInt(Settings.token[contador])>=50 && Integer.parseInt(Settings.token[contador])<=100) {
                Settings.contador ++;
                q1(Settings.contador);
            } else {
                Settings.e.qError(1);
            }
        }
        return aceptado;
    }

    private boolean q1(int contador) {
        aceptado = false;
        if (contador < token.length) {
            if (token[contador].equals("31")) {
                Settings.contador++;
                q2(Settings.contador);
            } else {
                Settings.e.qError(19);
            }
        }
        return aceptado;
    }

    private boolean q2(int contador) {
        aceptado = false;
        if (contador < token.length) {
            if (Integer.parseInt(Settings.token[contador])> 50) {
                Settings.contador++;
                q3(Settings.contador);
            } else {
                        Settings.e.qError(14);
                    }
        }
        return aceptado;
    }

    private boolean q3(int contador) {
        aceptado = false;
        if (contador < token.length) {
            if (token[contador].equals("11")) {
                aceptado = true;
            } else {
               // Settings.e.qError(11);
            }
        }
        return aceptado;
    }

}
