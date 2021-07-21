/**
 * Lista simple para buscar por categoria y poder crear nuevas categorias definidas por el usuario
 */
import java.util.ArrayList;
public class Categoria
{
    String categ_name;
    ArrayList <ID> ids;
    Categoria next;
    /**
     * Constructor del objeto categoria, le asigna a la categoria un nombre y un id.
     */
    public Categoria (String categ_name, ID id)
    {
        this.categ_name = categ_name;
        ids = new ArrayList <ID> ();
        ids.add(id);
        next = null;
    }
    /**
     * add: Método que añade una categoría a la lista
     * 
     * @param categ: Recibe un string que es el nombre de la nueva categoría. 
     * @param id_num: Recibe un objeto tipo ID para asignarle a la categoría.
     */
    
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
    /**
     * existe: Método que devuelve un boolean indicando si existe o no una categoría en la lista, por nombre
     * 
     * @param n: Recibe un string que es el nombre de la categoría por buscar en la lista.
     
     */
     public boolean existe(String n){
        boolean flag=false;
        if(categ_name==n){
            flag=true;
        }else{
            if(next!=null){flag=next.existe(n);}
        }
        return flag;
    }
    /**
     * buscarCategoria: Método que busca una categoría por nombre, y devuelve su arreglo de objetos tipo ID.
     * 
     * @param n: Recibe un string que es la cateogíra por buscar.
     */
    public ArrayList<ID> buscarCategoria(String n){
        if(existe(n)){
            if(categ_name==n){
                return ids;
           }else{
                return next.buscarCategoria(n);
            }
        }else{
            String d="¡Esa categoría no existe en la lista!";
            System.out.print(d);
            return null;
        }
    }
}
