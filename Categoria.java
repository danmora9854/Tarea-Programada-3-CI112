import java.util.ArrayList;
/**
 * Lista simple para buscar por categoria y poder crear nuevas categorias definidas por el usuario
 */
public class Categoria
{
    String categ_name;
    ArrayList <ID> ids;
    Categoria next;
    
    public Categoria (String categ_name)
    {
        this.categ_name = categ_name;
        ids = new ArrayList <ID> ();
        next = null;
    }
}
