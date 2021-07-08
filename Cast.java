import java.util.ArrayList;
/**
 * Arbol binario de busqueda para buscar por miembro del cast
 */
public class Cast
{
    String actor;
    ArrayList <ID> ids;
    Cast actor_izq, actor_der;//ordenadas segun el metodo de comparacion de strings compareTo() para hacer un arbol binario de busqueda
    
    public Cast (String actor)
    {
        this.actor = actor;
        ids = new ArrayList <ID> ();
        actor_izq = null;
        actor_der = null;
    }
    
    public String muestreActor(){
        
        return actor + "Participó en las siguientes películas:\n" + ids;
    
    }
    
    public Cast buscarActor(String act)
    {
        Cast c = null;  
        if (act.compareTo(actor) == 0) 
            c=this;
        else{
            if (act.compareTo(actor) < 0){ 
                if (actor_der!=null)
                    return actor_der. buscarActor(act);
            }else{
                if (actor_izq!=null)
                    return actor_izq. buscarActor(act);
            }
        }
        return c;
    }
    
    public void insertarActor(String act)
    {
        if (act.compareTo(actor) < 0){                            
            if (actor_der == null){
                actor_der = new Cast(act);
            }else{
                actor_der.insertarActor(act);
            }
        }else{
            if ((act.compareTo(actor) > 0) && (actor == null)){ 
                actor_izq = new Cast(act);
            }else{
                if (act.compareTo(actor) != 0)                     
                    actor_izq.insertarActor(act);
            }
        }
    }
}
