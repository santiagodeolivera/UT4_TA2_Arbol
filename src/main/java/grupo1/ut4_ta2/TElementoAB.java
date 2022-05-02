/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo1.ut4_ta2;

/**
 *
 * @author santi
 */
public class TElementoAB<T> implements IElementoAB<T> {
    private Comparable etiqueta;
    private T datos;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;

    public TElementoAB (Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public Tupla<TElementoAB<T>, Integer> buscar(Comparable unaEtiqueta) {
        return this.buscar(unaEtiqueta, 0);
    }
        
    private Tupla<TElementoAB<T>, Integer> buscar(Comparable unaEtiqueta, int prof) {
        int comp = this.etiqueta.compareTo(unaEtiqueta);
        if (comp < 0) {
            if (this.hijoDer == null) {
                return null;
            }
            return this.hijoDer.buscar(unaEtiqueta, prof + 1);
        } else if (comp > 0) {
            if (this.hijoIzq == null) {
                return null;
            }
            return this.hijoIzq.buscar(unaEtiqueta, prof + 1);
        } else {
            return new Tupla<>(this, prof);
        }
    }
    
    @Override
    public Tupla<Boolean, Integer> insertar(TElementoAB<T> elemento) {
        int comp = this.getEtiqueta().compareTo(elemento.getEtiqueta());
        if (comp < 0)
        {
            if(this.hijoDer == null) {
                this.hijoDer = elemento;
                return new Tupla<>(true, 0);
            } else {
                var res = this.hijoDer.insertar(elemento);
                res.segundo++;
                return res;
            }
        } else if (comp > 0) {
            if(this.hijoIzq == null) {
                this.hijoIzq = elemento;
                return new Tupla<>(true, 0);
            } else {
                var res = this.hijoIzq.insertar(elemento);
                res.segundo++;
                return res;
            }
        }    
        return new Tupla<>(false, 0);
    }
    
    @Override
    public String preOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String inOrden() {
        String izqStr = "";
        if (this.hijoIzq != null) {
            izqStr = this.hijoIzq.inOrden() + ", ";
        }
        
        String thisValue = this.getEtiqueta().toString();
        
        String derStr = "";
        if (this.hijoDer != null) {
            derStr = ", " + this.hijoDer.inOrden();
        }
        
        return izqStr + thisValue + derStr;
    }

    @Override
    public String postOrden() {
        String izqStr = "";
        if (this.hijoIzq != null) {
            izqStr = this.hijoIzq.postOrden() + ", ";
        }
        
        String derStr = "";
        if (this.hijoDer != null) {
            derStr = this.hijoDer.postOrden() + ", ";
        }
        
        String thisValue = this.getEtiqueta().toString();
        
        return izqStr + derStr + thisValue;
    }

    @Override
    public T getDatos() {
        return this.datos;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
