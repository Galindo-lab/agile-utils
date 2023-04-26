/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronescompuestos;

/**
 *
 * @author Eduar
 */
public interface QuackObservable {

    public void registerObserver(Observer observer);

    public void notifyObservers();
}
