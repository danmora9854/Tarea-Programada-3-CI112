/**
 * Arbol binario de busqueda para buscar por miembro del cast
 */
import java.util.ArrayList;
public class Cast
{
    String actor; //Nombre del actor asociado al nodo Cast
    ArrayList <ID> ids; //Arreglo de objetos tipo ID asociados a cada actor
    Cast actor_izq, actor_der;//Ramas del arbol,ordenadas segun el metodo de comparacion de strings compareTo() para hacer un arbol binario de busqueda
     /**
     * Constructor de la clase Cast
     * @param actor: Recibe un string que es el nombre del actor.
     * @param id: Recibe un objeto tipo ID para asignarle a cada cast.
     */
    public Cast (String actor, ID id)
    {
        this.actor = actor;
        ids = new ArrayList <ID> ();
        ids.add(id);
        actor_izq = null;
        actor_der = null;
    }
      /**
     * muestreActor: Devuelve un String con las peliculas en las que participo el actor asociado al nodo.
     */
    public String muestreActor(){

        return actor + "Participó en las siguientes películas:\n" + ids;

    }
      /**
     * busque: Devuelve un objeto tipo Cast al buscar un actor por su nombre.
     * @param act: Recibe un string que es el nombre del actor por buscar.
     */
    public Cast busque(String act)
    {
        Cast c = null;  
        if (act.compareTo(actor) == 0) 
            c=this;
        else{
            if (act.compareTo(actor) < 0){ 
                if (actor_der!=null)
                    return actor_der.busque(act);
            }else{
                if (actor_izq!=null)
                    return actor_izq.busque(act);
            }
        }
        return c;
    }
      /**
     * add: Añade un nodo al arbol de Cast, ordenado por orden alfabetico.
     * @param nombre: Recibe un string que es el nombre del actor por añadir.
     * @param id_num: Recibe un objeto tipo ID para asignarle a cada actor por añadir.
     */
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
}
