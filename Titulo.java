import java.util.ArrayList;
/**
 * Arbol binario de busqueda para buscar por titulo de pelicula
 */
public class Titulo
{
    String title_name;
    ID show_id;
    Titulo title_izq, title_der;//ordenadas segun el metodo de comparacion de strings compareTo() para hacer un arbol binario de busqueda
    
    public Titulo (String title_name)
    {
        this.title_name = title_name;
        show_id = null;
        title_izq = null;
        title_der = null;
    }
}
