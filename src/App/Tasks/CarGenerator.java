package App.Tasks;

import App.Cars.Car;
import App.Cars.Type.Size;
import App.Cars.Type.Type;
import App.Interfaces.Generator;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class CarGenerator{

    private static int carId;
    private ArrayDeque<Car>cars;
    private int maxCarsAmount;
    private int carsCounter;
    private Random rand;
    private static final int AMOUNT__CAR_TYPES = 3;
    private static final int AMOUNT__CAR_SIZES = 3;

    public CarGenerator(int maxCarsAmount){
        this.maxCarsAmount = maxCarsAmount;
        carsCounter = 0;
        cars = new ArrayDeque<>(this.maxCarsAmount);
        rand = new Random();
    }

    public void generateCars(int size){
        carsCounter+= size;
        for (int i = 0 ; i < size; i++){
            cars.add(gen.generate());
        }
    }

    private synchronized int createCarId(){
         return carId++;
    }

    public ArrayDeque<Car> getCars() {
        return cars;
    }

    public synchronized Car getCarFromQueue(){
        carsCounter--;
        return cars.remove();
    }

    private Generator<Car> gen = () ->{
        int randType = rand.nextInt(AMOUNT__CAR_TYPES); // return 0-2
        int randSize = rand.nextInt(AMOUNT__CAR_SIZES);
        return new Car(Type.values()[randType], Size.values()[randSize], createCarId());
    };


}
