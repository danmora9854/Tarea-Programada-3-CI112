import java.util.ArrayList;
/**
 * Lista simple para buscar por pais
 */
public class Pais
{
    String pais_name;
    ArrayList <ID> ids; 
    Pais next;
    Pais prev;
    public Pais (String pais_name)
    {
        this.pais_name = pais_name;
        ids = new ArrayList <ID> ();
        next = null;
        prev = null;
    }
}
