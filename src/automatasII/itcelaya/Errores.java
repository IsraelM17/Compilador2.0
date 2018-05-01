/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatasII.itcelaya;

/**
 *
 * @author Lau Rodríguez
 */
public class Errores {
    Interfaz interfaz;
    public void qError(int error){
        String msj="";
        switch(error){
            case 1:
                msj="Error:200	Se esperaba un identificador";
                Settings.cadenaError += msj + "\n";
                break;
            case 2:
                msj="Error:201	Se esperaba un ‘=’ o un ‘;’";
                Settings.cadenaError += msj + "\n";
                break;
            case 3:
                msj="Error:202	Se esperaba un número";
                Settings.cadenaError += msj + "\n";
                break;
            case 4:
                 msj="Error:203	Se esperaba un ‘;’";
                 Settings.cadenaError += msj + "\n";
                break;
            case 5:
                msj="Error:204	Se esperaba un caracter";
                Settings.cadenaError += msj + "\n";
                break;
            case 6:
                msj="Error:200	Se esperaba un identificador";
                Settings.cadenaError += msj + "\n";
                break;
            case 7:
                msj="Error:201	Se esperaba un ‘=’ o un ‘;’";
                Settings.cadenaError += msj + "\n";
                
                break;
            case 8:
                msj="Error:202	Se esperaba un número";
                Settings.cadenaError += msj + "\n";
                break;
            case 9:
                 msj="Error:203	Se esperaba un ‘ ' ’ (comilla)";
                 Settings.cadenaError += msj + "\n";
                break;
            case 10:
                msj="Error:204	Se esperaba un caracter";
                Settings.cadenaError += msj + "\n";
                break;
            case 11:
                msj="Error:205	Se esperaba un (";
                Settings.cadenaError += msj + "\n";
                break;
            case 12:
                msj="Error:206	Se esperaba un operador aritmético o un ‘;’";
                Settings.cadenaError += msj + "\n";
                break;
            case 13:
                msj="Error:207	Se esperaba un operador de comparación";
                Settings.cadenaError += msj + "\n";
                break;
            case 14:
                 msj="Error:208	Se esperaba un caracter";
                 Settings.cadenaError += msj + "\n";
                break;
            case 15:
                msj="Error:209	Se esperaba un )";
                Settings.cadenaError += msj + "\n";
                break;
            case 16:
                msj="Error:210	Se esperaba un {";
                Settings.cadenaError += msj + "\n";
                break;
            case 17:
                msj="Error:211	Se esperaba un }";
                Settings.cadenaError += msj + "\n";
                break;
            case 18:
                msj="Error:212	Se esperaba un número o un identificador";
                Settings.cadenaError += msj + "\n";
                break;
            case 19:
                msj="Error:213	Se esperaba un =";
                Settings.cadenaError += msj + "\n";
                break;
            case 20:
                 msj="Error:214	Se esperaba un +";
                 Settings.cadenaError += msj + "\n";
                break;
            case 21:
                msj="Error:215	Se esperaba un -";
                Settings.cadenaError += msj + "\n";
                break;
            case 22:
                msj="Error:216	Se esperaba la palabra 'begin' al inicio del programa";
                Settings.cadenaError += msj + "\n";
                break;
            case 23:
                 msj="Error:217	Se esperaba la palabra 'end' al final del programa";
                 Settings.cadenaError += msj + "\n";
                break;
            case 24:
                msj="Error:218	Se esperaba la palabra reservada main para inicio de método principal";
                Settings.cadenaError += msj + "\n";
                break;
        }
        //interfaz.mostrarError(Settings.cadenaError);
    }
}
