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
class Flock implements Quackable {

    List<Quackable> ducks = new ArrayList<Quackable>();

    public void add(Quackable duck) {
        ducks.add(duck);
    }

    public void quack() {
        Iterator<Quackable> iterator = ducks.iterator();
        while (iterator.hasNext()) {
            Quackable duck = (Quackable) iterator.next();
            duck.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = ducks.iterator();
        while (iterator.hasNext()) {
            Quackable duck = (Quackable) iterator.next();
            duck.registerObserver(observer);
        }
    }

    public void notifyObservers() {
    }

    public String toString() {
        return "Flock of Ducks";
    }
}
