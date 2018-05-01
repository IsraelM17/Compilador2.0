package Automatas;
    /**
 * Created by israel on 07/03/18.
 * @author Israel Moreno -- Laura Perez -- Fernando Lazaro
 */

public class AfdCadena {

    char[]  cadena;
    int     contador = 0;
    public boolean aceptado = false;

    public AfdCadena(String cadena)
    {
        this.cadena = cadena.toCharArray();
        q0(contador+1);
    }

    public boolean  q0(int contador)
    {
        aceptado = true;
        if(contador < cadena.length)
        {
            if (contador < cadena.length) {
                if (cadena[contador] == '"') {
                    q1(contador + 1);
                } else if (cadena[contador] != '"') {
                    q0(contador + 1);//ERROR
                }
            }
        }
        return aceptado;
    }

    public boolean  q1(int contador)
    {
        aceptado = false;
        if(contador < cadena.length)
        {
            if (contador < cadena.length) {
                if (cadena[contador] == '"') {
                    q2(contador + 1);//Aceptado
                } else if (cadena[contador] != '"') {
                    q2(contador + 1);
                }
            }
        }
        return aceptado;
    }

    public boolean  q2(int contador)
    {
        aceptado = true;
        if(contador < cadena.length)
        {
            if (contador < cadena.length) {
                if (cadena[contador] == '"') {
                    q2(contador + 1);
                } else if (cadena[contador] != '"') {
                    q1(contador + 1);
                }
            }
        }
        return aceptado;
    }

}
