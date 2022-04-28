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
public class TArbolBB<T> implements IArbolBB<T> {
    
    TElementoAB<T> raiz;
    
    public TArbolBB(TElementoAB<T> raiz){
       this.raiz = raiz;
    }

    public TElementoAB<T> raiz;
    public static int contadorElementosInsertados = 0;
    
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if(raiz == null)
        {
            raiz = unElemento;
        }
        else
        {
            raiz.insertar(unElemento);
        }
        contadorElementosInsertados++;
        return true;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
