package it.stacja.app.factory;

import it.stacja.app.factory.model.Car;
import it.stacja.app.factory.model.Tire;
import it.stacja.app.factory.model.Wheel;

import java.net.CacheRequest;

public class FactoryExample {

    public static void main(String[] args) {

        Tire tire1 = new Tire();
        Wheel wheel1 = new Wheel(tire1);

        Tire tire2 = new Tire();
        Wheel wheel2 = new Wheel(tire2);

        Tire tire3 = new Tire();
        Wheel wheel3 = new Wheel(tire3);

        Tire tire4 = new Tire();
        Wheel wheel4 = new Wheel(tire4);

        Car car = new Car(wheel1, wheel2, wheel3, wheel4);

    }


}
