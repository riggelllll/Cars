package App.Tasks;

import App.Cars.Car;
import App.Cars.Type.Size;
import App.Cars.Type.Type;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class CarGenerator {

    private static int carId;
    private ArrayDeque<Car>cars;
    private int carsAmount;
    private Random rand;
    private static final int AMOUNT_TYPES = 3;

    public CarGenerator(int carsAmount){
        this.carsAmount = carsAmount;
        cars = new ArrayDeque<>(this.carsAmount);
        rand = new Random();
    }

    private void generateCars(){
        for (int i = 0 ; i < carsAmount; i++){
            int r = rand.nextInt(AMOUNT_TYPES + 1); // return 0-3
            cars.add(new Car(Type.values()[r], Size.values()[r], getCarId()));
        }
    }

    private synchronized int getCarId(){
         return carId++;
    }
}
