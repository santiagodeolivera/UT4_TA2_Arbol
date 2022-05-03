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
    public void testTamanioVacio() {
	var arbol = new TArbolBB<Object>();

	var tamanio = arbol.tamanio();

	assertEquals(0, tamanio);
    }

    @Test
    public void testTamanioConRaiz() {
        var raiz = new TElementoAB<>(1, 1);
	var arbol = new TArbolBB<Integer>(raiz);

	var tamanio = arbol.tamanio();

	assertEquals(1, tamanio);
    }

    @Test
    public void testTamanioConRaizEHijoIzquierdo() {
        var hijoIzq = new TElementoAB<>(0, 0);
        var raiz = new TElementoAB<>(1, 1);
        raiz.setHijoIzq(hijoIzq);
	var arbol = new TArbolBB<Integer>(raiz);

	var tamanio = arbol.tamanio();

	assertEquals(2, tamanio);
    }

    @Test
    public void testAlturaArbolVacio (){
        TArbolBB arbol = new TArbolBB<Integer> ();
        
        int alt = arbol.altura();
        
        assertEquals(-1,alt);
    }
    
    
    @Test
    public void testAlturaUnElemento(){
        TArbolBB arbol = new TArbolBB<Integer> ();
        arbol.insertar(new TElementoAB(1,1));
        int alt = arbol.altura();
        
        assertEquals(0,alt);
    }

    @Test
    public void testAltura5Elementos(){
        TArbolBB arbol = new TArbolBB<Integer> ();

        TElementoAB el = new TElementoAB(2,2);    
        arbol.raiz = el;
        TElementoAB el1 = new TElementoAB(1,1); 
        el.setHijoIzq(el1);
        TElementoAB el4 = new TElementoAB(4,4);
        el.setHijoDer(el4);
        TElementoAB el5 = new TElementoAB(5,5); 
        el4.setHijoDer(el5);
        TElementoAB el6 = new TElementoAB(6,6); 
        el5.setHijoDer(el6);
        
        int alt = arbol.altura();
        
        assertEquals(3,alt);
    }
    
    @Test
    public void testAlturaNoCambia(){
        TArbolBB arbol = new TArbolBB<Integer> ();

        TElementoAB el = new TElementoAB(2,2);    
        arbol.raiz = el;
        TElementoAB el1 = new TElementoAB(1,1); 
        el.setHijoIzq(el1);
        TElementoAB el4 = new TElementoAB(4,4);
        el.setHijoDer(el4);
        TElementoAB el5 = new TElementoAB(5,5); 
        el4.setHijoDer(el5);
        TElementoAB el6 = new TElementoAB(6,6); 
        el5.setHijoDer(el6);
        
        String preOrdenPreAltura = arbol.preOrden();
        String postOrdenPreAltura = arbol.postOrden();
        String inOrdenPreAltura = arbol.inOrden();
        
        
        arbol.altura();
        
        String preOrdenPostAltura = arbol.preOrden();
        String postOrdenPostAltura = arbol.postOrden();
        String inOrdenPostAltura = arbol.inOrden();
        
        assertEquals(preOrdenPostAltura,preOrdenPreAltura);
        assertEquals(postOrdenPostAltura,postOrdenPreAltura);
        assertEquals(inOrdenPostAltura,inOrdenPreAltura);
    }
    
    
}
