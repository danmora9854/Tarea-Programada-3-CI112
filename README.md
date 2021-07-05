# Tarea-Programada-3-CI112
Fecha de Entrega: S 24 Julio antes de MD
Se tiene un archivo sobre películas de una plataforma de streaming1 (netflix_titles.csv) que están
asociadas con categorías y que poseen una audiencia hacia la cual se dirigen. En ese archivo hay datos
acerca de casi 8000 videos. Los datos que se manejan sobre cada video son hileras asociadas con cada
uno de estos atributos:
• show_id
• tipo
• título
• director
• cast
• país de procedencia
• fecha_agregacion
• año_producción
• audiencia
• duración
• categoría
• descripción
Para facilitar la búsqueda de contenidos, se ha decidido que estos datos deben cargarse en algún
conjunto de estructuras dinámicas implementadas por uds, que faciliten:
1. Saber cuáles películas pertenecen a una categoría específica. Para responder a estar necesidad
cada vez que se consulte no debe recorrerse todo el conjunto de datos buscando los requeridos,
sino que estos ya deben estar incorporados en una estructura creada por ustedes (y que solo
mantenga agrupados los datos relacionados entre si) 20%
2. Saber en cuáles videos ha actuado un persona dada (en la celda “cast” los actores aparecen
separados por comas). 25%
3. Permitir reagrupar todos los videos en cuya categoría exista una palabra dada por el usuario,
como si se tratara de una categoría definida por el usuario. Ej: reclasificar como “Dramas” 25%
Action & Adventure, Dramas, International Movies
Comedies, Dramas
Comedies, Dramas, International Movies
Comedies, Dramas, Romantic Movies
Crime TV Shows, International TV Shows, TV Dramas
Crime TV Shows, TV Dramas, TV Mysteries
Dramas, Independent Movies
Dramas, Independent Movies, International Movies
Dramas, Independent Movies, Sports Movies
Dramas, International Movies
1 Tomado de https://www.kaggle.com/shivamb/netflix-shows
Dramas, International Movies, Romantic Movies
Dramas, International Movies, Sports Movies
Dramas, International Movies, Thrillers
Dramas, LGBTQ Movies
International TV Shows, Romantic TV Shows, TV Dramas
International TV Shows, TV Dramas
Ej2:
reclasificar como “Español”, aquellos videos que incluyan en su categoría, la palabra “Spanish”
Nota: Esta reclasificación no debe eliminar la aparición en la categoría anterior de los
videos reclasificados.
4. Visualizar todos los datos disponibles acerca de videos que pertenecen a una categoría dada.
10%
5. Se espera que como mínimo hagan uso de al menos 2 estructuras de datos distintas: listas
simples, listas doblemente enlazadas, pilas, colas, árboles binarios de búsqueda. 20%
6. Se espera que las búsquedas sean inteligentes y no que para responder cada pregunta deba
recorrerse el 100 de los casos, buscando si cada uno de ellos coincide con los criterios definidos
por el usuario en su consulta.
Elementos a ser considerados en la solución
existencia de estructuras de datos creadas por ustedes para soportar consultas por:
• nombre de actor
• clasificación de películas
• país de procedencia
• nombre del video
• reagrupación de películas
Existencia de un controlador que permita leer los datos, procesarlos, administrar un menú de
operaciones y mostrar los resultados al usuario.
Se les sugiere hacer pruebas con un conjunto muy reducido de datos unos 10 o 20 registros.
