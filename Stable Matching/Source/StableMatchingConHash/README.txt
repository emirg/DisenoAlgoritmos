Compilar :

  $ javac App.java StableMatching.java

Ejecutar :

  $ java App data.txt

Data
----
El archivo de datos contiene una persona por linea. La primer columna es el nombre de la persona. Las siguientes N columnas son las preferencias
del sobre el otro sexo, siendo la de mas a la izquierda la que mas prefiere.

En el archivo siempre vienen primero todos los nombres y luego todas las mujeres. Por lo tanto el archivo tiene 2*n lineas.

La implementación no puede asumir un número N máximo para la entrada, por lo que deberá adaptarse al tamaño del archivo a leer.

Implementación
--------------

Se entregan dos archivos : App.java y StableMatching.java. El alumno deberá trabajar solo sobre StableMatching.java, dejando el App.java como está.

StableMatching tiene 3 métodos públicos :
 * readFile : En este método el alumno debe leer el archivo y guardar en estructuras de datos a las personas y sus preferencias.
 * resolv : En este método se debe resolver el problema de asignación de parejas estables.
 * show : Este método debe imprimir las parejas resultantes.

El método readFile se entrega con un ejemplo de cómo se puede leer el archivo y separar las líneas. El alumno puede si lo desea ignorar estas sugerencias,
siempre y cuando mantenga la interfaz del método readFile.

De ser necesario se pueden agregar métodos privados y atributos de instancia.

Resultado esperado para data.txt
--------------------------------
  Woman1 Man2
  Woman2 Man1
  Woman3 Man3

Adicionalmente hay un archivo de datos de 100 parejas.
