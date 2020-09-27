
package Suma.subarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /*
    Complejidad O(n^2)
    */
    static void metodoFuerzaBruta(int[] array, int x){

        boolean encontrado = false;

        for (int i = 0; i < array.length && !encontrado; i++){
            for (int j = 0; j < array.length && !encontrado; j++){

                if (i != j){ // Desechar caso de que ambos índices sean iguales
                    if (array[i] + array[j] == x){

                        System.out.println("Bingo!");
                        System.out.println("array[" + i + "] + array[" + j + "] = " + x);
                        encontrado = true;

                    }
                }

            }
        }

    }

    /*
        Complejidad O(n)
    */
    static void metodoTablaHash(int[] array, int x){

        // Insertar complemento de cada elemento del array
        // El complemento de un elemento del array equivale a suma - elemento
        Map<Integer, Integer> diccionario = new HashMap<>();

        for (int i = 0; i < array.length; i++){
            diccionario.put(x - array[i], i);
        }

        // Recorrer array en busca de coincidencias en la tabla hash
        // Si algún elemento del array está presente en la tabla hash, ello
        // quiere decir que en su momento insertamos (suma - elemento)
        for (int i = 0; i < array.length; i++){
            if (diccionario.containsKey(array[i]) // El diccionario contiene el complemento
                    && diccionario.get(array[i]) != i) // El índice del complemento no es el actual
            {
                System.out.println("Bingo!");
                System.out.println("array[" + i + "] + array[" + diccionario.get(array[i]) + "] = " + x);
                break;
            }
        }

    }

    /*
        Complejidad O(log(n))
    */
    static void metodoDosPunteros(int[] array, int x){

        // Ordenamos el array en orden creciente
        Arrays.sort(array);

        // Creamos dos índices
        int i = 0;
        int j = array.length - 1;

        while (i < j){

            if (array[i] + array[j] < x){
                i++;
            }else if (array[i] + array[j] > x){
                j--;
            }else{ // Son iguales
                System.out.println("Bingo!");
                System.out.println("array[" + i + "] + array[" + j + "] = " + x);
                break;
            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int unArray[] = {1, 4, 2, 3, 4, 6, 7, 1, -2, 1, -20, 4, 7, 9, 0};

        int _x_ = 10;

        System.out.println("FUERZA BRUTA");
        metodoFuerzaBruta(unArray, _x_);

        System.out.println("TABLA HASH");
        metodoTablaHash(unArray, _x_);

        System.out.println("DOS PUNTEROS");
        metodoDosPunteros(unArray, _x_);

    }

}
