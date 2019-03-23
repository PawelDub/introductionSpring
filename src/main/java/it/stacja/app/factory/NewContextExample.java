package it.stacja.app.factory;

import it.stacja.app.factory.context.SimpleContext;
import it.stacja.app.factory.model.Car;

public class NewContextExample {
    public static void main(String[] args) {
        SimpleContext context = new SimpleContext("it.stacja.app.factory.model");

//        Tire tire = context.getElement(Tire.class);
//
//        System.out.println(tire);
//
//        tire = context.getElement(Tire.class);
//        System.out.println(tire);

        Car car = context.getElement(Car.class);
        System.out.println(car);


    }
}
