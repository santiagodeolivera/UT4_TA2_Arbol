/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo1.ut4_ta2;

/**
 *
 * @author santi
 */
public interface ITDAArbol<T> {
    public int altura();
    
    public int tamanio();
    
    public int cantHojas();
    
    public int nivelDe(Comparable etiqueta);
}
