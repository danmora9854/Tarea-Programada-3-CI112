/**
 * Lista simple para buscar por categoria y poder crear nuevas categorias definidas por el usuario
 */
import java.util.ArrayList;
public class Categoria
{
    String categ_name;
    ArrayList <ID> ids;
    Categoria next;
    
    public Categoria (String categ_name, ID id)
    {
        this.categ_name = categ_name;
        ids = new ArrayList <ID> ();
        ids.add(id);
        next = null;
    }
    
    public void add (String categ, ID id_num) {
        if (categ.equals(categ_name)) {
            ids.add(id_num);
            id_num.categ.add(this);
        }
        if (next==null) {
            next = new Categoria(categ,id_num);
            id_num.categ.add(next);
        }else{
            next.add(categ,id_num); //cualquier otro caso
        }
    }
}
