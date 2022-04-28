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
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;

    public TElementoAB (Comparable etiqueta, TElementoAB<T> hijoIzq, TElementoAB<T> hijoDer){
        this.etiqueta = etiqueta;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }
    
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public boolean insertar(TElementoAB<T> elemento) {
        if(this.getEtiqueta().compareTo(elemento.getEtiqueta())<0)
        {
            if(this.der == null) {
                this.der = elemento;
            } else {
                this.der.insertar(elemento);     
            }
        } else {
            if(this.izq == null) {
                this.izq = elemento;
            } else {
                this.izq.insertar(elemento);                    
            }
        }    
        return true;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
