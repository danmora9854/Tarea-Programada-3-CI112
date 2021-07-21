/**
 * Lista simple para buscar por pais
 */
import java.util.ArrayList;
public class Pais
{
    String pais_name; //Nombre del pais
    ArrayList <ID> ids; //Arreglo de objetos tipo ID
    Pais next; //Siguiente nodo tipo Pais de la lista
     /**
     * Constructor del objeto tipo Pais
     * @param pais_name: Recibe un string que sera el nombre del pais 
     * @param id: Recibe un objeto tipo ID para asignarle al pais en el arreglo ids.
     */
    public Pais (String pais_name, ID id)
    {
        this.pais_name = pais_name;
        ids = new ArrayList <ID> ();
        ids.add(id);
        next = null;
    }
     /**
     * add: Método que añade un objeto tipo pais a la lista simple
     * 
     * @param pais: Recibe un string que es el nombre del nuevo pais 
     * @param id_num: Recibe un objeto tipo ID para asignarle al pais.
     */
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
     /**
     * existe: Método que devuelve un boolean que indica si un pais existe en la lista. 
     * 
     * @param n: Recibe un string que es el nombre del pais por buscar.
     */
    public boolean existe(String n){
        boolean flag=false;
        if(pais_name==n){
            flag=true;
        }else{
            if(next!=null){flag=next.existe(n);}
        }
        return flag;
    }
     /**
     * buscarPais: Método que busca un pais por nombre y una vez que lo encuentra, devuelve su lista de IDs asociados. 
     * Si el pais que se esta buscando no existe, se imprime un mensaje de aviso.
     * @param n: Recibe un string que es el nombre del pais por buscar.
     */
    public ArrayList<ID> buscarPais(String n){
        if(existe(n)){
            if(pais_name==n){
                return ids;
           }else{
                return next.buscarPais(n);
            }
        }else{
            String d="¡Ese país no existe en la lista!";
            System.out.print(d);
            return null;
        }
    }
}
