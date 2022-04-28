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

    public static void main(String[] args) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/claves1.txt");
        IArbolBB<String> arbol = new TArbolBB();
        
        String cadena = "";
        
        for(String linea : lineas) {
            IElementoAB<String> elemento = new TElementoAB(linea, linea);
            arbol.insertar((TElementoAB)elemento);
        }
        String[] lineasEscribir = new String[TArbolBB.contadorElementosInsertados];

        int i = 0;
        for(String linea : lineas) {
            lineasEscribir[i] = linea + " " + TArbolBB.contadorElementosInsertados;
            i++;
        }
        
        ManejadorArchivosGenerico.escribirArchivo("src/escritura.txt", lineasEscribir);
    }
}
