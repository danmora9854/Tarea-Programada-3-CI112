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

    public boolean existe(String n){
        boolean flag=false;
        if(pais_name==n){
            flag=true;
        }else{
            if(next!=null){flag=next.existe(n);}
        }
        return flag;
    }
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
