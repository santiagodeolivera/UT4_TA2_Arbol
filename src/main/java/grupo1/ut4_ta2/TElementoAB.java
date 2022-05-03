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
    
    public TElementoAB (Comparable etiqueta, T datos, TElementoAB<T> hijoIzq, TElementoAB<T> hijoDer) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
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
                return new Tupla<>(true, 1);
            } else {
                var res = this.hijoDer.insertar(elemento);
                res.segundo++;
                return res;
            }
        } else if (comp > 0) {
            if(this.hijoIzq == null) {
                this.hijoIzq = elemento;
                return new Tupla<>(true, 1);
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
        String thisValue = this.getEtiqueta().toString();
        
        String izqStr = "";
        if (this.hijoIzq != null) {
            izqStr = ", " + this.hijoIzq.preOrden();
        }
        
        String derStr = "";
        if (this.hijoDer != null) {
            derStr = ", " + this.hijoDer.preOrden();
        }
        
        return thisValue + izqStr + derStr;
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
    
    @Override
    public int altura() {
        int altIzq = -1;
        int altDer = -1;
        
        if (this.hijoIzq != null) {
            altIzq = this.hijoIzq.altura();
        }
        if (this.hijoDer != null) {
            altDer = this.hijoDer.altura();
        }
        
        return Math.max(altIzq, altDer) + 1;
    }
    
    @Override
    public int tamanio() {
        int res = 1;
        
        if (this.hijoIzq != null) {
            res += this.hijoIzq.tamanio();
        }
        if (this.hijoDer != null) {
            res += this.hijoDer.tamanio();
        }
        
        return res;
    }
    
    public int cantHojas() {
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 1;
        }
        
        int res = 0;
        if (this.hijoIzq != null) {
            res = this.hijoIzq.cantHojas();
        }
        if (this.hijoDer != null) {
            res += this.hijoDer.cantHojas();
        }
        return res;
    }
    
    public int sumOneIfNotNeg1(int n) {
        if (n < 0) {
            return n + 1;
        }
        return -1;
    }
    
    public int nivelDe(Comparable etiqueta) {
        int comp = etiqueta.compareTo(this.getEtiqueta());
        if (comp < 0) {
            if (this.hijoIzq != null) {
                return sumOneIfNotNeg1(this.hijoIzq.nivelDe(etiqueta));
            } else {
                return -1;
            }
        } else if (comp > 0) {
            if (this.hijoDer != null) {
                return sumOneIfNotNeg1(this.hijoDer.nivelDe(etiqueta));
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

}
