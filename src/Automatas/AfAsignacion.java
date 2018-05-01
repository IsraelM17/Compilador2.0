/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automatas;
import automatasII.itcelaya.Errores;

/**
 *
 * @author fernando
 */
public class AfAsignacion {

    Errores error = new Errores();
    AfdAcciones ac = new AfdAcciones();
    public int contador = 0;
    public boolean aceptado;
    public String[] token;
    String cadena;

    public void inicio(String cadena) {
        this.cadena = cadena;
        token = cadena.split(" ");
        q0(contador);
    }

    private boolean q0(int contador) {
        aceptado = false;
        if (contador < token.length) {
            if (token[contador].equals("50")) {
                q1(contador + 1);
            } else {
                error.qError(22);
            }
        }
        return aceptado;
    }

    private boolean q1(int contador) {
        aceptado = false;
        if (contador < token.length) {
            if (token[contador].equals("31")) {
                q2(contador + 1);
            } else {
                error.qError(19);
            }
        }
        return aceptado;
    }

    private boolean q2(int contador) {
        aceptado = false;
        if (contador < token.length) {
            if (token[contador].equals("50")) {
                q3(contador + 1);
            } else {
                if (token[contador].equals("100")) {
                    q3(contador + 1);
                } else {
                    if (token[contador].equals("150")) {
                        q3(contador + 1);
                    } else {
                        error.qError(14);
                    }
                }
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
                error.qError(11);
            }
        }
        return aceptado;
    }

}
