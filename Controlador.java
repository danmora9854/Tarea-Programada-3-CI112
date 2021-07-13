
/**
 * Write a description of class Controlador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
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
     * DEBERIAMOS IMPLEMENTAR TODAS LAS LISTAS TAL QUE
     * TENGAMOS ALGO QUE APUNTE A SU FINAL
     */
    
    /**
     * Método que guarda la data de todas las peliculas.
     */
    public void ingreseData (String [] fila, boolean flag)
    {
        char c1 = 34;
        char c2 = 0;
        String [] data = fila.clone();
        String [] actores;
        String [] categs;
        for (int i = 0; i < 12; i++)
        {
            data[i] = data[i].replace(c1,c2).trim();
        }
        actores = data[4].split(",");
        for (int j = 0; j < actores.length; j++)
        {
            actores[j] = actores[j].trim();
        }
        categs = data[10].split(",|&");
        for (int k = 0; k < categs.length; k++)
        {
            categs[k] = categs[k].trim();
        }
        
        if (flag)
        {
            id_list = new ID (data[0],data[1],data[3],data[6],data[7],data[8],data[9],data[11]);
            categ_list = new Categoria (categs[0],id_list);
            country_list = new Pais (data[5],id_list);
            title_tree = new Titulo (data[2],id_list);
            cast_tree = new Cast (actores[0]);
            cast_tree.ids.add(id_list);
            
            id_list.categ.add(categ_list);
            id_list.cast.add(cast_tree);
            id_list.title = title_tree;
            id_list.country = country_list;
            
            for (int n = 1; n < actores.length(); n++)
            {
                cast_tree.add(actores[n],id_list);
                //Aca debe ademas linkear el nuevo objeto cast al id_list
            }
            for (int p = 1; p < categs.length(); p++)
            {
                categ_list.add(categs[p],id_list);
                //Aca debe ademas linkear el nuevo objeto categoria al id_list
            }
        } else {
            //Hace algo similar al if anterior solo que los objetos ya
            //han sido creados entonces solo usa metodos add
        }
        
    }
    
    /**
     * Método que lee la data de todas las películas.
     */
    public void leaData ()
    {
        //Habria que implementar un metodo que le vaya dando al ciclo
        //siguiente la info separada de cada pelicula.
        
        String hilera;
        String d[];
        boolean flag = true;
        
        try{
            Scanner sc = new Scanner (new FileReader("netflix_titles.txt"));
            while((sc.hasNextLine())){
                hilera = sc.nextLine();
                d = hilera.split(";");
                ingreseData(d,flag);
                flag = false;
            }
        }
        catch (Exception e) {}
        
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
