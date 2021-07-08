
/**
 * Write a description of class Controlador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Controlador
{
    ID id_list;
    Categoria categ_list;
    Pais country_list;
    Titulo title_tree;
    Cast cast_tree;
    
    public Controlador ()
    {
        id_list = null;
        categ_list = null;
        country_list = null;
        title_tree = null;
        cast_tree = null;
    }
    
    /**
     * Método que lee la data de todas las películas.
     */
    public void leaData ()
    {
        //Habria que implementar un metodo que le vaya dando al ciclo
        //siguiente la info separada de cada pelicula.
        
        //Inicio de un ciclo que se repite por cada pelicula
        
            //1era iteracion inicializa variables
            id_list = new ID (id,tipo,director,fecha,año,audiencia,duracion,descripcion);
            categ_list = new Categoria (categoria,id_list);
            country_list = new Pais (pais,id_list);
            title_tree = new Titulo (titulo,id_list);
            cast_tree = new Cast (actor_1,id_list);
            //Inicio de un ciclo que se repite por cada miembro del cast exceptuando el primero
                cast_tree.add(actor_i,id_list);
            //Fin de ciclo
            
            //Demás iteraciones que no sean la 1era, solo añaden
            id_list.add(id,tipo,director,fecha,año,audiencia,duracion,descripcion);
            categ_list.add(categoria,id_list);
            country_list.add(pais,id_list);
            title_tree.add(titulo,id_list);
            //Inicio de un ciclo que se repite por cada miembro del cast
                cast_tree.add(actor_i,id_list);
            //Fin de ciclo
            
        //Fin de ciclo
        
    }
    
    /**
     * Método que devuelve en una string la información de la película
     * asociada con el id dado de parámetro.
     */
    public String muestrePelicula (ID id)
    {
        String msg = "";
        msg += id.value + " // " + id.tipo + " // " + id.title.title_name + " // " + id.director + " // " + id.cast + " // " + id.country.pais_name;
        msg += " // " + id.fecha + " // " + id.año + " // " + id.audiencia + " // " + id.duracion + " // " + id.descripcion;
        return msg;
    }
    
    public ID busqueTitulo (String title)
    {
        ID id = null;
        Titulo tit = title_tree.busque(title);
        if (tit != null)
        {
            id = tit.show_id;
        }
        return id;
    }
    
    public ArrayList <ID> busqueCast (String actor)
    {
        ArrayList <ID> ids = null;
        Cast cast = cast_tree.busque(actor);
        if (cast != null)
        {
            ids = cast.ids;
        }
        return ids;
    }
    
    public ArrayList <ID> busqueCategoria (String categoria)
    {
        ArrayList <ID> ids = null;
        Categoria categ = categ_list.busque(categoria);
        if (categ != null)
        {
            ids = categ.ids;
        }
        return ids;
    }
    
    public ArrayList <ID> busquePais (String pais)
    {
        ArrayList <ID> ids = null;
        Pais country = country_list.busque(pais);
        if (country!= null)
        {
            ids = country.ids;
        }
        return ids;
    }
    
    public static void main (String arg[])
    {
        Controlador c = new Controlador ();
        c.leaData();
        boolean continua = true;
        do {
          //Elige qué acción realizar con el programa
          String[] ops1 = {"Buscar por titulo","Buscar por actor","Buscar por categoria","Buscar por pais","Crear nueva categoria"};
          String ans1 = (String)(JOptionPane.showInputDialog(null,"Qué desea hacer?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
          switch (ans1)
          {
            case "Buscar por titulo":
                
                break;
            case "Buscar por actor": 
              
                break;
            case "Buscar por categoria":
              
                break;
            case "Buscar por pais":
              
                break;
            case "Crear nueva categoria":
                c.crearCategoria();//Falta implementar
                break;
          }
          //Elige si continuar utilizando el programa o no
          String[] ops2 = {"Realizar nueva acción","Cerrar programa"};
          String ans2 = (String)(JOptionPane.showInputDialog(null,"Qué desea hacer?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops2, ops2[0]));
          continua = (ans2.equals("Cerrar programa"))?false:true;
        } while (continua);
    }
}
