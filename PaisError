/**
 * Lista simple para buscar por pais
 */
import java.util.ArrayList;
public class Pais
{
    String pais_name;
    ArrayList <ID> ids; 
    Pais next;
    
    public Pais (String pais_name, ID id)
    {
        this.pais_name = pais_name;
        ids = new ArrayList <ID> ();
        ids.add(id);
        next = null;
    }
    
    public void add (String pais, ID id_num) {
        if (pais.equals(pais_name)) {
            ids.add(id_num);
            id_num.country = this;
        }
        if (next==null) {
            next = new Pais(pais,id_num);
            id_num.country = next;
        }else{
            next.add(pais,id_num); //cualquier otro caso
        }
    }
}
