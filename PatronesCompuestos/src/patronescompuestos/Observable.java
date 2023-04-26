/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronescompuestos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Eduar
 */
public class Observable implements QuackObservable {

    List<Observer> observers = new ArrayList<>();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (var observer : observers) {
            observer.update(duck);
        }
    }

    public Iterator<Observer> getObservers() {
        return observers.iterator();
    }
}
