package Archivos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author israel
 */
public class Delimitadores {
    
    RandomAccessFile    fichero = null;
    String              cadena;
    StringBuilder       auxBuilder;
    boolean             encontro;
    long                pos;
    int                 indice;
    public int                 valor;

    public boolean analizar(String palabra) {
        encontro = false;
        try {
            fichero = new RandomAccessFile("delimitadores", "rw");

            cadena = fichero.readLine();
            while (cadena != null) {
                if(cadena.indexOf(palabra) != -1)
                    if (cadena.split(" ")[0].equalsIgnoreCase(palabra)){
                        encontro = true;
                        valor = Integer.parseInt(cadena.split(" ")[1]);
                    }
                pos = fichero.getFilePointer();
                cadena = fichero.readLine();
            }
            return encontro;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return encontro;
    }
    
}
