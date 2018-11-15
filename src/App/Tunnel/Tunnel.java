package App.Tunnel;

import App.Cars.Car;

import java.util.ArrayDeque;

public class Tunnel {

    private boolean isEmpty;
    private boolean isFull;
    private static final int MAX_CARS_AMOUNT = 5;
    private int carsCounter;
    private ArrayDeque<Car> cars;

    Tunnel(){
        isEmpty = true;
        isFull = false;
        carsCounter = 0;
        cars = new ArrayDeque<>();
    }
}
