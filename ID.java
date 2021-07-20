/**
 * Lista simple con todos los ids de las peliculas ingresadas.
 * Sirve de central hub para linkear toda la información de una película según cómo se busque esta.
 */
import java.util.ArrayList;
public class ID
{
    String value;
    Titulo title;
    ArrayList <Categoria> categ;
    Pais country;
    ArrayList <Cast> cast;
    String tipo, director, fecha, año, audiencia, duracion, descripcion;
    ID next;
    
    public ID (String value, String tipo, String director, String fecha, String año, String audiencia, String duracion, String descripcion)
    {
        this.value = value;
        this.tipo = tipo;
        this.director = director;
        this.fecha = fecha;
        this.año = año;
        this.audiencia = audiencia;
        this.duracion = duracion;
        this.descripcion = descripcion;
        categ = new ArrayList <Categoria> ();
        cast = new ArrayList <Cast> ();
        title = null;
        country = null;
    }
    
    public void add (ID newID)
    {
        if (next == null){
            next = newID;
        }else{
            next.add(newID);
        }
    }
}
