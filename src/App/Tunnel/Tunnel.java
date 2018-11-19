package App.Tunnel;

import App.Cars.Car;
import App.Cars.Type.Type;
import java.util.ArrayList;

public class Tunnel {

    private static final int MAX_CARS_AMOUNT = 5;
    private int carsCounter;
    private ArrayList<Car> carsInTunnel;

    public Tunnel(){
        carsCounter = 0;
        carsInTunnel = new ArrayList<>();
    }

    public static int getMaxCarsAmount() {
        return MAX_CARS_AMOUNT;
    }

    public int getCarsCounter() {
        return carsCounter;
    }

    public synchronized void setCarsCounter(int carsCounter) {
        this.carsCounter = carsCounter;
    }

    public void setCarInTunnel(Car car) {
        carsCounter++;
        carsInTunnel.add(car);
    }

    public Car getCarFromTunnel(Type type){
        int carIndex = -1; //havent in array

        for (int i = 0; i < carsInTunnel.size(); i++){
            if (type == carsInTunnel.get(i).getType()){
                carIndex = i;
                break;
            }
        }

        if (carIndex != -1) carsCounter--;

        return (carIndex != -1) ? carsInTunnel.remove(carIndex) : null;
    }

    public boolean isFull(){
        return carsCounter == MAX_CARS_AMOUNT;
    }

    public ArrayList<Car> getCarsInTunnel() {
        return carsInTunnel;
    }

    public int get_MAX_CARS_AMOUNT(){
        return MAX_CARS_AMOUNT;
    }
}
