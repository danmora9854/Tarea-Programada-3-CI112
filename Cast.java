/**
 * Arbol binario de busqueda para buscar por miembro del cast
 */
import java.util.ArrayList;
public class Cast
{
    String actor;
    ArrayList <ID> ids;
    Cast actor_izq, actor_der;//ordenadas segun el metodo de comparacion de strings compareTo() para hacer un arbol binario de busqueda
    
    public Cast (String actor, ID id)
    {
        this.actor = actor;
        ids = new ArrayList <ID> ();
        ids.add(id);
        actor_izq = null;
        actor_der = null;
    }
    
    public void add (String nombre, ID id_num) {
        if (nombre.compareTo(actor) < 0){                            
            if (actor_der == null){
                actor_der = new Cast(nombre, id_num);
                id_num.cast.add(actor_der);
            }else{
                actor_der.add(nombre, id_num);
            }
        }else{
            if ((nombre.compareTo(actor) > 0) && (actor_izq == null)){ 
                actor_izq = new Cast(nombre, id_num);
                id_num.cast.add(actor_izq);
            }else{
                if (nombre.compareTo(actor) != 0){                   
                    actor_izq.add(nombre, id_num);
                }else{
                    ids.add(id_num);
                    id_num.cast.add(this);
                }
            }
        }
    }
    
    /**
     * Método que busca si existe cierto actor en el arbol.
     * De ser así devuelve el objeto Cast. De lo contrario devuelve null.
     */
    public Cast busque(String nombre){
        Cast r = null;  
        if (nombre.compareTo(actor) == 0) 
            r=this;
        else{
            if (nombre.compareTo(actor) < 0){ 
                if (actor_der!=null)
                    return actor_der.busque(nombre);
            }else{
                if (actor_izq!=null)
                    return actor_izq.busque(nombre);
            }
        }
        return r;
    }
}
