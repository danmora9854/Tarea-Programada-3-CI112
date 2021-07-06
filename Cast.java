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
}
