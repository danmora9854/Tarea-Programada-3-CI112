/**
 * Lista simple con todos los ids de las peliculas ingresadas.
 * Sirve de central hub para linkear toda la información de una película según cómo se busque esta.
 */
import java.util.ArrayList;
public class ID
{
    String value; // Codigo por pelicula
    Titulo title; // Titulo por pelicula
    ArrayList <Categoria> categ; //Arreglo de categorias a las que pertenece 
    Pais country; //Pais de procedencia de la pelicula
    ArrayList <Cast> cast; //Arreglo de objetos tipo Cast asociados a una pelicula
    String tipo, director, fecha, año, audiencia, duracion, descripcion; //Strings del tipo, directos, fecha, anio, audiencia, duracion y descripcion asociados a una pelicula
    ID next; //Siguiente objeto de la lista ID
     
    /**
     * Constructor del objeto tipo ID. Recibe todos los Strings y le asigna sus valores a cada respectivo atributo.
     * 
     * @param value: Recibe un string con el valor del código de la película/serie
     * @param tipo: Recibe un string con el tipo del producto que es película/serie
     * @param director: Recibe un string con el dierector del de la película/serie
     * @param fecha: Recibe un string con la fecha de rodaje de la película/serie
     * @param año: Recibe un string con el año lanzamiento de la película/serie
     * @param audiencia: Recibe un string con la audencia de la película/serie
     * @param duracion: Recibe un string con la duración de la película/serie
     * @param descripcion: Recibe un string con la descripcion de la película/serie
     * 
     */
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
    
     /**
     * add: Método que añade un ID a la lista
     * 
     * @param newID: Recibe un objeto tipo ID que es el nuevo nodo de la lista de IDs
     */
    public void add (ID newID)
    {
        if (next == null){
            next = newID;
        }else{
            next.add(newID);
        }
    }
}
