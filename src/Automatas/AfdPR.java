package Automatas;

/**
 *
 * @author israel
 */
public class AfdPR {
    
    
    public String   estado1, estado2, estado3, estado4, estado5;
    public boolean  error1, error2, error3, error4, error5;
    
    public void anzaliza(){
        if(estado1.equals("("))
        {
            error1 = true;
        }
    }
    
    /*
    char[]  cadena;
    int     contador = 0;
    boolean aceptado = false;
    
    public AfdPR(String cadena){
        
        this.cadena = cadena.toCharArray();
        q0(contador+1);
        
    }
    
    public boolean  q0(int contador)
    {
        aceptado = false;
        if(contador < cadena.length)
        {
            if (contador < cadena.length) {
                if (cadena[contador] == '(') {
                    q1(contador + 1);
                } else if (cadena[contador] != '(') {
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
                if (cadena[contador] >= 'a' && cadena[contador] <= 'z') {
                    q1(contador + 1);//No aceptado
                } else if (cadena[contador] == ')') {
                    q3(contador + 1);
                }
            }
        }
        return aceptado;
    }
    
    public boolean  q3(int contador)
    {
        aceptado = false;
        if(contador < cadena.length)
        {
            if (contador < cadena.length) {
                if (cadena[contador] == '{') {
                    q4(contador + 1);
                } else if (cadena[contador] != '{') {
                    q3(contador + 1);
                }
            }
        }
        return aceptado;
    }
    
    public boolean  q4(int contador)
    {
        aceptado = false;
        if(contador < cadena.length)
        {
            if (contador < cadena.length) {
                if (cadena[contador] >= 'a' && cadena[contador] <= 'z') {
                    q4(contador + 1);
                } else if (cadena[contador] == '}') {
                    q5(contador + 1);
                }
            }
        }
        return aceptado;
    }
    
    public boolean  q5(int contador)
    {
        aceptado = true;
        if(contador < cadena.length)
        {
            if (contador < cadena.length) {
                if (cadena[contador] == '}') {
                    q5(contador + 1);
                } 
            }
        }
        return aceptado;
    }
    */
}
