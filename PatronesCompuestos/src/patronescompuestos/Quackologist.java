/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronescompuestos;

/**
 *
 * @author Eduar
 */
public class Quackologist implements Observer {

    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }

    @Override
    public String toString() {
        return "Quackologist";
    }
}
