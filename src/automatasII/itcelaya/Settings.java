/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatasII.itcelaya;

import Automatas.AfdAcciones;
import Automatas.AfdChar;
import Automatas.AfdCondicion;
import Automatas.AfdInt;
import Automatas.AfdIf;
import Automatas.AfdOutput;
import Automatas.AfdWhile;

/**
 *
 * @author israel
 */
public class Settings {


    public static int contador = 0;
    public static String cadenaError = "";
    public static String cadena = "";
    public static String token[];

    public static AfdAcciones  ac       = new AfdAcciones();
    public static AfdWhile aw           = new AfdWhile();
    public static AfdCondicion afdCon   = new AfdCondicion();
    public static AfdChar afdChar       = new AfdChar();
    public static AfdIf  afdIf          = new AfdIf();
    public static AfdInt afdDec = new AfdInt();
    public static AfdOutput afdOutput   = new AfdOutput();
    public static Errores e = new Errores();
    
}
