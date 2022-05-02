/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package grupo1.ut4_ta2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ut5.ta2.ManejadorArchivosGenerico;

/**
 *
 * @author santi
 */
public class TArbolBBTest {
    
    public TArbolBBTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testInsertar() {
        int[] numClaves;
        {
            String[] claves = ManejadorArchivosGenerico.leerArchivo("clavesPrueba.txt");
            numClaves = new int[claves.length];
            for(int i = 0; i < claves.length; i++) {
                numClaves[i] = Integer.parseInt(claves[i]);
            }
        }
        
        var arbol = new TArbolBB<Integer>();
        for (int clave : numClaves) {
            arbol.insertar(new TElementoAB<>(clave, clave));
        }
        for (int clave : numClaves) {
            assertEquals(clave, arbol.buscar(clave).primero.getDatos());
        }
    }
}
