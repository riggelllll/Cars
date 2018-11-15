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
    private int carsCounter;
    private Random rand;
    private static final int AMOUNT__CAR_TYPES = 3;
    private static final int AMOUNT__CAR_SIZES = 3;

    public CarGenerator(int carsAmount){
        this.carsAmount = carsAmount;
        carsCounter = carsAmount;
        cars = new ArrayDeque<>(this.carsAmount);
        rand = new Random();
    }

    public void generateCars(){
        for (int i = 0 ; i < carsAmount; i++){
            int randType = rand.nextInt(AMOUNT__CAR_TYPES); // return 0-2
            int randSize = rand.nextInt(AMOUNT__CAR_SIZES);
            cars.add(new Car(Type.values()[randType], Size.values()[randSize], getCarId()));
        }
    }

    private synchronized int getCarId(){
         return carId++;
    }

    public ArrayDeque<Car> getCars() {
        return cars;
    }
}
