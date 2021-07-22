/**
 * Clase controlador de la Tarea Programada 3.
 *
 * @author (Diego Hernández Agüero B83716)
 * @version (v.1)
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Controlador
{
    ID id_list; //id_list: almacena los id de las peliculas
    Categoria categ_list; //categ_list: almacena las categorias de las peliculas
    Pais country_list; //country_list: almacena el país de las peliculas
    Titulo title_tree; //title_tree: almacena los títulos de las peliculas
    Cast cast_tree; //cast_tree: almacena los cast de las peliculas

    /**
     * Controlador: Es el constructor de la clase
     */
    public Controlador ()
    {
        id_list = null;
        categ_list = null;
        country_list = null;
        title_tree = null;
        cast_tree = null;
    }

    /**
     * ingreseData: Método que guarda la data de todas las peliculas.
     * 
     * @param fila: Recibe un Array con los datos de la pelicula separados por celdas
     * @param flag: Recibe un boolean para determinar si es la primera pelicula que recibe
     */
    public void ingreseData (String [] fila, boolean flag)
    {
        char c1 = '"';
        char c2 = ' ';
        char c3 = '​';
        String [] data = new String [fila.length];
        String [] actores;
        String [] categs;
        for (int i = 0; i < 12; i++)
        {
            data[i] = fila[i].replace(c1,c2).replace(c3,c2).trim();
        }
        actores = data[4].split(",");
        for (int j = 0; j < actores.length; j++)
        {
            actores[j] = actores[j].trim();
        }
        categs = data[10].split(",");
        for (int k = 0; k < categs.length; k++)
        {
            categs[k] = categs[k].trim();
        }

        //Flag = true si es la primera pelicula de todo el dataset
        if (flag)
        {
            id_list = new ID (data[0],data[1],data[3],data[6],data[7],data[8],data[9],data[11]);
            categ_list = new Categoria (categs[0],id_list);
            country_list = new Pais (data[5],id_list);
            title_tree = new Titulo (data[2],id_list);
            cast_tree = new Cast (actores[0],id_list);

            id_list.categ.add(categ_list);
            id_list.cast.add(cast_tree);
            id_list.title = title_tree;
            id_list.country = country_list;

            for (int n = 1; n < actores.length; n++)
            {
                cast_tree.add(actores[n],id_list);
            }
            for (int p = 1; p < categs.length; p++)
            {
                categ_list.add(categs[p],id_list);
            }
        } else {
            ID new_id = new ID (data[0],data[1],data[3],data[6],data[7],data[8],data[9],data[11]);
            id_list.add(new_id);
            country_list.add(data[5],new_id);
            title_tree.add(data[2],new_id);

            for (int n = 0; n < actores.length; n++){
                cast_tree.add(actores[n],new_id);
            }
            for (int p = 0; p < categs.length; p++)
            {
                categ_list.add(categs[p],new_id);
            }
        }

    }

    /**
     * leaData: Método que lee la data de todas las películas.
     * 
     */
    public void leaData (String file_name)
    {
        String hilera;
        String d[];
        boolean flag = true;

        try{
            Scanner sc = new Scanner (new FileReader(file_name));
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
     * muestrePelicula: Método que devuelve en una string la información de la película
     * asociada con el id dado de parámetro.
     * 
     * @param id: Recibe un ID para buscar la película
     */
    public void muestrePelicula (ID id)
    {
        System.out.print(id.value + " // " + id.tipo + " // " + id.title.title_name + " // " + id.director + " // ");
        for(int i = 0; i < id.cast.size();i++) {
            System.out.print(id.cast.get(i).actor + ",");
        }
        System.out.print(" // " + id.country.pais_name +" // " + id.fecha + " // " + id.año + " // " + id.audiencia + " // " + id.duracion + " // ");
        for(int i = 0; i < id.categ.size();i++) {
            System.out.print(id.categ.get(i).categ_name + ",");
        }
        System.out.println(" // "+ id.descripcion);
    }

    /**
     * busqueTitulo: Método que devuelve un ID asociado a una película
     * asociada con el string dado de parámetro.
     * 
     * @param title: Recibe un String para buscar la película
     */
    public ID busqueTitulo (String title)
    {
        ID id = null;
        Titulo tit = title_tree.busque(title);
        if (tit != null)
        {
            id = tit.show_id;
        }else{
            System.out.println("No se ha encontrado la pelicula/serie solicitada");
        }
        return id;
    }

    /**
     * busqueCast: Método que devuelve un ArrayList de ID's asociado a un actor
     * asociado con el string dado de parámetro.
     * 
     * @param actor: Recibe un String para buscar el actor
     */
    public ArrayList <ID> busqueCast (String actor)
    {
        ArrayList <ID> ids = null;
        Cast cast = cast_tree.busque(actor);
        if (cast != null)
        {
            ids = cast.ids;
        }else{
            System.out.println("No se ha encontrado  al actor solicitado");
        }
        return ids;
    }

    /**
     * busqueCategoria: Método que devuelve un ArrayList de ID's asociado a una categoria
     * asociada con el string dado de parámetro.
     * 
     * @param categoria: Recibe un String para buscar la categoria
     */
    public ArrayList <ID> busqueCategoria (String categoria)
    {
        ArrayList <ID> ids = null;
        if (categ_list.existe(categoria))
        {
            ids = categ_list.buscarCategoria(categoria);
        }else{
            String d="¡Esa categoría no existe en la lista!";
            System.out.print(d);
            return null;
        }
        return ids;
    }

    /**
     * busquePais: Método que devuelve un ArrayList de ID's asociado a un pais
     * asociada con el string dado de parámetro.
     * 
     * @param pais: Recibe un String para buscar el pais
     */
    public ArrayList <ID> busquePais (String pais)
    {
        ArrayList <ID> ids = null;
        if(country_list.existe(pais))
        {
            ids = country_list.buscarPais(pais);
        }else{
            String d="¡Ese país no existe en la lista!";
            System.out.print(d);
            return null;
        }
        return ids;
    }

    /**
     * crearCategoria: Método que crea una Categoría con un nuevo nombre dado por el usuario
     * 
     */
    public void crearCategoria()
    {
        System.out.println("Ingrese el nombre de la nueva categoría:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        Categoria iterador = categ_list;
        ArrayList<ID> listaDeID= new ArrayList<ID>();

        do {
            if (iterador.categ_name.contains(name)){
                listaDeID.addAll(iterador.ids);
            }
            iterador = iterador.next;
        } while(iterador != null);
        
        if(listaDeID.size() == 0)
        {
            System.out.println("No se han encontrado películas/series con esa categoría");
        }
        
        if(listaDeID.size() != 0){

            for(int i = 0; i < listaDeID.size();i++){
                categ_list.add(name,listaDeID.get(i));
            }
        }

        System.out.println("La categoría ha sido creada con éxito");
    }

    public static void main (String arg[])
    {
        Controlador c = new Controlador ();
        String[] fileChoice = {"Cargar la data total","Cargar las primeras 25 entradas"};
        String ansFile = (String)(JOptionPane.showInputDialog(null,"Cómo desea cargar la data?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null,fileChoice,fileChoice[0]));
        String file_name = (ansFile.equals("Cargar la data total"))?"netflix_titles.txt":"netflix_titles(cortada)";
        c.leaData(file_name);
        boolean continua = true;
        Scanner scan = new Scanner("");
        ArrayList<ID> busqueda = new ArrayList<ID>();
        do {
            //Elige qué acción realizar con el programa
            String[] ops1 = {"Buscar por titulo","Buscar por actor","Buscar por categoria","Buscar por pais","Crear nueva categoria","Salir del programa"};
            String ans1 = (String)(JOptionPane.showInputDialog(null,"¿Qué desea hacer?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops1, ops1[0]));
            switch (ans1)
            {
                case "Buscar por titulo":
                    System.out.println("Ingrese el título de la película que desea buscar");
                    scan = new Scanner(System.in);
                    String tituloDeBusqueda = scan.nextLine();
                    ID peliBuscada = c.busqueTitulo(tituloDeBusqueda);
                    c.muestrePelicula(peliBuscada);
                    break;

                case "Buscar por actor":
                    System.out.println("Ingrese el nombre del actor que desea buscar");
                    scan = new Scanner(System.in);
                    String nombreDeActor = scan.nextLine();
                    busqueda = c.busqueCast(nombreDeActor);
                    for(int i = 0; i < busqueda.size();i++){
                        c.muestrePelicula(busqueda.get(i));
                    }
                    break;

                case "Buscar por categoria":
                    System.out.println("Ingrese el nombre de la categoría que desea buscar");
                    scan = new Scanner(System.in);
                    String nombreDeCateg = scan.nextLine();
                    busqueda = c.busqueCategoria(nombreDeCateg);
                    for(int i = 0; i < busqueda.size();i++){
                        c.muestrePelicula(busqueda.get(i));
                    }
                    break;

                case "Buscar por pais":
                    System.out.println("Ingrese el nombre del país que desea buscar");
                    scan = new Scanner(System.in);
                    String nombreDePais = scan.nextLine();
                    busqueda = c.busquePais(nombreDePais);
                    for(int i = 0; i < busqueda.size();i++){
                        c.muestrePelicula(busqueda.get(i));
                    }
                    break;

                case "Crear nueva categoria":
                    c.crearCategoria();
                    break;
            }
            //Elige si continuar utilizando el programa o no
            String[] ops2 = {"Realizar nueva acción","Cerrar programa"};
            String ans2 = (String)(JOptionPane.showInputDialog(null,"Qué desea hacer?","Por favor escoja una opción",JOptionPane.QUESTION_MESSAGE, null, ops2, ops2[0]));
            continua = (ans2.equals("Cerrar programa"))?false:true;
        } while (continua);
    }
}
