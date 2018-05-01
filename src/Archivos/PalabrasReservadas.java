package Archivos;

/**
 * Created by Equipo #3 on 07/03/18.
 * @author Israel Moreno -- Laura Perez -- Fernando Lazaro
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PalabrasReservadas {

    public boolean      encontro;
    public int          valor;
    
    RandomAccessFile    fichero = null;
    StringBuilder       auxBuilder;
    String              cadena;
    
    long                pos;
    int                 indice;

    public boolean analizar(String palabra) {
        encontro = false;
        try {
            fichero = new RandomAccessFile("palabrasReservadas", "rw");

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
    
    public void valor(){
        
    }
}
