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
    
    @Test
    public void testVacioInOrden() {
        var arbol = new TArbolBB<Object>();
        
        var orden = arbol.inOrden();
        
        assertEquals("", orden);
    }
    
    @Test
    public void testInOrdenWithOneElement() {
        var arbol = new TArbolBB<Integer>(new TElementoAB<>(1, 1));
        
        var orden = arbol.inOrden();
        
        assertEquals("1", orden);
    }
    
    @Test
    public void testInOrdenWithElementInLeft() {
        var el = new TElementoAB<Integer>(5, 5);
        el.setHijoIzq(new TElementoAB<>(2, 2));
        var arbol = new TArbolBB<Integer>(el);
        
        var orden = arbol.inOrden();
        
        assertEquals("2, 5", orden);
    }

    @Test
    public void testInOrdenWithElementInRight() {
        var el = new TElementoAB<Integer>(2, 2);
        el.setHijoDer(new TElementoAB<>(5, 5));
        var arbol = new TArbolBB<Integer>(el);
        
        var orden = arbol.inOrden();
        
        assertEquals("2, 5", orden);
    }

    @Test
    public void testInOrdenWithFiveElements() {
        var arbol = new TArbolBB<Integer>();
        
        for (int i : new int[] {5, 2, 6, 3, 4}) {
            arbol.insertar(new TElementoAB<>(i, i));
        }
        
        var orden = arbol.inOrden();
        
        assertEquals("2, 3, 4, 5, 6", orden);
    }
    
    @Test
    public void testTamanio() {
        
    }

    @Test
    public void testAltura() {
        
    }

}
