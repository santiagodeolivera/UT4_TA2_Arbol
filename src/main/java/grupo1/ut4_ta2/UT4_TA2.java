/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package grupo1.ut4_ta2;

import ut5.ta2.ManejadorArchivosGenerico;

/**
 *
 * @author santi
 */
public class UT4_TA2 {
    
    private static <T extends Comparable> Tupla<TArbolBB<T>, String[]> arbolDesdeLista(T[] data) {
        var arbol = new TArbolBB<T>();
        String[] lineas = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            T clave = data[i];
            var res = arbol.insertar(new TElementoAB<>(clave, clave));
            lineas[i] = clave + ", " + res.segundo;
        }
        return new Tupla<>(arbol, lineas);
    }
    
    private static Tupla<TArbolBB<Integer>, String[]> arbolDesdeArchivo(String input) {
        Integer[] numClaves;
        {
            String[] claves = ManejadorArchivosGenerico.leerArchivo(input);
            numClaves = new Integer[claves.length];
            for(int i = 0; i < claves.length; i++) {
                numClaves[i] = Integer.valueOf(claves[i]);
            }
        }
        
        return arbolDesdeLista(numClaves);
    }
    
    private static void cargar(String input, String output) {
        var res = arbolDesdeArchivo(input);
        ManejadorArchivosGenerico.escribirArchivo(output, res.segundo);
    }

    public static void main(String[] args) {
        cargar("clavesPrueba.txt", "r.txt");
    }
}
