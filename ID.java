import java.util.ArrayList;
/**
 * Lista simple con todos los ids de las peliculas ingresadas.
 * Sirve de central hub para linkear toda la información de una película según cómo se busque esta.
 */
public class ID
{
    int value;
    Categoria categ;
    Pais country;
    ArrayList <Cast> cast;
    String tipo, director, fecha, año, audiencia, duracion, descripcion;
    ID next;
}
