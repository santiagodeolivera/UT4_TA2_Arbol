/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo1.ut4_ta2;

/**
 *
 * @author santi
 * @param <T>
 */
public class TArbolBB<T> extends TDAArbol<T> implements IArbolBB<T> {
    
    public TArbolBB() {
        super();
    }
    
    public TArbolBB(TElementoAB raiz) {
        super();
        this.raiz = raiz;
    }
    
    /**
     * Intenta insertar un elemento en el árbol,
     * imprimiendo la cantidad de llamadas recursivas para ello.
     * @param unElemento El elemento.
     * @return true si el elemento ha sido insertado.
     */
    @Override
    // Hay que hacer que devuelva una Tupla<Boolean, Integer> también
    public Tupla<Boolean, Integer> insertar(TElementoAB<T> unElemento) {
        if(raiz == null)
        {
            raiz = unElemento;
            System.out.println(1);
            return new Tupla<>(true, 1);
        }
        else
        {
            var res = raiz.insertar(unElemento);
            if (!res.primero) {
                res.segundo = 0;
                return res;
            }
            res.segundo++;
            System.out.println(res.segundo);
            return res;
        }
    }

    @Override
    public Tupla<TElementoAB<T>, Integer> buscar(Comparable unaEtiqueta) {
        if (raiz != null) {
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public String preOrden() {
        if (this.raiz != null) {
            return this.raiz.preOrden();
        }
        return "";
    }

    @Override
    public String inOrden() {
        if (this.raiz != null) {
            return this.raiz.inOrden();
        }
        return "";
    }

    @Override
    public String postOrden() {
        if (this.raiz != null) {
            return this.raiz.postOrden();
        }
        return "";
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return;
        }
        raiz = raiz.eliminar(unaEtiqueta);
    }
    
    @Override
    public int altura() {
        if (this.raiz != null) {
            return this.raiz.altura();
        }
        return -1;
    }
    
    @Override
    public int tamanio() {
        if (this.raiz != null) {
            return this.raiz.tamanio();
        }
        return 0;
    }
    
    @Override
    public int cantHojas() {
        if (this.raiz != null) {
            return this.raiz.cantHojas();
        }
        
        return 0;
    }
    
    @Override
    public int nivelDe(Comparable etiqueta) {
        if (this.raiz != null) {
            return this.raiz.nivelDe(etiqueta);
        }
        return -1;
    }

}
