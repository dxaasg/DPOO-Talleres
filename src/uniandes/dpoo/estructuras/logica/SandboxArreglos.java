package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Arrays;


/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[]copia = arregloEnteros.clone();
    	
        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[]copia = arregloCadenas.clone();
    	
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        int[] nuevo = new int[arregloEnteros.length + 1];

        for (int i = 0; i < arregloEnteros.length; i++) {
            nuevo[i] = arregloEnteros[i];
        }

        nuevo[nuevo.length - 1] = entero;

        arregloEnteros = nuevo;  
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
        String[] nuevo = new String[arregloCadenas.length + 1];

        for (int i = 0; i < arregloCadenas.length; i++) {
            nuevo[i] = arregloCadenas[i];
        }

        nuevo[nuevo.length - 1] = cadena;

        arregloCadenas = nuevo;   // ← FALTABA ESTO
    }


    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int contador = 0; 
    	for (int i = 0; i< arregloEnteros.length;i++) {
    		if (arregloEnteros[i] != valor){
    			contador++;
    		}
    	}
    	int[] nuevo = new int[contador];
    	int indice = 0; 
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] != valor )   {
    			nuevo[indice]= arregloEnteros[i];
    			indice++;
    			}
    		}
 
    	arregloEnteros = nuevo;  
    	
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int contador = 0; 
    	for (int i = 0; i< arregloCadenas.length;i++) {
    		if (!arregloCadenas[i].equals(cadena) ){
    			contador++;
    		}
    	}
    	String[] nuevo = new String[contador];
    	int indice = 0; 
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		if (!arregloCadenas[i].equals(cadena)  )   {
    			nuevo[indice]= arregloCadenas[i];
    			indice++;
    			}
    		}
 
    	arregloCadenas = nuevo;

    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion < 0) {
            posicion = 0;
        } else if (posicion > arregloEnteros.length) {
            posicion = arregloEnteros.length;
        }

        int[] nuevo = new int[arregloEnteros.length + 1];

        for (int i = 0; i < nuevo.length; i++) {
            if (i < posicion) {
                nuevo[i] = arregloEnteros[i];
            } 
            else if (i == posicion) {
                nuevo[i] = entero;
            } 
            else {
                nuevo[i] = arregloEnteros[i - 1];
            }
        }

        arregloEnteros = nuevo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	
    	if (posicion < 0 || posicion >= arregloEnteros.length ) {
    		return;
    	}
    	int[] nuevo =new  int[arregloEnteros.length-1];
    	for (int i = 0; i < nuevo.length; i++) {
    	    if (i < posicion) {
    	        nuevo[i] = arregloEnteros[i];
    	    } else {
    	        nuevo[i] = arregloEnteros[i + 1];
    	    }
    	}

    	arregloEnteros = nuevo;
    	
    }
    	
    	
    	
    

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] nuevo = new int[valores.length];
    	for(int i = 0; i< valores.length; i++) {
    		nuevo[i] = (int) valores[i];
    		
    	}
    	arregloEnteros = nuevo;                                      
    	
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] nuevo = new String[objetos.length];
    	for(int i = 0; i < objetos.length; i++) {
    		nuevo[i] = objetos[i].toString();
    		
    	}
    	arregloCadenas = nuevo;  

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		arregloEnteros[i] = Math.abs(arregloEnteros[i]);
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros()
    {
        Arrays.sort(arregloEnteros);
    }
    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas()
    {
        Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int veces = 0;
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] == valor){
    			veces++;
    		}
    		
    	}
        return veces;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int veces = 0;
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		if (arregloCadenas[i].equalsIgnoreCase(cadena)){
    			veces++;
    		}
    		
    	}
        return veces;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero(int valor)
    {
        
        int contador = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                contador++;
            }
        }

        int[] posiciones = new int[contador];

        
        int indice = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones[indice] = i;
                indice++;
            }
        }

        return posiciones;
    }

    

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros()
    {
        if (arregloEnteros.length == 0) {
            return new int[0]; // opcional si el arreglo puede estar vacío
        }

        int valor_menor = arregloEnteros[0];
        int valor_mayor = arregloEnteros[0];

        for (int i = 1; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < valor_menor) {
                valor_menor = arregloEnteros[i];
            }
            if (arregloEnteros[i] > valor_mayor) {
                valor_mayor = arregloEnteros[i];
            }
        }

        int[] rango = new int[2];
        rango[0] = valor_menor;
        rango[1] = valor_mayor;

        return rango;
    }


    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> mapa = new HashMap<>();

        for (int i = 0; i < arregloEnteros.length; i++) {
            int valor = arregloEnteros[i];

            if (mapa.containsKey(valor)) {
                mapa.put(valor, mapa.get(valor) + 1);
            } else {
                mapa.put(valor, 1);
            } 
        }

        return mapa;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */ 
    public int contarEnterosRepetidos( )
    {
    	 HashMap<Integer, Integer> mapa = calcularHistograma();
    	    int contador = 0;

    	    for (Integer clave : mapa.keySet()) {
    	        if (mapa.get(clave) > 1) {
    	            contador++;
    	        }
    	    }

    	    return contador;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	 if (otroArreglo == null || otroArreglo.length != arregloEnteros.length) {
    	        return false;
    	    }

    	    for (int i = 0; i < arregloEnteros.length; i++) {
    	        if (arregloEnteros[i] != otroArreglo[i]) {
    	            return false;
    	        }
    	    }

    	    return true;
    }
 
    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	if (otroArreglo == null || otroArreglo.length != arregloEnteros.length) {
            return false;
        }

        HashMap<Integer, Integer> mapa1 = calcularHistograma();
        HashMap<Integer, Integer> mapa2 = new HashMap<>();

        for (int i = 0; i < otroArreglo.length; i++) {
            int valor = otroArreglo[i];

            if (mapa2.containsKey(valor)) {
                mapa2.put(valor, mapa2.get(valor) + 1);
            } else {
                mapa2.put(valor, 1);
            }
        }

        return mapa1.equals(mapa2);
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        arregloEnteros = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            arregloEnteros[i] = minimo + (int)(Math.random() * (maximo - minimo + 1));
        }
        
    }
    }
       
    


