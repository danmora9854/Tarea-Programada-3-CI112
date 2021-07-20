/**
 * Arbol binario de busqueda para buscar por titulo de pelicula
 */
import java.util.ArrayList;
public class Titulo
{
    String title_name;
    ID show_id;
    Titulo title_izq, title_der;//ordenadas segun el metodo de comparacion de strings compareTo() para hacer un arbol binario de busqueda
    
    public Titulo (String title_name, ID show_id)
    {
        this.title_name = title_name;
        this.show_id = show_id;
        title_izq = null;
        title_der = null;
    }
    
    public void add(String titulo, ID id_num){ 
        if (titulo.compareTo(title_name) < 0){                            
            if (title_der == null){
                title_der = new Titulo(titulo, id_num);
                id_num.title = title_der;
            }else{
                title_der.add(titulo, id_num);
            }
        }else{
            if ((titulo.compareTo(title_name) > 0) && (title_izq == null)){ 
                title_izq = new Titulo(titulo, id_num);
                id_num.title = title_izq;
            }else{
                if (titulo.compareTo(title_name) != 0){                   
                    title_izq.add(titulo, id_num);
                }
            }
        }
    }
    
    /**
     * Método que busca si existe cierto titulo en el arbol.
     * De ser así devuelve el objeto Titulo. De lo contrario devuelve null.
     */
    public Titulo busque(String titulo){
        Titulo r = null;  
        if (titulo.compareTo(title_name) == 0) 
            r=this;
        else{
            if (titulo.compareTo(title_name) < 0){ 
                if (title_der!=null)
                    return title_der.busque(titulo);
            }else{
                if (title_izq!=null)
                    return title_izq.busque(titulo);
            }
        }
        return r;
    }
}
